package com.richwerks.exceptions;

public class DuplicateAppointmentException extends IllegalArgumentException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3158501441034113258L;
	public DuplicateAppointmentException(String message) {
		super(message);
	}

}
