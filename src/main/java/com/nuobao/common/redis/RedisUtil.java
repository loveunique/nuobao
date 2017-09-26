package com.nuobao.common.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nuobao.common.exception.CacheException;
import com.nuobao.common.util.SerializeUtil;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Redis工具类
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 12:57
 * @modify
 **/
public class RedisUtil {

	private static JedisSentinelPool pool;
	
	private static CacheSettings cacheSettings;
	
	private static RedisCacheSettings redisCacheSettings;
	
	private static ObjectMapper objectMapper;
	
	/**
	 * 缓存数据,使用自定义时间
	 * @param key 缓存key
	 * @param expire 缓存时间
	 * @param value 缓存的数据
	 */
	public static void put(String key,Integer expire,Object value){
		if(key == null || "".endsWith(key)){
			throw new CacheException("redis缓存参数有误");
		};
		Jedis jedis = getRedis();
		boolean tag = false;
		try {
			if(expire==-1){
				jedis.set(key.getBytes("UTF-8"), SerializeUtil.serialize(value));
			}
			else{
				jedis.setex(key.getBytes("UTF-8"), expire, SerializeUtil.serialize(value)/* objectMapper.writeValueAsBytes(value)*/);
			}
		} catch (Exception e) {
			tag = true;
		}finally{
			clearCache(tag, jedis);
		};
	}
	
	/**
	 * 缓存数据，使用默认设定的时间
	 * @Title: put
	 * @param type 缓存名称,对应application.properties中的cache分组中的某个值
	 * @param key 缓存key
	 * @param value 缓存的数据
	 */
	public static void put(String type,String key,Object value){
		Jedis jedis = getRedis();
		boolean tag = false;
		try {
			int expire = 0;
			if(key == null || "".endsWith(key) || type == null || "".endsWith(type)){
				throw new CacheException("redis缓存参数有误");
			};
			if(type.equals(cacheSettings.getCacheName())){
				expire = cacheSettings.getCacheExpireSeconds();//缓存时间
			}else if(type.equals(cacheSettings.getTmpCacheName())){
				expire = cacheSettings.getTempCacheExpireeSeconds();//临时缓存时间
			}else if(type.equals(cacheSettings.getImgCodeCacheName())){
				expire = cacheSettings.getImageCacheExpireeSeconds();//图片缓存时间
			}else if(type.equals(cacheSettings.getAccessTokenCacheName())){
				expire = cacheSettings.getAccessTokenCacheExpireeSeconds();//微信token缓存 71minutes(微信token默认是72分钟，本地最好小于官方的)
			}else{
				throw new CacheException("redis缓存参数有误");
			};
			
//			jedis.setex(key.getBytes("UTF-8"), expire, objectMapper.writeValueAsBytes(value));
			jedis.setex(key.getBytes("UTF-8"), expire, SerializeUtil.serialize(value));
		} catch (Exception e) {
			tag = true;
		}finally{
			clearCache(tag, jedis);
		}
	}
	
	/**
	 * 获取缓存数据
	 * @param key
	 * @return
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static Object get(String key) throws CacheException{
		if(key == null || "".endsWith(key)){
			throw new CacheException("redis缓存参数有误");
		};
		Jedis jedis = getRedis();
		Object obj = null;
		boolean tag = false;
		try {
			byte[] bs = jedis.get(key.getBytes("UTF-8"));
			if(bs != null){
//				obj = objectMapper.readValue(bs, Object.class);
				obj = SerializeUtil.unserialize(bs);
			};
		}
		catch (Exception e) {
			tag = true;
			throw new CacheException("无法获取缓存数据",e);
		}
		finally{
			clearCache(tag, jedis);
		};
		return obj;
	}
	
	/**
	 * 更新缓存时间
	 * @param key 缓存key
	 * @param expire 缓存时间
	 * @throws Exception 
	 */
	public static void setExpiration(String key, Integer expire) throws Exception{
		if(key == null || "".endsWith(key)){
			throw new CacheException("redis缓存参数有误");
		};
		Jedis jedis = getRedis();
		boolean tag = false;
		try {
			jedis.expire(key.getBytes("UTF-8"), expire);
		}catch (Exception e) {
			tag = true;
			throw e;
		}finally{
			clearCache(tag, jedis);
		};
	}
	
