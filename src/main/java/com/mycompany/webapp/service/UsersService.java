package com.mycompany.webapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.HospitalsDao;
import com.mycompany.webapp.dao.UsersDao;
import com.mycompany.webapp.dto.Users;

@Service
public class UsersService {
	
	@Autowired
	private UsersDao usersDao;
	@Autowired
	private HospitalsDao hospitalsDao; 

	public List<Users> getAllUsers() {
		List<Users> usersList = usersDao.selectAllUser();
		return usersList;
	}
	
	public List<Users> getUsers(String keyword, String authority) {
		List<Users> usersList = usersDao.selectUsers(keyword, authority);
		return usersList;
	}

	public void updateUser(Users user) {
		usersDao.updateUser(user);		
	}

	public void createUser(Users user) {
		usersDao.insertUser(user);
	}	
	

	
	public int getCount(String hcode, String uauth) {
		int count = hospitalsDao.getCount(hcode, uauth);
		return count;
	}
	
	// 직원 등록 시 index+1
	public void updateUser(String hcode, String uauth) {
		hospitalsDao.updateUser(hcode, uauth);
	}
}
