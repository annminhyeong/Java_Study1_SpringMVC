package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.model.BoardVO;

@Mapper
public interface BoardMapper {
	
	//게시판 리스트
	public List<BoardVO> getList();
	
	//게시판 등록
	public void insert(BoardVO vo);
	
	//게시판 상세보기
	public BoardVO read(int bno);
	
	//게시판 삭제
	public int delete(int bno);
	
	//게시판 수정
	public int update(BoardVO vo);
	
	//게시판 조회수
	public int count(int bno);
	
}
