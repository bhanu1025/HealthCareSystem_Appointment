package com.project.entity;

/*********************************************************************************************
 * @author Bhanu Prakash Kavuri
 * Class: Appointment
 *********************************************************************************************/

public class Appointment {
	
	private String apmtId;
	private String userId;
	private long userContactNum;
	private String testId;
	private String centreId;
	private String slotId;
	
	/*****************************************************************************************
	 * Method: Constructor method - Appointment
	 * @param apmtId - appointmnet ID
	 * @param userId
	 * @param userContactNum
	 * @param testId
	 * @param centreId
	 * @param slotId
	 *****************************************************************************************/
	public Appointment(String apmtId, String userId, long userContactNum, String testId, String centreId,
			String slotId) {
		super();
		this.apmtId = apmtId;
		this.userId = userId;
		this.userContactNum = userContactNum;
		this.testId = testId;
		this.centreId = centreId;
		this.slotId = slotId;
	}

	public String getApmtId() {
		return apmtId;
	}

	public void setApmtId(String apmtId) {
		this.apmtId = apmtId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public long getUserContactNum() {
		return userContactNum;
	}

	public void setUserContactNum(long userContactNum) {
		this.userContactNum = userContactNum;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getCentreId() {
		return centreId;
	}

	public void setCentreId(String centreId) {
		this.centreId = centreId;
	}

	public String getSlotId() {
		return slotId;
	}

	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}

	/*****************************************************************************************
	 * Method: This is the overrided constructor method toString()
	 * @return the values of all the variables 
	 *****************************************************************************************/
	@Override
	public String toString() {
		return "apmtId=" + apmtId + ", userId=" + userId + ", userContactNum=" + userContactNum
				+ ", testId=" + testId + ", centreId=" + centreId + ", slotId=" + slotId + "\n        " ;
	}
	
}
