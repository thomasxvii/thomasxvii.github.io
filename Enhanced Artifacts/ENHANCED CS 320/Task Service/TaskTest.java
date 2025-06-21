package mod4.testing;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import mod4.snhu.Task;

class TaskTest {

	@Test
	void testTask() {
		Task task = new Task("12345", "First Task", "Initial task created for testing");
		assertTrue(task.getId().equals("12345"));
		assertTrue(task.getName().equals("First Task"));
		assertTrue(task.getDescription().equals("Initial task created for testing"));
	}
	
	@Test
	void testTaskIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345678910", "First Task", "Initial task created for testing");
		});	
	}
	@Test
	void testTaskIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "First Task", "Initial task created for testing");
		});	
	}
	
	@Test
	void testTaskNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345", "First Task Ever Created", "Initial task created for testing");
		});	
	}
	
	@Test
	void testTaskNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345", null, "Initial task created for testing");
		});	
	}
	
	@Test
	void testTaskDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345", "First Task", "This is the initial task created for testing at the start of program creation.");
		});	
	}
	
	@Test
	void testTaskDescriptionIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345", "First Task", null);
		});	
	}
}
