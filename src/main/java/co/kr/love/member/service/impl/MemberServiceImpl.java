package co.kr.love.member.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.love.member.domain.Member;
import co.kr.love.member.service.MemberService;
import co.kr.love.member.store.MemberStore;

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
