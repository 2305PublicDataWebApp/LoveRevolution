package kr.co.love.notice.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.love.notice.domain.Notice;
import kr.co.love.notice.domain.PageInfo;

public interface NoticeStore {

	int insertNotice(SqlSession sqlSession, Notice notice);

	int selectListCount(SqlSession sqlSession);

	List<Notice> selectNotice(SqlSession sqlSession, PageInfo pInfo);

	Notice selectNoticeByNo(SqlSession sqlSession, Integer noticeNo);

	int deleteNotice(SqlSession sqlSession, Notice notice);

	int updateNotice(SqlSession sqlSession, Notice notice);

}
