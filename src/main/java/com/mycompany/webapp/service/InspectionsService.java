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
	
	@Autowired
	private TreatmentsDao treatmentsDao;
	@Autowired
	private InspectionsDao inspectionsDao;

	public List<Treatments> getPatients(String treatmentDate) {
		List<Treatments> treatmentsList = treatmentsDao.selectTreatments(treatmentDate);
		return treatmentsList;
	}

	public boolean istateI(int treatmentId) {
		try {
			int row = treatmentsDao.updateIstateI(treatmentId);
			if(row != 1) {
				return false;
			}
		} catch(NullPointerException e) {
			return false;
		}
		return true;
	}
	
	public boolean istateC(int treatmentId) {
		try {
			int row = treatmentsDao.updateIstateC(treatmentId);
			if(row != 1) {
				return false;
			}
		} catch(NullPointerException e) {
			return false;
		}
		return true;
	}

	public List<Inspections> getInspections(int treatmentId) {
		List<Inspections> inspectionList = inspectionsDao.selectInspections(treatmentId);
		return inspectionList;
	}

	public List<Inspections> getTreatmentInspection(int treatment_id) {
		List<Inspections> list = inspectionsDao.selectByTreatmentInspection(treatment_id);
		return list;
	}

}
