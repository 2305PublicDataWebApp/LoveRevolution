package kr.co.love.notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.love.notice.domain.Notice;
import kr.co.love.notice.service.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService nService;
	
	@RequestMapping(value="/notice/write.do", method = RequestMethod.GET)
	public ModelAndView showWriteForm(ModelAndView mv) {
		mv.setViewName("notice/write");
		return mv;
	}
	
	@RequestMapping(value="/notice/write.do", method = RequestMethod.POST)
	public ModelAndView noticeRegister(
			ModelAndView mv
			, @ModelAttribute Notice notice
			, HttpSession session
			, HttpServletRequest request) {
		try {
			String noticeAdmin = (String)session.getAttribute("memberName");
			System.out.println("noticeAdmin" + noticeAdmin);
			if(noticeAdmin != null && !noticeAdmin.equals("")) {
				notice.setNoticeAdmin(noticeAdmin);
				int result = nService.insertNotice(notice);
				mv.setViewName("redirect:/notice/list.gg");
		}else {
			mv.addObject("msg", "로그인 정보가 존재하지 않습니다.");
			mv.addObject("error", "로그인이 필요합니다.");
			mv.addObject("url", "/index.jsp");
			mv.setViewName("common/serviceFailed");
		}
	
	}catch(Exception e) {
		mv.addObject("msg", "공지사항 등록이 완료하지 않습니다.");
		mv.addObject("error", e.getMessage());
		mv.addObject("url", "/notice/write.gg");
		mv.setViewName("common/serviceFailed");
	}
		return mv;

	}
	
	
	
	
}
