package kr.co.love.notice.service;

import java.util.List;

import kr.co.love.notice.domain.Notice;
import kr.co.love.notice.domain.PageInfo;

public interface NoticeService {

	int insertNotice(Notice notice);

	Integer getListCount();

	List<Notice> selectNotice(PageInfo pInfo);

	Notice selectNoticeByNo(Integer noticeNo);

	int deleteNotice(Notice notice);

	int updateNotice(Notice notice);

	

}
