package com.nuobao.common.util;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 系统中一些特定的.properties文件中定义的信息提取工具
 * error定义.properties，业务信息定义.properties
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 12:16
 * @modify
 **/
@Component
public class ConfigPropertiesReader implements ApplicationContextAware {
	/**
	 * Spring ApplicationContext
	 */
	private static ApplicationContext applicationContext;

	@SuppressWarnings("static-access")
	public void setApplicationContext(ApplicationContext applicationContext) {
		ConfigPropertiesReader.applicationContext = applicationContext;
	}

	/**
	 * 获取配置值
	 * @param code
	 * @return
	 */
	public static final String getPropertyValue(String code) {
		return applicationContext.getMessage(code, null, null);
	}

	/**
	 * 获取配置值
	 * @param code 配置值名称
	 * @param defaultValue 配制中不存在时的默认值
	 * @return
	 */
	public static final String getPropertyValue(String code, String defaultValue) {
		return applicationContext.getMessage(code, null, defaultValue, null);
	}

	/**
	 * 获取配置值
	 * @param code
	 * @param locale
	 * @return
	 */
	public static final String getPropertyValue(String code,Locale locale) {
		return applicationContext.getMessage(code, null, locale);
	}

	/**
	 * 获取配置值
	 * @param code 配置值名称
	 * @param placeHolderValue 配置值占位符实际值
	 * @return
	 */
	public static final String getPropertyValue(String code, Object[] placeHolderValue) {
		return applicationContext.getMessage(code, placeHolderValue, null);
	}

	/**
	 * 获取配置值
	 * @param code 配置值名称
	 * @param placeHolderValue 配置值占位符实际值
	 * @return
	 */
	public static final String getPropertyValue(String code, Object[] placeHolderValue,Locale locale) {
		return applicationContext.getMessage(code, placeHolderValue, locale);
	}

	/**
	 * 获取配置值
	 * @param code 配置值名称
	 * @param defaultValue 如果配置文件中没有找到时,要设置的默认值
	 * @param placeHolderValue 配置值占位符实际值
	 * @return
	 */
	public static final String getPropertyValue(String code, String defaultValue, Object[] placeHolderValue) {
		return applicationContext.getMessage(code, placeHolderValue,defaultValue, null);
	}

	/**
	 * 获取配置值
	 * @param code 配置值名称
	 * @param defaultValue 如果配置文件中没有找到时,要设置的默认值
	 * @param placeHolderValue 配置值占位符实际值
	 * @return
	 */
	public static final String getPropertyValue(String code, String defaultValue, Object[] placeHolderValue,Locale locale) {
		return applicationContext.getMessage(code, placeHolderValue,defaultValue, locale);
	}
}
