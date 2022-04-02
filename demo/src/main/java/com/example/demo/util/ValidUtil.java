package com.example.demo.util;

import com.example.demo.exception.MyException;

public class ValidUtil {
	public static boolean isVaild()  {
		if(true) {
			throw new MyException("");
		}
		return true;

	}
}
