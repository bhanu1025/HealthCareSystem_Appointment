package com.project.service;

import java.util.Map;

import com.project.entity.CheckUpSlot;
import com.project.exception.AppointmentException;
import com.project.exception.SlotException;
import com.project.exception.ValidateException;

public interface HealthService {

	public boolean cancelAppointment(String slotId, String apmtId)
			throws SlotException, AppointmentException, ValidateException;

	public Map<String, CheckUpSlot> getSlots();

	public CheckUpSlot getSlot(String slotId) throws SlotException, ValidateException;

}
