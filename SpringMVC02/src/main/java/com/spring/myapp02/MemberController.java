package com.spring.myapp02;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.model.MemberDAO;
import com.spring.model.MemberVO;

// @ -> 어노테이션(전처리) -> Spring Container에서 관리해준다.
@Controller
public class MemberController {
	
	@Autowired
	private MemberDAO dao;
	
	//상세보기
	@RequestMapping("/memberContent.do") //파라미터 받을때 파라미터 이름 같게 하면 그냥 바로 받을 수 있음
	public String memberContent(int num, Model model)
			throws ServletException, IOException {
		
		MemberVO vo = new MemberVO();
		vo =dao.memberContent(num);

		model.addAttribute("vo", vo);

		return "memberContent";
	}
	
	//탈퇴하기
	@RequestMapping("/memberDelete.do")
	public String memberDelete(@RequestParam("num") int su) //파라미터 받을때 변수명 다르게 하고 싶으면 @RequestParm("파라미터이름") 변수명 식으로 쓸수 있음
			throws ServletException, IOException {
		
		dao.memberDelete(su);

		return "redirect:/memberList.do";
	}
	
	//회원가입 기능
	@RequestMapping("/memberInsert.do")
	public String  memberInsert(MemberVO vo) //파라미터 받을때 파라미터 이름 같게 하면 그냥 바로 받을 수 있음
			throws ServletException, IOException {
	
		dao.memberInsert(vo);
		
		return "redirect:/memberList.do";
	}
	
	//회원 리스트
	@RequestMapping("/memberList.do")
	public String memberList(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		List<MemberVO> list = dao.memberList();
		
		//겍체 바인딩
		model.addAttribute("list", list);
	
		return "memberList";
	}
	
	//회원가입 페이지
	@RequestMapping("/memberRegister.do")
	public String  memberRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return "memberRegister";
	}
	
	//정보 수정
	@RequestMapping("/memberUpdate.do")
	public String memberUpdate(MemberVO vo)
			throws ServletException, IOException {		
		
		dao.memberUpdate(vo);
		
		return "redirect:/memberList.do";
	}
	
	
	
	
}
