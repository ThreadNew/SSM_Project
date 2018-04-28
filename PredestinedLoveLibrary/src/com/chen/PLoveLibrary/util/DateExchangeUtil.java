package com.chen.PLoveLibrary.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
   * @类 名： DateExchangeUtil
   * @功能描述： TODO 日期转化工厂 把html5 date类型的如2018/03/04 转换成2018-03-04
   * @作者信息： 陈强
   * @创建时间： 2018年4月24日下午8:55:15
   * @修改备注：
   */
public class DateExchangeUtil {
	/** 
	   * @Title : StringToDate 
	   * @功能描述: TODO  字符串转化为日期
	   * @开发者：陈强  
	   * @参数： @param str1
	   * @参数： @return
	   * @参数： @throws ParseException 
	   * @返回类型：Date 
	   * @throws ：
	   */
	public static Date  StringToDate(String str1) throws ParseException
	{
		String[] buffer=str1.split("/");
		StringBuilder builder=new StringBuilder();
		for(int i=0;i<buffer.length;i++)
		{
			builder.append(buffer[i]);
			if(i!=buffer.length-1)
			{
				builder.append("-");
			}
		}
		System.out.println(builder.toString());
		SimpleDateFormat date1=new SimpleDateFormat("yyyy-MM-dd");
		
		return date1.parse(builder.toString());
	}
	/** 
	   * @Title : DateToString 
	   * @功能描述: TODO 将日期转化为字符串
	   * @开发者：陈强  
	   * @参数： @param date
	   * @参数： @return 
	   * @返回类型：String 
	   * @throws ：
	   */
	public static String  DateToString(Date date)
	{
		SimpleDateFormat date1=new SimpleDateFormat("yyyy-MM-dd");
		return date1.format(date);
		
	}
	/** 
	   * @Title : GetDayFormDate 
	   * @功能描述: TODO  得到两个时间的相差的天数
	   * @开发者：陈强  
	   * @参数： @param date1
	   * @参数： @param date2
	   * @参数： @return 
	   * @返回类型：long 
	   * @throws ：
	   */
	public static long  GetDayFormDate(Date date1,Date date2)
	{
		long  day=(date1.getTime()-date2.getTime())/(24*60*60*1000);
		return day;
	}
	/** 
	   * @Title : GetDateFromDay 
	   * @功能描述: TODO 距离多少天后的日期
	   * @开发者：陈强  
	   * @参数： @param date
	   * @参数： @param day
	   * @参数： @return 
	   * @返回类型：Date 
	   * @throws ：
	   */
	public static Date  GetDateFromDay(Date date,int day)
	{
		 Calendar calendar = Calendar.getInstance();
		 calendar.setTime(date);
		 calendar.add(Calendar.DATE, day);
		 return calendar.getTime();
	}
	

}
