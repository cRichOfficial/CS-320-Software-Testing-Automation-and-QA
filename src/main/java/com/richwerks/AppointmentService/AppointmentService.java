package com.richwerks.AppointmentService;

import java.util.HashMap;
import com.richwerks.exceptions.*;

/**
 * 
 * @author Chris Richards
 * @file AppointmentService.java
 * @date 03/31/2023
 */

public class AppointmentService {
	
	/**
	 * Default constructor. Initializes HashMap<String, Appointment>
	 */
	
	public AppointmentService() {
		this.m_appointmentList = new HashMap<String, Appointment>();
	}
	
	/**
	 * 
	 * @param t_appointment The appointment to be added to the AppointmentService
	 * @return AppointmentService The current AppointmentService object for method chaining.
	 */
	
	public AppointmentService addAppointment(Appointment t_appointment) {
		if(t_appointment == null) {
			throw new IllegalArgumentException("Appointment cannot be null");
		}
		if(this.m_appointmentList.containsKey(t_appointment.getId())) {
			throw new DuplicateAppointmentException("Appointment already exists");
		}
		
		this.m_appointmentList.put(t_appointment.getId(), t_appointment);
		return this;
	}
	
	/**
	 * 
	 * @param t_id The id of the appointment to be deleted.
	 * @return AppointmentService The current AppointmentService object for method chaining.
	 */
	
	public AppointmentService deleteAppointment(String t_id) {
		if(t_id == null || t_id.isBlank() || t_id.length() > 10) {
			throw new IllegalArgumentException("Invalid id");
		}
		if(!this.m_appointmentList.containsKey(t_id)) {
			throw new AppointmentNotFoundException("Appointment not found");
		}
		
		this.m_appointmentList.remove(t_id);
		return this;
	}
	
	/**
	 * 
	 * @param t_id The id of the appointment to be retrieved.
	 * @return Appointment The appointment object retrieved from the HashMap<String, Appointment>
	 */
	
	public Appointment getAppointment(String t_id) {
		if(t_id == null || t_id.isBlank() || t_id.length() > 10) {
			throw new IllegalArgumentException("Invalid id");
		}
		
		return this.m_appointmentList.get(t_id);
	}
	
	private HashMap<String, Appointment> m_appointmentList;
}
