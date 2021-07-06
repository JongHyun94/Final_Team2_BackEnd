package com.mycompany.webapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.DrugsInjectionsListsDao;
import com.mycompany.webapp.dto.DrugsInjectionsLists;


@Service
public class DrugsInjectionsListsService {
	private static final Logger logger = LoggerFactory.getLogger(DrugsInjectionsListsService.class);
	
	@Autowired
	private DrugsInjectionsListsDao drugsInjectionsListsDao;
	
	public List<DrugsInjectionsLists> getDrug(String keyword) {
		logger.info("asddsdddaaaaa"+keyword);
		List<DrugsInjectionsLists> list = drugsInjectionsListsDao.selectByDruglist(keyword);
//		logger.info("aaaaaaaaa"+list.get(1).getDrug_injection_list_category());
		return list;
	}

}
