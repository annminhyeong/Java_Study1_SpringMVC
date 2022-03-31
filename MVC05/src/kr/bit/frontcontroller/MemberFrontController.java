package kr.bit.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.controller.Controller;



@WebServlet("*.do")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//클라이언트가 어떤 요청을 했는지 파악하기
		String url =request.getRequestURI();
		String ctx = request.getContextPath();
		
		//실제로 요청한 명령
		String commend = url.substring(ctx.length());
		System.out.println(commend);
		
		Controller controller = null;
		String nextPage = null;
		
		//HandlerMapping 객체 생성
		HandlerMapping  mapping = new HandlerMapping();
		
		//요청한 url를  getController함수에 넣어 해당 url의 Controller 인스턴스 생성
		controller =mapping.getController(commend);
		
		//해당 url의 인스턴스 함수인 requestHandler을 이용해 다음페이지 url 가져오기
		nextPage = controller.requestHandler(request, response);
		System.out.println(nextPage);
		
		//url에 'redirect:'가 있으면  redirect 없으면 forward
		if(nextPage != null) {
			if(nextPage.indexOf("redirect:")!=-1) {
				response.sendRedirect(nextPage.split(":")[1]);
			}else {
				RequestDispatcher rd=request.getRequestDispatcher(ViewResolver.makeView(nextPage));
				rd.forward(request, response);
			}
		}
		
		
	}

}
