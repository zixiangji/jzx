package com.jzx.basic.xml;

import java.util.Date;

public class Test {
	public static void main(String[] args) {
		Book book = new Book();
		book.setAuthor("wangyu");
		book.setCalender(new Date());
		book.setId(120);
		book.setPrice(130.3f);
		book.setUser("jzx");
		String str =JaxbUtil.converToxml(book);
		System.out.println(str);
	}
}
