package com.myweb.www.repository;

import java.util.List;

import com.myweb.www.domain.CommentVO;

public interface CommentDAO {

	int insertCvo(CommentVO cvo);

	int editCvo(CommentVO cvo);

	List<CommentVO> listCvo(int bno);

	int removeCvo(int cno);

}
