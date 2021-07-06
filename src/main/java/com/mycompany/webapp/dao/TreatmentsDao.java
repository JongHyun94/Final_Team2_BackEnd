package com.mycompany.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.webapp.dto.Treatments;

@Mapper
public interface TreatmentsDao {

	public List<Treatments> selectTreatments(String treatmentDate);

	public int updateIstateI(int treatmentId);
	
	public int updateIstateC(int treatmentId);

}
