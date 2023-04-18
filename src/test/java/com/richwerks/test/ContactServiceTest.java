package com.richwerks.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import com.richwerks.ContactService.Contact;
import com.richwerks.ContactService.ContactService;
import com.richwerks.exceptions.ContactNotFoundException;
import com.richwerks.exceptions.DuplicateContactIdException;

/**
 * 
 * @author Chris Richards
 * @file ContactServiceTest.java
 * @date 03/16/2023
 *
 */

class ContactServiceTest {

	ContactService contactService;
	
	/**
	 * 
	 * @param testInfo Information for the test
	 * Setup of contactService object for testing.
	 */
	@BeforeEach
	void setup(TestInfo testInfo) {
		System.out.println("Prepping ContactService data...");
		contactService = new ContactService();
		contactService.addContact(new Contact("1", "John", "Doe", "5555555555", "123 Main St."));
		contactService.addContact(new Contact("2", "Billy", "The Kid", "5551234567", "188 Horse Path Rd."));
		System.out.println("Running test " + testInfo.getDisplayName());
	}
	
	/**
	 * Test the ContactService Constructor
	 */
	@Test
	@DisplayName("Constructor")
	void testContactService() {
		ContactService contactService = new ContactService();
		assertNotNull(contactService.getAllContacts());
	}
	
	/**
	 * Test the addContact function and Throwables
	 */
	@Test
	@DisplayName("addContact")
	void testContactServiceAddContact() {
		Contact contact = new Contact("3", "Jesse", "James", "2223334567", "5434 Broad Way");
		contactService.addContact(contact);
		assertNotNull(contactService.getContact(contact.getId()));
		assertThrows(IllegalArgumentException.class, ()->{
			contactService.addContact(null);
		});
		assertThrows(DuplicateContactIdException.class, ()->{
			contactService.addContact(new Contact("1", "Joan", "OfArc", "4456547894", "1 Rue de Blvd"));
		});
	}
	
	/**
	 * Test the getContact function and Throwables
	 */
	@Test
	@DisplayName("getContact")
	void testContactServiceGetContact() {
		assertNotNull(contactService.getContact("1"));
		assertThrows(IllegalArgumentException.class, ()->{
			contactService.getContact("01234567890");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			contactService.getContact(null);
		});
	}
	
	/**
	 * Test the deleteContact and Throwables
	 */
	@Test
	@DisplayName("deleteContact")
	void testContactServiceDeleteContact() {
		contactService.deleteContact("1");
		assertNull(contactService.getContact("1"));
		assertThrows(ContactNotFoundException.class, ()->{
			contactService.deleteContact("4");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			contactService.deleteContact(null);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			contactService.deleteContact("01234567890");
		});
	}
	
	/**
	 * Test the updateFirstName and Throwables
	 */
	@Test
	@DisplayName("updateFirstName")
	void testContactServiceUpdateFirstName() {
		contactService.updateFirstName("1", "Joseph");
		assertTrue(contactService.getContact("1").getFirstName().equals("Joseph"));
		assertThrows(IllegalArgumentException.class, ()->{
			contactService.updateFirstName("01234567890", "Joseph");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			contactService.updateFirstName(null, "Joseph");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			contactService.updateFirstName("1", "JosephIsAReallyLongName");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			contactService.updateFirstName("1", null);
		});
		assertThrows(ContactNotFoundException.class, ()->{
			contactService.updateFirstName("9", "Joseph");
		});
	}
	
	/**
	 * Test the updateLastName and Throwables
	 */
	@Test
	@DisplayName("updateLastName")
	void testContactServiceUpdateLastName() {
		contactService.updateLastName("1", "Smithson");
		assertTrue(contactService.getContact("1").getLastName().equals("Smithson"));
		assertThrows(IllegalArgumentException.class, ()->{
			contactService.updateLastName("01234567890", "Smithson");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			contactService.updateLastName(null, "Smithson");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			contactService.updateLastName("1", "SmithsonianLongName");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			contactService.updateLastName("1", null);
		});
		assertThrows(ContactNotFoundException.class, ()->{
			contactService.updateLastName("9", "Smithson");
		});
	}
	
	/**
	 * Test the updatePhone and Throwables
	 */
	@Test
	@DisplayName("updatePhone")
	void testContactServiceUpdatePhone() {
		contactService.updatePhone("1", "5554567893");
		assertTrue(contactService.getContact("1").getPhone().equals("5554567893"));
		assertThrows(IllegalArgumentException.class, ()->{
			contactService.updatePhone("01234567890", "1234567890");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			contactService.updatePhone(null, "1234567890");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			contactService.updatePhone("1", "234567890");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			contactService.updatePhone("1", null);
		});
		assertThrows(ContactNotFoundException.class, ()->{
			contactService.updatePhone("9", "1234567890");
		});
	}
	
	/**
	 * Test the updateAddress and Throwables
	 */
	@Test
	@DisplayName("updateAddress")
	void testContactServiceUpdateAddress() {
		contactService.updateAddress("1", "4434 Highway 12");
		assertTrue(contactService.getContact("1").getAddress().equals("4434 Highway 12"));
		assertThrows(IllegalArgumentException.class, ()->{
			contactService.updateAddress("01234567890", "4434 Highway 12");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			contactService.updateAddress(null, "4434 Highway 12");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			contactService.updateAddress("1", "4434 Highway 12 on the corner of happy and healthy");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			contactService.updateAddress("1", null);
		});
		assertThrows(ContactNotFoundException.class, ()->{
			contactService.updateAddress("9", "4434 Highway 12");
		});
	}
}
