package com.mycompany.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.HospitalsDao;

@Service
public class HospitalsService {
	@Autowired
	private HospitalsDao hospitalsDao; 
	
	public int getCount(String hcode, String uauth) {
		int count = hospitalsDao.getCount(hcode, uauth);
		return count;
	}
	
	// 직원 등록 시 index+1
	public void updateUser(String hcode, String uauth) {
		hospitalsDao.updateUser(hcode, uauth);
	}
}
