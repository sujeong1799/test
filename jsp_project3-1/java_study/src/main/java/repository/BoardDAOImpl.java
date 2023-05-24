package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import orm.DatabaseBuilder;

public class BoardDAOImpl implements BoardDAO {
	private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);
	private SqlSession sql;
	private String BS = "BoardMapper.";
	
	public BoardDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession(); // sql연결
	}

	@Override
	public int insert(BoardVO bvo) {
		log.info("insert DAO진입");
		int isOk = sql.insert(BS+"reg", bvo);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public List<BoardVO> selectList() {
		log.info("list DAO진입");
		List<BoardVO> list = sql.selectList(BS+"list");
		return list;
	}

	@Override
	public BoardVO detailOne(int bno) {
		log.info("detail DAO 진입");
		return sql.selectOne(BS+"detail", bno);
	}

	@Override
	public int updateEdit(BoardVO bvo) {
		log.info("edit DAO 진입 ");
		int isOk = sql.insert(BS+"edit", bvo);
		if(isOk > 0 ) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public int removeOne(int bno) {
		log.info("remove DAO 진입");
		int isOk = sql.delete(BS+"remove", bno);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}


	@Override
    public int updateCount(int bno) {
        // TODO Auto-generated method stub
        int isOk = sql.update(BS+"count", bno);
        if(isOk>0) sql.commit();
        return isOk;
    }

	@Override
	public BoardVO detail1(int bno) {

		return sql.selectOne(BS+"detail1", bno);
	}

	@Override
	public int total(PagingVO pgvo) {
		return sql.selectOne(BS+"total", pgvo);
	}

	@Override
	public List<BoardVO> pageList(PagingVO pgvo) {
		
		//return sql.selectList(BS+"pageList", pgvo);
		return sql.selectList(BS+"selectList", pgvo);
	}

}
