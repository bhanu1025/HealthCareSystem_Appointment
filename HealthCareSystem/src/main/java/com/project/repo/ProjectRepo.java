package com.project.repo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.entity.Appointment;
import com.project.entity.CheckUp;
import com.project.entity.CheckUpSlot;
import com.project.entity.DiagnosisCentre;

/************************************************************************************************
 * @author Bhanu Prakash Kavuri
 * Description : This class 'ProjectRepo' handles the repository information 
 * 				 of all the required classes and methods
 ************************************************************************************************
*/

public class ProjectRepo {

	public static Map<String, CheckUpSlot> listOfSlots = new HashMap<>();

	static {

		CheckUp c1 = new CheckUp("1001", "test1", 500);
		CheckUp c2 = new CheckUp("1002", "test2", 400);

		List<CheckUp> chList = new ArrayList<>();
		chList.add(c1);
		chList.add(c2);

		DiagnosisCentre dc1 = new DiagnosisCentre("dc1", "name1", chList);
		DiagnosisCentre dc2 = new DiagnosisCentre("dc2", "name2", chList);
		DiagnosisCentre dc3 = new DiagnosisCentre("dc3", "name3", chList);

		List<DiagnosisCentre> dcList = new ArrayList<>();
		dcList.add(dc1);
		dcList.add(dc2);
		dcList.add(dc3);

		CheckUpSlot slot1 = new CheckUpSlot("t1s1", "1001", LocalDate.of(2020, 02, 20), 0);
		CheckUpSlot slot2 = new CheckUpSlot("t1s2", "1001", LocalDate.of(2020, 02, 21), 0);

		List<CheckUpSlot> cusList1 = new ArrayList<>();
		cusList1.add(slot1);
		cusList1.add(slot2);
		c1.setCheckUpSlotList(cusList1);

		CheckUpSlot slot3 = new CheckUpSlot("t2s1", "1002", LocalDate.of(2020, 02, 20), 0);
		CheckUpSlot slot4 = new CheckUpSlot("t2s2", "1002", LocalDate.of(2020, 02, 21), 0);

		List<CheckUpSlot> cusList2 = new ArrayList<>();
		cusList2.add(slot3);
		cusList2.add(slot4);
		c2.setCheckUpSlotList(cusList2);

		Appointment apmt1 = new Appointment("10001", "user1", 999999999, "1001", "dc1", "t1s1");
		Appointment apmt2 = new Appointment("10002", "user2", 888888888, "1001", "dc1", "t1s2");
		Appointment apmt3 = new Appointment("10003", "user3", 777777777, "1001", "dc1", "t1s1");

		List<Appointment> apmtList1 = new ArrayList<>();
		apmtList1.add(apmt1);
		apmtList1.add(apmt3);
		slot1.setApmtList(apmtList1);
		slot1.setNumOfApp(apmtList1.size());

		List<Appointment> apmtList2 = new ArrayList<>();
		apmtList2.add(apmt2);
		slot2.setApmtList(apmtList2);
		slot2.setNumOfApp(apmtList2.size());

		listOfSlots.put(slot1.getTestSlotId(), slot1);
		listOfSlots.put(slot2.getTestSlotId(), slot2);
		listOfSlots.put(slot3.getTestSlotId(), slot3);
		listOfSlots.put(slot4.getTestSlotId(), slot4);
	}

}