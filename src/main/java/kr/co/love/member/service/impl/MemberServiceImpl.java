package kr.co.love.member.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.love.member.store.MemberStore;
import kr.co.love.member.domain.Member;
import kr.co.love.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private SqlSession session;
	
	@Autowired
	private MemberStore mStore;

	@Override
	public int registerMember(Member member) {
		int result = mStore.insertMember(session, member);
		return result;
	}
}
