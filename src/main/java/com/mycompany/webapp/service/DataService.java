package com.mycompany.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.PatientsDao;
import com.mycompany.webapp.dao.RegistersDao;
import com.mycompany.webapp.dao.TreatmentsDao;
import com.mycompany.webapp.dto.Data1;
import com.mycompany.webapp.dto.Data2;
import com.mycompany.webapp.dto.Data3;
import com.mycompany.webapp.dto.Data4;

@Service
public class DataService {
	
	@Autowired
	private PatientsDao patientsDao;
	@Autowired
	private TreatmentsDao treatmentsDao;
	@Autowired
	private RegistersDao registersDao;
	
	public List<Data1> getData1() {
		List<Data1> data1 = registersDao.selectThreeMonths();
		return data1;
	}
	
	public List<Data2> getData2() {
		List<Data2> data2 = registersDao.selectRegistersState();
		return data2;
	}
	public List<Data3> getData3() {
		List<Data3> data3 = registersDao.selectPatientsByDays();
		return data3;
	}
	public List<Data4> getData4() {
		List<Data4> data4 = registersDao.selectQuatersState();
		return data4;
	}
}
