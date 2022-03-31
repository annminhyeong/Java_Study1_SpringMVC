package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcReq.do")
public class CalcReqController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<form action='calcResp.do' method='post'>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<td>수1</td>");
		out.println("<td><input type='text' name='su1'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>수2</td>");
		out.println("<td><input type='text' name='su2'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>");
		out.println("<input type='submit' value='전송'> ");
		out.println("<input type='reset' value='취소'>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
		
	}

}
