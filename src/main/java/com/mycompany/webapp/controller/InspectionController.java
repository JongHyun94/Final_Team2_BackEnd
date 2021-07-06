package com.mycompany.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.webapp.dto.Treatments;
import com.mycompany.webapp.service.InspectionsService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/inspection")
public class InspectionController {
	private static final Logger logger = LoggerFactory.getLogger(InspectionController.class);
	
	@Autowired
	private InspectionsService inspectionsService;
	
	@GetMapping("")
	public void readPatient(HttpServletRequest request, HttpServletResponse response, @RequestParam String treatmentDate) {
		List<Treatments> treatmentList = inspectionsService.getPatients(treatmentDate);
		
		response.setContentType("application/json;charset=UTF-8");
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("treatmentList", treatmentList);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.write(jsonObj.toString());
			pw.flush();
			pw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@PostMapping("/istateI")
	public void updateIstateI(HttpServletRequest request, HttpServletResponse response, @RequestParam int treatmentId) {
		boolean result = inspectionsService.istateI(treatmentId);

		if(result) {
			logger.info("istate 검사 변경 성공");
		} else {
			logger.info("istate 검사 변경 실패");
		}
	}
	
	@PostMapping("/istateC")
	public void updateIstateC(HttpServletRequest request, HttpServletResponse response, @RequestParam int treatmentId) {
		boolean result = inspectionsService.istateC(treatmentId);

		if(result) {
			logger.info("istate 완료 변경 성공");
		} else {
			logger.info("istate 완료 변경 실패");
		}
	}
	
	@GetMapping("/inspections")
	public void readPatient(HttpServletRequest request, HttpServletResponse response, @RequestParam int treatmentId) {
		logger.info("" + treatmentId);
		
		/*
		List<Inspections> inspectionList = inspectionsService.getInspections(treatmentId);
		
		response.setContentType("application/json;charset=UTF-8");
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("inspectionList", inspectionList);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.write(jsonObj.toString());
			pw.flush();
			pw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/

	}
	
}
