package kr.bit.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {

	private static SqlSessionFactory sqlSessionFactory; // [O O O O O]

	// 초기화 블록 - 프로그램 실행시 딱 한번만 실행되는 코드 영역
	static {
		try {
			// config 파일 경로
			String resource = "kr/bit/mybatis/config.xml";

			// config 파일 읽기
			InputStream inputStream = Resources.getResourceAsStream(resource);

			// 커넥션 풀 만들기
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
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
	
	//파일 업로드 회원가입
	public int memberInsertFile(MemberVO vo) {
		//SqlSession 생성
		SqlSession session = sqlSessionFactory.openSession();
		
		//sql 결과값 저장, insert("sql id값 넣기", 값)
		int cnt = session.insert("memberInsertFile", vo);
		
		//sql 적용
		session.commit();
		
		//sqlSession 반납
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
	
	//로그인
	public String memberLogin(MemberVO vo) {
		//SqlSession 생성
		SqlSession session = sqlSessionFactory.openSession();
		
		//sql 결과값 저장, selectOne("sql id값 넣기", 값)
		String name = session.selectOne("memberLogin", vo);
		
		//SqlSession 반납
		session.close();
		
		return name;
	}

	public String memberDbCheck(String id) {
		//SqlSession 생성
		SqlSession session = sqlSessionFactory.openSession();
		
		//sql 결과값 저장, selectOne("sql id값 넣기", 값)
		String checkId = session.selectOne("memberDbCheck", id);		
		
		//SqlSession 반납
		session.close();
		
		String checkMsg="NO";
		if(checkId !=null) {
			checkMsg = "YES";
		}
		
		return checkMsg;
	}
	
	//파일 삭제(update)
	public int memberDeleteFile(int num) {
		//SqlSession 생성
		SqlSession session = sqlSessionFactory.openSession();
		
		//sql 결과값 저장, update("sql id값 넣기", 값)
		int cnt=session.update("memberDeleteFile", num);
		
		//sql 적용
		session.commit();
		
		//SqlSession 반납
		session.close();
		
		return cnt;
	}
	
	//파일 업데이트
	public int memberUpdateFile(MemberVO vo) {
		//SqlSession 생성
		SqlSession session = sqlSessionFactory.openSession();
		
		//sql 결과값 저장, update("sql id값 넣기", 값)
		int cnt = session.update("memberUpdateFile", vo);
		
		//sql 적용
		session.commit();
		
		//SqlSession 반납
		session.close();
		
		return cnt;
	}
		
}
