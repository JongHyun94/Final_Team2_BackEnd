package com.mycompany.webapp.controller;

import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.webapp.dto.Users;
import com.mycompany.webapp.service.UsersService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/auth")
public class AuthController {
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	private UsersService usersService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@PostMapping("/login")
	//{"uid":"user1", "upassword":"12345"}
	
	public Map<String, String> login(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, String> user) {
		//인증 데이터 얻기
		String uid = user.get("userId");
		String upassword = user.get("userPassword");
		logger.info(uid);
		logger.info(upassword);
		
		Users dbUser = usersService.getUser(uid);		
		if (dbUser == null) {
			logger.info("notFindID");
		} else {
			BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
			boolean result = bpe.matches(upassword, dbUser.getUser_password());
			if (result) {
				logger.info("success");
			} else {
				logger.info("notCorrectPW");
			}
		}
				
		//사용자 인증
	    UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(uid, upassword);			
		Authentication 	authentication = authenticationManager.authenticate(upat);
		
		//Spring Security에 인증 객체 등록
		SecurityContextHolder.getContext().setAuthentication(authentication);
		//JWT 생성
		String jwt = com.mycompany.webapp.security.JwtUtil.createToken(uid);
		
		//JSON 응답 보내기
		Map<String, String> map = new HashMap<String, String>();
		map.put("uid", uid);
		map.put("authToken", jwt);
				
		return map;
		
//		response.setContentType("application/json;charset=UTF-8");
//		JSONObject jObj = new JSONObject();
//		jObj.put("user", uid);
//		try {
//			Writer writer = response.getWriter();
//			writer.write(jObj.toString());
//			writer.flush();
//			writer.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}	
}
