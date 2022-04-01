package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.BoardMapper;
import com.spring.model.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper; // DI 의존성 주입
	
	//게시판 리스트
	@Override
	public List<BoardVO> getList() {
		return mapper.getList();
	}
	
	//게시판 등록
	@Override
	public void register(BoardVO vo) {
		mapper.insert(vo);
	}
	
	//게시판 상세보기
	@Override
	public BoardVO get(int bno, String mode) {
		
		if(mode.equals("get")) {
			mapper.count(bno);
		}
		return mapper.read(bno);
	}
	
	//게시판 삭제
	@Override
	public int remove(int bno) {
		return mapper.delete(bno);
	}
	
	//게시판 수정
	@Override
	public int modify(BoardVO vo) {
		return mapper.update(vo);
	}

	@Override
	public int count(int bno) {
		return 0;
	}
}
