package com.project.service;

import java.util.Map;

import com.project.dao.HealthDao;
import com.project.dao.HealthDaoImpl;
import com.project.entity.CheckUpSlot;
import com.project.exception.AppointmentException;
import com.project.exception.SlotException;
import com.project.exception.ValidateException;

public class HealthServiceImpl implements HealthService {

	private HealthDao dao = new HealthDaoImpl();

	private boolean validateSlotId(String slotId) throws ValidateException {
		if (!slotId.matches("[a-zA-Z0-9]{4}"))
			throw new ValidateException("Invalid slot ID");
		return true;
	}

	private boolean validateApmtId(String apmtId) throws ValidateException {
		if (!apmtId.matches("[0-9]{5}"))
			throw new ValidateException("Invalid Appointment ID");
		return true;
	}

	@Override
	public boolean cancelAppointment(String slotId, String apmtId)
			throws SlotException, AppointmentException, ValidateException {
		if (validateSlotId(slotId) && validateApmtId(apmtId)) {
			CheckUpSlot slot = dao.getSlot(slotId);
			dao.cancelAppointment(slot, apmtId);
			return true;
		}
		return false;
	}

	@Override
	public Map<String, CheckUpSlot> getSlots() {
		return dao.getSlots();
	}

	@Override
	public CheckUpSlot getSlot(String slotId) throws SlotException, ValidateException {
		if (validateSlotId(slotId))
			return dao.getSlot(slotId);
		return dao.getSlot("");
	}

}