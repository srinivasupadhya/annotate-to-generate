package com.tw.atg.util;

public class StringUtil {
	public static boolean isEmpty(String str) {
		if (str == null || str.trim().isEmpty())
			return true;
		return false;
	}
}
