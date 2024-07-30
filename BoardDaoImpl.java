package com.fastcampus.ch4.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fastcampus.ch4.domain.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	private SqlSession session;
	private static String namespace = "com.fastcampus.ch4.dao.BoardMapper.";
	
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public BoardDto select(Integer bno) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<BoardDto> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int insert(BoardDto boardDto) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int delete(Integer bno) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int update(BoardDto boardDto) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int increaseViewCnt(Integer bno) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
