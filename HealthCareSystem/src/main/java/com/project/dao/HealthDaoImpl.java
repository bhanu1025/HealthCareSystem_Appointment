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
 * 				methods which are not implemented in the Dao interface and this is layer will 
 * 				access the data from the repository and provide service layer implement logical
 *				operations on the data provided.    
 ***********************************************************************************************/

public class HealthDaoImpl implements HealthDao {
	
	private Map<String, CheckUpSlot> slots = ProjectRepo.listOfSlots;

	/*******************************************************************************************
	 * Method: This method 'getSlots()' fetches the list of slots and 
	 * 		   return the list of slots
	 *******************************************************************************************/
	@Override
	public Map<String, CheckUpSlot> getSlots() {

		return slots;
	}

	/*******************************************************************************************
	 * 
	 */
	public CheckUpSlot getSlot(String slotId) throws SlotException {
		if (!slots.containsKey(slotId))
			throw new SlotException("No Slot Found");
		return slots.get(slotId);
	}

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
