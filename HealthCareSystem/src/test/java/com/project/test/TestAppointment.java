package com.project.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.project.exception.AppointmentException;
import com.project.exception.SlotException;
import com.project.exception.ValidateException;
import com.project.service.HealthService;
import com.project.service.HealthServiceImpl;

public class TestAppointment {

	@Test
	@DisplayName("Test Case 1")
	public void testAppointment1() throws AppointmentException, ValidateException, SlotException {
		HealthService ser = new HealthServiceImpl();
		assertEquals(0, ser.getSlot("t2s2").getApmtList().size());
	}

	@Test
	@DisplayName("Test Case 2")
	public void testAppointment2() throws AppointmentException, ValidateException, SlotException {
		HealthService ser = new HealthServiceImpl();
		assertEquals(2, ser.getSlot("t1s1").getApmtList().size());
	}

	@Test
	@DisplayName("Test Case 3")
	public void testAppointment3() throws AppointmentException, ValidateException, SlotException {
		HealthService ser = new HealthServiceImpl();
		assertAll(() -> assertEquals(2, ser.getSlot("t1s1").getApmtList().size()),
			      () -> assertTrue(ser.cancelAppointment("t1s1", "10001")),
				  () -> assertEquals(1, ser.getSlot("t1s1").getApmtList().size()));
	}
	
	
	

}
