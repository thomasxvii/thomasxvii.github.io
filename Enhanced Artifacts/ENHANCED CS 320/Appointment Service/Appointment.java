/* 
 * Michael Thomas
 * CS 499
 * 5/25/2025
 * Appointment.java
 * Appointment class definement 
*/

package mod5.snhu;

import java.util.Date;

// Appointment class with validation and SOLID improvements
public class Appointment {
    private final String id; // Unique identifier for the appointment
    private Date date; // Date of the appointment
    private String description; // Description of the appointment

    /**
     * Constructor that validates and initializes an appointment.
     * @param id Unique ID (max 10 chars)
     * @param date Appointment date (must be in the future)
     * @param description Description (max 50 chars)
     */
    public Appointment(String id, Date date, String description) {
        validateId(id);
        validateDate(date);
        validateDescription(description);
        this.id = id;
        this.date = date;
        this.description = description;
    }

    /**
     * Gets the appointment ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the appointment date.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Updates the appointment date after validation.
     * @param date new appointment date
     */
    public void setDate(Date date) {
        validateDate(date);
        this.date = date;
    }

    /**
     * Gets the appointment description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Updates the appointment description after validation.
     * @param description new description
     */
    public void setDescription(String description) {
        validateDescription(description);
        this.description = description;
    }

    // Validates the appointment ID
    private void validateId(String id) {
        if (id == null || id.length() > 10) {
            throw new IllegalArgumentException("Invalid ID: must be non-null and <= 10 characters");
        }
    }

    // Validates that the appointment date is not null or in the past
    private void validateDate(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Invalid date: cannot be null");
        }
        if (date.before(new Date())) {
            throw new IllegalArgumentException("Invalid date: cannot be in the past");
        }
    }

    // Validates the appointment description
    private void validateDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description: must be non-null and <= 50 characters");
        }
    }
}