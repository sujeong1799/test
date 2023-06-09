package com.myweb.www.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.www.Handler.PagingHandler;
import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.PagingVO;
import com.myweb.www.domain.UserVO;
import com.myweb.www.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/board/*")
@Controller

public class BoardController {

	@Inject
	private BoardService bsv;

	@GetMapping("/register")
	public String registerGet() {
		return "/board/register";
	}

	@PostMapping("/register")
	public String registerPost(BoardVO bvo, RedirectAttributes rAttr) {
		// 모델객체 보내서 뭐 할거면 쓰셈
		log.info(">>> bvo >" + bvo.toString()); // 잘나오는지 확인먼저
		int isOk = bsv.register(bvo);
		log.info(">> board register >> " + (isOk > 0 ? "OK" : "FAIL"));

		// 가져가야하는 객체가 있다면
		rAttr.addAttribute("isOk", isOk);// 이케 가져가셈 얘는 값이 안사라짐 flush붙은거는 1회용임
		return "redirect:/board/list";
	}

	// insert update delete 후 redirect 처리 함
	// RedirectAttributes : 데이터 새로고침

	// list는 보내줄거 없으니까 PostMapping 안씀 (페이징할때 쓸거래)
	@GetMapping("/list") // 왔던 형태에서 다시 돌아간다면 String말고 void 써도 됨 
	public String listPost(Model m, PagingVO pvo) {
		log.info(">>> pagevo : " + pvo);
		// RedirectAttributes 객체사용 : 데이터의 새로고침
		List<BoardVO> list = bsv.list(pvo);
		m.addAttribute("list", list);
		int totalCount = bsv.getTotalCount(pvo);
		PagingHandler ph = new PagingHandler(pvo, totalCount);
		m.addAttribute("ph", ph);
		return "/board/list";
	}
	
	/*
	 * // 검... 색...?
	 * 
	 * @GetMapping("/page") public String pagePost(Model m, PagingVO pvo) {
	 * log.info(">>> pgvo >" + pvo.getTypeToArray()); int totCount = bsv.total(pvo);
	 * List<BoardVO> list = bsv.pageList(pvo); PagingHandler ph = new
	 * PagingHandler(pvo, totCount); m.addAttribute("ph", ph);
	 * m.addAttribute("list", list); return "/board/list"; }
	 */

	
	@GetMapping("/detail")
	   public void detail(Model m, @RequestParam("bno")int bno) {
	      log.info(">>> bno >" + bno);
	      BoardVO bvo = bsv.detail(bno);
	      int isOk = bsv.count(bno);
	      log.info(">>> count up > " + (isOk > 0 ? "success" : "Fail"));
	      m.addAttribute("bvo", bvo);
	   }
	
	// String으로 하면 return 값을 써야하잔아..
	// detail을 가져와야 하는 케이스 : detail, modify 둘다 detail을 가져와야하니께 두개 다 써줘
	@GetMapping("/modify") // 다시 board detail값으로 돌아간다능.. 뭐 .. 그런..
	// 물음표 달고오능거는 @RequestParam으로 받으면 됨
	public void modify(Model m, @RequestParam("bno") int bno) {
		log.info(">>> bno >" + bno);
		BoardVO bvo = bsv.modify(bno);
		m.addAttribute("bvo", bvo);
	}
		

	@PostMapping("/modify")
	public String edit(Model m, BoardVO bvo, RedirectAttributes rAttr) {
		log.info(">>> bvo >" + bvo);
		int isOk = bsv.edit(bvo);
		m.addAttribute("bvo", bvo);
		return "redirect:/board/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("bno") int bno, RedirectAttributes rAttr, HttpServletRequest request) {
		// DB상 update하기 isDel = "y" => 삭제한 글 처리????????
		/*
		 * HttpSession ses = request.getSession(); UserVO sesUser = (UserVO)
		 * ses.getAttribute("ses"); // 세션 객체("현재 로그인한 객체)를 UserVO에 담았어요
		 * log.info(">>> sesUser >" + sesUser.toString()); UserVO user
		 * =udao.getUser(sesUser.getId());
		 */
		
		log.info(">>> bno >" + bno);
		int isOk = bsv.delete(bno);
		log.info(">>> 글 삭제 >" + (isOk > 0 ? "성공" : "실패"));
		return "redirect:/board/list";
	}
	
	
	
	
	
}
