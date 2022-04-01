package com.spring.service;

import java.util.List;

import com.spring.model.BoardVO;

public interface BoardService {
	//게시판 리스트
	public List<BoardVO> getList();
	
	//게시판 등록
	public void register(BoardVO vo);
	
	//게시판 상세보기
	public BoardVO get(int bno, String mode);
	
	//게시판 삭제
	public int remove(int bno);
	
	//게시판 수정
	public int modify(BoardVO vo);
	
	//게시판 조회수
	public int count(int bno);
}
