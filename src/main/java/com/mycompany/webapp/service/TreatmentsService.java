package com.mycompany.webapp.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.controller.TreatmentController;
import com.mycompany.webapp.dao.TreatmentsDao;
import com.mycompany.webapp.dto.Treatments;


@Service
public class TreatmentsService {
	private static final Logger logger = LoggerFactory.getLogger(TreatmentsService.class);
	@Autowired
	private TreatmentsDao treatmentsDao;
	
	public List<Treatments> getAllTreatment() {
		List<Treatments> treatmentslist = treatmentsDao.selectAllTreatment();
		return treatmentslist;
	}
	
	
	/*
	 * public int insert(Treatments treatment) { int result =
	 * treatmentsDao.insert(treatment); return result; }
	 */	
	
	public int update(Map<String, Object> treatment) {
		logger.info("맵맵맵");
		return treatmentsDao.update(treatment);
	}


	public List<Treatments> getHistoryList(int treatment_patient_id) {
		List<Treatments> list = treatmentsDao.selectByPatientId(treatment_patient_id);

		return list;
	}


//	public Treatments getTreatment(int treatment_id) {
//		// TODO Auto-generated method stub
//		return treatmentsDao.selectByTreatment(treatment_id);
//	}


	public List<Treatments> getTreatmentSoap(int treatment_id) {
		List<Treatments> list = treatmentsDao.selectByTreatmentSoap(treatment_id);
		return list;
	}



}
