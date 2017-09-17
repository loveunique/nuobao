package com.nuobao.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * 序列化及反序列化工具
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 12:57
 * @modify
 **/
public class SerializeUtil {

    private static Logger logger = LoggerFactory.getLogger(SerializeUtil.class);


	public static byte[] serialize(Object object) throws IOException {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		byte[] bytes = (byte[]) null;
		try{
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			bytes = baos.toByteArray();
		} catch (IOException e){
            logger.error("SerializeUtil.serialize.IOException", e);
			throw e;
		} finally{
			try{
				if(oos != null){
					oos.close();
				}
				if(baos != null) baos.close();
			} catch (IOException e){
                logger.error("SerializeUtil.serialize.finally", e);
			}
		}
		return bytes;
	}

	public static Object unserialize(byte[] bytes) throws IOException, ClassNotFoundException {
		ByteArrayInputStream bais = null;
		ObjectInputStream ois = null;
		try{
			bais = new ByteArrayInputStream(bytes);
			ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (IOException e1){
            logger.error("SerializeUtil.unserialize.IOException", e1);
			throw e1;
		} catch (ClassNotFoundException e2){
            logger.error("SerializeUtil.unserialize.ClassNotFoundException", e2);
			throw e2;
		} finally{
			try{
				if(bais != null){
					bais.close();
				}
				if(ois != null) ois.close();
			} catch (IOException e){
                logger.error("SerializeUtil.unserialize.finally", e);
			}
		}
	}
}
