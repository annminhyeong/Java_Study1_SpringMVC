package kr.web.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import kr.web.util.MyUtil;

//servlet 매핑 2번째 방법
//web.xml 매핑 1번째 방법 대신 사용
@WebServlet("/hs2.do")
public class HelloServletMapping extends HttpServlet {
	
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
