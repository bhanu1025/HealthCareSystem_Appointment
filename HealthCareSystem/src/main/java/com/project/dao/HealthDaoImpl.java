package com.project.dao;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.project.entity.Appointment;
import com.project.entity.CheckUpSlot;
import com.project.exception.AppointmentException;
import com.project.exception.SlotException;
import com.project.repo.ProjectRepo;

/***********************************************************************************************
 * @author Bhanu Prakash Kavuri
 * Description: This class implements the Dao interface of HealthCareSystem it overrides the 
 * 				methods which are not implemented in the Dao interface and this layer will 
 * 				access the data from the repository and provide service layer implement logical
 *				operations on the data provided.    
 ***********************************************************************************************/

public class HealthDaoImpl implements HealthDao {
	
	private Map<String, CheckUpSlot> slots = ProjectRepo.listOfSlots;

	/*******************************************************************************************
	 * Method: This method 'getSlots()' fetches the list of slots
	 * @return List of slots
	 *******************************************************************************************/
	@Override
	public Map<String, CheckUpSlot> getSlots() {

		return slots;
	}

	/*******************************************************************************************
	 * Method: This method 'getSlot()' fetches the slot according to the given slot ID
	 * @param slotId
	 * @return the slot of the given slot ID
	 * @throws 'SlotException' if given slot id does not contain in the List
	 *******************************************************************************************/
	public CheckUpSlot getSlot(String slotId) throws SlotException {
		if (!slots.containsKey(slotId))
			throw new SlotException("No Slot Found");
		return slots.get(slotId);
	}
	
	/*******************************************************************************************
	 * Method: This method 'cancelAppointment()' cancel the appointment of the given apmt ID 
	 * 		   in the apmtList of the given slot 
	 * @param slot, apmtId
	 * @return true if appointment is cancelled
	 * @throws 'AppointmentException' if there is no appointment in the apmtList
	 *******************************************************************************************/
	@Override
	public boolean cancelAppointment(CheckUpSlot slot, String apmtId) throws SlotException, AppointmentException {
		List<Appointment> apmtList = slot.getApmtList().stream().filter(a -> a.getApmtId().equals(apmtId))
				.collect(Collectors.toList());
		if (apmtList.isEmpty())
			throw new AppointmentException("No Appointment Found");
		slot.getApmtList().remove(apmtList.get(0));
		return true;
	}

}
