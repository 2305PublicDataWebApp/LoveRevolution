package co.kr.love.member.store;

import org.apache.ibatis.session.SqlSession;

import co.kr.love.member.domain.Member;

public interface MemberStore {

	public int insertMember(SqlSession session, Member member);

}
