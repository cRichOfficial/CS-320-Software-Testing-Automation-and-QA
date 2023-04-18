package com.richwerks.exceptions;

/**
 * 
 * @author Chris Richards
 * @file TaskNotFoundException.java
 * @date 03/23/2023
 *
 */

public class TaskNotFoundException extends IllegalArgumentException {

	private static final long serialVersionUID = -3265625179149274334L;
	public TaskNotFoundException(String message) {
		super(message);
	}
}
