package kr.web.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import kr.web.util.MyUtil;

public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//1~100까지 합
		MyUtil myutill = new MyUtil();
		int sum= myutill.hap();
		
		//요청한 클라이언트에게 응답하기
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println(sum);
		out.println("</body>");
		out.println("</html>");
		
	}
}
