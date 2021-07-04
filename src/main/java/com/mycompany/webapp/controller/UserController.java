package com.mycompany.webapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.webapp.dto.Users;
import com.mycompany.webapp.service.UsersService;

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
	public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response) {
		List<Users> userList = usersService.getAllUsers();
		
		for (int i = 0; i < userList.size(); i++) {
			logger.info(userList.get(i).getUser_id());
		}
		
		logger.info("" + userList.size());
		
		Map<String, Object> map = new HashMap<>();
		map.put("users", userList);
		
		return map;
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
