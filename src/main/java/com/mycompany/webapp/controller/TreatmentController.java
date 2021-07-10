package com.mycompany.webapp.controller;

import java.io.File;

import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.webapp.dto.DrugsInjections;
import com.mycompany.webapp.dto.DrugsInjectionsLists;
import com.mycompany.webapp.dto.InspectionLists;
import com.mycompany.webapp.dto.Inspections;
import com.mycompany.webapp.dto.Patients;
import com.mycompany.webapp.dto.Treatments;
import com.mycompany.webapp.service.TreatmentsService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/treatment")
public class TreatmentController {
	private static final Logger logger = LoggerFactory.getLogger(TreatmentController.class);

	@Autowired
	private TreatmentsService treatmentsService;

	/* 진료대기환자 리스트 */
	@GetMapping("/treatmentlist") 
	public void list(HttpServletRequest request, HttpServletResponse response, @RequestParam String date){ 

		// 해당 날짜의 접수 내역 불러오기
		List<Treatments> treatmentlist = treatmentsService.getAllTreatment(date);

//		logger.info("" + treatmentlist.get(0).getTreatment_omemo());
//		logger.info("" + treatmentlist.get(1).getTreatment_amemo());
		
		for(int i = 0; i< treatmentlist.size(); i++) {
			treatmentlist.get(i).setPatient_ssn(treatmentlist.get(i).getPatient_ssn().split("-")[0]);
		}
		
		  response.setContentType("application/json;charset=UTF-8");
		
	      JSONObject jObj = new JSONObject();
	      jObj.put("treatmentlist", treatmentlist);
	      try {
	         Writer writer = response.getWriter();
	         writer.write(jObj.toString());
	         writer.flush();
	         writer.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		
	}
	
	/* 약/주사 키워드 검색 */
	@GetMapping("/keyword")
	public void searchDrug(@RequestParam(defaultValue = "") String keyword, HttpServletRequest request,
			HttpServletResponse response) {
//		logger.info("qtqtqt"+keyword);
		List<DrugsInjectionsLists> druglist = treatmentsService.getDrug(keyword);
		response.setContentType("application/json;charset=UTF-8");
		JSONObject jObj = new JSONObject();
		jObj.put("druglist", druglist);
		try {
			Writer writer = response.getWriter();
			writer.write(jObj.toString());
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* 진단 검사별 검사 리스트 */
	@GetMapping("/categoryValue")
	public void categoryInspectionList(@RequestParam String categoryValue,
			HttpServletRequest request, HttpServletResponse response) {
		List<InspectionLists> inspectionList = treatmentsService.getInspection(categoryValue);
		response.setContentType("application/json;charset=UTF-8");
		JSONObject jObj = new JSONObject();
		jObj.put("inspectionList", inspectionList);
		try {
			Writer writer = response.getWriter();
			writer.write(jObj.toString());
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* 환자 번호 별 진료 기록리스트 */
	@GetMapping("/historyList")
	public void read(@RequestParam int treatment_patient_id, HttpServletRequest request, HttpServletResponse response) {
		List<Treatments> historylist = treatmentsService.getHistoryList(treatment_patient_id);
		response.setContentType("application/json;charset=UTF-8");
		JSONObject jObj = new JSONObject();
		jObj.put("historylist", historylist);
		try {
			Writer writer = response.getWriter();
			writer.write(jObj.toString());
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/* 진료 번호 별 진료 상세 보기 (soap, 검사기록, 약처방기록) */
	@GetMapping("/historyRead")
	public void historyread(@RequestParam int treatment_id, HttpServletRequest request, HttpServletResponse response) {
		List<Treatments> treatmentSoaplist = treatmentsService.getTreatmentSoap(treatment_id);
		List<Inspections> treatmentInspectionlist = treatmentsService.getTreatmentInspection(treatment_id);
		List<DrugsInjections> treatmentDrugsInjectionlist = treatmentsService.getTreatmentDrugsInjection(treatment_id);

		response.setContentType("application/json;charset=UTF-8");
		JSONObject jObj = new JSONObject();
		jObj.put("treatmentSoaplist", treatmentSoaplist);
		jObj.put("treatmentInspectionlist", treatmentInspectionlist);
		jObj.put("treatmentDrugsInjectionlist", treatmentDrugsInjectionlist);
		try {
			Writer writer = response.getWriter();
			writer.write(jObj.toString());
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PutMapping("")
	public void update(@RequestBody Treatments treatment, HttpServletResponse response) {
		logger.info(""+treatment.getTreatment_id());
		logger.info(""+treatment.getTreatment_register_id());
		logger.info(""+treatment.getTreatment_patient_id());
		logger.info(""+treatment.getTreatment_user_id());
		logger.info(""+treatment.getTreatment_date());
		logger.info(""+treatment.getTreatment_smemo());
		logger.info(""+treatment.getTreatment_omemo());
		logger.info(""+treatment.getTreatment_amemo());
		logger.info(""+treatment.getTreatment_pmemo());
		logger.info(""+treatment.getTreatment_communication());
		logger.info(""+treatment.getTreatment_state());
		logger.info(""+treatment.getTreatment_istate());
		logger.info(""+treatment.getTreatment_type());
		
		int result = treatmentsService.update(treatment);
		
		response.setContentType("application/json;charset=UTF-8");
		JSONObject jObj = new JSONObject();
		jObj.put("result", result);
		try {
			Writer writer = response.getWriter();
			writer.write(jObj.toString());
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PostMapping("/drugsInjections") 
	public void createDrugsInjections(HttpServletRequest request, HttpServletResponse response, @RequestBody String[] selectedDrug) {
		logger.info("cccccccccccc");
		//String[] selectedDrug = request.getParameterValues("selectedDrug[]");
		logger.info(""+ selectedDrug[0]);
		//treatmentsService.createDrugsInjections(drugsInjections);
		//logger.info("bbbbbbbbbbbbbbb"+drugsInjections);
		response.setContentType("application/json;charset=UTF-8");
		JSONObject jObj = new JSONObject();
		jObj.put("result", "success");
		try {
			Writer writer = response.getWriter();
			writer.write(jObj.toString());
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@PostMapping("/inspections")
	public Inspections createInspections(HttpServletRequest request, HttpServletResponse respons, @RequestBody Inspections inspections) {
		
		inspections.setInspection_inspector_id("I138010001");
		inspections.setInspection_lab("혈액검사실1");
		inspections.setInspection_state("대기");	
		inspections.setInspection_result("");
		treatmentsService.createInspections(inspections);
		
		return inspections;
	}
	


}
