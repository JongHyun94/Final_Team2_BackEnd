package com.mycompany.webapp.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycompany.webapp.dto.Registers;

@Mapper
public interface RegistersDao {

	List<Registers> selectAllRegisters();

	List<Registers> selectRegistersByDate(@Param("register_date")String register_date,@Param("state") String state);

	int insertNewRegister(Registers register);

	int updateRegister(Registers register);

	int updateStateRegister(Registers register);

}
