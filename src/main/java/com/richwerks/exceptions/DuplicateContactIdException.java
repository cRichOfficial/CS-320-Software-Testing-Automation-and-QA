package com.richwerks.exceptions;

public class DuplicateContactIdException extends IllegalArgumentException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6371723610826112501L;

	public DuplicateContactIdException(String message) {
		super(message);
	}
}
