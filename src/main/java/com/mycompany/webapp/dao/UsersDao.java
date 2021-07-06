package com.mycompany.webapp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycompany.webapp.dto.Users;

@Mapper
public interface UsersDao {

	public List<Users> selectAllUser();
<<<<<<< HEAD

	public List<Users> selectAllDoctors();
	
=======
	public List<Users> selectUsers(@Param("keyword") String keyword, @Param("authority") String authority);
	public void updateUser(Users user);
	public void insertUser(Users user);	
>>>>>>> branch 'develop' of https://github.com/JongHyun94/Final_Team2_BackEnd
}
