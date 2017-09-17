package com.nuobao.common.exception;

import com.nuobao.common.constant.ApplicationErrorCode;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * 缓存异常
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 12:16
 * @modify
 **/
public class CacheException extends BaseException {
	private static final long serialVersionUID = -7133998308000010505L;

	/**
	 * @param errorMessage 错误信息
	 */
	public CacheException(String errorMessage) {
		super(ApplicationErrorCode.CACHE_ERROR, errorMessage);
	}
	/**
	 * @param errorMessage 错误信息
	 * @param cause 原异常
	 */
	public CacheException(String errorMessage, Throwable cause) {
		super(ApplicationErrorCode.CACHE_ERROR, errorMessage, cause);
	}
	/**
	 * @param errorCode 错误码
	 * @param errorMessage 错误信息
	 */
	public CacheException(String errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}

	/**
	 * @param errorCode 错误码
	 * @param errorMessage 错误信息
	 * @param cause 原异常
	 */
	public CacheException(String errorCode, String errorMessage, Throwable cause) {
		super(errorCode, errorMessage, cause);
	}

	/**
	 * 本构造方法只适用于错误信息在properties文件中有配置的情况下，错误信息中有占位符时使用
	 * @param errorCode 错误码
	 * @param placeHolderMessage 错误信息占位符对应的实际值
	 */
	public CacheException(String errorCode, Object[] placeHolderMessage){
		super(errorCode, placeHolderMessage);
	}
	
	/**
	 * 本构造方法只适用于错误信息在properties文件中有配置的情况下，错误信息中有占位符时使用
	 * @param errorCode 错误码
	 * @param placeHolderMessage 错误信息占位符对应的实际值
	 * @param cause 原异常
	 */
	public CacheException(String errorCode, Object[] placeHolderMessage, Throwable cause) {
		super(errorCode, placeHolderMessage, cause);
	}
	
	/**
	 * 取得Error的StackTrace
	 * 
	 * @return String
	 */
	public String getErrorStack() {
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(bo);
		printStackTrace(ps);
		String errorStack = new String(bo.toByteArray());
		return errorStack;
	}

	@Override
	public String toString() {
		Throwable cause = super.getCause();
		if(cause == null || cause == this){
			return "errorCode:" + this.getErrorCode() + ",errorMessage:" + this.getMessage();
		}
		else{
			return "errorCode:" + this.getErrorCode() + ",errorMessage:" + this.getMessage() + "\n[See nested exception: " + cause + "]";
		}
	}
}