package kr.co.love.notice.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.love.notice.domain.Notice;
import kr.co.love.notice.service.NoticeService;
import kr.co.love.notice.store.NoticeStore;

@Repository
public class NoticeStoreLogic implements NoticeStore  {

	@Override
	public int insertNotice(SqlSession sqlSession, Notice notice) {
		int result = sqlSession.insert("NoticeMapper.insertNotice", notice);
		return result;
	}

	

}
