package com.spring.model;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory; // [O O O O O]
	
	//회원 리스트 보기
	public List<MemberVO> memberList() {
		
		//[connection + statement] -> SqlSession
		//SqlSession 생성
		SqlSession session=sqlSessionFactory.openSession();
		
		//sql결과값 저장, selectList("sql id값 넣기")
		List<MemberVO> list = session.selectList("memberList");
		
		//Sqlsession 반납
		session.close();
		
		return list;
	}
	
	//회원가입
	public int memberInsert(MemberVO vo) {
		//SqlSession 생성
		SqlSession session=sqlSessionFactory.openSession();
		
		//sql 결과값 저장, insert("sql id값 넣기", 값)
		int cnt = session.insert("memberInsert", vo);
		
		//sql 적용
		session.commit();
		
		//Sqlsession 반납
		session.close();
		
		return cnt;
	}
	
	//회원 삭제
	public int memberDelete(int num) {
		//SqlSession 생성
		SqlSession session = sqlSessionFactory.openSession();
		
		//sql 결과값 저장, insert("sql id값 넣기", 값)
		int cnt = session.delete("memberDelete", num);
		
		//sql 적용
		session.commit();
		
		//Sqlsession 반납
		session.close();
		
		return cnt;
	}
	
	//회원 상세보기
	public MemberVO memberContent(int num) {
		//SqlSession 생성
		SqlSession session = sqlSessionFactory.openSession();
		
		//sql 결과값 저장, selectOne("sql id값 넣기", 값)
		//selectOne은 하나를 리턴할때
		MemberVO vo = session.selectOne("memberContent", num);
		
		//sql 적용
		session.commit();
		
		//Sqlsession 반납
		session.close();
		
		return vo;
	}
	
	//회원 수정하기
	public int memberUpdate(MemberVO vo) {
		//SqlSession 생성
		SqlSession session = sqlSessionFactory.openSession();
		
		//sql 결과값 저장, update("sql id값 넣기", 값)
		int cnt = session.update("memberUpdate", vo);
		
		//sql 적용
		session.commit();
		
		//Sqlsession 반납
		session.close();
		
		return cnt;
	}
	
	
}
