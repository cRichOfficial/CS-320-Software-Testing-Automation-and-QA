package com.richwerks.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import com.richwerks.AppointmentService.Appointment;
import com.richwerks.AppointmentService.AppointmentService;
import com.richwerks.exceptions.AppointmentNotFoundException;
import com.richwerks.exceptions.DuplicateAppointmentException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 * 
 * @author Chris Richards
 * @file AppointmentServiceTest.java
 * @date 03/31/2023
 *
 */
class AppointmentServiceTest {

	
	private AppointmentService appointmentService;
	
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
		System.out.println("Testing finsished.");
	}

	/**
	 * 
	 * @param testInfo
	 * @throws Exception
	 */
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp(TestInfo testInfo) throws Exception {
		System.out.println("Preparing AppointmentService for test...");
		// For each test, initialize appointmentService as new AppointmentService and populate it with Appointments.
		this.appointmentService = new AppointmentService();
		this.appointmentService.addAppointment(new Appointment("0123456789", new Date("08/08/2023"), "Appointment number 1"));
		this.appointmentService.addAppointment(new Appointment("9876543210", new Date("09/09/2023"), "Appointment number 2"));
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
	 * Test the constructor of the AppointmentService class.
	 */
	
	@Test
	@DisplayName("Constructor")
	void testAppointmentService() {
		AppointmentService appointmentService = new AppointmentService();
		assertNotNull(appointmentService);
	}
	
	/**
	 * Test the addAppointment method.
	 * Add Appointment to appointmentService and retrieve it.
	 * Test that adding a null appointment throws an IllegalArgumentException.
	 * Test that adding a duplicate appointment throws a DuplicateAppointmentException.
	 */
	
	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("addAppointment")
	void testAppointmentServiceAddAppointment() {
		Appointment appointment = new Appointment("1122334455", new Date("01/01/2024"), "Test Appointment");
		this.appointmentService.addAppointment(appointment);
		assertNotNull(appointmentService.getAppointment(appointment.getId()));
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{
			appointmentService.addAppointment(null);
		});
		assertThrows(DuplicateAppointmentException.class, ()->{
			appointmentService.addAppointment(new Appointment("0123456789", new Date("02/22/2025"), "Duplicate Task"));
		});
		assertEquals("Appointment cannot be null", exception.getMessage());
	}
	
	/**
	 * Test the deleteAppointment method.
	 * Test that deleting an appointment yields a null result when trying to retrieve that appointment.
	 * Test that a null argument throws an IllegalArgumentException.
	 * Test that a blank argument throws an IllegalArgumentException.
	 * Test that trying to delete an appointment that doesn't exist throws an IllegalArgumentException.
	 */
	
	@Test
	@DisplayName("deleteAppointment")
	void testAppointmentServiceDeleteAppointment() {
		this.appointmentService.deleteAppointment("0123456789");
		assertNull(this.appointmentService.getAppointment("0123456789"));
		assertThrows(IllegalArgumentException.class, ()->{
			this.appointmentService.deleteAppointment(null);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			this.appointmentService.deleteAppointment("      ");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			this.appointmentService.deleteAppointment("0012345678999");
		});
		assertThrows(AppointmentNotFoundException.class, ()->{
			this.appointmentService.deleteAppointment("0012345678");
		});
	}
	
	/**
	 * Test the getAppointment method.
	 * Test that retrieving an appointment that exists returns a non-null appointment.
	 * Test that trying to retrieve an appointment that doesn't exist returns a null object.
	 * Test that a null argument throws an IllegalArgumentException.
	 * Test that a blank argument throws an IllegalArguemntException.
	 * Test that an argument greater than 10 characters returns an IllegalArgumentException.
	 */
	
	@Test
	@DisplayName("getAppointment")
	void testAppointmentServiceGetAppointment() {
		assertNotNull(this.appointmentService.getAppointment("0123456789"));
		assertNull(this.appointmentService.getAppointment("999"));
		assertThrows(IllegalArgumentException.class, ()->{
			this.appointmentService.getAppointment(null);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			this.appointmentService.getAppointment("     ");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			this.appointmentService.getAppointment("0000646546450654");
		});
	}
	
}
