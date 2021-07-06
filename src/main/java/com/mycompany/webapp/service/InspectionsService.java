package com.mycompany.webapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.InspectionsDao;
import com.mycompany.webapp.dto.Inspections;

@Service
public class InspectionsService {

	private static final Logger logger = LoggerFactory.getLogger(InspectionsService.class);
	@Autowired
	private InspectionsDao inspectionsDao;
	
	public List<Inspections> getTreatmentInspection(int treatment_id) {
		List<Inspections> list = inspectionsDao.selectByTreatmentInspection(treatment_id);
		return list;
	}

}
