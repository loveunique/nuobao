package com.nuobao.common.util;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 简单图形验证码生成器
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 12:57
 * @modify
 **/
public class DynamicPasswordBean {

	private static String keyValue = "`1234567890-=qwertyuiop[]\\asdfghjkl;'zxcvbnm,./";
	private static String keyValue2 = "~!@#$%^&*()_+QWERTYUIOP{}|ASDFGHJKL:\"ZXCVBNM<>?";
	private static String numKey = "1234567890";

	private static int seed = 0;

    /**
     * 构造器
     */
	public DynamicPasswordBean() {
		super();
	}

    /**
     * 获取图形码
     * @param keySerial
     * @param inputPin
     * @return String
     */
	public static String getPassword(int[] keySerial, String inputPin) {

		if (keySerial == null)
			return inputPin;

		int len = keySerial.length;
		if (len > 10) // full key board
		{
			StringBuffer buf1 = new StringBuffer();
			StringBuffer buf2 = new StringBuffer();

			for (int i = 0; i < len; i++) {
				buf1.append(keyValue.charAt(keySerial[i]));
				buf2.append(keyValue2.charAt(keySerial[i]));
			}

			StringBuffer targetPin = new StringBuffer();

			for (int i = 0; i < inputPin.length(); i++) {
				char ch = inputPin.charAt(i);
				int idx = keyValue.indexOf(ch);
				if (idx == -1) {
					idx = keyValue2.indexOf(ch);
					targetPin.append(buf2.charAt(idx));
				}
				else
					targetPin.append(buf1.charAt(idx));
			}

			return targetPin.toString();

		}
		else // number key board
		{

			StringBuffer targetPin = new StringBuffer();
			for (int i = 0; i < inputPin.length(); i++) {
				char ch = inputPin.charAt(i);

				int idx = (int) (ch - '0');
				idx = keySerial[idx];
				targetPin.append(numKey.charAt(idx));
			}
			return targetPin.toString();
		}
	}

    /**
     * 获取图形码
     * @param request
     * @param inPassword
     * @return String
     * @throws Exception
     */
	public static String getPassword(HttpServletRequest request, String inPassword) throws Exception {

		int[] imageOrder;
		HttpSession session = request.getSession(false);
		if (session == null)
			throw new Exception("Session timeout or not established!");

		imageOrder = (int[]) session.getAttribute("ctpPassword");

		if (imageOrder == null)
			throw new Exception("Internal error, session not initialized!");

		String password = "";
		for (int i = 0; i < inPassword.length(); i++) {
			int idx = inPassword.charAt(i) - '0';
			password = password + String.valueOf(imageOrder[idx]);
		}

		return password;
	}

    /**
     * 验证PIN码
     * @param request
     * @param inPin
     * @return boolean
     * @throws Exception
     */
	public static boolean isVerifyPinOk(HttpServletRequest request, String inPin) throws Exception {
		HttpSession session = request.getSession(false);
		if (session == null)
			throw new Exception("Session timeout or not established!");

		String certifyPin = (String) session.getAttribute("ctpCertifyPin");
		if (certifyPin == null) {
			throw new Exception("error request !");
		}

		if (inPin.equals(certifyPin))
			return true;

		return false;
	}

    /**
     * 获取PIN码
     * @param len
     * @param verifyChars
     * @return String
     */
	public String generateCertifyPin(int len, String verifyChars) {
		Random random = new Random(System.currentTimeMillis() + seed++);

		int charLen = verifyChars.length();

		String value = "";
		for (int i = 0; i < len; i++) {
			int iV = random.nextInt(charLen);
			value = value + verifyChars.charAt(iV);

		}
		return value;

	}

    /**
     * 生产随机序列
     * @param maxValue
     * @return int[]
     */
	public int[] generateRadomSerial(int maxValue) {
		if (maxValue < 1)
			return null;

		int serialValue[] = new int[maxValue];
		Random random = new Random(System.currentTimeMillis() + seed++);

		for (int i = 0; i < maxValue; i++) {
			serialValue[i] = i;
		}

		for (int i = 0; i < maxValue; i++) {
			int idx1 = random.nextInt(maxValue);
			int idx2 = random.nextInt(maxValue);

			int tmp = serialValue[idx1]; // swift the radam position
			serialValue[idx1] = serialValue[idx2];
			serialValue[idx2] = tmp;
		}

		return serialValue;
	}

}
