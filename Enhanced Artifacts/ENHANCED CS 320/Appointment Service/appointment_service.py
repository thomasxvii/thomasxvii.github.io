"""
Michael Thomas
CS 499
5/25/2025
appointment_service.py
Appointment application for adding, deleting, and updating appointments
"""

from typing import List, Optional
from appointment import Appointment

class AppointmentService:
    def __init__(self):
        self.appointments: List[Appointment] = []

    def add_appointment(self, appointment: Appointment) -> bool:
        # Ensure appointment ID is unique
        if any(existing.get_id() == appointment.get_id() for existing in self.appointments):
            return False
        self.appointments.append(appointment)
        return True

    def delete_appointment(self, appointment_id: str) -> bool:
        for appointment in self.appointments:
            if appointment.get_id() == appointment_id:
                self.appointments.remove(appointment)
                return True
        return False

    def update_appointment(self, appointment_id: str, new_date=None, new_description=None) -> bool:
        # Update the appointment with new date and/or description if it exists
        for appointment in self.appointments:
            if appointment.get_id() == appointment_id:
                if new_date:
                    appointment.set_date(new_date)
                if new_description:
                    appointment.set_description(new_description)
                return True
        return False

    def get_appointment_by_id(self, appointment_id: str) -> Optional[Appointment]:
        # Retrieve an appointment by ID if it exists
        for appointment in self.appointments:
            if appointment.get_id() == appointment_id:
                return appointment
        return None
