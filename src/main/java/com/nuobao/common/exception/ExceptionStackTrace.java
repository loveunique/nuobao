package com.nuobao.common.exception;

import java.io.Serializable;

/**
 * 发生异常,返回时,用于保存异常信息的详细stack内容
 * 用于设置到OperationResult.businessDataObject字段中
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 12:16
 * @modify
 **/
public class ExceptionStackTrace implements Serializable{

	private static final long serialVersionUID = 600784368555787298L;
	/**
	 * 异常信息的stackTrace
	 */
	private String stackTrace;

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}
	
	
}
