package com.nuobao;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * 创建系统启动类
 */
@SpringBootApplication
@Configuration
// 指定扫描范围
@ComponentScan
public class NuobaoApplication {

    /**
     * 添加fastjson支持
     * @return HttpMessageConverters
     */
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastConverter.setFastJsonConfig(fastJsonConfig);
		HttpMessageConverter<?> converter = fastConverter;
		return new HttpMessageConverters(converter);
	}

    /**
     * 设置文件上传控制
     * @return MultipartResolver
     */
	@Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        //设置上传文件总大小
        multipartResolver.setMaxUploadSize(10000000);
        //设置上传单个文件大小
        multipartResolver.setMaxUploadSizePerFile(10000000);
        return multipartResolver;
    }

	public static void main(String[] args) {
		SpringApplication.run(NuobaoApplication.class, args);
	}
}
