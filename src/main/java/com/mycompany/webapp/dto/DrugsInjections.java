 package com.mycompany.webapp.dto;

import java.util.Date;

public class DrugsInjections {

	private int drug_injection_id;
	private String drug_injection_drug_injection_list_id;
	private int drug_injection_treatment_id;
	private String drug_injection_id_doctor_id;
	private int drug_injection_patient_id;
	private Date drug_injection_regdate;
	
	public int getDrug_injection_id() {
		return drug_injection_id;
	}
	public void setDrug_injection_id(int drug_injection_id) {
		this.drug_injection_id = drug_injection_id;
	}
	public String getDrug_injection_drug_injection_list_id() {
		return drug_injection_drug_injection_list_id;
	}
	public void setDrug_injection_drug_injection_list_id(String drug_injection_drug_injection_list_id) {
		this.drug_injection_drug_injection_list_id = drug_injection_drug_injection_list_id;
	}
	public int getDrug_injection_treatment_id() {
		return drug_injection_treatment_id;
	}
	public void setDrug_injection_treatment_id(int drug_injection_treatment_id) {
		this.drug_injection_treatment_id = drug_injection_treatment_id;
	}
	public String getDrug_injection_id_doctor_id() {
		return drug_injection_id_doctor_id;
	}
	public void setDrug_injection_id_doctor_id(String drug_injection_id_doctor_id) {
		this.drug_injection_id_doctor_id = drug_injection_id_doctor_id;
	}
	public int getDrug_injection_patient_id() {
		return drug_injection_patient_id;
	}
	public void setDrug_injection_patient_id(int drug_injection_patient_id) {
		this.drug_injection_patient_id = drug_injection_patient_id;
	}
	public Date getDrug_injection_regdate() {
		return drug_injection_regdate;
	}
	public void setDrug_injection_regdate(Date drug_injection_regdate) {
		this.drug_injection_regdate = drug_injection_regdate;
	}
	
	
}
