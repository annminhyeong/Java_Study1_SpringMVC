package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberLogoutController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//세션을 가져옴
		HttpSession session=request.getSession();
		
		//세션을 제거하는 방법
		//1. 강제로
		//2. 브라우저 종료(JSESSIONID 브라우저 쿠키에 저장 )
		//3. 세션이 종료될때까지 기다리기(세션타임아웃 기본: 30분)
		session.invalidate();
		
		return "redirect:/memberList.do";
	}

}
