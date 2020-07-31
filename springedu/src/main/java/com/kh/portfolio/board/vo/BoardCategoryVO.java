package com.kh.portfolio.board.vo;

import javax.persistence.Entity;
import javax.validation.constraints.Positive;

import lombok.Data;

@Entity
@Data
public class BoardCategoryVO {
	
	@Positive(message="분류를 선택하세요")
	private long cid;		//분류코드
	private String cname;	//이름
}
