package com.mycompany.webapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mycompany.webapp.dao.InspectionListsDao;
import com.mycompany.webapp.dto.InspectionLists;

@Service
public class InspectionsListsService {
	private static final Logger logger = LoggerFactory.getLogger(InspectionsListsService.class);
	@Autowired
	private InspectionListsDao inspectionListsDao;
	
	public List<InspectionLists> getInspection(String categoryValue) {
		logger.info("서비스 카테고리"+categoryValue);
		List<InspectionLists> list = inspectionListsDao.selectByInspectionlist(categoryValue);
		logger.info("서비스 리스트"+list);
		return list;
	}

}
