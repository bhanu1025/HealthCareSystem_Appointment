package com.project.ui;

import java.util.Map;
import java.util.Scanner;

import com.project.entity.CheckUpSlot;
import com.project.exception.AppointmentException;
import com.project.exception.SlotException;
import com.project.exception.ValidateException;
import com.project.service.HealthService;
import com.project.service.HealthServiceImpl;

public class HealthServiceClient {

	static HealthService ser = new HealthServiceImpl();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String slotId = "";
		String apmtId = "";
		Map<String, CheckUpSlot> slots = ser.getSlots();
		System.out.println("List of slots and Appointments in it");
		slots.values().forEach(System.out::println);
		System.out.println("Enter Slot ID ");
		slotId = scan.next();
		System.out.println("Enter Appointment ID ");
		apmtId = scan.next();
		scan.close();
		try {
			if (ser.cancelAppointment(slotId, apmtId))
				System.out.println("Appointment Cancelled");
		} catch (SlotException | AppointmentException | ValidateException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
