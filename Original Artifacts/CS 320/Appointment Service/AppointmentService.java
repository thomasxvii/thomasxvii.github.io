package mod5.snhu;
import java.util.ArrayList;

public class AppointmentService {
	
	ArrayList<Appointment> list = new ArrayList<Appointment>();
	
	//ID must be unique
	public boolean addAppointment(Appointment appointment) {
		boolean didAdd = false; 
		
		//Empty list
		if (list.size() == 0) {
			list.add(appointment);
			didAdd = true;
		}
		else {
			for(Appointment a : list) {
				if (appointment.getId().equalsIgnoreCase(a.getId())) {
					return didAdd;
				}
			}//End for Loop
			list.add(appointment);
			didAdd = true;
		}
		return didAdd;
	}
	public boolean deleteAppointment (String id) {
		boolean didRemove = false;
		for(Appointment a : list) {
			if (a.getId().equalsIgnoreCase(a.getId())) {
				didRemove = list.remove(a);
				if(didRemove) {
					System.out.println("Appointment deleted.");
					return didRemove;
				}
			}
		}//End for Loop
		System.out.println("Unable to find appointment to delete.");
		return false;
	}
}// end class AppointmentService