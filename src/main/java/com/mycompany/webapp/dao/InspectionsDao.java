package com.mycompany.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycompany.webapp.dto.Inspections;

@Mapper
public interface InspectionsDao {

	List<Inspections> selectByTreatmentInspection(int treatment_id);
	List<Inspections> selectInspections(int treatmentId);
	int updateState(@Param("inspectionId") int inspectionId, @Param("state") String state);
	int updateResult(@Param("inspectionId") int inspectionId, @Param("inspectionResult") String inspectionResult);
}
