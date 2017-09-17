package com.nuobao.common.http;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 创建服务器配置
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 16:00
 * @modify
 **/
@Component
@ConfigurationProperties(prefix = "hostServer")
public class ServerSettings {
}
