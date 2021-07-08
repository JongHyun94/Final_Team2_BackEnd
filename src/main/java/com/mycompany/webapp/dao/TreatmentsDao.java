package com.mycompany.webapp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.webapp.dto.Registers;
import com.mycompany.webapp.dto.Treatments;


@Mapper
public interface TreatmentsDao {
	
	public List<Treatments> selectAllTreatment();
	
	/* public int insert(Treatments treatment); */
	
	public int update(Treatments treatment);

	public List<Treatments> selectByPatientId(int treatment_patient_id);

	public List<Treatments> selectByTreatmentSoap(int treatment_id);

//	public Treatments selectByTreatment(int treatment_id);
	
	public List<Treatments> selectTreatments(String treatmentDate);

	public int updateIstateI(int treatmentId);
	
	public int updateIstateC(int treatmentId);

	//진료 시작시 생성되는 함수
	public int insertNewTreatment(Registers register);
	
}
