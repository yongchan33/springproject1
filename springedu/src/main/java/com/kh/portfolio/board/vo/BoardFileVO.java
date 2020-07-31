package com.kh.portfolio.board.vo;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardFileVO {
	private long fid;
	private long bnum;
	private String fname;
	private long fsize;
	private String ftype;
	private byte[] fdata;
	private Timestamp cdate;
	private Timestamp udate;
}
