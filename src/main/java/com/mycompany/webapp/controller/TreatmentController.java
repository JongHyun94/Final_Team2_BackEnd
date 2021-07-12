package com.mycompany.webapp.controller;

import java.io.File;

import java.io.Writer;
import java.util.ArrayList;
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
import com.mycompany.webapp.dto.Users;
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
	public void list(HttpServletRequest request, HttpServletResponse response,
			@RequestParam String date, @RequestParam(defaultValue = "") String state){ 

		// 해당 날짜의 접수 내역 불러오기
		List<Treatments> treatmentlist = treatmentsService.getAllTreatment(date, state);

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
	public void update(@RequestBody Treatments treatment,HttpServletResponse response) {

	
		logger.info("의사임: " +treatment.getTreatment_user_id());

		List<Inspections> InspectionList = new ArrayList<Inspections>();
		List<DrugsInjections> DrugInjectionsList = new ArrayList<DrugsInjections>();

		int result1 = treatmentsService.update(treatment);
		logger.info("카테고리 뭐냐: "+treatment.getInspectionOption());
		/* 검사 */
		int Inspection_id = 0;

		List<Users> userid = treatmentsService.getInspectorId();
		
		logger.info("userlist:::"+userid);
		
		for(int i=0; i<treatment.getSelectedInspection().length;i++) {
			Inspections newInspection = new Inspections();
			newInspection.setInspection_patient_id(treatment.getTreatment_patient_id());
			newInspection.setInspection_doctor_id(treatment.getTreatment_user_id());
			newInspection.setInspection_treatment_id(treatment.getTreatment_id());
			newInspection.setInspection_state("대기");
			newInspection.setInspection_result("");
//			newInspection.setInspection_inspector_id();
//			user_id = treatmentsService.getInspectorId(hcode, uauth);
//			logger.info("user_id 뭐시당가?"+user_id);
			
			newInspection.setInspection_inspector_id("I138010001");
			newInspection.setInspection_list_category(treatment.getInspectionOption());
//			newInspection.setInspection_lab("혈액검사실88");
//			newInspection.setInspection_lab("영상검사실88");
//			newInspection.setInspection_lab("");
//			newInspection.setInspection_list_category(treatment.get);
//			logger.info(""+newInspection.setInspection_list_category(treatment.getSelectedInspection()[i]));
			logger.info("treatment.getSelectedInspection()[i] : "+treatment.getSelectedInspection()[i]);
			Inspection_id = Integer.parseInt(treatment.getSelectedInspection()[i]);
			logger.info("Inspection_id : "+Inspection_id);
			
			newInspection.setInspection_inspection_list_id(Inspection_id);
			InspectionList.add(newInspection);
			logger.info("InspectionList.get(i).getInspection_inspection_list_id(): "+InspectionList.get(i).getInspection_inspection_list_id());
		}
		int result2 = treatmentsService.createInspections(InspectionList);

		/* 처방 */
		for(int i=0; i<treatment.getSelectedDrug().length;i++) {
			DrugsInjections newDrugInjections = new DrugsInjections();
			String Druglist_id = treatment.getSelectedDrug()[i];
			newDrugInjections.setDrug_injection_drug_injection_list_id(Druglist_id);
			newDrugInjections.setDrug_injection_patient_id(treatment.getTreatment_patient_id());
			newDrugInjections.setDrug_injection_id_doctor_id(treatment.getTreatment_user_id());
			newDrugInjections.setDrug_injection_treatment_id(treatment.getTreatment_id());
			DrugInjectionsList.add(newDrugInjections);

		}
		int result3 = treatmentsService.createDrugsInjections(DrugInjectionsList);

		response.setContentType("application/json;charset=UTF-8");
		JSONObject jObj = new JSONObject();
		jObj.put("result1", result1);
		jObj.put("result2", result2);
		jObj.put("result3", result3);
		try {
			Writer writer = response.getWriter();
			writer.write(jObj.toString());
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
