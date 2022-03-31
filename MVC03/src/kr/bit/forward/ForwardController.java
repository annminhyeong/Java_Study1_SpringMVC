package kr.bit.forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberVO;


@WebServlet("/fc.do")
public class ForwardController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name ="forward";
		int age = 23;
		String pass ="12345";
		
		//controller에서 view페이지로 전환하는 방법
		
		//2.forward 기법
		// controller 요청을 받으면 포워딩으로 데이터를 view를 보낸후 다시 결과를 받아 클라이언트에게 전달
		//fc.do로 요청하면 url이 그대로인 이유는: view의 결과를 다시 controller를 통해 전달하기 때문에 바뀌지 않음
		
		MemberVO vo = new MemberVO();
		
		vo.setName(name);
		vo.setAge(age);
		vo.setPass(pass);
		
		//겍체 바인딩
		request.setAttribute("vo", vo);
		
		//객체 바인딩 url 선택
		RequestDispatcher rd=request.getRequestDispatcher("view/fcResult.jsp");
		
		//기존의 있는 request, response를   view에 보냄
		rd.forward(request, response);
		
		
		
		
	}

}
