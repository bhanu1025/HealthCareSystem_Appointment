package com.project.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.project.exception.SlotException;
import com.project.exception.ValidateException;
import com.project.service.HealthService;
import com.project.service.HealthServiceImpl;

public class TestSlot {

	@Test
	@DisplayName("Test Case 1")
	public void testAppointment1() throws SlotException, ValidateException {
		HealthService ser = new HealthServiceImpl();
		assertThrows(SlotException.class, () -> ser.getSlot("t3s1"));
	}
	
	@Test
	@DisplayName("Test Case 2")
	public void testAppointment2() {
		HealthService ser = new HealthServiceImpl();
		assertEquals(4, ser.getSlots().size());
	}
	
	@Test
	@DisplayName("Test Case 3")
	public void testAppointment3() throws SlotException, ValidateException {
		HealthService ser = new HealthServiceImpl();
		assertThrows(ValidateException.class, () -> ser.getSlot("ts"));
	}
	
}
