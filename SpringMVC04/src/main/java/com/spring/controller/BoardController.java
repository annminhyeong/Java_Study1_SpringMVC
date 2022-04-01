package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.model.BoardVO;
import com.spring.service.BoardService;


@Controller
public class BoardController {
	/*
	   /list.do --> GET --> list()
	   /register.do --> POST --> register()
	   /read.do -->  GET --> read()
	   /remove.do --> GET --> remove()
	   /modify.do --> POST --> modify()
	*/
	
	
	@Autowired
	private BoardService service;
	
	//게시판 리스트
	@RequestMapping("/list.do")
	public String list(Model model) {
		List<BoardVO> list = service.getList();
		model.addAttribute("list", list);
		return "boardList"; //boardList.jsp
	}
	//게시판 등록
	@RequestMapping(value = "/register.do", method = RequestMethod.GET)
	//@GetMapping("/register.do")
	public String registerGET() {
		return "register";
	}
	//게시판 등록
	//@PostMapping("/register.do")
	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public String registerPOST(BoardVO vo) {
		service.register(vo);
		return "redirect:/list.do";
	}
	//게시판 상세보기
	@RequestMapping("/read.do")
	public String read(@RequestParam("idx") int bno, Model model) {
		BoardVO vo=service.get(bno, "get");
		model.addAttribute("vo", vo);
		return "read";
	}
	
	
	//게시판 삭제
	@RequestMapping("/remove.do")
	public String remove(@RequestParam("idx") int bno) {
		service.remove(bno);
		return "redirect:/list.do";
	}
	//게시판 수정
	@RequestMapping(value = "/modify.do", method = RequestMethod.GET)
	public String modifyGET(@RequestParam("idx") int bno, Model model) {
		BoardVO vo=service.get(bno, "mode");
		model.addAttribute("vo", vo);
		return "modify";
	}
	
	//게시판 수정
	@RequestMapping(value = "/modify.do", method = RequestMethod.POST)
	public String modifyPOST(BoardVO vo, Model model) {
		service.modify(vo);
		return "redirect:/list.do";
	}
	
	
	
	
	
}
