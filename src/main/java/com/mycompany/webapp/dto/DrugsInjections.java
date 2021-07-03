 package com.mycompany.webapp.dto;

import java.util.Date;

public class DrugsInjections {

	private int drugInjectionId;
	private String drugInjectionDrugInjectionListId;
	private int drugInjectionTreatmentId;
	private String drugInjectionIdDoctorId;
	private int drugInjectionPatientId;
	private Date drugInjectionRegdate;
	
	public int getDrugInjectionId() {
		return drugInjectionId;
	}
	public void setDrugInjectionId(int drugInjectionId) {
		this.drugInjectionId = drugInjectionId;
	}
	public String getDrugInjectionDrugInjectionListId() {
		return drugInjectionDrugInjectionListId;
	}
	public void setDrugInjectionDrugInjectionListId(String drugInjectionDrugInjectionListId) {
		this.drugInjectionDrugInjectionListId = drugInjectionDrugInjectionListId;
	}
	public int getDrugInjectionTreatmentId() {
		return drugInjectionTreatmentId;
	}
	public void setDrugInjectionTreatmentId(int drugInjectionTreatmentId) {
		this.drugInjectionTreatmentId = drugInjectionTreatmentId;
	}
	public String getDrugInjectionIdDoctorId() {
		return drugInjectionIdDoctorId;
	}
	public void setDrugInjectionIdDoctorId(String drugInjectionIdDoctorId) {
		this.drugInjectionIdDoctorId = drugInjectionIdDoctorId;
	}
	public int getDrugInjectionPatientId() {
		return drugInjectionPatientId;
	}
	public void setDrugInjectionPatientId(int drugInjectionPatientId) {
		this.drugInjectionPatientId = drugInjectionPatientId;
	}
	public Date getDrugInjectionRegdate() {
		return drugInjectionRegdate;
	}
	public void setDrugInjectionRegdate(Date drugInjectionRegdate) {
		this.drugInjectionRegdate = drugInjectionRegdate;
	}
	
	
}
