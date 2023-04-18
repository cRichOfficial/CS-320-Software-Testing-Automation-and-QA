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

/**
 * 
 * @author Chris Richards
 * @file TaskTest.java
 * @date 03/23/2023
 *
 */

class TaskTest {
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
	 */
	@BeforeEach
	void setUp(TestInfo testInfo) throws Exception {
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
	 * Testing the Task Constructor
	 */
	@Test
	@DisplayName("Task Constructor Test")
	void testTask() {
		Task task = new Task("0123456789", "Test Task Name", "Test Task Descpription for testing.");
		assertTrue(task.getId().equals("0123456789"));
		assertTrue(task.getName().equals("Test Task Name"));
		assertTrue(task.getDescription().equals("Test Task Descpription for testing."));
		assertThrows(IllegalArgumentException.class, ()->{
			new Task("0123456789000", "Task1", "The first Task");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new Task("          ", "Task1", "The first Task");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new Task(null, "Task1", "The first Task");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new Task("0123456789", "Task1ThatIsOver20Characters", "The first Task");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new Task("0123456789", "          ", "The first Task");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new Task("0123456789", null, "The first Task");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new Task("0123456789", "Task1", "The first Task that is going to be over 50 characters to test for length and stuff.");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new Task("0123456789", "Task1", "             ");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new Task("0123456789", "Task1", null);
		});
	}

	/**
	 * Testing the setName method
	 */
	@Test
	@DisplayName("setName")
	void testTaskSetName() {
		Task task = new Task("0123456789", "Task1", "This is the first task");
		task.setName("Task2");
		assertTrue(task.getName().equals("Task2"));
		assertThrows(IllegalArgumentException.class, ()->{
			task.setName("This is a name that is over 20 characters long");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			task.setName("            ");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			task.setName(null);
		});
	}
	
	/**
	 * Testing the setDescription method
	 */
	@Test
	@DisplayName("setDescription")
	void testTaskSetDescription() {
		Task task = new Task("0123456789", "Task1", "This is the first task");
		task.setDescription("This is the second task.");
		assertTrue(task.getDescription().equals("This is the second task."));
		assertThrows(IllegalArgumentException.class, ()->{
			task.setDescription("This is a task description that is over 50 characters long and should throw an exception.");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			task.setDescription("      ");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			task.setDescription("                                                                 ");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			task.setDescription(null);
		});
	}

}
