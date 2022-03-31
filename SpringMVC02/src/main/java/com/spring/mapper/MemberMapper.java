package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.model.MemberVO;

@Mapper
public interface MemberMapper {
	
	//회원 리스트 보기
	public List<MemberVO> memberList();
	
	//회원가입
	public int memberInsert(MemberVO vo);
	
	//회원 삭제
	public int memberDelete(int num);
	
	//회원 상세보기
	public MemberVO memberContent(int num);
	
	//회원 수정하기
	public int memberUpdate(MemberVO vo);
}
