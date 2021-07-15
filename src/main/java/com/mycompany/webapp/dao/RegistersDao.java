package com.mycompany.webapp.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycompany.webapp.dto.Data1;
import com.mycompany.webapp.dto.Data2;
import com.mycompany.webapp.dto.Data3;
import com.mycompany.webapp.dto.Data4;
import com.mycompany.webapp.dto.Registers;

@Mapper
public interface RegistersDao {

	List<Registers> selectAllRegisters();

	List<Registers> selectRegistersByDate(@Param("register_date")String register_date,@Param("state") String state);

	int insertNewRegister(Registers register);
	
	int insertNewRegister2(Registers register);

	int updateRegister(Registers register);

	int updateStateRegister(Registers register);

	int checkRegister(Registers register);
	
	int checkSameRegister(Registers register);
	
	List<Registers> selectThreeMonths();

	List<Data2> selectRegistersState();

	List<Registers> selectPatientsByDays();

	List<Registers> selectQuatersState();

	int deleteRegister(Registers register);

}
