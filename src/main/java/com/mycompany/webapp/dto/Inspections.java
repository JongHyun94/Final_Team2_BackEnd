package com.mycompany.webapp.dto;

import java.util.Date;

public class Inspections {
	private int inspectionId;
	private int inspectionPatientId;
	private String inspectionDoctorId;
	private String inspectionInspectorId;
	private int inspectionTreatmentId;
	private int inspectionListId;
	private String inspectionLab;
	private Date inspectionDate;
	private String inspectionResult;
	private String inspectionState;
	
	public int getInspectionId() {
		return inspectionId;
	}
	
	public void setInspectionId(int inspectionId) {
		this.inspectionId = inspectionId;
	}
	
	public int getInspectionPatientId() {
		return inspectionPatientId;
	}
	
	public void setInspectionPatientId(int inspectionPatientId) {
		this.inspectionPatientId = inspectionPatientId;
	}
	
	public String getInspectionDoctorId() {
		return inspectionDoctorId;
	}
	
	public void setInspectionDoctorId(String inspectionDoctorId) {
		this.inspectionDoctorId = inspectionDoctorId;
	}
	
	public String getInspectionInspectorId() {
		return inspectionInspectorId;
	}
	
	public void setInspectionInspectorId(String inspectionInspectorId) {
		this.inspectionInspectorId = inspectionInspectorId;
	}
	
	public int getInspectionTreatmentId() {
		return inspectionTreatmentId;
	}
	
	public void setInspectionTreatmentId(int inspectionTreatmentId) {
		this.inspectionTreatmentId = inspectionTreatmentId;
	}
	
	public int getInspectionListId() {
		return inspectionListId;
	}
	
	public void setInspectionListId(int inspectionListId) {
		this.inspectionListId = inspectionListId;
	}
	
	public String getInspectionLab() {
		return inspectionLab;
	}
	
	public void setInspectionLab(String inspectionLab) {
		this.inspectionLab = inspectionLab;
	}
	
	public Date getInspectionDate() {
		return inspectionDate;
	}
	
	public void setInspectionDate(Date inspectionDate) {
		this.inspectionDate = inspectionDate;
	}
	
	public String getInspectionResult() {
		return inspectionResult;
	}
	
	public void setInspectionResult(String inspectionResult) {
		this.inspectionResult = inspectionResult;
	}
	
	public String getInspectionState() {
		return inspectionState;
	}
	
	public void setInspectionState(String inspectionState) {
		this.inspectionState = inspectionState;
	}

	@Override
	public String toString() {
		return "Inspections [inspectionId=" + inspectionId + ", inspectionPatientId=" + inspectionPatientId
				+ ", inspectionDoctorId=" + inspectionDoctorId + ", inspectionInspectorId=" + inspectionInspectorId
				+ ", inspectionTreatmentId=" + inspectionTreatmentId + ", inspectionListId=" + inspectionListId
				+ ", inspectionLab=" + inspectionLab + ", inspectionDate=" + inspectionDate + ", inspectionResult="
				+ inspectionResult + ", inspectionState=" + inspectionState + "]";
	}
	
}
