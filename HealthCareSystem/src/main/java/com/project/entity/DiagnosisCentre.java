package com.project.entity;

import java.util.List;

public class DiagnosisCentre {
	private String centreId;
	private String centreName;
	private List<CheckUp> cupList;

	public DiagnosisCentre(String centerId, String centerName, List<CheckUp> cupList) {
		super();
		this.centreId = centerId;
		this.centreName = centerName;
		this.cupList = cupList;
	}

	public String getCenterId() {
		return centreId;
	}

	public void setCenterId(String centerId) {
		this.centreId = centerId;
	}

	public String getCenterName() {
		return centreName;
	}

	public void setCenterName(String centerName) {
		this.centreName = centerName;
	}

	public List<CheckUp> getCupList() {
		return cupList;
	}

	public void setCupList(List<CheckUp> cupList) {
		this.cupList = cupList;
	}

}
