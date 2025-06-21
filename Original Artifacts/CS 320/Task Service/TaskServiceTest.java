package mod4.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mod4.snhu.Task;
import mod4.snhu.TaskService;

class TaskServiceTest {

	@Test
	void testAddTask() {
		Task task = new Task("12345", "First Task", "Initial task created for testing");
		Task task2 = new Task("123456", "Second Task", "Second task created for testing");
		Task task3 = new Task("1234567", "Third Task", "Third task created for testing");
		TaskService service = new TaskService();
		
		assertEquals(true, service.addTask(task));
		assertEquals(true, service.addTask(task2));
		assertEquals(false, service.addTask(task2));
		assertEquals(true, service.addTask(task3));
		assertEquals(false, service.addTask(task3)); 
	}
	
	@Test
	void testDeleteTask() {
		Task task = new Task("12345", "First Task", "Initial task created for testing");
		Task task2 = new Task("123456", "Second Task", "Second task created for testing");
		Task task3 = new Task("1234567", "Third Task", "Third task created for testing");
		TaskService service = new TaskService();
		
		assertEquals(true, service.addTask(task));
		assertEquals(true, service.addTask(task2));
		assertEquals(true, service.addTask(task3));
		assertEquals(true, service.deleteTask("12345"));
		assertEquals(true, service.deleteTask("123456"));
		assertEquals(true, service.deleteTask("1234567"));
	}
	
	@Test
	void testUpdateTaskName() {
		Task task = new Task("12345", "First Task", "Initial task created for testing");
		TaskService service = new TaskService();
		
		assertEquals(true, service.addTask(task));
		
		//Test task name update
		assertEquals(true, service.updateName("12345", "Initial Task"));
		assertEquals(task.getName(), "Initial Task");
	}
	
	@Test
	void testUpdateTaskDescription() {
		Task task = new Task("12345", "First Task", "Initial task created for testing");
		TaskService service = new TaskService();
		
		assertEquals(true, service.addTask(task));
		
		//Test task description update
		assertEquals(true, service.updateDescription("12345", "First task created for testing"));
		assertEquals(task.getDescription(), "First task created for testing");
	}
}
