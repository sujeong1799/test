package com.myweb.www.service;

import java.util.List;

import com.myweb.www.domain.BoardVO;

public interface BoardService {

	int insert(BoardVO bvo);

	List<BoardVO> list();

}
