package com.richwerks.AppointmentService;

import java.util.Date;

/**
 * 
 * @author Chris Richards
 * @file Appointment.java
 * @date 03/31/2023
 */

public class Appointment {
	
	/**
	 * 
	 * @param t_id The id of the appointment. Limited to 10 characters. Must not be null and must not be blank.
	 * @param t_date The date for the appointment. Must not be in the past. Must not be null.
	 * @param t_description A description of the appointment. Limited to 50 characters. Must not be null and must not be blank.
	 */
	
	public Appointment(String t_id, Date t_date, String t_description) {
		this.setId(t_id);
		this.setDate(t_date);
		this.setDescription(t_description);
	}
	
	/**
	 * 
	 * @param t_description A description of the appointment. Limited to 50 characters. Must not be null and must not be blank.
	 * @return Appointment The current Appointment object for method chaining.
	 */
	
	public Appointment setDescription(String t_description) {
		if(t_description == null || t_description.isBlank() || t_description.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		
		this.m_appointmentDescription = t_description;
		return this;
	}
	
	/**
	 * 
	 * @return String The description of the appointment.
	 */
	
	public String getDescription() {
		return this.m_appointmentDescription;
	}
	
	/**
	 * 
	 * @param t_date The date of the appointment. Must not be in the past. Must not be null.
	 * @return Appointment The current Appointment object for method chaining.
	 */
	
	public Appointment setDate(Date t_date) {
		if(t_date == null) {
			throw new IllegalArgumentException("Invalid date");
		}
		if(t_date.before(new Date())) {
			throw new IllegalArgumentException("Date cannot be in the past");
		}
		
		this.m_appointmentDate = t_date;
		return this;
	}
	
	/**
	 * 
	 * @return Date The date of the appointment.
	 */
	
	public Date getDate() {
		return this.m_appointmentDate;
	}
	
	/**
	 * 
	 * @param t_id The id of the appointment. Limited to 10 characters. Must not be null and must not be blank.
	 * @return Appointment The current Appointment object for method chaining.
	 */
	
	private Appointment setId(String t_id) {
		if(t_id == null || t_id.isBlank() || t_id.length() > 10) {
			throw new IllegalArgumentException("Invalid id");
		}
		this.m_appointmentId = t_id;
		return this;
	}
	
	/**
	 * 
	 * @return String The id of the appointment.
	 */
	
	public String getId() {
		return this.m_appointmentId;
	}
	
	
	private String m_appointmentId;
	private Date m_appointmentDate;
	private String m_appointmentDescription;
}
