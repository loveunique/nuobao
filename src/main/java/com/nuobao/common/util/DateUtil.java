package com.nuobao.common.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期工具类
 * @author liuxiaosong(liuxs@yusys.com.cn)
 * @date 2017-3-29
 */
public class DateUtil {
	public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_TIME_FORMAT_WITHOUT_SIGN = "yyyyMMddHHmmss";
	public static final String ONLY_DATE_FORMAT = "yyyy-MM-dd";
	public static final String ONLY_DATE_FORMAT_WITHOUT_SIGN = "yyyyMMdd";
	public static final String ONLY_TIME_FORMAT = "HH:mm:ss";
	public static final String ONLY_TIME_FORMAT_WITHOUT_SIGN = "HHmmss";
	private static ThreadLocal<SimpleDateFormat> defaultDateTimeFormatLocal = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT);
		}
	};
	private static ThreadLocal<SimpleDateFormat> dateTimeFormatWithoutSignLocal = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat(DATE_TIME_FORMAT_WITHOUT_SIGN);
		}
	};
	private static ThreadLocal<SimpleDateFormat> onlyDateFormatLocal = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat(ONLY_DATE_FORMAT);
		}
	};
	private static ThreadLocal<SimpleDateFormat> onlyDateFormatWithoutSignLocal = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat(ONLY_DATE_FORMAT_WITHOUT_SIGN);
		}
	};
	
	private static ThreadLocal<SimpleDateFormat> onlyTimeFormatLocal = new ThreadLocal<SimpleDateFormat>(){
		@Override  
	    protected SimpleDateFormat initialValue() {  
	        return new SimpleDateFormat(ONLY_TIME_FORMAT);  
	    } 
	};
	
	private static ThreadLocal<SimpleDateFormat> onlyTimeFormatWithoutSignLocal = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat(ONLY_TIME_FORMAT_WITHOUT_SIGN);
		}
	};

	/**
	 * 获取当前时间,格式化yyyy-MM-dd
	 * @return
	 */
	public static String getCurrentTime() {
		Date now = new Date();
		return onlyTimeFormatLocal.get().format(now);
	}

	/**
	 * 获取当前时间,格式化yyyyMMdd
	 * @return
	 */
	public static String getCurrentTimeWithoutSign() {
		Date now = new Date();
		return onlyTimeFormatWithoutSignLocal.get().format(now);
	}

	/**
	 * 获取当前时间,格式化yyyy-MM-dd
	 * @return
	 */
	public static String getCurrentDate() {
		Date now = new Date();
		return onlyDateFormatLocal.get().format(now);
	}

	/**
	 * 获取当前时间,格式化yyyyMMdd
	 * @return
	 */
	public static String getCurrentDateWithoutSign() {
		Date now = new Date();
		return onlyDateFormatWithoutSignLocal.get().format(now);
	}

	/**
	 * 获取当前时间,格式化yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getCurrentDateTime() {
		Date now = new Date();
		return defaultDateTimeFormatLocal.get().format(now);
	}

	/**
	 * 获取当前时间,格式化yyyyMMddHHmmss
	 * @return
	 */
	public static String getCurrentDateTimeWithoutSign() {
		Date now = new Date();
		return dateTimeFormatWithoutSignLocal.get().format(now);
	}
	
	/**
	 * 获取当前时间,格式化yyyyMMddHHmmss
	 * @return
	 * @throws ParseException 
	 */
	public static Date parseDateTimeWithoutSign(String dateString) throws Exception {
		return dateTimeFormatWithoutSignLocal.get().parse(dateString);
	}

	/**
	 * 按指定格式获取当前时间
	 * @param format
	 * @return
	 */
	public static String getCurrentDateTime(String format) {
		if(format != null && !"".equals(format)){
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			Date now = new Date();
			return dateFormat.format(now);
		}
		else{
			return getCurrentDateTime();
		}
	}

	/**
	 * 计算两个日期相差的天数
	 * 
	 * @param startDate 小日期
	 * @param endDate  大日期
	 * @return
	 */
	public static int daysBetween(Date startDate, Date endDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		long time1 = cal.getTimeInMillis();

		cal.setTime(endDate);
		long time2 = cal.getTimeInMillis();

		long beween_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(beween_days));
	}

	/**
	 * 计算两个时间相差的分钟数
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static long minutsBetween(Date startTime, Date endTime) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(startTime);
		long time1 = cal.getTimeInMillis();

		cal.setTime(endTime);
		long time2 = cal.getTimeInMillis();

		long beween_mins = (time2 - time1) / (1000 * 60);
		return beween_mins;
	}
	/**
	 * 返回本月的第一天日期
	 * @param format 格式,如果为空时返回yyyyMMdd
	 * @return 
	 */
	public static String getTheFirstDateOfThisMonth(String format) {
		if(format==null){
			format="yyyyMMdd";
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, calendar.getMinimum(Calendar.DATE));
		return dateFormat.format(calendar.getTime());
	}
	/**
	 * 返回本月的最后一天日期
	 * @param format 如果为空时,默认为yyyyMMdd
	 * @return
	 */
	public static String getTheLastDateOfThisMonth(String format) {
		if(format==null){
			format="yyyyMMdd";
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, calendar.getMaximum(Calendar.DATE));
		return dateFormat.format(calendar.getTime());
	}
	/**
	 * 返回参数所在月的最后一天日期
	 * @param date
	 * @return
	 */
	public static int getTheLastDateNumOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, calendar.getMaximum(Calendar.DATE));
		return calendar.get(Calendar.DATE);
	}

	/**
	 * 返回参数所在月的最后一天日期
	 * @param date
	 * @return
	 */
	public static Date getTheLastDateOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, calendar.getMaximum(Calendar.DATE));
		return calendar.getTime();
	}

	/**
	 * 获取距离参照日期date 有monthsAfterThisMonth个月的那月最后一天日期
	 * @param date 参照日期
	 * @param monthsAfterThisMonth 距离参照日期所在月的月数，可以为负数
	 * @return
	 */
	public static int getTheLastDateNumAfterMonths(Date date, int monthsAfterThisMonth) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, monthsAfterThisMonth);
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
		return calendar.get(Calendar.DATE);
	}

	/**
	 * 获取距离参照日期date 有monthsAfterThisMonth个月的那月最后一天日期
	 * @param date 参照日期
	 * @param monthsAfterThisMonth 距离参照日期所在月的月数，可以为负数
	 * @return
	 */
	public static Date getTheLastDateAfterMonth(Date date, int monthsAfterThisMonth) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, monthsAfterThisMonth);
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
		return calendar.getTime();
	}

	/**
	 * 获取距离当前日期指定天数的日期
	 * @param days 相距的天数，可以为负数
	 * @param format 格式
	 * @return 格式化后的字符串结果
	 */
	public static String getDateAfterDays(int days,String format) {
		if(format==null){
			format="yyyyMMdd";
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, days);
		return dateFormat.format(calendar.getTime());
	}
	/**
	 * 获取距离当前日期指定月数的日期
	 * @param months 相距的月数，可以为负数
	 * @param format 格式
	 * @return 格式后的字符串结果
	 */
	public static String getDateAfterMonths(int months,String format) {
		if(format==null){
			format="yyyyMMdd";
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, months);
		return dateFormat.format(calendar.getTime());
	}
	/**
	 * 获取距离当前日期指定月数的日期
	 * @param years 相距的年数，可以为负数
	 * @param format 格式
	 * @return 格式后的字符串结果
	 */
	public static String getDateAfterYears(int years,String format) {
		if(format==null){
			format="yyyyMMdd";
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, years);
		return dateFormat.format(calendar.getTime());
	}
	/**
	 * 根据参数格式显示格式化日期
	 * 
	 * @param date
	 * @param format
	 * @return String
	 */
	public static String formatDate(String date, String format) {
		Date dt = null;
		SimpleDateFormat inFmt = null, outFmt = null;
		ParsePosition pos = new ParsePosition(0);
		if((date == null) || ("".equals(date.trim()))) return "";
		try{
			if(Long.parseLong(date) == 0) return "";
		}
		catch (Exception nume){
			return date;
		}
		try{
			switch(date.trim().length()){
			case 14:
				inFmt = new SimpleDateFormat("yyyyMMddHHmmss");
				break;
			case 12:
				inFmt = new SimpleDateFormat("yyyyMMddHHmm");
				break;
			case 10:
				inFmt = new SimpleDateFormat("yyyyMMddHH");
				break;
			case 8:
				inFmt = new SimpleDateFormat("yyyyMMdd");
				break;
			case 6:
				inFmt = new SimpleDateFormat("yyyyMM");
				break;
			default:
				return date;
			}
			if((dt = inFmt.parse(date, pos)) == null) return date;
			if((format == null) || ("".equals(format.trim()))){
				outFmt = new SimpleDateFormat("yyyy年MM月dd日");
			}
			else{
				outFmt = new SimpleDateFormat(format);
			}
			return outFmt.format(dt);
		}
		catch (Exception ex){
			return date;
		}
	}

	/**
	 * 根据参数格式显示格式化日期  HH:mm:ss
	 * 
	 * @param aTime
	 * @param aFmt
	 * @return String
	 */
	public static String formatTime(String aTime, String aFmt) {
		Date dt = null;
		SimpleDateFormat inFmt = null;
		SimpleDateFormat outFmt = null;
		ParsePosition pos = new ParsePosition(0);

		if((aTime == null) || (aTime.trim().equals(""))) return "";
		try{
			if(Long.parseLong(aTime) == 0L) return "00:00:00";
		}
		catch (Exception nume){
			return aTime;
		}

		if((aFmt == null) || (aFmt.trim().equals(""))){
			aFmt = "HH:mm:ss";
		}
		aTime = aTime.trim();
		try{
			inFmt = new SimpleDateFormat("HHmmss");

			if((dt = inFmt.parse(aTime, pos)) == null){
				return aTime;
			}
			outFmt = new SimpleDateFormat(aFmt);

			return outFmt.format(dt);
		}
		catch (Exception ex){
			return aTime;
		}

	}

	/**
	 * 重新格式化时间
	 * 
	 * @param datetime 原有时间字符串，如20050101
	 * @param oldFormat 原有时间字符串的格式，如20050101160145为"yyyyMMddHHmmss"
	 * @param newFormat  新的时间字符串的格式，如2005-01-01 16:01:45为"yyyy-MM-dd HH:mm:ss"
	 * @return String
	 */
	public static String convertTimeFormat(String datetime, String oldFormat, String newFormat) {
		SimpleDateFormat oldFmt = null, newFmt = null;
		oldFmt = new SimpleDateFormat(oldFormat);
		newFmt = new SimpleDateFormat(newFormat);
		Date date = null;
		try{
			date = oldFmt.parse(datetime);
			return newFmt.format(date);
		}
		catch (ParseException ex){
		}
		return datetime;
	}

	/**
	 * 取得指定时间间隔后的系统时间<br>
	 * 示例：<br>
	 * getDifferentTime( 1, 2, 3,"yyyyMMddHHmmss") <br>
	 * 使用yyyyMMddHHmmss格式输出1小时2分3秒后的系统时间<br>
	 * getDifferentTime( -24, 0, 0,"yyyyMMdd") <br>
	 * 使用yyyyMMdd格式输出1天前的系统日期<br>
	 * 
	 * @param hour  小时
	 * @param minute 分钟
	 * @param second 秒
	 * @param timeFormat 格式化
	 * @return String
	 */
	public static String getDifferentTime(int hour, int minute, int second, String timeFormat) {
		String format = (timeFormat == null) ? DATE_TIME_FORMAT_WITHOUT_SIGN : timeFormat;
		GregorianCalendar calendar = (GregorianCalendar) Calendar.getInstance();
		calendar.add(Calendar.HOUR, hour);
		calendar.add(Calendar.MINUTE, minute);
		calendar.add(Calendar.SECOND, second);
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(calendar.getTime());
	}
	/**
	 * 取得若干天前/后的系统日期
	 * 
	 * @param days 与现在相隔的日数，正数为当前日期之后，负数为当前日期之前
	 * @param timeFormat 格式化
	 * @return String
	 */
	public static String getDifferentDate( int days, String timeFormat )
	{
		return getDifferentTime( 24 * days, 0, 0, timeFormat );
	}
	/**
	 * 获取当前时间的时分秒数组
	 * @return String[] 内容为{HH,mm,ss}
	 */
	public String[] getCurrentHHmmssArray(){
		String[] reValues = {"","",""};
		Calendar cal = Calendar.getInstance();
		int hh = cal.get(Calendar.HOUR_OF_DAY);
		int mm = cal.get(Calendar.MINUTE);
		int ss = cal.get(Calendar.SECOND);
		reValues[0] = String.valueOf(hh);
		reValues[1] = String.valueOf(mm);
		reValues[2] = String.valueOf(ss);
		return reValues;
	}
	
	public static void main(String args[]) {
		System.out.println(getTheFirstDateOfThisMonth(null));
	}
}