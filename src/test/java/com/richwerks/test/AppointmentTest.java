package com.richwerks.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import com.richwerks.AppointmentService.Appointment;

/**
 * 
 * @author Chris Richards
 * @file AppointmentTest.java
 * @date 03/31/2023
 *
 */
class AppointmentTest {

	/**
	 * 
	 * @throws Exception
	 */
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Starting tests...");
	}

	/**
	 * 
	 * @throws Exception
	 */
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Testing finished.");
	}

	/**
	 * 
	 * @param testInfo
	 * @throws Exception
	 */
	
	@BeforeEach
	void setUp(TestInfo testInfo) throws Exception {
		System.out.println(String.format("Running test %s...", testInfo.getDisplayName()));
	}

	/**
	 * 
	 * @param testInfo
	 * @throws Exception
	 */
	
	@AfterEach
	void tearDown(TestInfo testInfo) throws Exception {
		System.out.println(String.format("Test %s finished.", testInfo.getDisplayName()));
	}

	/**
	 * Test the constructor.
	 * Initialize a new Appointment object and test that it is not null.
	 * Test that the id equals the id provided.
	 * Test that the date equals the date provided.
	 * Test that the description equals the description provided.
	 * Test that invalid arguments throw IllegalArgumentException.
	 * 
	 */
	
	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("Appointment Constructor Test")
	void testAppointment() {
		Appointment appointment = new Appointment("0123456789", new Date("05/05/2023"), "Test Appointment");
		assertNotNull(appointment);
		assertTrue(appointment.getId().equals("0123456789"));
		assertTrue(appointment.getDate().equals(new Date("05/05/2023")));
		assertTrue(appointment.getDescription().equals("Test Appointment"));
		assertThrows(IllegalArgumentException.class, ()->{
			new Appointment("0012345678900", new Date("05/05/2023"), "Test Appointment");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new Appointment("       ", new Date("05/05/2023"), "Test Appointment");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new Appointment(null, new Date("05/05/2023"), "Test Appointment");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new Appointment("0123456789", new Date("05/05/2022"), "Test Appointment");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new Appointment("0123456789", null, "Test Appointment");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new Appointment("0123456789", new Date("05/05/2023"), "Test Appointment that is longer than 50 characters long.");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new Appointment("0123456789", new Date("05/05/2023"), "                    ");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new Appointment("0123456789", new Date("05/05/2023"), null);
		});
	}
	
	/**
	 * Test getId method.
	 * Initialize new Appointment object.
	 * Test that the Id equals the id provided.
	 */
	
	@Test
	@DisplayName("getId")
	void testAppointmentGetId() {
		@SuppressWarnings("deprecation")
		Appointment appointment = new Appointment("0123456789", new Date("05/05/2023"), "Test Appointment");
		assertTrue(appointment.getId().equals("0123456789"));
	}
	
	
	/**
	 * Test getDate method.
	 * Initialize new Appointment object.
	 * Test that the date is the date provided. 
	 */
	
	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("getDate")
	void testAppointmentGetDate() {
		Appointment appointment = new Appointment("0123456789", new Date("05/05/2023"), "Test Appointment");
		assertTrue(appointment.getDate().equals(new Date("05/05/2023")));
	}
	
	/**
	 * Test setDate method.
	 * Initialized new Appointment.
	 * Set date and test that date equals date provided.
	 * Set date to date in the past. Test that an IllegalArgumentException is thrown.
	 * Set date to null. Test that an IllegalArgumentException is thrown.
	 */
	
	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("setDate")
	void testAppointmentSetDate() {
		Appointment appointment = new Appointment("0123456789", new Date("05/05/2023"), "Test Appointment");
		appointment.setDate(new Date("08/08/2025"));
		assertTrue(appointment.getDate().equals(new Date("08/08/2025")));
		assertThrows(IllegalArgumentException.class, ()->{
			appointment.setDate(null);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			appointment.setDate(new Date("01/01/1959"));
		});
	}
	
	/**
	 * Test getDescription method
	 * Initialize new Appointment object.
	 * Test that description equals description provided.
	 */
	
	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("getDescription")
	void testAppointmentGetDescription() {
		Appointment appointment = new Appointment("0123456789", new Date("05/05/2023"), "Test Appointment");
		assertTrue(appointment.getDescription().equals("Test Appointment"));
	}
	
	/**
	 * Test setDescription method.
	 * Initialize new Appointment object.
	 * Set description. Test that description equals description provided.
	 * Test that adding a null description throws an IllegalArgumentException.
	 * Test that adding a blank description throws an IllegalArgumentException.
	 * Test that adding a description longer than 50 characters thows an IllegalArgumentException.
	 */
	
	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("setDescription")
	void testAppointmentSetDescription() {
		Appointment appointment = new Appointment("0123456789", new Date("05/05/2023"), "Test Appointment");
		appointment.setDescription("New appointment description");
		assertTrue(appointment.getDescription().equals("New appointment description"));
		assertThrows(IllegalArgumentException.class, ()->{
			appointment.setDescription(null);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			appointment.setDescription("    ");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			appointment.setDescription("New test appointment description longer than 50 characters.");
		});
	}

}
