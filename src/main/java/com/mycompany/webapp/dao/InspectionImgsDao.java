package com.mycompany.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.webapp.dto.InspectionImgs;


@Mapper
public interface InspectionImgsDao {

	List<InspectionImgs> selectInspectionImgs(int inspectionId);
	
}
