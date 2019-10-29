package com.chenxudong.utilackage;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	/***
	 * 判断源字符串是否有值，空引号也算没值
	 */
	public static boolean isNull(String str) {
		if(str!=null&&str.length()>0) {
			return true;
		}
		return false;
	}
	/***
	 * 判断源字符串是否有值，空引号和空格也算没值"" "   "
	 */
	public static boolean isBlank(String str) {
		//trim()
		if(str!=null&&str.length()>0&&str.trim().length()>0) {
			return true;
		}
		return false;
	}

	/***
	 * 判断是否为手机号码
	 * 
	 */
	public static boolean isPhone(String str) {
		//先判断字符串不是空的
		boolean blank = isBlank(str);
		if(!blank) {
			return false;
		}
		Pattern pattern = Pattern.compile("^1[3|4|5|7|8][0-9]\\d{8}$");
		Matcher matcher = pattern.matcher(str);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}

	/***
	 * 判断是否为电子邮箱
	 * xxx@ss.ss
	 * ^(\w+((-\w+)|(\.\w+))*)\+\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$  
	 */
	public static boolean isEmail(String str) {
		//先判断字符串不是空的
		boolean blank = isBlank(str);
		if(!blank) {
			return false;
		}
		Pattern pattern = Pattern.
				compile("^([a-z0-9A-Z]+)@([a-z0-9A-Z]+\\.)+[a-zA-Z]{2,}$");
		Matcher matcher = pattern.matcher(str);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}

	/***
	 * 判断字符串全是字母
	 * @param str
	 * @return
	 */
	public static boolean isEnglish(String str) {
		//先判断字符串不是空的
		boolean blank = isBlank(str);
		if(!blank) {
			return false;
		}
		Pattern pattern = Pattern.
				compile("^[a-zA-Z]+$");
		Matcher matcher = pattern.matcher(str);
		if(matcher.matches()) {
			return true;
		}
		
		return false;
	}
	/***
	 * 获取n位随机英文字符串
	 * @return
	 */
	public static String getRandomStr(int length) {
		char [] arr = {'A','B','C','D','E','F','G',
				'H','I','J','K','L','M','N',
				'O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		int len = arr.length;
		StringBuffer buffer = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			//返回小于len参数的整数值
			int nextInt = random.nextInt(len);
			//取绝对值
			int abs = Math.abs(nextInt);
			char c = arr[abs];
			buffer.append(c);
		}
		return buffer.toString();
	}
	/***
	 * 获取n位随机英文字符串和数字
	 * @return
	 */
	public static String getRandomStrAndNumber(int length) {
		char [] arr = {'A','B','C','D','E','F','G',
				'H','I','J','K','L','M','N',
				'O','P','Q','R','S','T','U','V','W','X','Y','Z',
				'0','1','2','3','4','5','6','7','8','9'};
		int len = arr.length;
		StringBuffer buffer = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			//返回小于len参数的整数值
			int nextInt = random.nextInt(len);
			//取绝对值
			int abs = Math.abs(nextInt);
			char c = arr[abs];
			buffer.append(c);
		}
		return buffer.toString();
	}
	/****
	 * 获取n个随机中文字符串
	 */
	public static String getRandomChinese(int length) {
		// Unicode中汉字所占区域\u4e00-\u9fa5,将4e00和9fa5转为10进制
		int start = Integer.parseInt("4e00", 16);
		int end = Integer.parseInt("9fa5", 16);
		// 输出结果
		// 19968
		// 40869
		// 随机数
		StringBuffer buffer = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			int code = random.nextInt(end - start + 1) + start;
			// 转为字符
			String str = new String(new char[] { (char) code });
			buffer.append(str);
		}
		return buffer.toString();
	}
	
}
