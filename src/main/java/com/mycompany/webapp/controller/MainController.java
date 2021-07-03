package com.mycompany.webapp.controller;

import java.sql.Connection;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	/*
	 * @GetMapping("/test") public String test(){ String user =
	 * 
	 * return user; }
	 */
	
	
	
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
