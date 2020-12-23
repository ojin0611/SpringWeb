package com.example.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BbsDao;
import com.example.vo.BbsVO;

@Service("bbsService")
public class BbsServiceImpl implements BbsService {
	@Autowired
	private BbsDao bbsDao;
	
	@Override
	public void create(BbsVO bbsVo) {
		String writer = bbsVo.getWriter();
		writer = changeStr(writer);
		bbsVo.setWriter(writer);
		
		String title = bbsVo.getTitle();
		title = changeStr(title);
		bbsVo.setTitle(title);
		
		String contents = bbsVo.getContents();
		contents = changeStr(contents);
		bbsVo.setContents(contents);
		
		this.bbsDao.insert(bbsVo);
	}
	
	private String changeStr(String str) {
		//3가지 작업
		//1. 홑따옴표를 쌍따옴표나 홑홑따옴표로
		str = str.replace("'", "''");
		//2. 여는 태그를 &lt; 로 
		str = str.replace("<", "&lt;");
		//3. 닫는 태그를 &gt; 로
		str = str.replace(">", "&gt;");
		//4. 추가적으로 일반 TextArea일 경우에는 
		//str = str.replace("\n", "<br />");
		return str;
	}

	@Override
	public void read(Map map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void readAll(Map map) {
		this.bbsDao.selectAll(map);
	}

	@Override
	public void update(BbsVO bbsVo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int idx) {
		// TODO Auto-generated method stub

	}

}
