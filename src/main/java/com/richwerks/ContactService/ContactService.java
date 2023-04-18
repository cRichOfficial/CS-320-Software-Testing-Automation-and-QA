package com.richwerks.ContactService;

import java.util.HashMap;

import com.richwerks.exceptions.ContactNotFoundException;
import com.richwerks.exceptions.DuplicateContactIdException;
/**
 * 
 * @author Chris Richards
 * @file ContactService.java
 * @date 03/16/2023
 *
 */


public class ContactService {
	public ContactService() {
		this.m_contactList = new HashMap<String, Contact>();
	}
	
	/**
	 * 
	 * @param t_contact The contact to add
	 * @throws IllegalArgumentException if the contact.id is already present.
	 */
	public void addContact(Contact t_contact) {
		if(t_contact == null) {
			throw new IllegalArgumentException("Invalid contact");
		}
		if(m_contactList.containsKey(t_contact.getId())){
			throw new DuplicateContactIdException("Contact already exists");
		}
		m_contactList.put(t_contact.getId(), t_contact);
	}
	
	public Contact getContact(String t_id) {
		if(t_id == null || t_id.length() > 10) {
			throw new IllegalArgumentException("Invalid id");
		}
		
		return m_contactList.get(t_id);
	}
	
	public HashMap<String, Contact> getAllContacts(){
		return m_contactList;
	}
	
	/**
	 * 
	 * @param t_id The id of the Contact to delete
	 * @throws ContactNotFoundException 
	 * @throws IllegalArgumentException if t_id is invalid
	 */
	public void deleteContact(String t_id){
		if(t_id == null || t_id.length() > 10) {
			throw new IllegalArgumentException("Invalid id");
		}
		if(!m_contactList.containsKey(t_id)) {
			throw new ContactNotFoundException("Contact does not exist");
		}
		m_contactList.remove(t_id);
	}
	
	/**
	 * 
	 * @param t_id The id of the Contact to update
	 * @param t_firstName New first name for contact
	 * @throws IllegalArgumentException if t_id is invalid or t_firstName is invalid
	 */
	public void updateFirstName(String t_id, String t_firstName) {
		if(t_id == null || t_id.length() > 10) {
			throw new IllegalArgumentException("Invalid id");
		}
		if(t_firstName == null || t_firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid firstName");
		}
		if(!m_contactList.containsKey(t_id)) {
			throw new ContactNotFoundException("Contact does not exist");
		}
		
		m_contactList.get(t_id).setFirstName(t_firstName);
	}
	
	/**
	 * 
	 * @param t_id The id of the Contact to update
	 * @param t_lastName New last name for contact
	 * @throws IllegalArgumentException if t_id is invalid or t_lastName is invalid
	 */
	public void updateLastName(String t_id, String t_lastName) {
		if(t_id == null || t_id.length() > 10) {
			throw new IllegalArgumentException("Invalid id");
		}
		if(t_lastName == null || t_lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		if(!m_contactList.containsKey(t_id)) {
			throw new ContactNotFoundException("Contact does not exist");
		}
		
		m_contactList.get(t_id).setLastName(t_lastName);
	}
	/**
	 * 
	 * @param t_id The id of the Contact to update
	 * @param t_phone New phone number for contact
	 * @throws IllegalArgumentException if t_id is invalid or t_phone is invalid
	 */
	public void updatePhone(String t_id, String t_phone) {
		if(t_id == null || t_id.length() > 10) {
			throw new IllegalArgumentException("Invalid id");
		}
		if(t_phone == null || t_phone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone");
		}
		if(!m_contactList.containsKey(t_id)) {
			throw new ContactNotFoundException("Contact does not exist");
		}
		
		m_contactList.get(t_id).setPhone(t_phone);
	}
	
	/**
	 * 
	 * @param t_id The id of the Contact to update
	 * @param t_address New address for contact
	 * @throws IllegalArgumentException if t_id is invalid or t_address is invalid
	 */
	public void updateAddress(String t_id, String t_address) {
		if(t_id == null || t_id.length() > 10) {
			throw new IllegalArgumentException("Invalid id");
		}
		if(t_address == null || t_address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		if(!m_contactList.containsKey(t_id)){
			throw new ContactNotFoundException("Contact does not exist");
		}
		
		m_contactList.get(t_id).setAddress(t_address);
	}
	
	
	
	
	private HashMap<String, Contact> m_contactList;
}
