package com.mycompany.webapp.dto;

import java.util.Date;

public class Registers {
	private int register_id;
	private int register_patient_id;
	private Date register_regdate;
	private Date register_date;
	private Date register_starttime;
	private String register_memo;
	private String register_communication;
	private String register_state;
	
	public int getRegister_id() {
		return register_id;
	}
	public void setRegister_id(int register_id) {
		this.register_id = register_id;
	}
	public int getRegister_patient_id() {
		return register_patient_id;
	}
	public void setRegister_patient_id(int register_patient_id) {
		this.register_patient_id = register_patient_id;
	}
	public Date getRegister_regdate() {
		return register_regdate;
	}
	public void setRegister_regdate(Date register_regdate) {
		this.register_regdate = register_regdate;
	}
	public Date getRegister_date() {
		return register_date;
	}
	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}
	public Date getRegister_starttime() {
		return register_starttime;
	}
	public void setRegister_starttime(Date register_starttime) {
		this.register_starttime = register_starttime;
	}
	public String getRegister_memo() {
		return register_memo;
	}
	public void setRegister_memo(String register_memo) {
		this.register_memo = register_memo;
	}
	public String getRegister_communication() {
		return register_communication;
	}
	public void setRegister_communication(String register_communication) {
		this.register_communication = register_communication;
	}
	public String getRegister_state() {
		return register_state;
	}
	public void setRegister_state(String register_state) {
		this.register_state = register_state;
	}
	
}
