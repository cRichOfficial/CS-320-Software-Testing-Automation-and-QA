package com.richwerks.exceptions;

public class ContactNotFoundException extends IllegalArgumentException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -763934524255305724L;

	public ContactNotFoundException(String message) {
		super(message);
	}
}
