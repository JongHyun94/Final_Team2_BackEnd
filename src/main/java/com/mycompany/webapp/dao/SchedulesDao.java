package com.mycompany.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.webapp.dto.Schedules;

@Mapper
public interface SchedulesDao {

	List<Schedules> selectToDoList(Schedules schedule);
}
