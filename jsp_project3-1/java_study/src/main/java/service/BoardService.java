package service;

import java.util.List;

import domain.BoardVO;
import domain.PagingVO;

public interface BoardService {

	int insert(BoardVO bvo);

	List<BoardVO> list();

	BoardVO detail(int bno);

	int edit(BoardVO bvo);

	int remove(int bno);

	BoardVO detail1(int bno);

	int total(PagingVO pgvo);

	List<BoardVO> PageList(PagingVO pgvo);

}
