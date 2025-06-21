"""
Michael Thomas
CS 499
5/25/2025
appointment.py
Appointment class definement 
"""

from datetime import datetime

class Appointment:
    def __init__(self, appointment_id: str, date: datetime, description: str):
        if not appointment_id or len(appointment_id) > 10:
            raise ValueError("Invalid ID: Must be non-empty and <= 10 characters")
        if not date:
            raise ValueError("Invalid date: Cannot be null")
        if date < datetime.now():
            raise ValueError("Invalid date: Cannot be in the past")
        if not description or len(description) > 50:
            raise ValueError("Invalid description: Must be non-empty and <= 50 characters")

        self.id = appointment_id
        self.date = date
        self.description = description

    def set_date(self, new_date: datetime):
        if not new_date:
            raise ValueError("Invalid date: Cannot be null")
        if new_date < datetime.now():
            raise ValueError("Invalid date: Cannot be in the past")
        self.date = new_date

    def set_description(self, new_description: str):
        if not new_description or len(new_description) > 50:
            raise ValueError("Invalid description: Must be non-empty and <= 50 characters")
        self.description = new_description

    def get_id(self):
        return self.id

    def get_date(self):
        return self.date

    def get_description(self):
        return self.description
