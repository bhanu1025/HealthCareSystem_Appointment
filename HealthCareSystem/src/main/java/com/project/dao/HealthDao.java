package com.project.dao;

import java.util.Map;

import com.project.entity.CheckUpSlot;
import com.project.exception.AppointmentException;
import com.project.exception.SlotException;

public interface HealthDao {

	public CheckUpSlot getSlot(String slotId) throws SlotException;

	public Map<String, CheckUpSlot> getSlots();

	public boolean cancelAppointment(CheckUpSlot slot, String apmtId) throws SlotException, AppointmentException;

}
