package com.myweb.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.PagingVO;
import com.myweb.www.repository.BoardDAO;
import com.myweb.www.repository.UserDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO bdao;

	@Override
	public int register(BoardVO bvo) {
		log.info(">>> register service 진입");
		int isOk = bdao.registerBoard(bvo);
		return isOk;
	}

	@Override
	public List<BoardVO> list() {
		log.info(">>> list service 진입");
		return bdao.listBoard();
	}

	@Override
	public BoardVO detail(int bno) {
		log.info(">>> detail service 진입");
		return bdao.detailBoard(bno);
	}

	@Override
	public int edit(BoardVO bvo) {
		log.info(">>> edit service 진입");
		return bdao.editBoard(bvo);
	}

	@Override
	public int delete(int bno) {
		log.info(">>> delete service 진입");
		return bdao.deleteBoard(bno);
	}

	@Override
	public List<BoardVO> list(PagingVO pvo) {
		log.info(">>> board PagingList service 진입");
		return bdao.selectBoardListPaging(pvo);
	}

	@Override
	public int getTotalCount(PagingVO pvo) {
		// TODO Auto-generated method stub
		return bdao.getTotalCount(pvo);
	}

	@Override
	public int count(int bno) {
		log.info(">>> board count service 진입");
		return bdao.count(bno);
	}

	@Override
	public BoardVO modify(int bno) {
		log.info(">>> board modify service 진입");
		return  bdao.modifyBoard(bno);
	}

	@Override
	public int total(PagingVO pvo) {
		log.info(">>> board total service 진입");
		return bdao.totalBoard(pvo);
	}

	@Override
	public List<BoardVO> pageList(PagingVO pvo) {
		log.info(">>> board pageList service 진입");
		return bdao.pageListBoard(pvo);
	}




	
}
