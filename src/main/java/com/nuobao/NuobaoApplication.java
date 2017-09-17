package com.nuobao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 创建系统启动类
 */
@SpringBootApplication
@Configuration
// 指定扫描范围
@ComponentScan(basePackages = { "com.nuobao.common", "com.nuobao.bussiness"})
public class NuobaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NuobaoApplication.class, args);
	}
}
