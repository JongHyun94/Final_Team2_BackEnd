package com.mycompany.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.webapp.dto.Inspections;

@Mapper
public interface InspectionsDao {

	List<Inspections> selectInspections(int treatmentId);

}
