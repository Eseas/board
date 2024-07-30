package com.fastcampus.ch4.dao;

import java.util.List;

import com.fastcampus.ch4.domain.BoardDto;

public interface BoardDao {
	
	// count
	int count();
	
	// select, selectAll, insert, delete, deleteAll, update
	BoardDto select(Integer bno);
	List<BoardDto> selectAll();
	int insert(BoardDto boardDto);
	int delete(Integer bno);
	int deleteAll();
	int update(BoardDto boardDto);
	
	// increaseViewCnt
	int increaseViewCnt(Integer bno);
}