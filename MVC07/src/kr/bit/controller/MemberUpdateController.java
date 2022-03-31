package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

public class MemberUpdateController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mode = request.getParameter("mode");
		int num = Integer.parseInt(request.getParameter("num"));
		int age = Integer.parseInt(request.getParameter("age"));
		String email =request.getParameter("email");
		String phone =request.getParameter("phone");
		
		System.out.println("num:"+num);
		
		
		MemberVO vo = new MemberVO();
		
		if(mode.equals("fupdate")) {
			String filename = request.getParameter("filename");
			System.out.println("filename:"+filename);
			vo.setNum(num);
			vo.setAge(age);
			vo.setEmail(email);
			vo.setPhone(phone);
			vo.setFilename(filename);
			
			MemberDAO dao = new MemberDAO();
			dao.memberUpdateFile(vo);

		}else {
			vo.setNum(num);
			vo.setAge(age);
			vo.setEmail(email);
			vo.setPhone(phone);
			
			MemberDAO dao = new MemberDAO();
			dao.memberUpdate(vo);
		}



		return "redirect:/memberContent.do?num="+num;
	}

}
