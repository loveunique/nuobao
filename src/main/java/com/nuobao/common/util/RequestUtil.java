package com.nuobao.common.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 请求相关的数据处理工具
 *
 * @author Xu Chengzhi
 * @date 2017-09-19 九月 22:40
 * @modify
 **/
public class RequestUtil {

	/**
	 * 取客户端的真实IP地址 
	 * @param request
	 * @return
	 */
	public static String getClientIP(HttpServletRequest request) {
		//从SSL取客户IP
		String ip = request.getHeader("entrust-client-ip");

		//从格尔的SSL取
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
			// 获取客户IP
			Cookie[] cookies = request.getCookies();
			if(cookies == null){
				cookies = new Cookie[0];
			}
			for(int i = 0 ; i < cookies.length ; i++){
				Cookie cookie = cookies[i];
				if("KOAL_CLIENT_IP".equals(cookie.getName())){
					ip = cookie.getValue();
				}
			}
		}

		// 反向代理
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
			ip = request.getHeader("x-forwarded-for");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
			ip = request.getHeader("Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
			ip = request.getRemoteAddr();
			if(ip.equals("127.0.0.1")||ip.equals("0:0:0:0:0:0:0:1")){
				//根据网卡取本机配置的 IP
				InetAddress inet = null;
				try{
					inet = InetAddress.getLocalHost();
					ip = inet.getHostAddress();
				} catch (UnknownHostException e){
				}
			}
		}

		//存在多级反向代理的情况下，从x-forwarded-for获取的值为逗号分隔的ip串
		if(ip.indexOf(",") > 0){
			ip = ip.substring(0, ip.indexOf(",")).trim();
		}
		//由于反向追寻IP为APACHE地址 需SSL带入IP
		//if(null != request.getParameter(LianaConstants.FIELD_USER_IP)){
		//	ip = request.getParameter(LianaConstants.FIELD_USER_IP);
		//}
		return ip;
	}
}
