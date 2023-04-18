package com.richwerks.TaskService;

/**
 * 
 * @author Chris Richards
 * @file Task.java
 * @date 03/23/2023
 *
 */
public class Task {
	public Task(String t_id, String t_name, String t_description) {
			this.setId(t_id);
			this.setName(t_name);
			this.setDescription(t_description);
		
	}
	
	/**
	 * 
	 * @return returns the ID of the Task
	 */
	public String getId() {
		return this.m_id;
	}
	
	/**
	 * 
	 * @param t_name The name of the task
	 * @return The instance of Task. This is for method chaining.
	 * @throws IllegalArgumentException
	 */
	public Task setName(String t_name) {
		
		if(t_name == null || t_name.isBlank() || t_name.length() > 20 ) {
			throw new IllegalArgumentException("Invalid Name");
		}
		this.m_name = t_name;
		return this;
	}
	
	/**
	 * 
	 * @return The name of the Task
	 */
	public String getName() {
		return this.m_name;
	}
	
	/**
	 * 
	 * @param t_description The description of the Task
	 * @return The instance of the Task. This is for method chaining.
	 * @throws IllegalArgumentException
	 */
	public Task setDescription(String t_description) {
		if(t_description == null || t_description.isBlank() || t_description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		this.m_description = t_description;
		return this;
	}
	
	/**
	 * 
	 * @return The description of the Task
	 */
	public String getDescription() {
		return this.m_description;
	}
	
	/**
	 * 
	 * @param t_id Set the ID of the Task. This can only be done via constructor.
	 * @return An instance of the Task. This is for method chaining.
	 */
	private Task setId(String t_id) {
		if(t_id == null || t_id.isBlank() || t_id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		this.m_id = t_id;
		return this;
	}
	
	private String m_id;
	private String m_name;
	private String m_description;
}
