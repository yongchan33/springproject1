package com.kh.portfolio.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.portfolio.board.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	//게시글 작성(화면)
	@GetMapping("/writeForm")
	public String write() {
		
		return "/board/writeForm";
	}
	
	
	//게시글 작성처리
	@PostMapping
	public String wirte(BoardVO boardVO) {
		
		
		
		
		return "/board/list";				
	}
}
