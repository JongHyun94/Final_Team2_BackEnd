package com.mycompany.webapp.controller;

import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.webapp.dto.Patients;
import com.mycompany.webapp.dto.Registers;
import com.mycompany.webapp.dto.Schedules;
import com.mycompany.webapp.dto.Users;
import com.mycompany.webapp.service.RegistersService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/register")
public class RegisterController {
	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	@Autowired
	private RegistersService registersService;

	@GetMapping("")
	public void getAllRegisters(HttpServletRequest request, HttpServletResponse response, @RequestParam String date){ 
		// 해당 날짜의 접수 내역 불러오기
		List<Registers> registerList = registersService.getTodayRegisters(date);
		response.setContentType("application/json;charset=UTF-8");
		JSONObject jObj = new JSONObject();
		jObj.put("registerList", registerList);
		try {
			Writer writer = response.getWriter();
			writer.write(jObj.toString());
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 의사 목록
	@GetMapping("/doctors")
	public void getAllDoctors(HttpServletRequest request, HttpServletResponse response){ 
		// 모든 의사 불러오기
		List<Users> doctorList = registersService.getAllDoctors();
		response.setContentType("application/json;charset=UTF-8");
		JSONObject jObj = new JSONObject();
		jObj.put("doctorList", doctorList);
		try {
			Writer writer = response.getWriter();
			writer.write(jObj.toString());
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 환자 목록
	@GetMapping("/patients")
	public void getAllPatients(HttpServletRequest request, HttpServletResponse response){ 
		// 모든 의사 불러오기
		List<Patients> patientList = registersService.getAllPatients();
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
	}

	@PostMapping("")
	public void createNewRegister(HttpServletRequest request, HttpServletResponse response, @RequestBody Registers register) {
		
		// 새로운 register 만들기
		registersService.createNewRegister(register);
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
	@GetMapping("/todolists")
	public void getToDoLists(HttpServletRequest request, HttpServletResponse response, @RequestParam String date, @RequestParam String user_id){ 
		// 해당 날짜의 접수 내역 불러오기
		logger.info(date);
		logger.info(user_id);
		Schedules myschedule = new Schedules();
		myschedule.setSchedule_user_id(user_id);
		myschedule.setSchedule_regdate(date);
		List<Schedules> todolist = registersService.getToDoList(myschedule);
		response.setContentType("application/json;charset=UTF-8");
		JSONObject jObj = new JSONObject();
		jObj.put("todolist", todolist);
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
