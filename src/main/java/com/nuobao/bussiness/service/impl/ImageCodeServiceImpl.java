package com.nuobao.bussiness.service.impl;

import com.nuobao.bussiness.service.ImageCodeService;
import com.nuobao.common.constant.ApplicationErrorCode;
import com.nuobao.common.exception.CacheException;
import com.nuobao.common.exception.TranFailException;
import com.nuobao.common.redis.CacheSettings;
import com.nuobao.common.redis.RedisUtil;
import com.nuobao.common.util.DateUtil;
import com.nuobao.common.util.DynamicPasswordBean;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 创建验证码逻辑接口实现类
 * @author Xu Chengzhi
 * @date 2017-09-17 九月 9:04
 * @modify
 **/
@Service
public class ImageCodeServiceImpl implements ImageCodeService {

    private Logger logger = LoggerFactory.getLogger(getClass());

	private String verifyChars = "23456789abcdefghijkmnpqrstuvwxyz";

	private String verifyFontName = "Arial"; // "Rage Italic";

	private static int seed = 0;


	@Autowired
	CacheSettings cacheSettings;

	/**
	 * 获取图片验证码
	 * @param verifyWidthPerChar 图片中单个字母的宽度 像素
	 * @param verifyHeight 图片高度 像素
	 * @param charNum 图片中字母数量 
	 * @throws Exception
	 */
	@Override
	public Map<String, String> getImageCode(int verifyWidthPerChar,int verifyHeight, int charNum) throws Exception {
        logger.info("ImageCodeServiceImpl.getImageCode --> verifyWidthPerChar:{}, verifyHeight:{}, charNum:{}",
                verifyWidthPerChar, verifyHeight, charNum);

		Map<String, String> imageMap = new HashMap<String, String>();
		int len = 4;
		if(charNum > 0){
			len = charNum;
		}

		/**
		 * 生成验证码字符串
		 */
		/*
		Random codeRandom = new Random(System.currentTimeMillis() + seed++);
		int charLen = this.verifyChars.length();
		String certifyPin = "";
		for (int i = 0; i < len; ++i) {
			int iV = codeRandom.nextInt(charLen);
			certifyPin = certifyPin + this.verifyChars.charAt(iV);
		}
		*/
		String certifyPin = null;
		DynamicPasswordBean bean = new DynamicPasswordBean();
		certifyPin = bean.generateCertifyPin(len, this.verifyChars);
		//logger.info(certifyPin);
		//生成图片
		int WIDTH = verifyWidthPerChar * len; /*附加码图片宽度*/
		int HEIGHT = verifyHeight; /*附加码图片高度*/
		int MAXSWING = 3; /*最大振幅，要求WIDTH/4>(FONTSIZE+2*MAXSWING)*/
		int MINSWING = 2; /*最小振幅*/

		Random random = new Random();
		Graphics gc = null;

		try{//在内存中创建图象
			BufferedImage bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
			//获取图形上下文
			gc = bufferedImage.getGraphics();
			try{
				if(gc instanceof Graphics2D){
					((Graphics2D) gc).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
					((Graphics2D) gc).setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
					((Graphics2D) gc).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
				}
			}
			catch (LinkageError e){
			} // Graphics2D not found    

			gc.setColor(new Color(220, 238, 252));//(253,255,random) (219,231,random)
			gc.fillRect(0, 0, WIDTH, HEIGHT);

			Font fonts[] = new Font[len];
			for(int i = 0 ; i < len ; i++){
				fonts[0] = new Font(null, Font.BOLD, HEIGHT - 2);
			}
			//随机产生160条干扰线，使图象中的认证码不易被其它程序探测到
			for(int i = 0 ; i < 50 ; i++){
				gc.setColor(getRandColor(120, 160, random));
				int x = random.nextInt(WIDTH);
				int y = random.nextInt(HEIGHT);
				int xl = random.nextInt(10);
				int yl = random.nextInt(10);
				gc.drawLine(x, y, x + xl, y + yl);
			}

			//随机调整振幅,用于后面制作波动效果
			int swing = MINSWING + random.nextInt(MAXSWING - MINSWING);

			//取随机产生的认证码
			for(int i = 0 ; i < len ; i++){
				char c = certifyPin.charAt(i); //char c = CHARACTERS[random.nextInt(C_SIZE)];
				// 将认证码显示到图象中
				gc.setColor(new Color(100 + random.nextInt(100), 30 + random.nextInt(60), 30 + random.nextInt(60))); //调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
				gc.setFont(fonts[i]);
				FontMetrics fm = gc.getFontMetrics();
				int t = WIDTH / len - fm.charWidth(c) - 2 * swing;
				t = (t > 0) ? t : 1;
				int x = WIDTH * i / len + swing + random.nextInt(t);
				int y = HEIGHT - fm.getDescent();//fm.getDescent()+2+random.nextInt(fm.getAscent()-fm.getDescent()-4)*2;
				gc.drawString(c + "", x, y);
			}

			// 获取验证码对应的key（校验用）
			String key = DigestUtils.md5Hex((certifyPin.toString() + DateUtil.getCurrentDateTimeWithoutSign()).getBytes("UTF-8"));

			// 将验证码key放入response头部信息中
			// response.addHeader("imageCodeKey", key);
			imageMap.put("imageKey", key);

			RedisUtil.put(cacheSettings.getImgCodeCacheName(),key,certifyPin.toString());
			
			//制作波动效果	
			int startwpix = 0;
			int endwpix = WIDTH;
			int starthpix = 0;
			int endhpix = HEIGHT;
			double hpix = endhpix - starthpix;
			double xpix = random.nextInt() / 4.0;//相移
			for(int i = starthpix ; i < endhpix ; i++){
				int mpix = (int) (swing * Math.sin((i * 2 / hpix + xpix) * Math.PI));//横向移动mpix个象素，正数表示右移，负数表示左移
				if(mpix > 0){
					for(int j = endwpix - mpix - 1 ; j >= startwpix ; j--){
						int rgb = (bufferedImage).getRGB(j, i);
						(bufferedImage).setRGB(j + mpix, i, rgb);
					}
				}
				else if(mpix < 0){
					for(int j = startwpix - mpix ; j < endwpix ; j++){
						int rgb = (bufferedImage).getRGB(j, i);
						(bufferedImage).setRGB(j + mpix, i, rgb);
					}
				}
			}

			// 设置页面不缓存，并输出图像
			ByteArrayOutputStream outputStream = null;
			try{
				// outputStream = response.getOutputStream();
				/*
				 * response.setContentType("image/jpeg"); //设置页面不缓存
				 * response.setHeader("Pragma", "No-cache");
				 * response.setHeader("Cache-Control", "no-cache");
				 * response.setDateHeader("Expires", 0);
				 * 
				 * ImageIO.write(bufferedImage, "jpg", outputStream);
				 * 
				 * outputStream.flush();
				 */

				outputStream = new ByteArrayOutputStream();
				ImageIO.write(bufferedImage, "jpg", outputStream);
				String str = new String(Base64.encode(outputStream.toByteArray()));
				imageMap.put("imageCode", str);
				return imageMap;
			}
			catch (IOException ex){
                logger.error("ImageCodeServiceImpl.getImageCode --> 验证码生成出错:{}", ex);
			}
			finally{
				if(outputStream != null){
					try{
						outputStream.close();
					}
					catch (IOException ex){
                        logger.error("ImageCodeServiceImpl.getImageCode --> HTTP数据流对象关闭异常:{}", ex);
					}
				}
			}
		}
		catch (Exception e){
            logger.error("ImageCodeServiceImpl.getImageCode --> 验证码生成出错:{}", e);
		}
		finally{
			try{// 释放图形上下文
				if(gc != null) gc.dispose();
			}
			catch (Exception e){
			}
			finally{
			}
		}
		return imageMap;
	}

