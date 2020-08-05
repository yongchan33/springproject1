package com.kh.portfolio.board.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.portfolio.board.svc.BoardSVC;
import com.kh.portfolio.board.vo.BoardCategoryVO;
import com.kh.portfolio.board.vo.BoardFileVO;
import com.kh.portfolio.board.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	BoardSVC boardSVC;

	// 메소드레벨 vs 매개변수 레벨에서 의 차이를 알아야댐.
	// 모든view page에서 접근이 가능하다.
	//현재 컨트롤러에서 만들어지는 view페이지내에서 boardCategoryVO 이름으로 참조가 가능하다.
	@ModelAttribute("boardCategory")
	public List<BoardCategoryVO> getCategory() {
		return boardSVC.getCategory();
	}
	// 게시글 작성할때 카테고리가 필요할때 다른url요청에서도 카테고리목록이 필요하면 모든뷰에 대해서
	// 모델이 사용 가능하다

	// 작성화면 전달함 modelattribute를 전달할 이유 : string form tag와 연결하기 위하여 전달함.
	// boardVO로 VIEW에서 사용이 가능하도록 modelAtribute에 넘겨줌
	// el표현식으로 기존에는 request.~~이런식으로 했었는데 지금은 modelAttribute를 사용하여
	// 대체가능함.
	// 게시글 작성(화면)
	@GetMapping("/writeForm")
	public String writeForm(@ModelAttribute("boardVO") BoardVO baordVO, // case1)
			Model model) {
		// case2)
//		model.addAttribute("boardVO",new BoardVO());
		return "/board/writeForm";
	}

	// 어떤 페이지에서 작성할때 잘못입력하면 입력한값들이 날라감! 그래서 요청을할때 boardVO를 담아서
	// valid 유효성체크 / 위에는 빈값으로해서 화면과 매핑이 되지만, 여기서는 boardVO를 받아서
	// 저장하는단계, 사용자가 작성한 데이터의 유효성 체크를 해서 오류가나면 페이지를 보여주는데
	// 기존에는 다시 작성할때 데이터가 없었으나, @ModelAttribute 사용하면 BoardVO에 담아서오도록함.
	// 그리고 다시 작성 할때 boardVO로 접근이 가능함.
	// 기존에는 Model model 받아서 addAttribute 사용해서 넘겨주는 식으로 사용했음.
	// 게시글 작성처리
	@PostMapping("/write")
	public String wirte(

			@Valid @ModelAttribute("boardVO") BoardVO boardVO, // 유효성 체크를 하겠다.
			BindingResult result) {

		if (result.hasErrors()) {
			return "/board/writeForm";
		}
		boardSVC.write(boardVO);
		return "redirect:/board/list";
	}

//게시글
	@GetMapping("/list")
	public String list(Model model) {
		System.out.println("list호출");
		model.addAttribute("list", boardSVC.list());

		return "/board/list";
	}

//게시글 보기
	@GetMapping("/view/{bnum}")
	public String view(@PathVariable("bnum") String bnum, Model model) {

		Map<String, Object> map = boardSVC.view(bnum);
		BoardVO boardVO = (BoardVO) map.get("board");
		List<BoardFileVO> files = null;
		if (map.get("files") != null) {
			files = (List<BoardFileVO>) map.get("files");
		}

		model.addAttribute("boardVO", boardVO);
		model.addAttribute("files", files);

		return "/board/readForm";
	}
	//게시글삭제
	@GetMapping("/delete/{bnum}")
	public String delete(@PathVariable("bnum") String bnum) {
		
		boardSVC.delete(bnum);
		
		return "redirect:/board/list";
	}
}
