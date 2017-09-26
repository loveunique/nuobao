package com.nuobao.common.service;

import com.nuobao.common.constant.ApplicationErrorCode;
import com.nuobao.common.exception.BaseException;
import com.nuobao.common.exception.CacheException;
import com.nuobao.common.exception.SessionTimeOutException;
import com.nuobao.common.exception.TranFailException;
import com.nuobao.common.redis.CacheSettings;
import com.nuobao.common.redis.RedisUtil;
import com.nuobao.common.util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * Session逻辑类
 *
 * @author Xu Chengzhi
 * @date 2017-09-19 九月 21:23
 * @modify
 **/
@Component
public class SessionService {

    private static Logger logger = LoggerFactory.getLogger(SessionService.class);

    private static CacheSettings cacheSettings;

    /**
     * 退出系统，清除token
     * @param sessionToken
     */
    public static void destorySessionWhenLogout(String sessionToken) {
        logger.info("SessionService.destorySessionWhenLogout --> sessionToken:{}", sessionToken);
        if(StringUtils.isEmpty(sessionToken)) {
            throw new TranFailException(ApplicationErrorCode.NOT_NULL, "token为空");
        }

        try {
            String encryptedSessionToken = getEncryptedSessionToken(sessionToken);
            /*
             * 取出sessionToken缓存数据
             */
            Object value = RedisUtil.get(encryptedSessionToken);

            //无论值是否存在，都清理这条缓存
            RedisUtil.evict(encryptedSessionToken);
        } catch (Exception e) {
            logger.error("SessionService.destorySessionWhenLogout --> Exception:{}", e);
        }
    }

    /**
     * 对sessionToken做二次加密
     * @param sessionToken
     * @return
     */
    public static String getEncryptedSessionToken(String sessionToken){
        /*
         * 对sessionToken和sessionContextKey做二次加密
         */
        String encryptedSessionToken = null;
        try{
            encryptedSessionToken = MD5Util.encodeByMD5(sessionToken);
        }
        catch (Exception e){

            throw new TranFailException(ApplicationErrorCode.SYSTEM_ERROR, "系统异常");
        }
        return encryptedSessionToken;
    }

    /**
     * 检查session是否有效
     * @param sessionToken
     * @param httpSessionId
     * @param clientIp
     */
    public static void checkSessionAndAccessAuth(String sessionToken, String httpSessionId, String clientIp) {
        if(StringUtils.isEmpty(sessionToken)){
            throw new SessionTimeOutException(ApplicationErrorCode.LOGIN_TIMEOUT, "Session已超时");
        }

        if(StringUtils.isEmpty(httpSessionId)){
            throw new SessionTimeOutException(ApplicationErrorCode.LOGIN_TIMEOUT, "Session已超时");
        }

        if(StringUtils.isEmpty(clientIp)){
            throw new SessionTimeOutException(ApplicationErrorCode.LOGIN_TIMEOUT, "Session已超时");
        }
        /*
         * 对sessionToken和sessionContextKey做二次加密
         */
        String encryptedSessionToken = getEncryptedSessionToken(sessionToken);
        try{
            /*
             * 中获取sessionToken反向验证
             */
            Map<String, String> redisSessionMap = (Map<String, String>) RedisUtil.get(encryptedSessionToken);
            String redisSessionToken = redisSessionMap.get("sessionToken");
            String redisHttpSessionId = redisSessionMap.get("httpSessionId");
            String redisClientIP = redisSessionMap.get("clientIp");
            if(!encryptedSessionToken.equals(redisSessionToken)){
                try{
                    //清除这条无效的sessionToken的缓存
                    RedisUtil.evict(encryptedSessionToken);
                }
                catch (Exception e){
                    throw new CacheException(ApplicationErrorCode.CACHE_ERROR, "缓存服务器异常", e);
                }
                throw new SessionTimeOutException(ApplicationErrorCode.LOGIN_TIMEOUT, "Session已超时");
            }

            /*
             * 检查httpSessionId是否一致
             */
            if(!httpSessionId.equals(redisHttpSessionId)){
                try{
                    //清除这条无效的sessionToken的缓存
                    RedisUtil.evict(encryptedSessionToken);
                }
                catch (Exception e){
                    throw new CacheException(ApplicationErrorCode.CACHE_ERROR, "缓存服务器异常", e);
                }
                throw new SessionTimeOutException(ApplicationErrorCode.LOGIN_TIMEOUT, "Session已超时");
            }

            /*
             * 检查当前IP和缓存的上次操作IP是否一致，不一致时按超时处理
             */
			if(!clientIp.equals(redisClientIP)){
				try{
					//清除这条无效的sessionToken的缓存
					RedisUtil.evict(encryptedSessionToken);
				}
				catch (Exception e){
					throw new CacheException(ApplicationErrorCode.CACHE_ERROR, "缓存服务器异常", e);
				}
				throw new SessionTimeOutException(ApplicationErrorCode.LOGIN_TIMEOUT, "Session已超时");
			}
        } catch(BaseException e){
            throw e;
        }
    }

    /**
     * 更新session数据
     * @param sessionToken
     * @param httpSessionId
     * @param clientIp
     */
    public static void updateSession(String sessionToken, String httpSessionId, String clientIp) {
        if(StringUtils.isEmpty(sessionToken)){
            throw new SessionTimeOutException(ApplicationErrorCode.LOGIN_TIMEOUT, "Session已超时");
        }

        if(StringUtils.isEmpty(httpSessionId)){
            throw new SessionTimeOutException(ApplicationErrorCode.LOGIN_TIMEOUT, "Session已超时");
        }

        if(StringUtils.isEmpty(clientIp)){
            throw new SessionTimeOutException(ApplicationErrorCode.LOGIN_TIMEOUT, "Session已超时");
        }
        /*
         * 对sessionToken和sessionContextKey做二次加密
         */
        String encryptedSessionToken = getEncryptedSessionToken(sessionToken);
        try{
            Map<String, String> redisSessionMap = (Map<String, String>) RedisUtil.get(encryptedSessionToken);
            redisSessionMap.put("sessionToken", sessionToken);
            redisSessionMap.put("httpSessionId", httpSessionId);
            redisSessionMap.put("clientIp", clientIp);
            RedisUtil.put(cacheSettings.getCacheName(), encryptedSessionToken, redisSessionMap);
        } catch(BaseException e){
            throw e;
        }
    }
}
