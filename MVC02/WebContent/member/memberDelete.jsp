<%@page import="kr.bit.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	int cnt =0;
	MemberDAO dao = new MemberDAO();
	
	cnt = dao.memberDelete(num);
	
	if(cnt>0) {
		response.sendRedirect("memberList.jsp");
	}else {
		throw new ServletException();
	}
	
%>