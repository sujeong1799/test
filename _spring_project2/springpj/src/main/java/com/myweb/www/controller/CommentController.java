package com.myweb.www.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myweb.www.domain.CommentVO;
import com.myweb.www.service.CommentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/comment/*")
@Controller
public class CommentController {

	@Inject
	private CommentService csv;
	
	
	@PostMapping(value = "/post", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> post(@RequestBody CommentVO cvo) {
		log.info(">>> cvo : " + cvo);
		// DB 연결하기
		int isOk = csv.insertCvo(cvo);

		// 리턴을 위해서는 response의 통신상태를 같이 리턴해줘야한다.

		// 1은 HttpStatus가 Ok인 상태 아니면 0, 에러의 상태임 (1이 받는 값,,?)
		return isOk > 0 ? new ResponseEntity<String>("1", HttpStatus.OK)
				: new ResponseEntity<String>("0", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping(value = "/{bno}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<CommentVO>> spread(@PathVariable("bno") int bno) {
		log.info(">>> comment List bno > " + bno);

		// DB 요청
		List<CommentVO> list = csv.getList(bno);
		return new ResponseEntity<List<CommentVO>>(list, HttpStatus.OK);
	}


	@PutMapping(value="/{cno}", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> edit(@PathVariable("cno")int cno, @RequestBody CommentVO cvo){
	log.info(">>> edit cno "+ cno);
	log.info(">>> edit cvo "+ cvo);
	
	int isOk = csv.edit(cvo);
	
	return isOk > 0? new ResponseEntity<String>("1", HttpStatus.OK)
			: new ResponseEntity<String>("0", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

	@DeleteMapping(value="/{cno}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("cno")int cno){
		log.info(">>> remove cno >"+cno);
		int isOk = csv.remove(cno);
		if(isOk > 0) {
			return new ResponseEntity<String>("1", HttpStatus.OK);

		}else {
			return new ResponseEntity<String>("0", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	


}
