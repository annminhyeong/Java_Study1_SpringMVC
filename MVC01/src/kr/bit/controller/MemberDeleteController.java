package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;


@WebServlet("/memberDelete.do")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		int cnt =0;
		MemberDAO dao = new MemberDAO();
		
		cnt = dao.memberDelete(num);
		
		if(cnt>0) {
			response.sendRedirect("/MVC01/memberList.do");
		}else {
			throw new ServletException();
		}
		
		
	}
}
