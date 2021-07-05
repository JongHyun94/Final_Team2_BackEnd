package com.mycompany.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycompany.webapp.dto.Users;

@Mapper
public interface UsersDao {

	public List<Users> selectAllUser();
	public List<Users> selectUsers(@Param("keyword") String keyword, @Param("authority") String authority);
	public void updateUser(Users user);
	public void insertUser(Users user);	
}
