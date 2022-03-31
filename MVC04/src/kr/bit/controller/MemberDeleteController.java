package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;

public class MemberDeleteController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ctx =request.getContextPath();
		
		//POJO가 해야할일
		int num =Integer.parseInt(request.getParameter("num"));
		
		//1. Model 연동
		MemberDAO dao = new MemberDAO();
		dao.memberDelete(num);
		
		//2. 객체 바인딩
		
		//3. 다음페이지 정보
		return "redirect:"+ctx+"/memberList.do";
	}

}
