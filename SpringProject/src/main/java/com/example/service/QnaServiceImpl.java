package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.QnaDao;
import com.example.vo.BbsVO;
import com.example.vo.QnaVO;

@Service("qnaService")
public class QnaServiceImpl implements QnaService {
	@Autowired
	private QnaDao qnaDao;

	@Override
	public void create(QnaVO qnaVO) {
		String content = qnaVO.getContent();
		//content = this.changeEnter(content); //일반 Textarea에서는 해야 됨.
		content = this.changeTag(content);  
		content = content.replace("'", "\"");  //일반 Textarea에서는 해야 됨.
		qnaVO.setContent(content);
		
		String title = qnaVO.getTitle();
		title = this.changeTag(title);
		title = title.replace("'", "\"");
		qnaVO.setTitle(title);
		this.qnaDao.insertQna(qnaVO);
	}

	@Override
	public QnaVO read(int bno) {
		QnaVO qnaVO = this.qnaDao.selectQna(bno);
		String title = qnaVO.getTitle();
		title = this.reverseChangeTag(title);
		title = title.replace("\"", "'");
		qnaVO.setTitle(title);
		
		String content = qnaVO.getContent();
		//content = this.reverseChangeEnter(content);
		content = this.reverseChangeTag(content);
		qnaVO.setContent(content);
		return qnaVO;
	}

	@Override
	public List<QnaVO> readAll() {
		return this.qnaDao.selectAllQna();
	}

	@Override
	public void update(QnaVO qnaVO) {
		String content = qnaVO.getContent();
		//content = this.changeEnter(content); //일반 Textarea에서는 해야 됨.
		content = this.changeTag(content);  
		content = content.replace("'", "\"");  //일반 Textarea에서는 해야 됨.
		qnaVO.setContent(content);
		
		String title = qnaVO.getTitle();
		title = this.changeTag(title);
		title = title.replace("'", "\"");
		qnaVO.setTitle(title);
		this.qnaDao.updateQna(qnaVO);
	}

	@Override
	public void delete(int bno) {
		this.qnaDao.deleteQna(bno);
	}

	@Override
	public void updateReadnum(int bno) {
		this.qnaDao.readnumUpdate(bno);
	}
	
//	private String changeEnter(String str) {
//		return str.replace("\n", "<br />");
//	}
//	
//	private String reverseChangeEnter(String str) {
//		return str.replace("<br />", "\n");
//	}
	
	private String changeTag(String str) {
		String newStr = str.replace("<", "&lt;");
		return newStr.replace(">", "&gt;");
	}
	
	private String reverseChangeTag(String str) {
		String newStr = str.replace("&lt;", "<");
		return newStr.replace("&gt;", ">");
	}

	@Override
	public void reply(QnaVO qnaVO) {
		int lvl = qnaVO.getLvl();
		qnaVO.setLvl(lvl + 1);  //lvl 더하기 1 해야 함
		
		int step = qnaVO.getStep();
		qnaVO.setStep(step + 1);  //step도 1 더해야 함.
		
		String content = qnaVO.getContent();
		//content = this.changeEnter(content); //일반 Textarea에서는 해야 됨.
		content = this.changeTag(content);  
		content = content.replace("'", "\"");  //일반 Textarea에서는 해야 됨.
		qnaVO.setContent(content);
		
		String title = qnaVO.getTitle();
		title = this.changeTag(title);
		title = title.replace("'", "\"");
		qnaVO.setTitle(title);
		this.qnaDao.replyQna(qnaVO);
	}

	@Override
	public int getTotalPage(int pageSize) {
		int count = this.qnaDao.getTotalCount();  //전체 레코드 수
		int totalPage = (count % pageSize == 0) ? count / pageSize : count / pageSize + 1;
		return totalPage;
	}
	
	

}
