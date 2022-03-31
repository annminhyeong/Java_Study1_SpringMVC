package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

public class MemberLoginController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPass(pass);
		
		MemberDAO dao = new MemberDAO();
		String name = dao.memberLogin(vo);
		
		if(name !=null && !name.equals("")) {
			HttpSession session=request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			
		}else {
			request.getSession().setAttribute("id", "");
			request.getSession().setAttribute("name", "");
			request.getSession().setAttribute("msg", "로그인 실패");
		}
		return "redirect:/memberList.do";
	}

}
