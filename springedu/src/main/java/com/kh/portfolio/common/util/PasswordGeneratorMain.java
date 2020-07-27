package com.kh.portfolio.common.util;

public class PasswordGeneratorMain {
	public static void main(String[] args) {
		PasswordGenerator passwordGenerator = new PasswordGenerator.PasswordGeneratorBuilder()
				.useDigits(true)
				.useLower(true)
				.useUpper(true)
				.usePunctuation(false)	//특수문자사용x
				.build();
				String password = passwordGenerator.generate(8); 
				System.out.println(password);
	}
}
