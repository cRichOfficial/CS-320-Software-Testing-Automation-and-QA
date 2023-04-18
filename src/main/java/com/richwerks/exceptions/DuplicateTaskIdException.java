package com.richwerks.exceptions;

/**
 * 
 * @author Chris Richards
 * @file DuplicateTaskIdException.java
 * @date 03/23/2023
 *
 */

public class DuplicateTaskIdException extends IllegalArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5242028901907321733L;
	public DuplicateTaskIdException(String message) {
		super(message);
	}
}
