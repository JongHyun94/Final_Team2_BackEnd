package com.mycompany.webapp.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.controller.RegisterController;
import com.mycompany.webapp.dao.PatientsDao;
import com.mycompany.webapp.dao.RegistersDao;
import com.mycompany.webapp.dao.SchedulesDao;
import com.mycompany.webapp.dao.TreatmentsDao;
import com.mycompany.webapp.dao.UsersDao;
import com.mycompany.webapp.dto.Patients;
import com.mycompany.webapp.dto.Registers;
import com.mycompany.webapp.dto.RegistersCountByDate;
import com.mycompany.webapp.dto.Schedules;
import com.mycompany.webapp.dto.Users;

@Service
public class RegistersService {
	@Autowired
	private RegistersDao registersDao;
	@Autowired
	private UsersDao usersDao;
	@Autowired
	private PatientsDao patientsDao;
	@Autowired
	private SchedulesDao schedulesDao;
	@Autowired
	private TreatmentsDao treatmentsDao;
	
	private static final Logger logger = LoggerFactory.getLogger(RegistersService.class);

	public List<Registers> getAllRegisters() {
		List<Registers> registersList = registersDao.selectAllRegisters();
		return registersList;
	}

	public List<Registers> getTodayRegisters(String date_time, String state) {
		List<Registers> registersList = registersDao.selectRegistersByDate(date_time, state);
		return registersList;
	}

	public String createNewRegister(Registers register) {
		logger.info(register.getRegister_state());
		int row = registersDao.checkRegister(register);
		if(row > 0) {
			if(register.getRegister_state().equals("취소")) {
				//int delete = registersDao.deleteRegister(register);
				int result = registersDao.insertNewRegister2(register);
				return "성공";
			} else {
				return "중복";				
			}
		} else {
			int result = registersDao.insertNewRegister(register);
			return "성공";
		}
	}

	public String changeRegister(Registers register) {
		int row = registersDao.checkRegister(register);
		if(row > 0) {
			int count = registersDao.checkSameRegister(register);
			if(count > 0) {
				return "중복";				
			} else {
				int result = registersDao.updateRegister(register);
				return "성공";
			}
		} else {
			int result = registersDao.updateRegister(register);
			return "성공";
		}
	}

	public int changeStateRegister(Registers register) {
		int result = registersDao.updateStateRegister(register);
		return result;
	}

	// 진료 생성
	public int createNewTreatment(Registers register) {
		int result = treatmentsDao.insertNewTreatment(register);
		return result;
	}

	// User ----------------------------------------------------------

	public List<Users> getAllDoctors() {
		List<Users> doctorList = usersDao.selectAllDoctors();
		return doctorList;
	}

	public List<Patients> getAllPatients() {
		List<Patients> patientList = patientsDao.selectAllPatients();
		return patientList;
	}


	// To Do List ----------------------------------------------------------
	public List<Schedules> getToDoList(Schedules schedule) {
		List<Schedules> todolist = schedulesDao.selectToDoList(schedule);
		return todolist;
	}

	public int createNewToDoList(Schedules schedule) {
		int result = schedulesDao.insertNewToDoList(schedule);
		return result;
	}

	public int updateToDoList(Schedules schedule) {
		int result = schedulesDao.updateToDoList(schedule);
		return result;
	}

	public int deleteToDoList(int schedule_id) {
		int result = schedulesDao.deleteToDoList(schedule_id);
		return result;
	}

	public List<RegistersCountByDate> getRegisterByDoctor(String user_id, String date) {
		List<RegistersCountByDate> registerList = registersDao.selectRegisterByDoctor(user_id, date);
		return registerList;
	}
}
