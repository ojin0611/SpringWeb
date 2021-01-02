package com.example.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ReplyDao;
import com.example.vo.ReplyVO;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private ReplyDao replyDao;
	
	@Override
	public void select(Map map) {
		this.replyDao.select(map);
	}

	@Override
	public void create(ReplyVO replyVo) {
		String replyer = replyVo.getReplyer();
		replyer = this.convert(replyer);
		replyVo.setReplyer(replyer);
		
		String replytext = replyVo.getReplytext();
		replytext = this.convert(replytext);
		replyVo.setReplytext(replytext);
		this.replyDao.insert(replyVo);
	}
	
	private String convert(String oldStr) {
		String newStr = oldStr.replace("'", "''");
		newStr = newStr.replace("<", "&lt;");
		newStr = newStr.replace(">", "&gt;");
		newStr = newStr.replace("\n", "<br />");
		return newStr;
	}

}
