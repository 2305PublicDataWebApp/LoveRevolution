package kr.co.love.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
				return "member/login";
			} else {
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/serviceFailed";
		}
	}
	
	@RequestMapping(value="/update.do", method=RequestMethod.GET)
	public String showUpdateView(
			@RequestParam("memberId") String memberId
			, Model model) {
		try {
			Member member = service.showOneById(memberId);
			if(member != null) {
				model.addAttribute("member", member);
				return "member/modify";
			} else {
				model.addAttribute("msg", "데이터 조회에 실패했습니다.");
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "common/serviceFailed";
		}
	}
	
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public String updateMember(
			@ModelAttribute Member member
			, Model model) {
		try {
			Member confirmMember = service.selectCountCheck(member); 
			if (confirmMember == null) {
				int result = service.updateMember(member);
				if(result > 0) {
					return "redirect:/index.jsp";
				} else {
					model.addAttribute("msg", "회원정보 수정 실패");
					return "common/serviceFailed";
				}
			}	else {
				model.addAttribute("msg", "회원정보가같습니다..다시수정해주세요");
				model.addAttribute("url", "/member/update.do?memberId="+member.getMemberId());
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/serviceFailed";
		}
	}
	
	@RequestMapping(value="/delete.do", method=RequestMethod.GET)
	public String removeMember(
		@RequestParam("memberId") String memberId
		, Model model) {
		try {
			int result = service.deleteMember(memberId);
			if(result > 0) {
				return "redirect:/member/logout.do";
			} else {
				model.addAttribute("msg", "회원탈퇴가 완료되지 않았습니다.");
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/serviceFailed";
		}
		
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public ModelAndView showLoginForm(ModelAndView mv) {
		mv.setViewName("member/login");
		return mv;
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String memberLogin(
			@ModelAttribute Member member 
			, HttpSession session
			, Model model
			) {
		Member mOne = service.memberLoginCheck(member);
		System.out.println("mOne값 = "+mOne);
		try {
			if(mOne != null) {
				session.setAttribute("memberId", mOne.getMemberId());
				session.setAttribute("memberName", mOne.getMemberName());
				return "redirect:/index.jsp";
			} else {
				model.addAttribute("msg", "로그인이 완료되지 않았습니다.");
				model.addAttribute("error", "로그인 실패");
				model.addAttribute("url", "/member/login.do");
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "관리자에게 문의해주세요.");
			model.addAttribute("error", e.getMessage());
			model.addAttribute("url", "/member/register.do");
			return "common/serviceFailed";
		}
	}
	
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public String memberLogout(HttpSession session, Model model) {
		if(session != null) {
			session.invalidate();
			return "redirect:/index.jsp";
		} else {
			model.addAttribute("msg", "로그아웃을 완료하지 못했습니다.");
			model.addAttribute("error", "로그아웃 실패");
			model.addAttribute("url", "/index.jsp");
			return "common/serviceFailed";
		}
	}
	
	@RequestMapping(value="/mypage.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String showDetailMember(
		HttpSession session
		, Model model) {
		try {
			String memberId = (String)session.getAttribute("memberId");
			Member member = null;
			
			if(memberId != "" && memberId != null) {
				member = service.showOneById(memberId);
			}
			if(member != null) {
				model.addAttribute("member", member);
				return "member/mypage";
			} else {
				model.addAttribute("msg", "회원정보를 완료하지 못했습니다.");
				model.addAttribute("error", "마이페이지 조회 실패");
				model.addAttribute("url", "/member/login.gg");
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "관리자에게 문의해주세요.");
			model.addAttribute("error", e.getMessage());
			model.addAttribute("url", "/member/login.gg");
			return "common/serviceFailed";
		}
		
	}
	
	
	
	
}
