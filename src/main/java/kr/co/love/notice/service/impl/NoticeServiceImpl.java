package kr.co.love.notice.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.love.notice.store.NoticeStore;

import kr.co.love.notice.domain.Notice;
import kr.co.love.notice.domain.PageInfo;
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

	@Override
	public Integer getListCount() {
		int result = nStore.selectListCount(sqlSession);
		return result;
	}

	@Override
	public List<Notice> selectNotice(PageInfo pInfo) {
		List<Notice> nList = nStore.selectNotice(sqlSession,pInfo);
		return nList;
	}

	@Override
	public Notice selectNoticeByNo(Integer noticeNo) {
		Notice noticeOne = nStore.selectNoticeByNo(sqlSession,noticeNo);
		return noticeOne;
	}

	@Override
	public int deleteNotice(Notice notice) {
		int result = nStore.deleteNotice(sqlSession,notice);
		return result;
	}

	@Override
	public int updateNotice(Notice notice) {
		int result = nStore.updateNotice(sqlSession,notice);
		return result;
	}

}
