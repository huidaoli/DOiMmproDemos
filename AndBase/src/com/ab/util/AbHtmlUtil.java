package com.ab.util;


// TODO: Auto-generated Javadoc

/**
 * © 2012 amsoft.cn 
 * 名称：AbHtmlUtil.java 
 * 描述：HTML处理类.
 * 
 */
public class AbHtmlUtil {

	/**
	 * 
	 * 描述：替换标记以正常显示.
	 * @param text
	 * @return
	 */
	public static String replaceTag(String text) {
		if (!hasSpecialChars(text)) {
			return text;
		}
		StringBuffer filtered = new StringBuffer(text.length());
		char c;
		for (int i = 0; i <= text.length() - 1; i++) {
			c = text.charAt(i);
			switch (c) {
			case '<':
				filtered.append("&lt;");
				break;
			case '>':
				filtered.append("&gt;");
				break;
			case '"':
				filtered.append("&quot;");
				break;
			case '&':
				filtered.append("&amp;");
				break;
			default:
				filtered.append(c);
			}

		}
		return (filtered.toString());
	}

	/**
	 * 
	 * 描述：判断标记是否存在.
	 * @param text
	 * @return
	 */
	public static boolean hasSpecialChars(String text) {
		boolean flag = false;
		if ((text != null) && (text.length() > 0)) {
			char c;
			for (int i = 0; i <= text.length() - 1; i++) {
				c = text.charAt(i);
				switch (c) {
				case '>':
					flag = true;
					break;
				case '<':
					flag = true;
					break;
				case '"':
					flag = true;
					break;
				case '&':
					flag = true;
					break;
				}
			}
		}
		return flag;
	}

}
