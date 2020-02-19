package com.project.entity;

import java.util.List;

/*********************************************************************************************
 * @author Bhanu Prakash Kavuri
 * Class: DiagnosisCentre
 *********************************************************************************************/

public class DiagnosisCentre {
	private String centreId;
	private String centreName;
	private List<CheckUp> cupList;

	/*****************************************************************************************
	 * Method: Constructor method - DiagnosisCentre
	 * @param centerId
	 * @param centerName
	 * @param cupList
	 *****************************************************************************************/
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
