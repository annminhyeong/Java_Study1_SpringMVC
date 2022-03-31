package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;



@WebServlet("/memberInsert.do")
public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		//클라이언트에서 온 요청을 한글 인코딩하기
		request.setCharacterEncoding("utf-8");
		
		//1. 파라미터 수집
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		//방법1. 만든생성자에  넣기
		//MemberVO vo = new MemberVO(id, pass, name, age, email, phone);
		
		//방법2. setter로 넣기
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPass(pass);
		vo.setName(name);
		vo.setAge(age);
		vo.setEmail(email);
		vo.setPhone(phone);
		
		System.out.println(vo.toString()); // MemberVO에 toString함수 호출
		
		//Model 연결부분
		MemberDAO dao = new MemberDAO();
		int cnt=dao.memberInsert(vo);
		
		//응답 부분
		PrintWriter out=response.getWriter();
		out.print("");//노란줄방지
		
		if(cnt>0) {
			//가입 성공
			response.sendRedirect("/MVC01/memberList.do");
		}else {
			//가입실패 -> 예외객체를 만들어 Was에 던지자
			throw new ServletException("memberInsert 오류");
		}
		
		
		
			

	}

}
