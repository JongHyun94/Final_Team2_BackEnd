package com.mycompany.webapp.controller;

import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.webapp.dto.Patients;
import com.mycompany.webapp.service.PatientsService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/patient")
public class PatientController {
	private static final Logger logger = LoggerFactory.getLogger(PatientController.class);
	
	@Autowired
	private PatientsService patientsService;
	
	//환자 목록
	@GetMapping("")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		List<Patients> patientList = patientsService.getAllPatients();
		
		logger.info("환자 수: " + patientList.size());
		
		response.setContentType("application/json;charset=UTF-8");
		JSONObject jObj = new JSONObject();
		jObj.put("patientList", patientList);
		try {
			Writer writer = response.getWriter();
			writer.write(jObj.toString());
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		Map<String, Object> map = new HashMap<>();
//		map.put("patients", patientList);
//		
//		return map;
	}
	
	//환자 정보 수정
	@PutMapping("")
	public Patients update(@RequestBody Patients patient) {
		patientsService.updatePatient(patient);
		return patient;
	}
	
	//환자 등록
	@PostMapping("") 
	public Patients create(@RequestBody Patients patient) {
		patientsService.createPatient(patient);
		return patient;
	}
}
