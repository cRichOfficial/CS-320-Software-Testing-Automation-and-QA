package com.richwerks.ContactService;

/**
 * 
 * @author Chris Richards
 * @file Contact.java
 * @date 03/16/2023
 *
 */

public class Contact {

	/**
	 * 
	 * @param t_id The id of the contact
	 * @param t_firstName The first name of the contact
	 * @param t_lastName The last name of the contact
	 * @param t_phone The phone number of the contact
	 * @param t_address The address of the contact
	 */
	public Contact(String t_id, String t_firstName, String t_lastName, String t_phone, String t_address) {
		if(t_id == null || t_id.length() > 10) {
			throw new IllegalArgumentException("Invalid id");
		}
		if(t_firstName == null || t_firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		if(t_lastName == null || t_lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		if(t_phone == null || t_phone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone");
		}
		if(t_address == null || t_address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		this.setId(t_id);
		this.setFirstName(t_firstName);
		this.setLastName(t_lastName);
		this.setPhone(t_phone);
		this.setAddress(t_address);
	}
	
	/**
	 * @return t_id
	 */
	public String getId() {
		return m_id;
	}
	/**
	 * @param t_id the id to set
	 * 
	 * This function is private as the contact id should not be changeable
	 */
	private void setId(String t_id) {
		m_id = t_id;
	}
	/**
	 * @return m_firstName
	 */
	public String getFirstName() {
		return m_firstName;
	}
	/**
	 * @param t_firstName the firstName to set
	 */
	public void setFirstName(String t_firstName) {
		if(t_firstName == null || t_firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		m_firstName = t_firstName;
	}
	/**
	 * @return m_lastName
	 */
	public String getLastName() {
		return m_lastName;
	}
	/**
	 * @param t_lastName the lastName to set
	 */
	public void setLastName(String t_lastName) {
		if(t_lastName == null || t_lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		m_lastName = t_lastName;
	}
	/**
	 * @return m_phone
	 */
	public String getPhone() {
		return m_phone;
	}
	/**
	 * @param t_phone the phone to set
	 */
	public void setPhone(String t_phone) {
		if(t_phone == null || t_phone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone");
		}
		m_phone = t_phone;
	}

	/**
	 * @return m_address
	 */
	public String getAddress() {
		return m_address;
	}
	/**
	 * @param t_address the address to set
	 */
	public void setAddress(String t_address) {
		if(t_address == null || t_address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		m_address = t_address;
	}

	private String m_id;
	private String m_firstName;
	private String m_lastName;
	private String m_phone;
	private String m_address;
}
