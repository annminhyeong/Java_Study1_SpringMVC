package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MyCalc;


@WebServlet("/calcResp.do")
public class CalcRespController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//클라이언트에서 넘어오는 폼 파라미터 받기
		int su1 = Integer.parseInt(request.getParameter("su1"));
		int su2 = Integer.parseInt(request.getParameter("su2"));
		
		
		//비지니스 모델을 Model로 분리(MyCalc.java)
		/*
		int sum =0;
		for (int i = su1; i < su2; i++) {
			sum += i;
		}
		*/
		
		MyCalc mycalc = new MyCalc();
		int sum = mycalc.hap(su1, su2);
		
		//응답하는부분 (View)
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("total: "+sum);
		out.println("</body>");
		out.println("</html>");
		
	
	}

}
