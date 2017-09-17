package com.nuobao.common.exception;

import com.nuobao.common.constant.ApplicationErrorCode;
import com.nuobao.common.util.ConfigPropertiesReader;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

/**
 * 异常基类
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 12:16
 * @modify
 **/
public class BaseException extends RuntimeException {

	private static final long serialVersionUID = 3279177298537879700L;

	//默认是带明确错误信息的系统异常
	private String errorCode = ApplicationErrorCode.SYSTEM_ERROR;

	/**
	 * 返回错误码
	 * @return
	 */
	public String getErrorCode() {
		return this.errorCode;
	}
	/**
	 * 错误信息配置值中的占位符<br>
	 * 错误码中没有占位符时，错误信息内容将是placeHolderMessage[0]
	 */
	private Object[] placeHolderMessage;
	public Object[] getPlaceHolderMessage() {
		return placeHolderMessage;
	}

	/**
	 * @param errorCode 错误码
	 * @param errorMessage 错误信息
	 */
	public BaseException(String errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
	}

	/**
	 * @param errorCode 错误码
	 * @param errorMessage 错误信息
	 * @param cause 原异常
	 */
	public BaseException(String errorCode, String errorMessage, Throwable cause) {
		super(errorMessage, cause);
		this.errorCode = errorCode;
	}
	
	/**
	 * 本构造方法只适用于错误信息在properties文件中有配置的情况下，错误信息中有占位符时使用
	 * @param errorCode 错误码
	 * @param placeHolderMessage 错误信息占位符对应的实际值
	 */
	public BaseException(String errorCode, Object[] placeHolderMessage){
        super(ConfigPropertiesReader.getPropertyValue(errorCode, placeHolderMessage));
		this.errorCode = errorCode;
		this.placeHolderMessage = placeHolderMessage;
	}
	
	/**
	 * 本构造方法只适用于错误信息在properties文件中有配置的情况下，错误信息中有占位符时使用
	 * @param errorCode 错误码
	 * @param placeHolderMessage 错误信息占位符对应的实际值
	 * @param cause 原异常
	 */
	public BaseException(String errorCode, Object[] placeHolderMessage, Throwable cause) {
		super(ConfigPropertiesReader.getPropertyValue(errorCode, placeHolderMessage), cause);
		this.errorCode = errorCode;
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
		String errorStack = new String(bo.toByteArray(), Charset.defaultCharset());
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
