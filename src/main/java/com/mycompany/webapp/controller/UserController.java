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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.webapp.dto.Users;
import com.mycompany.webapp.service.UsersService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UsersService usersService;
	
	//로그인
//	@PostMapping("/auth/login")
//	public Map<String, String> login(@RequestBody Map<String, String> user) {
//		
//	}
	
	
	//직원 목록
	@GetMapping("")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		List<Users> userList = usersService.getAllUsers();
		
		for (int i = 0; i < userList.size(); i++) {
			userList.get(i).setUser_tel1(userList.get(i).getUser_tel());
			userList.get(i).setUser_tel2(userList.get(i).getUser_tel());
			userList.get(i).setUser_tel3(userList.get(i).getUser_tel());
			userList.get(i).setUser_email1(userList.get(i).getUser_email());
			userList.get(i).setUser_email2(userList.get(i).getUser_email());
			userList.get(i).setUser_ssn1(userList.get(i).getUser_ssn());
			userList.get(i).setUser_ssn2(userList.get(i).getUser_ssn());			
		}
		
		logger.info("" + userList.size());
		
		response.setContentType("application/json;charset=UTF-8");
		JSONObject jObj = new JSONObject();
		jObj.put("userList", userList);
		try {
			Writer writer = response.getWriter();
			writer.write(jObj.toString());
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 검색 및 직책 선택 시 직원 목록
	@GetMapping("/select")
	public void list(HttpServletRequest request, HttpServletResponse response, 
					@RequestParam(defaultValue = "") String keyword,
					@RequestParam(defaultValue = "") String authority) {
		logger.info("keyword: " + keyword);
		logger.info("a:" +  authority);
		List<Users> userList = usersService.getUsers(keyword, authority);
		
		for (int i = 0; i < userList.size(); i++) {
			userList.get(i).setUser_tel1(userList.get(i).getUser_tel());
			userList.get(i).setUser_tel2(userList.get(i).getUser_tel());
			userList.get(i).setUser_tel3(userList.get(i).getUser_tel());
			userList.get(i).setUser_email1(userList.get(i).getUser_email());
			userList.get(i).setUser_email2(userList.get(i).getUser_email());
			userList.get(i).setUser_ssn1(userList.get(i).getUser_ssn());
			userList.get(i).setUser_ssn2(userList.get(i).getUser_ssn());			
		}
		
		logger.info("" + userList.size());
		
		response.setContentType("application/json;charset=UTF-8");
		JSONObject jObj = new JSONObject();
		jObj.put("userList", userList);
		try {
			Writer writer = response.getWriter();
			writer.write(jObj.toString());
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//직원 정보 수정
	@PutMapping("")
	public Users update(@RequestBody Users user) {
		usersService.updateUser(user);
		return user;
	}
	
	//직원 등록
	@PostMapping("")
	public Users create(@RequestBody Users user) {
		usersService.createUser(user);
		return user;
	}
}
