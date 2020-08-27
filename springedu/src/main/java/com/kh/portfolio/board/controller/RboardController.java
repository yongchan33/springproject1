package com.kh.portfolio.board.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.portfolio.board.svc.RboardSVC;
import com.kh.portfolio.board.vo.RboardVO;
import com.kh.portfolio.board.vo.VoteVO;
import com.kh.portfolio.exception.ErrorMsg;
import com.kh.portfolio.exception.RestAccessException;

import net.bytebuddy.implementation.bind.annotation.BindingPriority;

@RestController
@RequestMapping("/rboard")
public class RboardController {

	private static final Logger logger
	= LoggerFactory.getLogger(RboardController.class);
	
	@Inject
	RboardSVC rboardSVC;
	
	//댓글작성
	@PostMapping(value="", produces="application/json")
	public ResponseEntity<String> write(
			@Valid @RequestBody RboardVO	rboardVO,
			BindingResult result
			){
		ResponseEntity<String> res = null;
		
		if(result.hasErrors()) {
			throwRestAccessException(result);
		}
		
		int cnt = rboardSVC.write(rboardVO);
		
		//성공
		if(cnt==1) {	
			res = new ResponseEntity<String>("success",HttpStatus.OK); //200
		}
		return res;

	}
	//댓글수정
	@PutMapping(value="",produces = "application/json")
	public ResponseEntity<String> modify(
		@Valid @RequestBody RboardVO rboardVO,	
		BindingResult result	
			){
		ResponseEntity<String> res = null;
		
		if(result.hasErrors()) {
			throwRestAccessException(result);
		}
		
		int cnt = rboardSVC.modify(rboardVO);
		
		//성공
		if(cnt==1) {	
			res = new ResponseEntity<String>("success",HttpStatus.OK); //200
		}		
		return res;
	}
	//댓글삭제
	@DeleteMapping(value="/{rnum}",produces = "application/json")
	public ResponseEntity<String> delete(
			@PathVariable(value="rnum",required = true) long rnum){
		
		ResponseEntity<String> res = null;
		
		int cnt = rboardSVC.delete(rnum);
		//성공
		if(cnt==1) {	
			res = new ResponseEntity<String>("success",HttpStatus.OK); //200
		}				
		return res;
	}
	//대댓글작성
	@PostMapping(value="/reply",produces = "application/json")
	public ResponseEntity<String> reply(
		@Valid @RequestBody RboardVO rboardVO,	
		BindingResult result){
		
		ResponseEntity<String> res = null;
		
		if(result.hasErrors()) {
			throwRestAccessException(result);
		}
		
		int cnt = rboardSVC.reply(rboardVO);
		//성공
		if(cnt==1) {	
			res = new ResponseEntity<String>("success",HttpStatus.OK); //200
		}			
		return res;
	}	
	//댓글목록
	@GetMapping(value="/{reqPage}",produces = "application/json")
	public ResponseEntity<List<RboardVO>> list(
		@PathVariable(value="reqPage", required = true) String reqPage	
			){
		ResponseEntity<List<RboardVO>> res = null;
				
		List<RboardVO> list =	rboardSVC.list();
		if(list.size() > 0) {
			res = new ResponseEntity<List<RboardVO>>(list,HttpStatus.OK); //200
		}
		
		return res;
	}	
	//선호,비선호
	@PutMapping(value="/vote",produces = "application/json")
	public ResponseEntity<String> vote(
		@Valid @RequestBody VoteVO voteVO,
		BindingResult result
			){
		ResponseEntity<String> res = null;
		
		if(result.hasErrors()) {
			throwRestAccessException(result);
		}
		
		int cnt = rboardSVC.vote(voteVO);
		
		//성공
		if(cnt==1) {	
			res = new ResponseEntity<String>("success",HttpStatus.OK); //200
		}			
		return res;
	}	
	
	//vo객체 바인딩 오류에 대한 예외 처리
	private void throwRestAccessException(BindingResult result) {
		List<FieldError> list = result.getFieldErrors();
		List<ErrorMsg> errList = new ArrayList<>();
		
		for(FieldError item : list) {
//			logger.info(
//					item.getField() + "/" + item.getDefaultMessage() + "/" + item.getRejectedValue());
			ErrorMsg errorMsg = new ErrorMsg();
			errorMsg.setFieldName(item.getField());
			errorMsg.setRequestValue((String)item.getRejectedValue());
			errorMsg.setErrMsg(item.getDefaultMessage());
			errList.add(errorMsg);				
		}
		throw new RestAccessException(errList);
	}	
}