package kr.co.love.member.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.love.member.domain.Member;
import kr.co.love.member.store.MemberStore;

@Repository
public class MemberStoreLogic implements MemberStore {

	@Override
	public int insertMember(SqlSession session, Member member) {
		int result = session.insert("MemberMapper.insertMember", member); 
		return result;
	}

	@Override
	public Member selectMemberLogin(SqlSession session, Member member) {
		Member mOne = session.selectOne("MemberMapper.selectMemberLogin", member); 
		return mOne;
	}

	@Override
	public Member selectOneById(SqlSession session, String memberId) {
		Member member = session.selectOne("MemberMapper.selectOneById", memberId);
		return member;
	}

	@Override
	public int deleteMember(SqlSession session, String memberId) {
		int result = session.delete("MemberMapper.deleteMember", memberId);
		return result;
	}

	@Override
	public Member selectCountCheck(SqlSession session, Member member) {
		Member mOne = session.selectOne("MemberMapper.selectCountCheck", member);
		return mOne;
	}

	@Override
	public int updateMember(SqlSession session, Member member) {
		int result = session.insert("MemberMapper.updateMember", member);
		return result;
	}

}
