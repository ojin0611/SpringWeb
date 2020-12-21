package com.example.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.vo.QnaVO;

import lombok.extern.java.Log;

@Repository("qnaDao")
@Log
public class QnaDaoImpl implements QnaDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertQna(QnaVO qnaVO) {
		this.sqlSession.insert("Qna.insertSP", qnaVO);
	}

	@Override
	public QnaVO selectQna(int bno) {
		return this.sqlSession.selectOne("Qna.selectOne", bno);
	}

	@Override
	public List<QnaVO> selectAllQna() {
		return this.sqlSession.selectList("Qna.selectAll");
	}

	@Override
	public void updateQna(QnaVO qnaVO) {
		this.sqlSession.update("Qna.update", qnaVO);
	}

	@Override
	public void deleteQna(int bno) {
		this.sqlSession.delete("Qna.delete", bno);
	}

	@Override
	public void readnumUpdate(int bno) {
		this.sqlSession.update("Qna.readnumUpdate", bno);
	}

	@Override
	public void replyQna(QnaVO qnaVO) {
		//log.info("grp = " + qnaVO.getGrp());
		//log.info("lvl = " + qnaVO.getLvl());
		//log.info("step = " + qnaVO.getStep());
		this.sqlSession.update("Qna.updateStepSP", qnaVO);
		this.sqlSession.insert("Qna.insertReply", qnaVO);
	}

	@Override
	public int getTotalCount() {
		return (Integer)this.sqlSession.selectOne("selectCount");
	}
}
