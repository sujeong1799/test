package com.myweb.www.service;

import java.util.List;

import com.myweb.www.domain.BoardDTO;
import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.PagingVO;

public interface BoardService {

	int insert(BoardVO bvo);

	List<BoardVO> list();

	BoardVO detail(int bno);

	int edit(BoardVO bvo);

	int delete(int bno);

	List<BoardVO> list(PagingVO pvo);

	int getTotalCount(PagingVO pvo);

	int count(int bno);

	BoardVO modify(int bno);

	int total(PagingVO pvo);

	List<BoardVO> pageList(PagingVO pvo);

	int register(BoardDTO bdto);

	BoardDTO detailFile(int bno);

	BoardDTO modifyFile(int bno);

	int removeFile(String uuid);

	int editFile(BoardDTO bdto);

}
