package com.mycompany.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.InspectionImgsDao;
import com.mycompany.webapp.dao.InspectionsDao;
import com.mycompany.webapp.dao.TreatmentsDao;
import com.mycompany.webapp.dto.InspectionImgs;
import com.mycompany.webapp.dto.Inspections;
import com.mycompany.webapp.dto.Treatments;

@Service
public class InspectionsService {
	
	@Autowired
	private TreatmentsDao treatmentsDao;
	@Autowired
	private InspectionsDao inspectionsDao;
	@Autowired
	private InspectionImgsDao inspectionImgsDao;
	

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

	public boolean state(int inspectionId, String state) {
		try {
			int row = inspectionsDao.updateState(inspectionId, state);
			if(row != 1) {
				return false;
			}
		} catch(NullPointerException e) {
			return false;
		}
		return true;
	}

	public boolean result(int inspectionId, String inspectionResult) {
		try {
			int row = inspectionsDao.updateResult(inspectionId, inspectionResult);
			if(row != 1) {
				return false;
			}
		} catch(NullPointerException e) {
			return false;
		}
		return true;
	}

	public List<InspectionImgs> getInspectionImg(int inspectionId) {
		List<InspectionImgs> inspectionImgList = inspectionImgsDao.selectInspectionImgs(inspectionId);
		
		for(InspectionImgs inspectionImg : inspectionImgList) {
			inspectionImg.setInspection_img_path("/resources/img/" + inspectionImg.getInspection_img_sname() + inspectionImg.getInspection_img_type());
		}
		
		return inspectionImgList;
	}



}
