package com.fastcampus.ch4.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastcampus.ch4.dao.BoardDao;
import com.fastcampus.ch4.domain.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;

	@Override
	public int getCount() throws Exception {
		// TODO Auto-generated method stub
		return boardDao.count();
	}

	@Override
	public int remove(Integer bno, String writer) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.delete(bno, writer);
	}

	@Override
	public int write(BoardDto boardDto) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.insert(boardDto);
	}

	@Override
	public List<BoardDto> getList() throws Exception {
		// TODO Auto-generated method stub
		return boardDao.selectAll();
	}

	@Override
	public BoardDto read(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.select(bno);
	}

	@Override
	public List<BoardDto> getPage(Map map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modify(BoardDto boardDto) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.update(boardDto);
	}

}