	/**
	 * 更新缓存时间，使用预设的时间
	 * @param type 缓存类型，对应application.properties中的cache分组中的某个值
	 * @param key 缓存key
	 * @throws Exception 
	 */
	public static void setExpiration(String type,String key) throws Exception{
		Jedis jedis = getRedis();
		boolean tag = false;
		try {
			Integer expire = 0;
			if(key == null || "".endsWith(key) || type == null || "".endsWith(type)){
				throw new CacheException("redis缓存参数有误");
			};
			if(type.equals(cacheSettings.getCacheName())){
				expire = cacheSettings.getCacheExpireSeconds();//缓存时间
			}else if(type.equals(cacheSettings.getTmpCacheName())){
				expire = cacheSettings.getTempCacheExpireeSeconds();//临时缓存时间
			}else if(type.equals(cacheSettings.getImgCodeCacheName())){
				expire = cacheSettings.getImageCacheExpireeSeconds();//图片缓存时间
			}else if(type.equals(cacheSettings.getAccessTokenCacheName())){
				expire = cacheSettings.getAccessTokenCacheExpireeSeconds();//微信token缓存 71minutes(微信token默认是72分钟，本地最好小于官方的)
			}else{
				throw new CacheException("redis缓存参数有误");
			};
			
			jedis.expire(key.getBytes("UTF-8"), expire);
		}catch (Exception e) {
			tag = true;
			throw e;
		}finally{
			clearCache(tag, jedis);
		};
	}
	
	/**
	 * 清除缓存
	 * @param key 缓存key
	 * @throws Exception 
	 */
	public static void evict(String key) throws Exception{
		if(key == null || "".endsWith(key)){
			throw new CacheException("redis缓存参数有误");
		};
		Jedis jedis = getRedis();
		boolean tag = false;
		try {
			jedis.del(key.getBytes("UTF-8"));
		}catch (Exception e) {
			tag = true;
			throw e;
		}finally{
			clearCache(tag, jedis);
		};
	}
	
	/**
	 * 检查缓存是否存在
	 * @Title: isExists
	 * @param key
	 * @return
	 */
	public static Boolean exists(String key){
		if(key == null || "".endsWith(key)){
			throw new CacheException("redis缓存参数有误");
		};
		Jedis jedis = getRedis();
		Boolean exists = false;
		boolean tag = false;
		try {
			exists = jedis.exists(key.getBytes("UTF-8"));
		} catch (Exception e) {
			tag = true;
		} finally{
			clearCache(tag, jedis);
		};
		return exists;
	}
	
	/**
	 * 取得redis
	 * @return
	 */
	public static Jedis getRedis(){
		Jedis jedis = null;
		try{
			jedis = pool.getResource();
		}catch (Exception e) {
			clearCache(true, jedis);
    	}
		return jedis;
	}
	
	/**
	 * 初始化redis连接池
	 * @Title: initRedis
	 */
	public static void initRedis(){
		GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
		poolConfig.setMaxIdle(redisCacheSettings.getMaxIdle());
		poolConfig.setMaxTotal(redisCacheSettings.getMaxTotal());
		poolConfig.setMinIdle(redisCacheSettings.getMinIdle());
		poolConfig.setMaxWaitMillis(redisCacheSettings.getMaxWaitMillis());
		poolConfig.setTestOnBorrow(redisCacheSettings.getTestOnBorrow());// 获得一个jedis是否检查连接可用性
		poolConfig.setTestOnReturn(redisCacheSettings.getTestOnReturn());// return一个jedis是否检查连接可用性
		poolConfig.setTestWhileIdle(redisCacheSettings.getTestWhileIdle()); // 空闲时检查连接
		poolConfig.setTimeBetweenEvictionRunsMillis(redisCacheSettings.getTimeBetweenEviction());// 两次扫描之间休眠的毫秒数.getNumTestPerEviction());// 每次扫描最多的对象数
		poolConfig.setSoftMinEvictableIdleTimeMillis(redisCacheSettings.getSoftMinEvictableIdleTime());// 对象空闲多久后逐出
		Set<String> sentinels = new HashSet<String>();
		String[] hostAndPorts = redisCacheSettings.getSentinelAndPort().split(",");
		for (String hap : hostAndPorts) {
			sentinels.add(hap);
		};
		pool = new JedisSentinelPool(redisCacheSettings.getMasterName(), sentinels, poolConfig);
		objectMapper = new ObjectMapper();
	}
	
	/**
	 * 释放资源
	 * @param tag
	 * @param jedis
	 */
	private static void clearCache(boolean tag,Jedis jedis){
		if(jedis != null){
			if(tag){
				pool.returnBrokenResource(jedis);
			}else{
				pool.returnResource(jedis);
			};
		}
	}


	public static CacheSettings getCacheSettings() {
		return cacheSettings;
	}

	public static void setCacheSettings(CacheSettings cacheSettings) {
		RedisUtil.cacheSettings = cacheSettings;
	}

	public static JedisSentinelPool getPool() {
		return pool;
	}

	public static void setPool(JedisSentinelPool pool) {
		RedisUtil.pool = pool;
	}

	public static RedisCacheSettings getRedisCacheSettings() {
		return redisCacheSettings;
	}

	public static void setRedisCacheSettings(RedisCacheSettings redisCacheSettings) {
		RedisUtil.redisCacheSettings = redisCacheSettings;
	}

	public static ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	public static void setObjectMapper(ObjectMapper objectMapper) {
		RedisUtil.objectMapper = objectMapper;
	}

}
