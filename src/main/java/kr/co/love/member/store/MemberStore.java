package kr.co.love.member.store;

import org.apache.ibatis.session.SqlSession;

import kr.co.love.member.domain.Member;

public interface MemberStore {

	public int insertMember(SqlSession session, Member member);

}
