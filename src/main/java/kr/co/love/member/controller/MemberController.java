package kr.co.love.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.love.member.domain.Member;
import kr.co.love.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@RequestMapping(value="/register.do", method=RequestMethod.GET)
	public ModelAndView showRegisterForm(ModelAndView mv) {
		mv.setViewName("member/register");
		return mv;
	}
	
	@RequestMapping(value="/register.do", method=RequestMethod.POST)
	public String registerMember(
		@ModelAttribute Member member
		,Model model) {
		try {
			int result = service.registerMember(member);
			System.out.println("result값:"+result);
			if(result > 0) {
				// 성공시 로그인페이지로 이동
				return "member/login.do";
			} else {
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/serviceFailed";
		}
	}
	
	
	
	
	
	
	
}
