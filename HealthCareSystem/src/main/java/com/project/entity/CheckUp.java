package com.project.entity;

import java.util.ArrayList;
import java.util.List;

public class CheckUp {
	public String testId;
	public String testName;
	public double amount;
	List<CheckUpSlot> checkUpSlotList = new ArrayList<CheckUpSlot>();

	public CheckUp(String testId, String testName, double amount) {
		super();
		this.testId = testId;
		this.testName = testName;
		this.amount = amount;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public List<CheckUpSlot> getCheckUpSlotList() {
		return checkUpSlotList;
	}

	public void setCheckUpSlotList(List<CheckUpSlot> checkUpSlotList) {
		this.checkUpSlotList = checkUpSlotList;
	}

}
