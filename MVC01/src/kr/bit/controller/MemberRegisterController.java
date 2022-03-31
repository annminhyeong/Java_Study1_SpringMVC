package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberRegister.do")
public class MemberRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf8");
		PrintWriter out =response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<p>MVC01</p>");
		out.println("<p>회원가입 화면</p>");
		out.println("<form action='/MVC01/memberInsert.do' method='post'>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<td>아이디</td>");
		out.println("<td><input type='text' name='id'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>비밀번호</td>");
		out.println("<td><input type='text' name='pass'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>이름</td>");
		out.println("<td><input type='text' name='name'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>나이</td>");
		out.println("<td><input type='text' name='age'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>이메일</td>");
		out.println("<td><input type='text' name='email'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>전화번호</td>");
		out.println("<td><input type='text' name='phone'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>");
		out.println("<input type='submit' value='제출'>");
		out.println("<input type='reset' value='취소'>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

}
