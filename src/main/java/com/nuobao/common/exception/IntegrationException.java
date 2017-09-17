package com.nuobao.common.exception;

import com.nuobao.common.constant.ApplicationErrorCode;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * 通信异常
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 12:16
 * @modify
 **/
public class IntegrationException extends BaseException{

	private static final long serialVersionUID = -2486163958609210807L;

	/**
	 * @param errorMessage 错误信息
	 */
	public IntegrationException(String errorMessage) {
		super(ApplicationErrorCode.HTTP_ERROR, errorMessage);
	}

	/**
	 * @param errorCode 错误码
	 * @param errorMessage 错误信息
	 */
	public IntegrationException(String errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}

	/**
	 * @param errorMessage 错误信息
	 * @param cause 原异常
	 */
	public IntegrationException(String errorMessage, Throwable cause) {
		super(ApplicationErrorCode.HTTP_ERROR, errorMessage, cause);
	}

	/**
	 * @param errorCode 错误码
	 * @param errorMessage 错误信息
	 * @param cause 原异常
	 */
	public IntegrationException(String errorCode, String errorMessage, Throwable cause) {
		super(errorCode, errorMessage, cause);
	}

	/**
	 * 本构造方法只适用于错误信息在properties文件中有配置的情况下，错误信息中有占位符时使用
	 * @param errorCode 错误码
	 * @param placeHolderMessage 错误信息占位符对应的实际值
	 */
	public IntegrationException(String errorCode, Object[] placeHolderMessage){
		super(errorCode, placeHolderMessage);
	}
	
	/**
	 * 本构造方法只适用于错误信息在properties文件中有配置的情况下，错误信息中有占位符时使用
	 * @param errorCode 错误码
	 * @param placeHolderMessage 错误信息占位符对应的实际值
	 * @param cause 原异常
	 */
	public IntegrationException(String errorCode, Object[] placeHolderMessage, Throwable cause) {
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
