package com.mycompany.webapp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HospitalsDao {

	public int getCount(@Param("hcode") String hcode, @Param("uauth") String uauth);
	public void updateUsercount(@Param("hcode") String hcode, @Param("uauth") String uauth);	
}
