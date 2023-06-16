package com.myweb.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myweb.www.domain.BoardDTO;
import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.FileVO;
import com.myweb.www.domain.PagingVO;
import com.myweb.www.repository.BoardDAO;
import com.myweb.www.repository.FileDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO bdao;
	@Inject
	private FileDAO fdao;

	@Override
	public int insert(BoardVO bvo) {
		log.info(">>> register service 진입");
		int isOk = bdao.insert(bvo);
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

	@Override
	public int register(BoardDTO bdto) {
		log.info("bvo+flist register service 진입");
		// 기존 게시글에 대한 내용 DB 저장 내용을 다시 호출
		int isOk = bdao.insert(bdto.getBvo());
		if(bdto.getFlist() == null ) { //  null이면 파일이 없다를 의미
			isOk*=1; // 값이 없기때문에 그냥 성공한걸로 친대
		}else {
			// bvo가 db에 들어갔고, 파일 개수가 있다면
			if(isOk > 0 && bdto.getFlist().size() >0 ) {
				//register는 등록시 bno가 결정되어있지 않음
//				int bno = bdto.getBvo().getBno(); // 업데이트면 이렇게해도 되는건데 register니까 bno가 없겠죠?
				int bno = bdao.selectBno();// 방금 저장된 bvo의 bno 리턴받기
				//fList의 모든 file의 bno를 방금 받은 bno로 set
				for(FileVO fvo : bdto.getFlist()) {
					fvo.setBno(bno);
					log.info(">>> registerBoard File : "+fvo.toString());
					isOk *= fdao.insertFile(fvo);
				}
			}
		}
		return isOk;
	}

	@Override
	public BoardDTO detailFile(int bno) {
		log.info(">>> detail File service 진입");
		BoardDTO bdto = new BoardDTO();
		bdto.setBvo(bdao.detailBoard(bno)); // bvo호출
		bdto.setFlist(fdao.getFileList(bno)); //fList호출
		return bdto;
	}

	@Override
	public BoardDTO modifyFile(int bno) {
		log.info(">>> modify File service 진입");
		BoardDTO bdto = new BoardDTO();
		bdto.setBvo(bdao.modifyBoard(bno));
		bdto.setFlist(fdao.getFileList(bno));
		return bdto;
	}

	@Override
	public int removeFile(String uuid) {
		log.info(">>> delete File service 진입");
		
		return fdao.deleteFile(uuid);
	}

	@Override
	public int editFile(BoardDTO bdto) {
		log.info("bvo+flist edit service 진입");
		// 기존 게시글에 대한 내용 DB 저장 내용을 다시 호출
		int isOk = bdao.editBoard(bdto.getBvo());
		if(bdto.getFlist() == null ) { //  null이면 파일이 없다를 의미
			isOk*=1; // 값이 없기때문에 그냥 성공한걸로 친대
		}else {
			// bvo가 db에 들어갔고, 파일 개수가 있다면
			if(isOk > 0 && bdto.getFlist().size() >0 ) {
				//register는 등록시 bno가 결정되어있지 않음
//				int bno = bdto.getBvo().getBno(); // 업데이트면 이렇게해도 되는건데 register니까 bno가 없겠죠?
				int bno = bdao.selectBno();// 방금 저장된 bvo의 bno 리턴받기
				//fList의 모든 file의 bno를 방금 받은 bno로 set
				for(FileVO fvo : bdto.getFlist()) {
					fvo.setBno(bno);
					log.info(">>> editBoard File : "+fvo.toString());
					isOk *= fdao.insertFile(fvo);
				}
			}
		}
		return isOk;
	}

	
}
