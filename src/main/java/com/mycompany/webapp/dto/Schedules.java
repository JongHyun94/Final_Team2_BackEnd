package com.mycompany.webapp.dto;

public class Schedules {
	
	private int scheduleId;
	private String scheduleUserId;
	private String scheduleContent;
	private String scheduleState;
	private String scheduleRegdate;
	
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	public String getScheduleUserId() {
		return scheduleUserId;
	}
	public void setScheduleUserId(String scheduleUserId) {
		this.scheduleUserId = scheduleUserId;
	}
	public String getScheduleContent() {
		return scheduleContent;
	}
	public void setScheduleContent(String scheduleContent) {
		this.scheduleContent = scheduleContent;
	}
	public String getScheduleState() {
		return scheduleState;
	}
	public void setScheduleState(String scheduleState) {
		this.scheduleState = scheduleState;
	}
	public String getScheduleRegdate() {
		return scheduleRegdate;
	}
	public void setScheduleRegdate(String scheduleRegdate) {
		this.scheduleRegdate = scheduleRegdate;
	}
}
