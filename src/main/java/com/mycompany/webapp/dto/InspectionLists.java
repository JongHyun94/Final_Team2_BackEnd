package com.mycompany.webapp.dto;

public class InspectionLists {
	private int inspectionListId;
	private String inspectionListCategory;
	private String inspectionListName;
	private String inspectionListContainer;
	private String inspectionListReference;
	
	public int getInspectionListId() {
		return inspectionListId;
	}
	
	public void setInspectionListId(int inspectionListId) {
		this.inspectionListId = inspectionListId;
	}
	
	public String getInspectionListCategory() {
		return inspectionListCategory;
	}
	
	public void setInspectionListCategory(String inspectionListCategory) {
		this.inspectionListCategory = inspectionListCategory;
	}
	
	public String getInspectionListName() {
		return inspectionListName;
	}
	
	public void setInspectionListName(String inspectionListName) {
		this.inspectionListName = inspectionListName;
	}
	
	public String getInspectionListContainer() {
		return inspectionListContainer;
	}
	
	public void setInspectionListContainer(String inspectionListContainer) {
		this.inspectionListContainer = inspectionListContainer;
	}
	
	public String getInspectionListReference() {
		return inspectionListReference;
	}
	
	public void setInspectionListReference(String inspectionListReference) {
		this.inspectionListReference = inspectionListReference;
	}

	@Override
	public String toString() {
		return "InspectionLists [inspectionListId=" + inspectionListId + ", inspectionListCategory="
				+ inspectionListCategory + ", inspectionListName=" + inspectionListName + ", inspectionListContainer="
				+ inspectionListContainer + ", inspectionListReference=" + inspectionListReference + "]";
	}
	
	
}
