package mod5.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

import mod5.snhu.Appointment;
import mod5.snhu.AppointmentService;

class AppointmentServiceTest {

	@Test
	void testAddAppointment() {
		String id = "12345";
		String id2 = "123456";
		String id3 = "1234567";
		Calendar c = Calendar.getInstance();
		String description = "Initial good description";
		
		c.set(Calendar.MONTH, 11);
		c.set(Calendar.DATE, 05);
		c.set(Calendar.YEAR, 2025);
		
		Date goodDate = c.getTime();
		
		Appointment appt = new Appointment(id, goodDate, description);
		Appointment appt2 = new Appointment(id2, goodDate, description);
		Appointment appt3 = new Appointment(id3, goodDate, description);
		AppointmentService apptService = new AppointmentService();
		
		assertEquals(true, apptService.addAppointment(appt));
		assertEquals(true, apptService.addAppointment(appt2));
		assertEquals(false, apptService.addAppointment(appt2));
		assertEquals(true, apptService.addAppointment(appt3));
		assertEquals(false, apptService.addAppointment(appt3)); 
	}
	
	@Test
	void testDeleteAppointment() {
		String id = "12345";
		String id2 = "123456";
		String id3 = "1234567";
		Calendar c = Calendar.getInstance();
		String description = "Initial good description";
		
		c.set(Calendar.MONTH, 11);
		c.set(Calendar.DATE, 05);
		c.set(Calendar.YEAR, 2025);
		
		Date goodDate = c.getTime();
		
		Appointment appt = new Appointment(id, goodDate, description);
		Appointment appt2 = new Appointment(id2, goodDate, description);
		Appointment appt3 = new Appointment(id3, goodDate, description);
		AppointmentService apptService = new AppointmentService();
		
		assertEquals(true, apptService.addAppointment(appt));
		assertEquals(true, apptService.addAppointment(appt2));
		assertEquals(true, apptService.addAppointment(appt3));
		assertEquals(true, apptService.deleteAppointment(id));
		assertEquals(true, apptService.deleteAppointment(id2));
		assertEquals(true, apptService.deleteAppointment(id3));
	}


}
