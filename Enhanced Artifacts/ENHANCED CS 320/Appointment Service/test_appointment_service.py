"""
Michael Thomas
CS 499
5/25/2025
test_appointment_service.py
Application for testing appointment service
"""

import pytest
from datetime import datetime, timedelta
from appointment import Appointment
from appointment_service import AppointmentService

def future_date(days=1):
    return datetime.now() + timedelta(days=days)

def test_add_and_delete_appointment():
    service = AppointmentService()
    appointment = Appointment("1", future_date(), "Test Desc")
    assert service.add_appointment(appointment) is True
    assert service.delete_appointment("1") is True

def test_add_duplicate_appointment():
    service = AppointmentService()
    appt1 = Appointment("1", future_date(), "Test")
    appt2 = Appointment("1", future_date(), "Another Test")
    service.add_appointment(appt1)
    assert service.add_appointment(appt2) is False

def test_delete_nonexistent_appointment():
    service = AppointmentService()
    assert service.delete_appointment("999") is False

def test_update_appointment_success():
    service = AppointmentService()
    appointment = Appointment("2", future_date(2), "Original")
    service.add_appointment(appointment)

    new_date = future_date(5)
    new_description = "Updated"
    result = service.update_appointment("2", new_date=new_date, new_description=new_description)

    assert result is True
    assert appointment.date == new_date
    assert appointment.description == new_description

def test_update_nonexistent_appointment():
    service = AppointmentService()
    new_date = future_date(3)
    result = service.update_appointment("nonexistent", new_date=new_date)
    assert result is False