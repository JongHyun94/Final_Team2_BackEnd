package com.mycompany.webapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.UsersDao;
import com.mycompany.webapp.dto.Users;

@Service
public class UsersService {
	
	@Autowired
	private UsersDao usersDao;

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
}
