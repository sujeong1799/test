package com.myweb.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myweb.www.domain.CommentVO;
import com.myweb.www.repository.CommentDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommentServiceImpl implements CommentService {
	
	@Inject
	private CommentDAO cdao;

	@Override
	public int insertCvo(CommentVO cvo) {
		log.info("Comment insert service 진입");
		return cdao.insertCvo(cvo);
	}

	@Override
	public List<CommentVO> getList(int bno) {
		log.info("Comment List service 진입");
		return cdao.listCvo(bno);
	}
	
	@Override
	public int edit(CommentVO cvo) {
		log.info("Comment edit service 진입");
		return cdao.editCvo(cvo);
	}

	@Override
	public int remove(int cno) {
		log.info("Comment remove service 진입");
		return cdao.removeCvo(cno);
	}

}