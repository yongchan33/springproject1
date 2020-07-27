package com.kh.portfolio.common.util;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class PropertiesEncryptor {

	public static void main(String[] args) {
		StandardPBEStringEncryptor enc = new StandardPBEStringEncryptor();
		//암호키
		//enc.setPassword("gkrToaWkd");
		enc.setPassword("skslrk");
		
		//db암호화
		System.out.println(enc.encrypt("oracle.jdbc.driver.OracleDriver"));
		System.out.println(enc.encrypt("jdbc:oracle:thin:@127.0.0.1:1521:xe"));
		System.out.println(enc.encrypt("portfolio"));
		System.out.println(enc.encrypt("portfolio1234"));

		
		//mail암호화
		System.out.println(enc.encrypt("skslrk00@gmail.com"));
		System.out.println(enc.encrypt("159263lsg1136!@"));
		
		//복호화
		//System.out.println(enc.decrypt("hUcYk7JR5X2aPkEsKSbYgU+G7J5F/Xqf"));
	}

}
