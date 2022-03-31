package kr.bit.model;

import java.sql.*;
import java.util.ArrayList;

//지금은 JDBC 사용함(나중에 쓸일이 없음 mybatis나 jpa를 많이 사용)
public class MemberDAO {

	// 커넥션 객체 생성
	private Connection conn;

	// sql 전송 객체 생성
	private PreparedStatement ps;

	// 데이터베이스 데이터를 가져와 저장하는 객체
	private ResultSet rs;

	// 데이터베이스 연결
	public void dbConnect() {
		String url = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "root";
		String password = "1234";

		try {
			// mysql Driver 로딩 (mysql-connector-java-5.1.31에 com.mysql.jdbc.Driver 클래스를 씀)
			Class.forName("com.mysql.jdbc.Driver"); // 동적로딩(실행지점에서 객체를 생성)
			conn = DriverManager.getConnection(url, user, password); // 데이터베이스 접속

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 데이터베이스 연결 끊기
	public void dbClose() {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 회원저장 동작
	public int memberInsert(MemberVO vo) {
		String SQL = "insert into member (id, pass, name, age, email, phone) values(?, ?, ?, ?, ?, ?)";
		dbConnect();
		int cnt = -1;
		try {
			// SQL문장 전송하는 객체 생성
			// 미리 컴파일 시킴(속도가 빠름)
			ps = conn.prepareStatement(SQL);

			// ?값 넣기
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPass());
			ps.setString(3, vo.getName());
			ps.setInt(4, vo.getAge());
			ps.setString(5, vo.getEmail());
			ps.setString(6, vo.getPhone());

			cnt = ps.executeUpdate(); // 실행 (성공 1, 실패 0)

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}

	// 회원리스트가져오기
	public ArrayList<MemberVO> memberList() {
		String SQL = "select * from member";
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		dbConnect();
				
		try {
			ps = conn.prepareStatement(SQL); //미리 컴파일
			
			//실행
			rs =ps.executeQuery(); //커서로 받음
			
			//커서 이동 next() 데이터가 있으면 true 없으면, false
			
			while (rs.next()) {
				int num=rs.getInt("num");
				String id = rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				int age=rs.getInt("age");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				
				MemberVO vo = new MemberVO();
				
				vo.setNum(num);
				vo.setId(id);
				vo.setPass(pass);
				vo.setName(name);
				vo.setAge(age);
				vo.setEmail(email);
				vo.setPhone(phone);
				
				list.add(vo);
				vo =null;
				
			}
			
		} catch (Exception e) {
			
		}finally {
			dbClose();
		}
		return list;
	}

	public int memberDelete(int num) {
		String SQL = "delete from member where num = ?";
		int cnt = 0;
		dbConnect();
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, num);
			cnt = ps.executeUpdate();//성공  1,실패 0
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return cnt;
		
	}

	public MemberVO memberContent(int num) {
		String SQL = "select * from member where num = ?";
		dbConnect();
		MemberVO vo = new MemberVO();
		
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			
			//회원한명이므로 리스트 필요없음
			if(rs.next()) {
				num=rs.getInt("num");
				String id = rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				int age=rs.getInt("age");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				
				vo.setNum(num);
				vo.setId(id);
				vo.setPass(pass);
				vo.setName(name);
				vo.setAge(age);
				vo.setEmail(email);
				vo.setPhone(phone);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return vo;
	}

	public int memberUpate(MemberVO vo) {
		String SQL = "update member set age=?, email=?, phone=? where num=?";
		int cnt = 0;
		dbConnect();
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, vo.getAge());
			ps.setNString(2, vo.getEmail());
			ps.setNString(3, vo.getPhone());
			ps.setInt(4, vo.getNum());
			
			cnt = ps.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return cnt;
				
	}

}
