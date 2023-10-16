package co.kr.love.member.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import co.kr.love.member.domain.Member;
import co.kr.love.member.store.MemberStore;

@Repository
public class MemberStoreLogic implements MemberStore {

	@Override
	public int insertMember(SqlSession session, Member member) {
		int result = session.insert("MemberMapper.insertMember", member); 
		return result;
	}

}
