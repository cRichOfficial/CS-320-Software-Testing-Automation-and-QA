package com.richwerks.TaskService;

import com.richwerks.exceptions.*;
import java.util.HashMap;

/**
 * 
 * @author Chris Richards
 * @file TaskService.java
 * @date 03/23/2023
 *
 */

public class TaskService {
	public TaskService() {
		this.m_taskList = new HashMap<String, Task>();
	}
	
	public TaskService addTask(Task t_task) {
		if(t_task == null) {
			throw new IllegalArgumentException("Invalid conact");
		}
		if(this.m_taskList.containsKey(t_task.getId())) {
			throw new DuplicateTaskIdException("Contact already exists");
		}
		this.m_taskList.put(t_task.getId(), t_task);
		return this;
	}
	
	public Task getTask(String t_id) {
		if(t_id == null || t_id.isBlank() || t_id.length() > 10) {
			throw new IllegalArgumentException("Invalid id");
		}
		
		return this.m_taskList.get(t_id);
	}
	
	public TaskService deleteTask(String t_id) {
		if(t_id == null || t_id.isBlank() || t_id.length() > 10) {
			throw new IllegalArgumentException("Invalid id");
		}
		if(!this.m_taskList.containsKey(t_id)) {
			throw new TaskNotFoundException("Task not found");
		}
		this.m_taskList.remove(t_id);
		return this;
	}
	
	public TaskService updateTaskName(String t_id, String t_name) {
		if(!this.m_taskList.containsKey(t_id)) {
			throw new TaskNotFoundException("Task not found");
		}
		this.m_taskList.get(t_id).setName(t_name);
		return this;
	}
	
	public TaskService updateTaskDescription(String t_id, String t_description) {
		if(!this.m_taskList.containsKey(t_id)) {
			throw new TaskNotFoundException("Task not found");
		}
		this.m_taskList.get(t_id).setDescription(t_description);
		return this;
	}
	
	
	private HashMap<String, Task> m_taskList;
}
