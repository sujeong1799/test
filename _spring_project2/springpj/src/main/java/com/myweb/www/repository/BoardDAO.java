package com.myweb.www.repository;

import java.util.List;

import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.PagingVO;

public interface BoardDAO {

	int insert(BoardVO bvo);

	List<BoardVO> listBoard();

	BoardVO detailBoard(int bno);

	int count(int bno);

	List<BoardVO> selectBoardListPaging(PagingVO pvo);

	int totalCount(PagingVO pvo);

	BoardVO modifyBoard(int bno);

	int editBoard(BoardVO bvo);

	int deleteBoard(int bno);

	int selectBno();


}
