package com.richwerks.exceptions;

public class AppointmentNotFoundException extends IllegalArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6066696064410851732L;
	public AppointmentNotFoundException(String message) {
		super(message);
	}

}
