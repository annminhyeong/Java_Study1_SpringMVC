package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

/**
 * Servlet implementation class MemberContentController
 */
@WebServlet("/memberContent.do")
public class MemberContentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num =Integer.parseInt(request.getParameter("num"));
		MemberDAO dao = new MemberDAO();
		
		MemberVO vo = dao.memberContent(num);
		
		if(vo != null) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			
			out.println("<html>");
			out.println("<head>");  
			out.println("</head>");  
			out.println("<body>");  
			out.println("<p>MVC01</p>");  
			out.println("<form action='/MVC01/memberUpdate.do' name='form1' method='post'>");  
			out.println("<input type='hidden' name='num' value='"+vo.getNum()+"'>");  
			out.println("<table border='1'>");  
			out.println("<tr>");  
			out.println("<td>번호</td>");  
			out.println("<td>"+vo.getNum()+"</td>");
			out.println("</tr>");  
			out.println("<tr>");  
			out.println("<td>아이디</td>");  
			out.println("<td>"+vo.getId()+"</td>");
			out.println("</tr>");  
			out.println("<tr>");  
			out.println("<td>비밀번호</td>");  
			out.println("<td>"+vo.getPass()+"</td>");  
			out.println("</tr>");  
			out.println("<tr>");  
			out.println("<td>이름</td>");  
			out.println("<td>"+vo.getName()+"</td>");
			out.println("</tr>");  
			out.println("<tr>");  
			out.println("<td>나이</td>");  
			out.println("<td><input type='text' name='age' value='"+vo.getAge()+"'></td>");  
			out.println("</tr>");  
			out.println("<tr>");  
			out.println("<td>이메일</td>");  
			out.println("<td><input type='text' name='email' value='"+vo.getEmail()+"'></td>");  
			out.println("</tr>");  
			out.println("<tr>");  
			out.println("<td>전화번호</td>");  
			out.println("<td><input type='text' name='phone' value='"+vo.getPhone()+"'></td>");  
			out.println("</tr>");  
			out.println("<tr>");  
			out.println("<td>");  
			out.println("<input type='submit' value='수정'>");  
			out.println("<input type='reset' value='취소'>");  
			out.println("</td>");  
			out.println("</tr>");  
			out.println("</table>");  
			out.println("</form>");  
			out.println("</body>");  
			out.println("</html>");
			
		}else {
			throw new ServletException();
		}
		
	}

}
