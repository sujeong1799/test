package com.myweb.www.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myweb.www.domain.CommentVO;
import com.myweb.www.service.CommentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping
@Controller("/comment/*")
public class CommentController {
	
	@Inject
	private CommentService csv; 
	
	//ResponseEntity 객체는 json파일을 나타내줄때 데이터를 주고받고 할 때 설정 할 수 있는 객체
	// http response 데이타가 포함되어 있대
	// value : mapping 값 설정, consumes : 가져오는 값의 형태
	// produces : 보낼때의 형식
	@PostMapping(value="/post", consumes = "application/json",
			 produces = MediaType.TEXT_PLAIN_VALUE )
	
	public ResponseEntity<String> post(@RequestBody CommentVO cvo){
		log.info(">>> cvo : " + cvo);
		// DB 연결하기
		
		
		
		// 리턴을 위해서는 response의 통신상태를 같이 리턴해줘야한다.
		int isOk = 1;
		
		// 1은 HttpStatus가 Ok인 상태 아니면 0, 에러의 상태임 (1이 받는 값,,?)
		return isOk > 0? new ResponseEntity<String>("1", HttpStatus.OK)
				: new ResponseEntity<String>("0", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
