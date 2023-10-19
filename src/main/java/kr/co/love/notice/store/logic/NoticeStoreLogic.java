package kr.co.love.notice.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.love.notice.domain.Notice;
import kr.co.love.notice.domain.PageInfo;
import kr.co.love.notice.service.NoticeService;
import kr.co.love.notice.store.NoticeStore;

@Repository
public class NoticeStoreLogic implements NoticeStore  {

	@Override
	public int insertNotice(SqlSession sqlSession, Notice notice) {
		int result = sqlSession.insert("NoticeMapper.insertNotice", notice);
		return result;
	}

	@Override
	public int selectListCount(SqlSession sqlSession) {
		int result = sqlSession.selectOne("NoticeMapper.selectListCount");
		return result;
	}

	@Override
	public List<Notice> selectNotice(SqlSession sqlSession, PageInfo pInfo) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Notice> nList = sqlSession.selectList("NoticeMapper.selectNotice", null, rowBounds);
		return nList;
	}

	@Override
	public Notice selectNoticeByNo(SqlSession sqlSession, Integer noticeNo) {
		Notice noticeOne = sqlSession.selectOne("NoticeMapper.selectNoticeByNo", noticeNo);
		return noticeOne;
	}

	@Override
	public int deleteNotice(SqlSession sqlSession, Notice notice) {
		int result = sqlSession.delete("NoticeMapper.deleteNotice", notice);
		return result;
	}

	@Override
	public int updateNotice(SqlSession sqlSession, Notice notice) {
		int result = sqlSession.update("NoticeMapper.updateNotice", notice);
		return result;
	}

	
	

}
