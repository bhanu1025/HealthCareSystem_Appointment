package com.project.service;

import java.util.Map;

import com.project.dao.HealthDao;
import com.project.dao.HealthDaoImpl;
import com.project.entity.CheckUpSlot;
import com.project.exception.AppointmentException;
import com.project.exception.SlotException;
import com.project.exception.ValidateException;

/***********************************************************************************************
 * @author Bhanu Prakash Kavuri
 * Description: This class implements the Service interface of HealthCareSystem it overrides the 
 * 				methods which are not implemented in the Service interface and this layer will 
 * 				access the data from the Dao layer and provide UI layer to implement logical
 *				operations on the data provided.    
 ***********************************************************************************************/

public class HealthServiceImpl implements HealthService {

	private HealthDao dao = new HealthDaoImpl();

	/*******************************************************************************************
	 * Method: This method validates the given slotId is following the given convention or not
	 * Convention: slotId may have alphabits or digits of 4 characters
	 * @param slotId
	 * @return true if slotId matches the given convention
	 * @throws 'ValidateException' if slotId does not match the convention
	 *******************************************************************************************/
	private boolean validateSlotId(String slotId) throws ValidateException {
		if (!slotId.matches("[a-zA-Z0-9]{4}"))
			throw new ValidateException("Invalid slot ID");
		return true;
	}

	/*******************************************************************************************
	 * Method: This method validates the given apmtId is following the given convention or not
	 * Convention: apmtId must have only 5 digits
	 * @param apmtId
	 * @return true if slotId matches the given convention
	 * @throws 'ValidateException' if apmtId does not match the convention
	 *******************************************************************************************/
	private boolean validateApmtId(String apmtId) throws ValidateException {
		if (!apmtId.matches("[0-9]{5}"))
			throw new ValidateException("Invalid Appointment ID");
		return true;
	}

	/*******************************************************************************************
	 * Method: This overrided method 'cancelAppointment()' access the data from Dao layer 
	 * 		   and cancel the appointment of the given apmt ID
	 * @param slotId, apmtId
	 * @return true - if slotId and apmtId is validated and appointment is cancelled 
	 * 		   false - if validation of slotId and apmtId is not done
	 * @throws 'ValidateException' if slotId and apmtId does not match the convention
	 * 		   'SlotException' if given slotId does not contain in the List
	 * 		   'AppointmentException' if there is no appointment in the apmtList
	 *******************************************************************************************/
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

	/*******************************************************************************************
	 * Method: This overrided method 'getSlots()' access the data from Dao layer 
	 * 		   and fetches the list of slots
	 * @return List of slots
	 *******************************************************************************************/
	@Override
	public Map<String, CheckUpSlot> getSlots() {
		return dao.getSlots();
	}

	/*******************************************************************************************
	 * Method: This overrided method 'getSlot()' access the data from Dao layer 
	 *         and fetches the slot according to the given slot ID
	 * @param slotId
	 * @return the slot of the given slot ID
	 * @throws 'SlotException' if given slot id does not contain in the List
	 *******************************************************************************************/
	@Override
	public CheckUpSlot getSlot(String slotId) throws SlotException, ValidateException {
		if (validateSlotId(slotId))
			return dao.getSlot(slotId);
		return dao.getSlot("");
	}

}