package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;
import repository.CommentDAO;
import repository.CommentDAOImpl;


public class CommentServiceImpl implements CommentService {
	private static final Logger log = LoggerFactory.getLogger(CommentServiceImpl.class);
	private CommentDAO cdao;
	
	public CommentServiceImpl() {
		cdao = new CommentDAOImpl();
	}
	
	@Override
	public int post(CommentVO cvo) {
		log.info("post service 진입!");
		
		return cdao.post(cvo);
	}

	@Override
	public java.util.List<CommentVO> List(int bno) {
		log.info("Comment list service 진입");
		
		return cdao.list(bno);
	}

	@Override
	public int remove(int cno) {
		log.info("Comment remove service 진입");
		return cdao.remove(cno);
	}

	@Override
	public int modify(CommentVO cvo) {
		log.info("Comment modify service 진입");
		return cdao.modify(cvo);
	}

}
