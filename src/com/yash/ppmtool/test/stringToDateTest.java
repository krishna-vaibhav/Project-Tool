package com.yash.ppmtool.test;

import java.util.Date;

import com.yash.ppmtool.util.DateUtil;

public class stringToDateTest {

	public static void main(String[] args) {
		String str="02-02-2020";
		Date dt=DateUtil.stringToDate(str);
		System.out.println(dt);

	}

}
