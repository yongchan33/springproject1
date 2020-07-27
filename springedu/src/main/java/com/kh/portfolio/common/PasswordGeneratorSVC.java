package com.kh.portfolio.common;

import org.springframework.stereotype.Service;

import com.kh.portfolio.common.util.PasswordGenerator;

/**
 * <pre>
 *  비밀번호 및 임시번호 발생기
 * </pre>
 * @author Administrator
 * @
 */


@Service
public class PasswordGeneratorSVC {



	public String generatorPassword(int passwordLength){
		PasswordGenerator passwordGenerator = new PasswordGenerator
				.PasswordGeneratorBuilder()
		.useDigits(true)				//숫자포함
		.useLower(true)					//소문자포함
		.useUpper(true)					//대문자포함
		.usePunctuation(true)		//특수문자포함
		.build();	
		return passwordGenerator.generate(passwordLength);
	}
}
