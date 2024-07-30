package com.fastcampus.ch4.dao;

import java.util.List;

import com.fastcampus.ch4.domain.UserDto;

public interface UserDao {
	// count
	int count() throws Exception;
	
	// select, selectAll, insert, delete, deleteAll, update
	UserDto select(String id) throws Exception;
	List<UserDto> selectAll() throws Exception;
	int insert(UserDto userDto) throws Exception;
	int delete(String id) throws Exception;
	int deleteAll() throws Exception;
	int update(UserDto userDto) throws Exception;
}
