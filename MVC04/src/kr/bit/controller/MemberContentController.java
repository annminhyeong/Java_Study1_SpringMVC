package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

public class MemberContentController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//POJO가 해야할일
		int num =Integer.parseInt(request.getParameter("num"));
		
		//1. Model 연동
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
		vo =dao.memberContent(num);
		
		//2. 객체 바인딩
		request.setAttribute("vo", vo);
		
		//3. 다음페이지 정보
		return "memberContent";
	}

}



