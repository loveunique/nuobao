package com.nuobao.common.result;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 处理结果对象，其他具体的业务功能中返回字段比较多的输出类时，输出类都需要先继承该类
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 12:16
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class OperationResult implements Serializable{

	private static final long serialVersionUID = 1812405387925792252L;

	/**
	 * 返回码
	 */
	private String resultCode="0";

	/**
	 * 返回类型
	 */
	private String resultMessage="ok";

	/**
	 * 时间戳
	 */
	private String timeStamp;

	/**
	 * 业务数据对象
	 */
	Object businessDataObject = null;

	/**
	 * 无参构造方法
	 */
	public OperationResult(){
		super();
	}

	/**
	 * 设置返回信息的构造方法,用于成功时返回明确的成功消息
	 * @param resultMessage 返回详细提示消息
	 */
	public OperationResult(String resultMessage){
		this.resultMessage = resultMessage;
	}

	/**
	 * 设置返回码和返回信息的构造方法,一般用于发生错误时设置
	 * @param resultCode 错误码
	 * @param resultMessage 错误信息
	 */
	public OperationResult(String resultCode,String resultMessage){
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
	}

	/**
	 * 正确情况下,只设置业务对象的构造方法
	 * @param businessDataObject 业务数据对象
	 */
	public OperationResult(Object businessDataObject){
		this.businessDataObject = businessDataObject;
	}
	
	/**
	 * 正确情况下,设置明确返回信息,并设置业务对象的构造方法
	 * @param resultMessage 返回详细提示消息
	 * @param businessDataObject 业务数据对象
	 */
	public OperationResult(String resultMessage,Object businessDataObject){
		this.resultMessage = resultMessage;
		this.businessDataObject = businessDataObject;
	}
	
	/**
	 * 明确设置返回码、返回信息、返回业务对象
	 * @param resultCode 返回码
	 * @param resultMessage 返回详细提示消息
	 * @param businessDataObject 返回业务对象
	 */
	public OperationResult(String resultCode,String resultMessage,Object businessDataObject){
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
		this.businessDataObject = businessDataObject;
	}
	
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	public Object getBusinessDataObject() {
		return businessDataObject;
	}
	public void setBusinessDataObject(Object businessDataObject) {
		this.businessDataObject = businessDataObject;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
}
