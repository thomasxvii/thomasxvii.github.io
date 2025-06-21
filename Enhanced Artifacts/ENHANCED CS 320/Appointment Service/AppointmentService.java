/* 
 * Michael Thomas
 * CS 499
 * 5/25/2025
 * AppointmentService.java
 * Application for adding, deleting, and updating appointments
*/

package mod5.snhu;
import java.util.*;

/**
 * Service class for managing appointments.
 */
public class AppointmentService {
    private final List<Appointment> appointments = new ArrayList<>(); // Stores the list of appointments

    /**
     * Adds a new appointment if the ID is unique.
     * @param appointment Appointment to add
     * @return true if added, false if duplicate ID
     */
    public boolean addAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null");
        }

        // Check for uniqueness of ID
        for (Appointment existing : appointments) {
            if (existing.getId().equalsIgnoreCase(appointment.getId())) {
                return false; // Duplicate ID found
            }
        }

        appointments.add(appointment); // Add appointment
        return true;
    }

    /**
     * Deletes an appointment by ID.
     * @param id ID of the appointment to delete
     * @return true if deleted, false if not found
     */
    public boolean deleteAppointment(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Invalid ID: cannot be null or blank");
        }

        Iterator<Appointment> iterator = appointments.iterator();
        while (iterator.hasNext()) {
            Appointment appointment = iterator.next();
            if (appointment.getId().equalsIgnoreCase(id)) {
                iterator.remove();
                return true; // Successfully removed
            }
        }

        return false; // ID not found
    }
}
