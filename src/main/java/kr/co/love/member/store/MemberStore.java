package kr.co.love.member.store;

import org.apache.ibatis.session.SqlSession;

import kr.co.love.member.domain.Member;

public interface MemberStore {

	public int insertMember(SqlSession session, Member member);

	public Member selectMemberLogin(SqlSession session, Member member);

	public Member selectOneById(SqlSession session, String memberId);

	public int deleteMember(SqlSession session, String memberId);

	public Member selectCountCheck(SqlSession session, Member member);

	public int updateMember(SqlSession session, Member member);

}
