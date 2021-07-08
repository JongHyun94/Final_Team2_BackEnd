package com.mycompany.webapp.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.webapp.dto.InspectionImgs;
import com.mycompany.webapp.dto.Inspections;
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
	
	@PutMapping("/istateI")
	public void updateIstateI(HttpServletRequest request, HttpServletResponse response, @RequestParam int treatmentId) {
		boolean result = inspectionsService.istateI(treatmentId);

		if(result) {
			logger.info("istate 검사 변경 성공");
		} else {
			logger.info("istate 검사 변경 실패");
		}
	}
	
	@PutMapping("/istateC")
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
	}
	
	@PutMapping("/state")
	public void updateStateI(HttpServletRequest request, HttpServletResponse response, @RequestParam int inspectionId, @RequestParam String state) {
		boolean result = inspectionsService.state(inspectionId, state);

		if(result) {
			logger.info("state 변경 성공");
		} else {
			logger.info("state 변경 실패");
		}
	}
	
	@PutMapping("/result")
	public void updateResult(HttpServletRequest request, HttpServletResponse response, @RequestParam int inspectionId, @RequestParam String inspectionResult) {
		boolean result = inspectionsService.result(inspectionId, inspectionResult);
		
		if(result) {
			logger.info("result 변경 성공");
		} else {
			logger.info("result 변경 실패");
		}
	}
	
	@GetMapping("/images")
	public void readImage(HttpServletRequest request, HttpServletResponse response, @RequestParam int inspectionId) {
		logger.info("" + inspectionId);
		List<InspectionImgs> inspectionImgList = inspectionsService.getInspectionImg(inspectionId);
		logger.info("kk" + inspectionImgList);
		
		response.setContentType("application/json;charset=UTF-8");
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("inspectionImgList", inspectionImgList);
	
		try {
			response.setHeader("Content-Disposition", "attachment; filename=\"" + "xray" + "\";");
			response.setContentType("image/jpeg");
			
//			for(InspectionImgs inspectionImg : inspectionImgList) {
//				InputStream is = new FileInputStream(inspectionImg.getInspection_img_path().toString());
				InputStream is = new FileInputStream("D:/img/xray.jpg");

//				logger.info("" + inspectionImg.getInspection_img_path().toString());
				OutputStream os = response.getOutputStream();
				FileCopyUtils.copy(is, os);
				is.close();
				os.flush();
				os.close();
//			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
//		try {
//			PrintWriter pw = response.getWriter();
//			pw.write(jsonObj.toString());
//			pw.flush();
//			pw.close();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
	}
	
}
