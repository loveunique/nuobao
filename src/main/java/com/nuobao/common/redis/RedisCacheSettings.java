package com.nuobao.common.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取Redis缓存配置
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 12:57
 * @modify
 **/
@Component
@ConfigurationProperties(prefix = "redis")
public class RedisCacheSettings {

    private String ip;

    private Integer port;

    private String sentinelAndPort;

    private String masterName;

    private Integer maxIdle;

    private Integer maxTotal;

    private Integer minIdle;

    private Long maxWaitMillis;

    private Boolean testOnBorrow;

    private Boolean testOnReturn;

    private Boolean testWhileIdle;

    private Long timeBetweenEviction;

    private Integer NumTestPerEviction;

    private Long softMinEvictableIdleTime;

    private Integer timeout;

    public Boolean getTestWhileIdle() {
        return testWhileIdle;
    }

    public void setTestWhileIdle(Boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    public String getSentinelAndPort() {
        return sentinelAndPort;
    }

    public void setSentinelAndPort(String sentinelAndPort) {
        this.sentinelAndPort = sentinelAndPort;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public Integer getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(Integer maxIdle) {
        this.maxIdle = maxIdle;
    }

    public Integer getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(Integer maxTotal) {
        this.maxTotal = maxTotal;
    }

    public Integer getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(Integer minIdle) {
        this.minIdle = minIdle;
    }

    public Long getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public void setMaxWaitMillis(Long maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }

    public Boolean getTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(Boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public Boolean getTestOnReturn() {
        return testOnReturn;
    }

    public void setTestOnReturn(Boolean testOnReturn) {
        this.testOnReturn = testOnReturn;
    }

    public Long getTimeBetweenEviction() {
        return timeBetweenEviction;
    }

    public void setTimeBetweenEviction(Long timeBetweenEviction) {
        this.timeBetweenEviction = timeBetweenEviction;
    }

    public Integer getNumTestPerEviction() {
        return NumTestPerEviction;
    }

    public void setNumTestPerEviction(Integer numTestPerEviction) {
        NumTestPerEviction = numTestPerEviction;
    }

    public Long getSoftMinEvictableIdleTime() {
        return softMinEvictableIdleTime;
    }

    public void setSoftMinEvictableIdleTime(Long softMinEvictableIdleTime) {
        this.softMinEvictableIdleTime = softMinEvictableIdleTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }
}
