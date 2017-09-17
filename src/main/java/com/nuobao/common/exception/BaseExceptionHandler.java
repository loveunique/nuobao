package com.nuobao.common.exception;

import com.nuobao.common.constant.ApplicationErrorCode;
import com.nuobao.common.util.ConfigPropertiesReader;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

/**
 * 异常处理器，如果是特定类型的错误则抛出错误信息<br>
 * 如果是其他异常，则尝试从错误配置中读取错误码对应的错误信息<br>
 * 其他情况，统一抛出999999交易异常
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 12:16
 * @modify
 **/
@ControllerAdvice(annotations = {
		Controller.class, RestController.class
})
public class BaseExceptionHandler implements PriorityOrdered {
	
	@ExceptionHandler(value = {
		BaseException.class
	})
	@ResponseBody
	public OperationResult baseExceptionHandler(BaseException e) {
		String errorCode = e.getErrorCode();
		String errorMessage = null;
		if(errorCode == null || "".equals(errorCode)){
			errorCode = ApplicationErrorCode.SYSTEM_ERROR;
			errorMessage = "交易异常";
		} else{
			/*
			 * 自带异常信息最次
			 * 如果errorCode中没有被定义,则取异常中自带的错误信息
			 */
			errorMessage = e.getMessage();
			if(errorMessage == null || "".equals(errorMessage)){
				/*
				 *常量配置文件定义次之
				 */
				Object[] placeHolderValue = e.getPlaceHolderMessage();
				if(placeHolderValue != null){
					errorMessage = ConfigPropertiesReader.getPropertyValue(errorCode, placeHolderValue, LocaleContextHolder.getLocale());
				}
			}
		}
		ExceptionStackTrace stackTrace=new ExceptionStackTrace();
		stackTrace.setStackTrace(e.getErrorStack());
		OperationResult result = new OperationResult(errorCode, errorMessage, stackTrace);
		return result;
	}

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public OperationResult otherExceptionHandler(Exception e) {
		String errorCode = ApplicationErrorCode.SYSTEM_ERROR;
		//如果errorCode中没有被定义,则取异常中自带的错误信息
		String errorMessage = ConfigPropertiesReader.getPropertyValue(errorCode, "交易异常");
		ExceptionStackTrace stackTrace=new ExceptionStackTrace();
		stackTrace.setStackTrace(BaseExceptionHandler.getErrorStack(e));
		OperationResult result = new OperationResult(errorCode, errorMessage, stackTrace);
		return result;
	}

	@Override
	public int getOrder() {
		return PriorityOrdered.HIGHEST_PRECEDENCE;
	}
	/**
	 * 获取异常详细信息
	 * @param e
	 * @return
	 */
	public static String getErrorStack(Exception e) {
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(bo);
		e.printStackTrace(ps);
		String errorStack = new String(bo.toByteArray(), Charset.defaultCharset());
		return errorStack;
	}
}
