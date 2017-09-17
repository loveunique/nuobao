package com.nuobao.common.http;

import com.nuobao.common.constant.ApplicationErrorCode;
import com.nuobao.common.exception.HttpConnectionException;
import com.nuobao.common.exception.IntegrationException;
import com.nuobao.common.util.JSONUtil;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import java.io.*;
import java.net.UnknownHostException;
import java.util.List;

/**
 * 创建http发送到工具类
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 12:16
 * @modify
 **/
public class HttpUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    private static CloseableHttpClient httpClient;

    // httpclient构造器
    private static HttpClientBuilder httpClientBuilder = null;

    // 建立连接池
    private static PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = null;

    private static HostServerIntegrationConfig hostServerIntegrationConfig;

    public static void setHostServerIntegrationConfig(HostServerIntegrationConfig hostServerIntegrationConfig){
        HttpUtil.hostServerIntegrationConfig = hostServerIntegrationConfig;
    }

    /**
     * 默认的连接设置
     */
    private static  RequestConfig defaultRequestConfig = RequestConfig.custom().setSocketTimeout(1800000) // 从服务器获取响应数据需要等待的时间
            .setConnectTimeout(10000) // 设置等待连接超时时间
            .setConnectionRequestTimeout(10000) // 设置从连接池获取连接超时时间
            .build();

    static {
        httpClientBuilder = HttpClientBuilder.create();
        poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
        poolingHttpClientConnectionManager.setMaxTotal(200);// 设置连接池最大连接数
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(100);//路由默认最大连接数
        httpClientBuilder.setConnectionManager(poolingHttpClientConnectionManager);
        httpClientBuilder.setDefaultRequestConfig(defaultRequestConfig);

        // 请求重试处理
        HttpRequestRetryHandler httpRequestRetryHandler = new HttpRequestRetryHandler() {
            public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
                if (executionCount >= 3) {// 如果已经重试了3次，就放弃
                    return false;
                }
                if (exception instanceof NoHttpResponseException) {// 如果服务器丢掉了连接，那么就重试
                    return true;
                }
                if (exception instanceof SSLHandshakeException) {// 不要重试SSL握手异常
                    return false;
                }
                if (exception instanceof InterruptedIOException) {// 超时
                    return false;
                }
                if (exception instanceof UnknownHostException) {// 目标服务器不可达
                    return false;
                }
                if (exception instanceof ConnectTimeoutException) {// 连接被拒绝
                    return false;
                }
                if (exception instanceof SSLException) {// SSL握手异常
                    return false;
                }

                HttpClientContext clientContext = HttpClientContext.adapt(context);
                HttpRequest request = clientContext.getRequest();
                // 如果请求是幂等的，就再次尝试
                if (!(request instanceof HttpEntityEnclosingRequest)) {
                    return true;
                }
                return false;
            };
        };
        httpClientBuilder.setRetryHandler(httpRequestRetryHandler);
    }

    /**
     *  获取连接
     * @return CloseableHttpClient
     */
    private static synchronized CloseableHttpClient getHttpClient() {
        if (httpClient == null) {
            httpClient = httpClientBuilder.build();
        }
        return httpClient;
    }

    /**
     *  配置请求特有参数（会覆盖通用配置），根据需要调用，一般使用通用配置即可
     * @param base
     * @param socketTimeout
     * @param connectTimeout
     * @param connectionRequestTimeout
     */
    private static void httpConfig(HttpRequestBase base, int socketTimeout, int connectTimeout, int connectionRequestTimeout) {
        RequestConfig.Builder builder = RequestConfig.custom();
        RequestConfig requestConfig = builder.setSocketTimeout(socketTimeout) // 从服务器获取响应数据需要等待的时间
                .setConnectTimeout(connectTimeout) // 设置等待连接超时时间
                .setConnectionRequestTimeout(connectionRequestTimeout) // 设置从连接池获取连接超时时间
                .build();
    }


    /**
     * post发送JSON数据，接收端如果不使用spring框架，接收端需要从request流中获取值
     * @param url
     * @param sendMsg
     * @return String
     * @throws IOException
     */
    private static String sendPost(String url, String sendMsg) throws IOException {
        HttpPost post = new HttpPost(url);
        post.setConfig(defaultRequestConfig);
        HttpEntity entity = EntityBuilder.create().setText(sendMsg).setContentType(ContentType.APPLICATION_JSON).build();
        post.setEntity(entity);
        CloseableHttpResponse response = null;
        String resultStr = null;
        try {
            response = getHttpClient().execute(post);
            HttpEntity respEntity = response.getEntity();
            resultStr = EntityUtils.toString(respEntity, "UTF-8");
        }
        catch (IOException e) {
            throw e;
        }
        finally {
            if (response != null) {
                try {
                    response.close();
                }
                catch (IOException e) {
                    throw e;
                }
            }
        }
        return resultStr;
    }

    public static <T> T sendPostAndParse(String url, Object requestData,Class<T> responseClazz){
        if(StringUtils.isEmpty(url)){
            throw new HttpConnectionException(ApplicationErrorCode.NOT_NULL,"请求路径不能为空");
        }
        String requestStr = null;
        try {
            requestStr = JSONUtil.objToJSON(requestData);
        } catch (IOException e) {
            throw new HttpConnectionException(ApplicationErrorCode.OBJECT_TO_JSON_FAIL,"通信失败：上送数据异常");
        }

        String responseStr = null;
        try {
            responseStr = sendPost(url, requestStr);
        } catch (IOException e) {
            throw new HttpConnectionException(ApplicationErrorCode.HTTP_ERROR,"通信异常");
        }
        T response = null;
        try {
            response= JSONUtil.JSONToObj(responseStr,responseClazz);
        } catch (IOException e) {
            throw new HttpConnectionException(ApplicationErrorCode.JSON_TO_OBJECT_FAIL,"通信异常：解析返回数据异常");
        }

        return response;
    }

    /**
     *  POST发送JSON数据，并解析结果到接收类
     * @param url 请求服务路径
     * @param jsonParamString json格式的参数字符串
     * @param responseClazz 答复结果类Class
     * @return
     * @author liuxiaosong(liuxs@yusys.com.cn)
     * @date 2017-4-27
     */
    public static <T> T sendPostAndParse(String url, String jsonParamString,Class<T> responseClazz){
        if(StringUtils.isEmpty(url)){
            throw new HttpConnectionException(ApplicationErrorCode.NOT_NULL,"请求路径不能为空");
        }
        if(StringUtils.isEmpty(jsonParamString)){
            throw new HttpConnectionException(ApplicationErrorCode.NOT_NULL,"请求JSON参数不能为空");
        }
        String responseStr = null;
        try {
            responseStr = sendPost(url, jsonParamString);
        } catch (IOException e) {
            throw new HttpConnectionException(ApplicationErrorCode.HTTP_ERROR,"通信异常",e);
        }
        T response = null;
        try {
            response=JSONUtil.JSONToObj(responseStr,responseClazz);
        } catch (IOException e) {
            throw new HttpConnectionException(ApplicationErrorCode.JSON_TO_OBJECT_FAIL,"通信异常：解析返回数据异常",e);
        }

        return response;
    }

    /**
     * 发送get请求
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static String sendGet(String url) throws IOException {
        HttpGet get = new HttpGet(url);
        CloseableHttpResponse response = null;
        String resultStr = null;
        try {
            response = getHttpClient().execute(get);
            HttpEntity entity = response.getEntity();
            resultStr = EntityUtils.toString(entity, "UTF-8");
        }
        catch (IOException e) {
            throw e;
        }
        finally {
            if (response != null) {
                try {
                    response.close();
                }
                catch (IOException e) {
                    throw e;
                }
            }
        }
        return resultStr;
    }

    /**
     *
     * @param useVirtualFormat
     * @param responseVirtualFormatFileName
     * @param charset
     * @param requestFormatModel
     * @param responseFormatModelClazz
     * @param <T>
     * @return T
     * @throws Exception
     */
    public static <T> T callHostServerByPost(boolean useVirtualFormat,
                                                       String responseVirtualFormatFileName,
                                                       String charset, Object requestFormatModel,
                                                       String shortUrl, Class<T> responseFormatModelClazz) throws Exception {
        // 使用虚拟报文
        if(useVirtualFormat){
            // 取当前时间为调用号
            long callNo = System.currentTimeMillis();
            // 检查请求报文实体对象是否正确
            // String
            // requestXmlString=ModelAndXmlParser.doParseModelToXml(requestFormatModel,charset);
            String requestJsonString = JSONUtil.objToJSON(requestFormatModel);
            logger.info("HttpUtil.callCashManagementServerByPost, 调用号:{}, 请求报文:{}", callNo, requestJsonString);
            // 读取答复报文
            InputStream responseJsonStream = FileUtils.openInputStream(new File(responseVirtualFormatFileName));

            // 将stream转化为String
            String responseJsonString = null;
            BufferedReader tempReader = new BufferedReader(new InputStreamReader(responseJsonStream, charset));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = tempReader.readLine()) != null){
                buffer.append(line);
            }
            responseJsonString = buffer.toString();
            logger.info("HttpUtil.callCashManagementServerByPost, 调用号:{}, 返回报文:{}", callNo, responseJsonString);

            if(responseJsonString != null){
                // 提取答复实体类对象
                // return
                // (T)ModelAndXmlParser.doParseXmlStringToModel(responseXmlString,responseFormatModelClazz);
                return (T) JSONUtil.JSONToObj(responseJsonString, responseFormatModelClazz);
            }
            else{
                throw new IntegrationException("虚拟报文不存在");
            }
        }

        List<String> urls = hostServerIntegrationConfig.getHostServerUrlList();
        if(urls == null || urls.size() <= 0){
            logger.error("HttpUtil.callCashManagementServerByPost, 请求路径不能为空");
            throw new HttpConnectionException(ApplicationErrorCode.NOT_NULL,"请求路径不能为空");
        }

        T response = null;
        String errorCode = "";
        String errorMessage = "";
        boolean allServersIsDown = true;

        for(String url:urls){
            try {
                if(StringUtils.isEmpty(shortUrl)) {
                    url += shortUrl;
                }
                response = sendPostAndParse(url, JSONUtil.objToJSON(requestFormatModel), responseFormatModelClazz);
            } catch (HttpConnectionException e) {
                logger.error("HttpUtil.callCashManagementServerByPost, 服务器{}通信失败，尝试下一个地址...", url);
                errorCode = e.getErrorCode();
                errorMessage = e.getMessage();
                continue;
            }
            allServersIsDown = false;
            break;
        }

        if(allServersIsDown){//所有服务器通信均失败，则抛异常
            throw new HttpConnectionException(errorCode, errorMessage);
        }

        return response;
    }
}
