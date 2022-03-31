package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.bit.model.MemberDAO;

public class MemberDeleteController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//POJO가 해야할일
		int num =Integer.parseInt(request.getParameter("num"));
		
		//1. Model 연동
		MemberDAO dao = new MemberDAO();
		dao.memberDelete(num);
		
		//세션 종료
		HttpSession session = request.getSession();
		session.invalidate();
		//2. 객체 바인딩
		
		//3. 다음페이지 정보
		return "redirect:/memberList.do";
	}

}
