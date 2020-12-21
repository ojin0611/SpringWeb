package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BbsDao;
import com.example.vo.BbsVO;

import lombok.extern.java.Log;

@Service("bbsService")
@Log
public class BbsServiceImpl implements BbsService {
	@Autowired
	private BbsDao bbsDao;

	@Override
	public void create(BbsVO bbsVO) {
		//Service는 비즈니스 처리 해야 함.
		//1. 엔터키를 <br />로 변경 
		//2. tag를 일반 특수문자 &lt;(<)  &gt(>); 로 변경
		//3. 홑따옴표를 쌍따옴표로 변경
		String content = bbsVO.getContent();
		content = this.changeEnter(content);
		content = this.changeTag(content);  
		//content = content.replace("'", "\"");
		bbsVO.setContent(content);
		
		String title = bbsVO.getTitle();
		title = this.changeTag(title);
		title = title.replace("'", "\"");
		bbsVO.setTitle(title);
		
		//log.info(bbsVO.toString());
		this.bbsDao.insertBoard(bbsVO);
	}

	@Override
	public BbsVO read(int bno) {
		//Service는 비즈니스 처리 해야 함.
		//1. <br />을 엔터키로 변경 
		//2. 특수문자 &lt;(<)  &gt(>);를 tag로 변경
		//3. 쌍따옴표를 홑따옴표로 변경
		BbsVO bbsVO = this.bbsDao.selectBoard(bno);
		String title = bbsVO.getTitle();
		title = this.reverseChangeTag(title);
		title = title.replace("\"", "'");
		bbsVO.setTitle(title);
		
		String content = bbsVO.getContent();
		content = this.reverseChangeEnter(content);
		content = this.reverseChangeTag(content);
		bbsVO.setContent(content);
		return bbsVO;
	}

	@Override
	public List<BbsVO> readAll() {
		List<BbsVO> list = this.bbsDao.selectAllBoard();
		list.forEach(bbs -> {
			String title = bbs.getTitle();
			title = this.reverseChangeTag(title);
			title = title.replace("\"", "'");
			bbs.setTitle(title);
		});
		return list;
	}

	@Override
	public void update(BbsVO bbsVO) {
		//Service는 비즈니스 처리 해야 함.
		//1. 엔터키를 <br />로 변경 
		//2. tag를 일반 특수문자 &lt;(<)  &gt(>); 로 변경
		//3. 홑따옴표를 쌍따옴표로 변경
		String content = bbsVO.getContent();
		content = this.changeEnter(content); //일반 Textarea에서는 해야 됨.
		content = this.changeTag(content);  
		content = content.replace("'", "\"");  //일반 Textarea에서는 해야 됨.
		bbsVO.setContent(content);
		
		String title = bbsVO.getTitle();
		title = this.changeTag(title);
		title = title.replace("'", "\"");
		bbsVO.setTitle(title);
		
		//log.info(bbsVO.toString());
		this.bbsDao.updateBoard(bbsVO);
	}

	@Override
	public void delete(int bno) {
		this.bbsDao.deleteBoard(bno);
	}

	private String changeEnter(String str) {
		return str.replace("\n", "<br />");
	}
	
	private String reverseChangeEnter(String str) {
		return str.replace("<br />", "\n");
	}
	
	private String changeTag(String str) {
		String newStr = str.replace("<", "&lt;");
		return newStr.replace(">", "&gt;");
	}
	
	private String reverseChangeTag(String str) {
		String newStr = str.replace("&lt;", "<");
		return newStr.replace("&gt;", ">");
	}

	@Override
	public void updateReadnum(int bno) {
		this.bbsDao.readnumUpdate(bno);
	}
	
}
