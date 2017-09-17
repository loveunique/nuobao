package com.nuobao.common.http;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建后台服务地址配置
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 16:06
 * @modify
 **/
public class HostServerIntegrationConfig {

    /**
     * 定时任务系统URL<br>
     * 格式为逗号分割：url1,url2...
     */
    @Value("${integration.hostServerUrl}")
    private String hostServerUrl;

    /**
     * URL可以有多个,hostServerUrlList被set时,该值是分割hostServerUrl而来
     */
    private List<String> hostServerUrlList;

    /**
     * 设置URL，通过在application-xxxx.properties中设置，该方法被spring调用
     * @author Xu Chengzhi  2017-8-2 下午4:56:38
     * @param cashManagementUrl
     */
    public void setHostServerUrlList(String cashManagementUrl) {
        if(StringUtils.isEmpty(hostServerUrl)) {
            this.hostServerUrl = hostServerUrl;
        }
        if(this.hostServerUrl != null && !"".equals(this.hostServerUrl)){
            String[] hostServerUrlArray = this.hostServerUrl.split(",");
            this.hostServerUrlList = new ArrayList<String>(hostServerUrlArray.length);
            for(String url: hostServerUrlArray){
                this.hostServerUrlList.add(url.trim());
            }
        }
    }

    public List<String> getHostServerUrlList() {
        return hostServerUrlList;
    }

}
