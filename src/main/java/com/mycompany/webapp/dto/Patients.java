package com.mycompany.webapp.dto;

import java.util.Date;

public class Patients {
	private int patient_id;
	private String patient_name;
	private String patient_ssn;
	private String patient_sex;
	private String patient_tel;
	private String patient_zipcode;
	private String patient_address;
	private String patient_detailaddress1;
	private String patient_detailaddress2;
	private Date patient_regdate;
	
	
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public String getPatient_ssn() {
		return patient_ssn;
	}
	public void setPatient_ssn(String patient_ssn) {
		this.patient_ssn = patient_ssn;
	}
	public String getPatient_sex() {
		return patient_sex;
	}
	public void setPatient_sex(String patient_sex) {
		this.patient_sex = patient_sex;
	}
	public String getPatient_tel() {
		return patient_tel;
	}
	public void setPatient_tel(String patient_tel) {
		this.patient_tel = patient_tel;
	}
	public String getPatient_zipcode() {
		return patient_zipcode;
	}
	public void setPatient_zipcode(String patient_zipcode) {
		this.patient_zipcode = patient_zipcode;
	}
	public String getPatient_address() {
		return patient_address;
	}
	public void setPatient_address(String patient_address) {
		this.patient_address = patient_address;
	}
	public String getPatient_detailaddress1() {
		return patient_detailaddress1;
	}
	public void setPatient_detailaddress1(String patient_detailaddress1) {
		this.patient_detailaddress1 = patient_detailaddress1;
	}
	public String getPatient_detailaddress2() {
		return patient_detailaddress2;
	}
	public void setPatient_detailaddress2(String patient_detailaddress2) {
		this.patient_detailaddress2 = patient_detailaddress2;
	}
	public Date getPatient_regdate() {
		return patient_regdate;
	}
	public void setPatient_regdate(Date patient_regdate) {
		this.patient_regdate = patient_regdate;
	}
	
	
	
}