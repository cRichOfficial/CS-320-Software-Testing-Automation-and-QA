/**
 * 
 */
package com.richwerks.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import com.richwerks.ContactService.Contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeAll;

/**
 * 
 * @author Chris Richards
 * @file ContactTest.java
 * @date 03/16/2023
 *
 *
 */

class ContactTest {

	/**
	 * 
	 */
	@BeforeAll
	static void initialize() {
		System.out.println("Starting tests...");
	}
	
	@BeforeEach
	void setup(TestInfo testInfo) {
		System.out.println("Running test " + testInfo.getDisplayName());
	}
	
	/**
	 * Test constructor
	 */
	@Test
	@DisplayName("Contact Constructor Test")
	void testContact() {
		Contact contact = new Contact("0123456789", "John", "Smith", "5551234567", "123 Main St");
		assertTrue(contact.getId().equals("0123456789"));
		assertTrue(contact.getFirstName().equals("John"));
		assertTrue(contact.getLastName().equals("Smith"));
		assertTrue(contact.getPhone().equals("5551234567"));
		assertTrue(contact.getAddress().equals("123 Main St"));
	}
	
	/**
	 * Test Constructor field types
	 */
	@Test
	@DisplayName("Contact Constructor Data Test")
	void testContactFields() {
		assertThrows(IllegalArgumentException.class, ()->{
			new Contact("01234567890", "John", "Smith", "5551234567", "123 Main St");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new Contact(null, "John", "Smith", "5551234567", "123 Main St");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new Contact("0123456789", "JohnnathanLongName", "Smith", "5551234567", "123 Main St");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new Contact("0123456789", null, "Smith", "5551234567", "123 Main St");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new Contact("0123456789", "John", "SmithAndSonsLongName", "5551234567", "123 Main St");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new Contact("0123456789", "John", null, "5551234567", "123 Main St");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new Contact("0123456789", "John", "Smith", "555123456", "123 Main St");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new Contact("0123456789", "John", "Smith", null, "123 Main St");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new Contact("0123456789", "John", "Smith", "5551234567", "123 Main St and the corner of happy and healthy");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new Contact("0123456789", "John", "Smith", "5551234567", null);
		});
	}
	
	/**
	 * Test setFirstName and Throwables
	 */
	@Test
	@DisplayName("setFirstName")
	void testContactSetFirstName() {
		Contact contact = new Contact("0123456789", "John", "Smith", "5551234567", "123 Main St");
		contact.setFirstName("Billy");
		assertTrue(contact.getFirstName().equals("Billy"));
		assertThrows(IllegalArgumentException.class, ()->{
			contact.setFirstName("JohnHasALongName");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			contact.setFirstName(null);
		});
	}
	
	/**
	 * Test setLastNaem and Throwables
	 */
	@Test
	@DisplayName("setLastName")
	void testContactSetLastName() {
		Contact contact = new Contact("0123456789", "John", "Smith", "5551234567", "123 Main St");
		contact.setLastName("Simpson");
		assertTrue(contact.getLastName().equals("Simpson"));
		assertThrows(IllegalArgumentException.class, ()->{
			contact.setLastName("SmithIsNotReallyALongName");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			contact.setLastName(null);
		});
	}
	
	/**
	 * Test setPhone and Throwables
	 */
	@Test
	@DisplayName("setPhone")
	void testContactSetPhone() {
		Contact contact = new Contact("0123456789", "John", "Smith", "5551234567", "123 Main St");
		contact.setPhone("5557654321");
		assertTrue(contact.getPhone().equals("5557654321"));
		assertThrows(IllegalArgumentException.class, ()->{
			contact.setPhone("55587654321");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			contact.setPhone(null);
		});
	}
	
	/**
	 * Test setAddress and Throwables
	 */
	@Test
	@DisplayName("setAddress")
	void testContactSetAddress() {
		Contact contact = new Contact("0123456789", "John", "Smith", "5551234567", "123 Main St");
		contact.setAddress("8254 Mockingbird Way");
		assertTrue(contact.getAddress().equals("8254 Mockingbird Way"));
		assertThrows(IllegalArgumentException.class, ()->{
			contact.setAddress("123 Main St at the corner of happy and healthy");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			contact.setAddress(null);
		});
	}
}
