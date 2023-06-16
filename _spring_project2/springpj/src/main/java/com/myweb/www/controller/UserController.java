package com.myweb.www.controller;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myweb.www.domain.UserVO;
import com.myweb.www.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/mem/*")
@Controller
public class UserController {
	
	@Inject
	private UserService usv;
	
	
	@GetMapping("/signup")
	public String index(Model m) {
		log.info("index 접근 완료");
		return "/user/signup";
	}
	
	@PostMapping("/signup")
	public String signupPost(Model m, UserVO uvo) {
		log.info("JOIN 접근 완료");
		log.info(uvo.toString());
		int isOk =usv.signUp(uvo);
		if(isOk > 0) {
			m.addAttribute("msg_signup", 1);
			log.info("JOIN 성공");
		}else {
			m.addAttribute("msg_signup", 0);
			log.info("JOIN 실패");
		}
		return "home";
	}
	
	@GetMapping("/login")
	public String index2(Model m) {
		log.info("index2 접근 완료");
		return "/user/login";
	}
	
	@PostMapping("/login")
	public String loginPost(Model m, UserVO user, HttpServletRequest request) {
		
		// 파라미터로 받은 id, pw를 db에 넘겨주고 일치하는 객체를 받음
		UserVO isUser = usv.isUser(user.getId(), user.getPw());
		log.info("로그인 접근 완료"+ user.toString());
		
	
		// DB에서 얻은 객체가 null이 아니라면 세션 연결 저장
		if( isUser != null) {
			HttpSession ses = request.getSession();
			ses.setAttribute("ses", isUser);
			ses.setMaxInactiveInterval(60*10);

			m.addAttribute("user > ", isUser);
			m.addAttribute("msg_login", 1);
			log.info("성공");
			
		}else {
			m.addAttribute("msg_login", 0);
			log.info("실패");
			return "home";
		}

		return "home2";
	}
	
	@GetMapping("/home2")
	public String index3(Model m) {
		log.info("index 접근 완료");
		return "home2";
	}
	
	@GetMapping("/logout")
	public String logout(Model m, HttpServletRequest request) {
		request.getSession().removeAttribute("ses");
		request.getSession().invalidate();
		m.addAttribute("msg_logout", 1);
		return "home";
	}
	
}
