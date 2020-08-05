package com.kh.portpolio.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.portfolio.board.dao.BoardDAO;
import com.kh.portfolio.board.vo.BoardCategoryVO;
import com.kh.portfolio.board.vo.BoardFileVO;
import com.kh.portfolio.board.vo.BoardVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class BoardDAOimplXMLTest {
	private final static Logger logger
	= LoggerFactory.getLogger(BoardDAOimplXMLTest.class);
	
	@Inject
	@Qualifier("boardDAOImplXML")
	BoardDAO boardDAO;
	
	@Test
	@DisplayName("게시판 카테고리읽어오기")
	void getCategory() {
		List<BoardCategoryVO> list = boardDAO.getCategory();
		//case1) 일반 for문
		for(int i=0; i<list.size();i++) {
			logger.info(list.get(i).toString());
		}
		//case2) 향상된 for문
		for(BoardCategoryVO boardCategoryVO: list) {
			logger.info(boardCategoryVO.toString());
		}
		//case3) 스트림사용
		list.stream().forEach(BoardCategoryVO->{
			System.out.println(BoardCategoryVO);
		});
		//case4) 스트림사용(단축)
		list.stream().forEach(System.out::println);
		
		
		
		
	}
	
	
	@Test
	@DisplayName("게시글 작성")
	@Disabled
	void write() {
		BoardVO boardVO = new BoardVO();
		BoardCategoryVO boardCategoryVO = new BoardCategoryVO();
		
		boardVO.setBoardCategoryVO(boardCategoryVO);
		boardVO.getBoardCategoryVO().setCid(1001);
		boardVO.setBtitle("테스트 제목");
		boardVO.setBid("test3@test.com");
		boardVO.setBnickname("별칭1");
		boardVO.setBcontent("본문1");
		
		int result = boardDAO.write(boardVO);
		Assertions.assertEquals(1, result); 		//result와 1이 같으면 초록색이 뜸.
		
	}
		@Test
		@DisplayName("게시글 목록")
		@Disabled
		void list() {
			List<BoardVO> list = boardDAO.list();
			logger.info("레코드갯수:" + list.size());
			/*
			 * list.stream().forEach((board)->{ System.out.println(board); });
			 */
			list.stream().forEach(System.out::println);
			/* logger.info("게시글목록:" + list.toString()); */
		}
		
		
		@Test
		@DisplayName("게시글 보기")
		@Disabled
		void view() {
			String bnum="63";
			BoardVO boardVO = boardDAO.view(bnum);
			logger.info(boardVO.toString());
			logger.info(String.valueOf(boardVO.getBoardCategoryVO().getCid()));
			
		}
		@Test
		@DisplayName("첨부파일조회")
		@Disabled
		void getFiles() {
			String bnum="82";
			List<BoardFileVO> list = boardDAO.getFiles(bnum);
			
			list.stream().forEach(System.out::println);
			Assertions.assertEquals(4, list.size());
			
		}
		@Test
		@DisplayName("조회수증가")
		@Disabled
		void updateBhit() {
			String bnum="82";
			int preBhit= boardDAO.view(bnum).getBhit();
			boardDAO.updateBhit(bnum);
			int postBhit = boardDAO.view(bnum).getBhit();
			Assertions.assertEquals(postBhit, preBhit+1);
		}
}
