package com.richwerks.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import com.richwerks.TaskService.Task;
import com.richwerks.TaskService.TaskService;
import com.richwerks.exceptions.DuplicateTaskIdException;
import com.richwerks.exceptions.TaskNotFoundException;

/**
 * 
 * @author Chris Richards
 * @file TaskServiceTest.java
 * @date 03/23/2023
 *
 */

class TaskServiceTest {

	/**
	 * TaskService member for the TaskServiceTest. 
	 */
	private TaskService taskService;
	
	/**
	 * 
	 * @throws Exception
	 * Setting up the test before class creation.
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Starting tests...");
	}

	/**
	 * 
	 * @throws Exception
	 * Cleaning up after the test.
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Testing finished.");
	}

	/**
	 * 
	 * @param testInfo
	 * @throws Exception
	 * Setting up for each test.
	 * Initializing taskService and adding back the entries before each test.
	 */
	@BeforeEach
	void setUp(TestInfo testInfo) throws Exception {
		System.out.println("Preparing TaskService for test...");
		this.taskService = new TaskService();
		taskService.addTask(new Task("0123456789", "Test Task 1", "The first task to be added for the test."));
		taskService.addTask(new Task("9876543210", "Test Task 2", "The second task to be added for the test."));
		System.out.println(String.format("Running test %s...", testInfo.getDisplayName()));
	}

	/**
	 * 
	 * @param testInfo
	 * @throws Exception
	 * Cleaning up after each test.
	 */
	@AfterEach
	void tearDown(TestInfo testInfo) throws Exception {
		System.out.println(String.format("Test %s finished.", testInfo.getDisplayName()));
	}
 
	/**
	 * Testing the constructor
	 */
	@Test
	@DisplayName("Constructor")
	void testTaskService() {
		TaskService taskService = new TaskService();
		assertNotNull(taskService);
	}
	
	/**
	 * Testing the addTask method
	 */
	@Test
	@DisplayName("addTask")
	void testTaskServiceAddTask() {
		Task task = new Task("0012235450", "Add Task Test", "This task is to test adding a task.");
		this.taskService.addTask(task);
		assertNotNull(this.taskService.getTask(task.getId()));
		assertThrows(IllegalArgumentException.class, ()->{
			this.taskService.addTask(null);
		});
		assertThrows(DuplicateTaskIdException.class, ()->{
			this.taskService.addTask(new Task("0123456789", "Duplicate Task", "This task is to test duplicate tasks."));
		});
	}
	
	/**
	 * Testing the getTask method
	 */
	@Test
	@DisplayName("getTask")
	void testTaskServiceGetTask() {
		assertNotNull(this.taskService.getTask("9876543210"));
		assertNull(this.taskService.getTask("0000"));
		assertThrows(IllegalArgumentException.class, ()->{
			this.taskService.getTask("01234567890");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			this.taskService.getTask("      ");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			this.taskService.getTask(null);
		});
	}

	/**
	 * Testing the deleteTask method
	 */
	@Test
	@DisplayName("deleteTask")
	void testTaskServiceDeleteTask() {
		this.taskService.deleteTask("0123456789");
		assertNull(this.taskService.getTask("0123456789"));
		assertThrows(IllegalArgumentException.class, ()->{
			this.taskService.deleteTask("012345678900");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			this.taskService.deleteTask("     ");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			this.taskService.deleteTask(null);
		});
		assertThrows(TaskNotFoundException.class, ()->{
			this.taskService.deleteTask("000");
		});
	}
	
	/**
	 * Testing the updateTaskName method
	 */
	@Test
	@DisplayName("updateTaskName")
	void testTaskServiceUpdateTaskName() {
		this.taskService.updateTaskName("0123456789", "Update Task");
		assertTrue(this.taskService.getTask("0123456789").getName().equals("Update Task"));
		assertThrows(IllegalArgumentException.class, ()->{
			this.taskService.updateTaskName("012345678900", "Update Task");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			this.taskService.updateTaskName("     ", "Update Task");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			this.taskService.updateTaskName(null, "Update Task");
		});
		assertThrows(TaskNotFoundException.class, ()->{
			this.taskService.updateTaskName("0000", "Update Task");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			this.taskService.updateTaskName("0123456789", "Update Task Name Longer Than 20 Characters");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			this.taskService.updateTaskName("0123456789", "     ");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			this.taskService.updateTaskName("0123456789", null);
		});
	}
	
	/**
	 * Testing the updateTaskDescription method
	 */
	@Test
	@DisplayName("updateTaskDescription")
	void testTaskServiceUpdateTaskDescription() {
		this.taskService.updateTaskDescription("0123456789", "This is an updated task description.");
		assertTrue(this.taskService.getTask("0123456789").getDescription().equals("This is an updated task description."));
		assertThrows(IllegalArgumentException.class, ()->{
			this.taskService.updateTaskDescription("0123456789000", "This is an updated task description.");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			this.taskService.updateTaskDescription("     ", "This is an updated task description.");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			this.taskService.updateTaskDescription(null, "This is an updated task description.");
		});
		assertThrows(TaskNotFoundException.class, ()->{
			this.taskService.updateTaskDescription("041645", "This is an updated task description.");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			this.taskService.updateTaskDescription("0123456789", "This is an updated task description that is longer than 50 characters.");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			this.taskService.updateTaskDescription("0123456789", "     ");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			this.taskService.updateTaskDescription("0123456789", null);
		});
	}
}
