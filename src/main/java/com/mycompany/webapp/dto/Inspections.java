package com.mycompany.webapp.dto;

import java.util.Date;

public class Inspections {
	private int inspection_id;
	private int inspection_patient_id;
	private String inspection_doctor_id;
	private String inspection_inspector_id;
	private int inspection_treatment_id;
	private int inspection_list_id;
	private String inspection_lab;
	private Date inspection_date;
	private String inspection_result;
	private String inspection_state;
	
	private String inspection_list_name;
	private String inspection_list_category;
	private String inspection_list_reference;
	private String user_name;
	
	public int getInspection_id() {
		return inspection_id;
	}
	
	public void setInspection_id(int inspection_id) {
		this.inspection_id = inspection_id;
	}
	
	public int getInspection_patient_id() {
		return inspection_patient_id;
	}
	
	public void setInspection_patient_id(int inspection_patient_id) {
		this.inspection_patient_id = inspection_patient_id;
	}
	
	public String getInspection_doctor_id() {
		return inspection_doctor_id;
	}
	
	public void setInspection_doctor_id(String inspection_doctor_id) {
		this.inspection_doctor_id = inspection_doctor_id;
	}
	
	public String getInspection_inspector_id() {
		return inspection_inspector_id;
	}
	
	public void setInspection_inspector_id(String inspection_inspector_id) {
		this.inspection_inspector_id = inspection_inspector_id;
	}
	
	public int getInspection_treatment_id() {
		return inspection_treatment_id;
	}
	
	public void setInspection_treatment_id(int inspection_treatment_id) {
		this.inspection_treatment_id = inspection_treatment_id;
	}
	
	public int getInspection_list_id() {
		return inspection_list_id;
	}
	
	public void setInspection_list_id(int inspection_list_id) {
		this.inspection_list_id = inspection_list_id;
	}
	
	public String getInspection_lab() {
		return inspection_lab;
	}
	
	public void setInspection_lab(String inspection_lab) {
		this.inspection_lab = inspection_lab;
	}
	
	public Date getInspection_date() {
		return inspection_date;
	}
	
	public void setInspection_date(Date inspection_date) {
		this.inspection_date = inspection_date;
	}
	
	public String getInspection_result() {
		return inspection_result;
	}
	
	public void setInspection_result(String inspection_result) {
		this.inspection_result = inspection_result;
	}
	
	public String getInspection_state() {
		return inspection_state;
	}
	
	public void setInspection_state(String inspection_state) {
		this.inspection_state = inspection_state;
	}

	public String getInspection_list_name() {
		return inspection_list_name;
	}

	public void setInspection_list_name(String inspection_list_name) {
		this.inspection_list_name = inspection_list_name;
	}

	public String getInspection_list_category() {
		return inspection_list_category;
	}

	public void setInspection_list_category(String inspection_list_category) {
		this.inspection_list_category = inspection_list_category;
	}

	public String getInspection_list_reference() {
		return inspection_list_reference;
	}

	public void setInspection_list_reference(String inspection_list_reference) {
		this.inspection_list_reference = inspection_list_reference;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	
	
}
