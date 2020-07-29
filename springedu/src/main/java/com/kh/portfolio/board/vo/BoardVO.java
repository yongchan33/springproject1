package com.kh.portfolio.board.vo;

import java.sql.Timestamp;

import lombok.Data;

//롬복사용
@Data
public class BoardVO {
	
	
	private long bnum;  											//BNUM	NUMBER(10,0)
	private BoardCategoryVO boardCategoryVO;	//BCATEGORY	NUMBER(3,0)
	private String btitle;										//BTITLE	VARCHAR2(150 BYTE)
	private String bid;												//BID	VARCHAR2(40 BYTE)
	private String nickname;									//BNICKNAME	VARCHAR2(30 BYTE)
	private Timestamp bdate;									//BCDATE	TIMESTAMP(6)
	private Timestamp udate;									//BUDATE	TIMESTAMP(6)
	private int hit;													//BHIT	NUMBER(5,0)
	private String bcontent;									//BCONTENT	CLOB
	private int bgroup;												//BGROUP	NUMBER(5,0)
	private int bstep;												//BSTEP	NUMBER(5,0)
	private int bindent;											//BINDENT	NUMBER(5,0)
	//COLUMN1	VARCHAR2(20 BYTE)
	//COLUMN2	VARCHAR2(20 BYTE)
	//COLUMN3	VARCHAR2(20 BYTE)
}
