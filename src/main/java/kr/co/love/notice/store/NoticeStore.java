package kr.co.love.notice.store;

import org.apache.ibatis.session.SqlSession;

import kr.co.love.notice.domain.Notice;

public interface NoticeStore {

	int insertNotice(SqlSession sqlSession, Notice notice);

}
