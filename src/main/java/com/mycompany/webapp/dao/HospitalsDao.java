package com.mycompany.webapp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HospitalsDao {

	public int getCount(@Param("hcode") String hcode, @Param("uauth") String uauth);
	public void updateUser(@Param("hcode") String hcode, @Param("uauth") String uauth);	
}
