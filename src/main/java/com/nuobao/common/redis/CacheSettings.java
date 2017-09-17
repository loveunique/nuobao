package com.nuobao.common.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 缓存配置信息
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 12:57
 * @modify
 **/
@Component
@ConfigurationProperties("cache")
public class CacheSettings {

	private String cacheName;

	private String tmpCacheName;

	private String imgCodeCacheName;

	private String accessTokenCacheName;

	/**
	 * 如果要用Spring的redis封装处理类时,下面的类型要改成Long
	 */
	private int cacheExpireSeconds = 600;
	
	private int imageCacheExpireeSeconds = 600;
	
	private int tempCacheExpireeSeconds = 180;

	private int accessTokenCacheExpireeSeconds = 4260;
	
	public String getCacheName() {
		return cacheName;
	}

	public void setCacheName(String cacheName) {
		this.cacheName = cacheName;
	}

	public String getTmpCacheName() {
		return tmpCacheName;
	}

	public void setTmpCacheName(String tmpCacheName) {
		this.tmpCacheName = tmpCacheName;
	}

	public String getImgCodeCacheName() {
		return imgCodeCacheName;
	}

	public void setImgCodeCacheName(String imgCodeCacheName) {
		this.imgCodeCacheName = imgCodeCacheName;
	}

	public String getAccessTokenCacheName() {
		return accessTokenCacheName;
	}

	public void setAccessTokenCacheName(String accessTokenCacheName) {
		this.accessTokenCacheName = accessTokenCacheName;
	}

	public int getCacheExpireSeconds() {
		return cacheExpireSeconds;
	}

	public void setCacheExpireSeconds(int cacheExpireSeconds) {
		this.cacheExpireSeconds = cacheExpireSeconds;
	}

	public int getImageCacheExpireeSeconds() {
		return imageCacheExpireeSeconds;
	}

	public void setImageCacheExpireeSeconds(int imageCacheExpireeSeconds) {
		this.imageCacheExpireeSeconds = imageCacheExpireeSeconds;
	}

	public int getTempCacheExpireeSeconds() {
		return tempCacheExpireeSeconds;
	}

	public void setTempCacheExpireeSeconds(int tempCacheExpireeSeconds) {
		this.tempCacheExpireeSeconds = tempCacheExpireeSeconds;
	}

	public int getAccessTokenCacheExpireeSeconds() {
		return accessTokenCacheExpireeSeconds;
	}

	public void setAccessTokenCacheExpireeSeconds(int accessTokenCacheExpireeSeconds) {
		this.accessTokenCacheExpireeSeconds = accessTokenCacheExpireeSeconds;
	}
	
	
}
