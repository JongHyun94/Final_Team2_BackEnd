package com.mycompany.webapp.dto;

public class Schedules {	
	private int SCHEDULE_ID;
	private String SCHEDULE_USER_ID;
	private String SCHEDULE_CONTENT;
	private String SCHEDULE_STATE;
	private String SCHEDULE_REGDATE;
	
	public int getSCHEDULE_ID() {
		return SCHEDULE_ID;
	}
	public void setSCHEDULE_ID(int sCHEDULE_ID) {
		SCHEDULE_ID = sCHEDULE_ID;
	}
	public String getSCHEDULE_USER_ID() {
		return SCHEDULE_USER_ID;
	}
	public void setSCHEDULE_USER_ID(String sCHEDULE_USER_ID) {
		SCHEDULE_USER_ID = sCHEDULE_USER_ID;
	}
	public String getSCHEDULE_CONTENT() {
		return SCHEDULE_CONTENT;
	}
	public void setSCHEDULE_CONTENT(String sCHEDULE_CONTENT) {
		SCHEDULE_CONTENT = sCHEDULE_CONTENT;
	}
	public String getSCHEDULE_STATE() {
		return SCHEDULE_STATE;
	}
	public void setSCHEDULE_STATE(String sCHEDULE_STATE) {
		SCHEDULE_STATE = sCHEDULE_STATE;
	}
	public String getSCHEDULE_REGDATE() {
		return SCHEDULE_REGDATE;
	}
	public void setSCHEDULE_REGDATE(String sCHEDULE_REGDATE) {
		SCHEDULE_REGDATE = sCHEDULE_REGDATE;
	}
}
