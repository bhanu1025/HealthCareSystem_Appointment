package com.project.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CheckUpSlot {
	private String testSlotId;
	private String testId;
	private LocalDate date;
	private int numOfApp;
	private List<Appointment> apmtList = new ArrayList<>();

	public CheckUpSlot(String testSlotId, String testId, LocalDate date, int numOfApp) {
		super();
		this.testSlotId = testSlotId;
		this.testId = testId;
		this.date = date;
		this.numOfApp = numOfApp;
	}

	public String getTestSlotId() {
		return testSlotId;
	}

	public void setTestSlotId(String testSlotId) {
		this.testSlotId = testSlotId;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getNumOfApp() {
		return numOfApp;
	}

	public void setNumOfApp(int numOfApp) {
		this.numOfApp = numOfApp;
	}

	public List<Appointment> getApmtList() {
		return apmtList;
	}

	public void setApmtList(List<Appointment> apmtList) {
		this.apmtList = apmtList;
	}

	@Override
	public String toString() {
		return "testSlotId=" + testSlotId + "\ntestId=" + testId + "\ndate=" + date + "\nnumOfApp=" + numOfApp
				+ "\napmtList=" + apmtList + "\n-----------------------------------------------------";
	}

}
