package com.nuobao.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 从Spring的ApplicationContext中获得组件类对象
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 12:16
 * @modify
 **/
@Component
public class ApplicationContextUtil implements ApplicationContextAware {

    private static Logger logger = LoggerFactory.getLogger(ApplicationContextUtil.class);

	private static ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext){
		context = applicationContext;
	}
	
	public static Object getBeanByName(String beanName) {
		if (context == null) {
            logger.error("ApplicationContextUtil.getBeanByName --> ApplicationContext为空，不能取得组件：{}", beanName);
			return null;
		}
		return context.getBean(beanName);
	}

	public static <T> T getBeanByClass(Class<T> type) {
		if (context == null) {
            logger.error("ApplicationContextUtil.getBeanByName --> ApplicationContext为空，不能取得该类型的组件：{}", type);
			return null;
		}
		return (T)context.getBean(type);
	}
	
}
