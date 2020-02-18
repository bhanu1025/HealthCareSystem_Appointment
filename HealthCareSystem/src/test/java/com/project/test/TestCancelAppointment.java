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
	@DisplayName("Test Case 1")
	public void testAppointment1() throws SlotException, AppointmentException, ValidateException {
		HealthService ser = new HealthServiceImpl();
		assertTrue(ser.cancelAppointment("t1s1", "10001"));
	}

	@Test
	@DisplayName("Test Case 2")
	public void testAppointment2() throws /* SlotException, */ AppointmentException, ValidateException {
		HealthService ser = new HealthServiceImpl();
		assertThrows(SlotException.class, () -> ser.cancelAppointment("t3s1", "10001"));
	}

	@Test
	@DisplayName("Test Case 3")
	public void testAppointment3() throws SlotException, ValidateException, AppointmentException {
		HealthService ser = new HealthServiceImpl();
		assertAll(() -> assertEquals(true, ser.cancelAppointment("t1s2", "10002")),
				  () -> assertThrows(AppointmentException.class, () -> ser.cancelAppointment("t1s2", "10002")));
	}

	@Test
	@DisplayName("Test Case 4")
	public void testAppointment4() throws SlotException, ValidateException, AppointmentException {
		HealthService ser = new HealthServiceImpl();
		assertThrows(AppointmentException.class, () -> ser.cancelAppointment("t2s1", "10001"));
	}

	@Test
	@DisplayName("Test Case 5")
	public void testAppointment5() throws SlotException, ValidateException, AppointmentException {
		HealthService ser = new HealthServiceImpl();
		assertThrows(ValidateException.class, () -> ser.cancelAppointment("t", "10001"));
	}
	
	@Test
	@DisplayName("Test Case 6")
	public void testAppointment6() throws SlotException, ValidateException, AppointmentException {
		HealthService ser = new HealthServiceImpl();
		assertThrows(ValidateException.class, () -> ser.cancelAppointment("", ""));
	}
	
}
