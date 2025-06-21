package mod5.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import mod5.snhu.Appointment;

class AppointmentTest {
	
	@Test
	void testAppointment() {
		String id = "12345";
		Calendar c = Calendar.getInstance();
		String description = "Initial good description";
		
		c.set(Calendar.MONTH, 11);
		c.set(Calendar.DATE, 05);
		c.set(Calendar.YEAR, 2025);
		
		Date goodDate = c.getTime();
		
		Appointment tempAppt = new Appointment(id, goodDate, description);
		
		assertTrue(tempAppt.getId().equals("12345")); 
		assertTrue(tempAppt.getDate().equals(goodDate));
		assertTrue(tempAppt.getDescription().equals("Initial good description"));
	}
	
	@Test
	void testAppointmentIdTooLong() {
		String id = "12345678910";
		Date date = new Date();
		String description = "Initial good description";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(id, date, description);
		});	
	}
	@Test
	void testAppointmentIdIsNull() {
		String id = null;
		Date date = new Date();
		String description = "Initial good description";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(id, date, description);
		});	
	}
	
	@Test
	void testAppointmentDateInPast() {
		String id = "12345";
		Calendar c = Calendar.getInstance();
		String description = "Initial good description";
		
		c.set(Calendar.MONTH, 11);
		c.set(Calendar.DATE, 05);
		c.set(Calendar.YEAR, 1990);
		
		Date badDate = c.getTime();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(id, badDate, description);
		});	
	}
	
	@Test
	void testAppointmentDateIsNull() {
		String id = "12345";
		Date badDate = null;
		String description = "Initial good description";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(id, badDate, description);
		});	
	}
	
	@Test
	void testAppointmentDescriptionTooLong() {
		String id = "12345";
		Date date = new Date();
		String badDescription = "This is the initial appointment created for testing at the start of program creation.";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(id, date, badDescription );
		});	
	}
	
	@Test
	void testAppointmentDescriptionIsNull() {
		String id = "12345";
		Date date = new Date();
		String badDescription = null;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(id, date, badDescription);
		});	
	}
}
