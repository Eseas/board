package com.fastcampus.ch4.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fastcampus.ch4.domain.UserDto;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SqlSession session;
	private static String namespace = "com.fastcampus.ch4.dao.UserMapper.";
	
	@Override
	public int count() throws Exception {
		return session.selectOne(namespace + "count");
	}
	
	@Override
	public UserDto select(String id) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + "selectOneUser", id);
	}

	@Override
	public List<UserDto> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + "selectAllUser");
	}

	@Override
	public int insert(UserDto userDto) throws Exception {
		// TODO Auto-generated method stub
		return session.insert(namespace + "insert", userDto);
	}

	@Override
	public int delete(String id) throws Exception {
		// TODO Auto-generated method stub
		return session.delete(namespace + "deleteOneUser", id);
	}

	@Override
	public int deleteAll() throws Exception {
		// TODO Auto-generated method stub
		return session.delete(namespace + "deleteAllUser");
	}

	@Override
	public int update(UserDto userDto) throws Exception {
		// TODO Auto-generated method stub
		return session.update(namespace + "updateUser", userDto);
	}
}
