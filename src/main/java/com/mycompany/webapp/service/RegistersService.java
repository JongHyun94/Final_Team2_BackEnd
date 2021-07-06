package com.mycompany.webapp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.PatientsDao;
import com.mycompany.webapp.dao.RegistersDao;
import com.mycompany.webapp.dao.UsersDao;
import com.mycompany.webapp.dto.Patients;
import com.mycompany.webapp.dto.Registers;
import com.mycompany.webapp.dto.Users;

@Service
public class RegistersService {
	@Autowired
	private RegistersDao registersDao;
	@Autowired
	private UsersDao usersDao;
	@Autowired
	private PatientsDao patientsDao;

	public List<Registers> getAllRegisters() {
		List<Registers> registersList = registersDao.selectAllRegisters();
		return registersList;
	}

	public List<Registers> getTodayRegisters(String date_time) {
		List<Registers> registersList = registersDao.selectRegistersByDate(date_time);
		return registersList;
	}

	public List<Users> getAllDoctors() {
		List<Users> doctorList = usersDao.selectAllDoctors();
		return doctorList;
	}

	public List<Patients> getAllPatients() {
		List<Patients> patientList = patientsDao.selectAllPatients();
		return patientList;
	}

	public void createNewRegister(Registers register) {
		registersDao.insertNewRegister(register);
		
	}
	

}
