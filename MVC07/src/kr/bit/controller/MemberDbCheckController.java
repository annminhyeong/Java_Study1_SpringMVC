package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;

public class MemberDbCheckController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		MemberDAO dao = new MemberDAO();
		String checkId =dao.memberDbCheck(id);
		
		//$.ajax의 success의 dbCheck 콜백함수의 파라미터에 결과값을 전달
		response.getWriter().print(checkId);
		
		return null;
	}

}
