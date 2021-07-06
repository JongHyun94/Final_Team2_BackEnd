package com.mycompany.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.webapp.dto.Patients;

@Mapper
public interface PatientsDao {

	List<Patients> selectAllPatients();


	public List<Patients> selectAllPatient();
	public void updatePatient(Patients patient);
	public void insertPatient(Patients patient);
}
