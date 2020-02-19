package com.project.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.project.exception.AppointmentException;
import com.project.exception.ValidateException;
import com.project.exception.SlotException;
import com.project.service.HealthService;
import com.project.service.HealthServiceImpl;

public class TestCancelAppointment {

	

	@Test
	@DisplayName("Cancel Appointment")
	public void testCancelAppointment1() throws SlotException, AppointmentException, ValidateException {
		HealthService ser = new HealthServiceImpl();
		assertTrue(ser.cancelAppointment("t1s1", "10001"));
	}

	@Test
	@DisplayName("SlotException for slotId")
	public void testCancelAppointment2() throws /* SlotException, */ AppointmentException, ValidateException {
		HealthService ser = new HealthServiceImpl();
		assertThrows(SlotException.class, () -> ser.cancelAppointment("t3s1", "10001"));
	}

	@Test
	@DisplayName("Cancel Appointment Twice")
	public void testCancelAppointment3() throws SlotException, ValidateException, AppointmentException {
		HealthService ser = new HealthServiceImpl();
		assertAll(() -> assertEquals(true, ser.cancelAppointment("t1s2", "10002")),
				  () -> assertThrows(AppointmentException.class, () -> ser.cancelAppointment("t1s2", "10002")));
	}

	@Test
	@DisplayName("AppointmentException for apmtId")
	public void testCancelAppointment4() throws SlotException, ValidateException, AppointmentException {
		HealthService ser = new HealthServiceImpl();
		assertThrows(AppointmentException.class, () -> ser.cancelAppointment("t2s1", "10001"));
	}

	@Test
	@DisplayName("ValidateException for slotId")
	public void testCancelAppointment5() throws SlotException, ValidateException, AppointmentException {
		HealthService ser = new HealthServiceImpl();
		assertThrows(ValidateException.class, () -> ser.cancelAppointment("t", "10001"));
	}
	
	@Test
	@DisplayName("ValidateException for slotId and apmtId")
	public void testCancelAppointment6() throws SlotException, ValidateException, AppointmentException {
		HealthService ser = new HealthServiceImpl();
		assertThrows(ValidateException.class, () -> ser.cancelAppointment("", ""));
	}
	
}
