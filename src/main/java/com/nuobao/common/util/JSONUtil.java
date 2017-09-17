package com.nuobao.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * JSON工具类
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 12:08
 * @modify
 **/
public class JSONUtil {

	private static ObjectMapper mapper = new ObjectMapper();

	static {
		mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		/*
		 *将null值转换成""序列化
		 *
		mapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>(){
            @Override  
            public void serialize(Object value, JsonGenerator jg, SerializerProvider sp) throws IOException, JsonProcessingException
            {  
                jg.writeString("");  
            }  
        });*/
	}

	public static String objToJSON(Object obj) throws IOException {
		if (obj instanceof InputStream) {
			return "It is InputStream";
		}
		else if (obj instanceof OutputStream) {
			return "It is OutputStream";
		}
		else if (obj instanceof ServletRequest) {
			return "It is HttpServletRequest";
		}
		else if (obj instanceof ServletResponse) {
			return "It is HttpServletResponse";
		}
		return JSON.toJSONString(obj);
	}

	public static <T> T JSONToObj(String jsonStr, Class<T> clazz) throws IOException {
		return JSON.toJavaObject(JSONObject.parseObject(jsonStr), clazz);
	}
}