	/**
	 * @description 生成随机码彩色图片并输出到指定输出流中。
	 * @param exPwd
	 *            随机码。
	 * @param out
	 *            输出流。
	 * @throws IOException
	 */
	public static void genColorGraphics(String exPwd, OutputStream out) throws IOException {
		int len = exPwd.length();
		int imageWidth = len * 18;
		int imageHeight = 28;
		BufferedImage image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();

		g.dispose();
		ImageIO.write(image, "jpg", out);
	}

	/**
	 * 获取给定范围内随机颜色
	 * 
	 * @param fc
	 * @param bc
	 * @return
	 */
	private Color getRandColor(int fc, int bc, Random random) {
		if(fc > 255) fc = 255;
		if(bc > 255) bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

	
	@Override
	public Map<String,String> checkImageCode(String key, String verifyKey) throws Exception {
		Object value=null;
		try {
			value = RedisUtil.get(key);
		} catch (Exception e) {
			throw new CacheException(ApplicationErrorCode.CACHE_ERROR, "缓存服务器异常", e);
		}
		
		if(value == null){
			throw new TranFailException(ApplicationErrorCode.VERIFYCODE_NOT_MATCH,"验证码错误");
		}
		
		String code=(String)value;
		
		// 验证码不匹配
		if(!verifyKey.equalsIgnoreCase(code)){
			throw new TranFailException(ApplicationErrorCode.VERIFYCODE_NOT_MATCH,"验证码错误");
		}
		
		try{
			RedisUtil.evict(code);
		}
		catch (Exception e){
			throw new CacheException(ApplicationErrorCode.CACHE_ERROR, "缓存服务器异常", e);
		}
		
		/**
		 * 没有异常的就返回true
		 */
		Map<String,String> map = new HashMap<String, String>(1);
		map.put("isRight", "true");
		return map;
	}
	
}
