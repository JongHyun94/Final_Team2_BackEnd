package com.mycompany.webapp.controller;

import java.util.List;
import java.io.Writer;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.webapp.dto.Users;
import com.mycompany.webapp.service.UsersService;

@CrossOrigin(origins="*")
@RestController
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
//	@Autowired
//	private RedisTemplate<String, String> redisTemplate;
//	
//	@Autowired
//	private MqttTemplate mqttTemplate;
	
	@Autowired
	private UsersService usersService;
	
	
	@Autowired
	private DataSource dataSource;
	
	@RequestMapping("/home")
	public String home() {
		try {
		      Connection conn = (Connection) dataSource.getConnection();
		      System.out.println("성공: " + conn);
		      
		      } catch (Exception ex){
		         System.out.println("실패..!");
		         ex.printStackTrace();
		      }
		
		return "home";
	}
	
//	@GetMapping("/test") 
//	public List<Users> test(){ 
//		List<Users> userList = usersService.getAllUsers();
//		logger.info("userList:");
//		logger.info("" + userList.get(0).getUser_name());
//////		userList.get(0).getUser_name()
////		/*
////		 * for(int i=0; i<userList.size();i++) { System.out.println(userList[i].); }
////		 */
//		return userList;
//	}
//	 
//	
	@GetMapping("/test") 
<<<<<<< HEAD
	   public void test(HttpServletRequest request, HttpServletResponse response){ 
	      List<Users> userList = usersService.getAllUsers();
	      logger.info("userList:");
	      logger.info("" + userList.get(0).getUser_name());
	      String str = userList.get(0).getUser_name();
//	      userList.get(0).getUser_name()
	      /*
	       * for(int i=0; i<userList.size();i++) { System.out.println(userList[i].); }
	       */
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
=======
	public void test(HttpServletRequest request, HttpServletResponse response){ 
		List<Users> userList = usersService.getAllUsers();
		//logger.info("userList:");
		//logger.info("" + userList.get(0).getUser_name());
		String str = userList.get(0).getUser_name();
//		userList.get(0).getUser_name()
		/*
		 * for(int i=0; i<userList.size();i++) { System.out.println(userList[i].); }
		 */
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
	 
	
	
>>>>>>> branch 'develop' of https://github.com/JongHyun94/Final_Team2_BackEnd.git
	
//	@RequestMapping("/sendRedisMessage")
//	public void sendRedisMessage(String topic, String content, HttpServletResponse res) {
//		logger.info("sendMessage");
//		try {
//			redisTemplate.convertAndSend(topic, content);
//		
//			JSONObject json = new JSONObject();
//			json.put("result", "success");
//			res.setContentType("application/json; charset=UTF-8");
//			PrintWriter writer = res.getWriter();
//			writer.write(json.toString());
//			writer.flush();
//			writer.close();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@RequestMapping("/sendMqttMessage")
//	public void sendMqttMessage(String topic, String content, HttpServletResponse res) {
//		logger.info("sendMessage");
//		try {
//			mqttTemplate.sendMessage(topic, content);
//		
//			JSONObject json = new JSONObject();
//			json.put("result", "success");
//			res.setContentType("application/json; charset=UTF-8");
//			PrintWriter writer = res.getWriter();
//			writer.write(json.toString());
//			writer.flush();
//			writer.close();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}	
}
