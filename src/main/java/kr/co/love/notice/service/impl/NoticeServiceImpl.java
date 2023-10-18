package kr.co.love.notice.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.love.notice.store.NoticeStore;

import kr.co.love.notice.domain.Notice;
import kr.co.love.notice.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	//의존성 주입
	@Autowired
	private NoticeStore nStore;
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertNotice(Notice notice) {
		int result = nStore.insertNotice(sqlSession, notice);
		return result;
	}

}
