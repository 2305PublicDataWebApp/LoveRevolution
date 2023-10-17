package kr.co.love.member.service;

import kr.co.love.member.domain.Member;

public interface MemberService {

	public int registerMember(Member member);

	public Member memberLoginCheck(Member member);

	public Member showOneById(String memberId);


}
