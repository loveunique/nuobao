package com.nuobao.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志记录工具类
 */
public class LoggingUtil {

	private static final Logger logger = LoggerFactory.getLogger(LoggingUtil.class);
	
	public static void creatLogging() {
		logger.info("----------------------------------INFO");
		logger.debug("----------------------------------DEBUG");
		logger.error("----------------------------------ERROR");
	}
}
