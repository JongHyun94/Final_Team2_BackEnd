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
import com.mycompany.webapp.dto.Registers;

@Service
public class DataService {
	
	@Autowired
	private PatientsDao patientsDao;
	@Autowired
	private TreatmentsDao treatmentsDao;
	@Autowired
	private RegistersDao registersDao;
	
	public List<Registers> getData1() {
		List<Registers> registers = registersDao.selectThreeMonths();
		return registers;
	}
	
	public List<Data2> getData2() {
		List<Data2> data2 = registersDao.selectRegistersState();
		return data2;
	}
	public List<Registers> getData3() {
		List<Registers> data3 = registersDao.selectPatientsByDays();
		return data3;
	}
	public List<Registers> getData4() {
		List<Registers> data4 = registersDao.selectQuatersState();
		return data4;
	}
}
