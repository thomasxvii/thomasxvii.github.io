"""
Michael Thomas
CS 499
5/25/2025
test_appointment.py
Application for testing appointments
"""

import pytest
from datetime import datetime, timedelta
from appointment import Appointment

def future_date(days=1):
    return datetime.now() + timedelta(days=days)

def past_date(days=1):
    return datetime.now() - timedelta(days=days)

def test_create_valid_appointment():
    appointment = Appointment("12345", future_date(), "Initial appointment")
    assert appointment.id == "12345"
    assert appointment.description == "Initial appointment"

def test_invalid_id_length():
    with pytest.raises(ValueError):
        Appointment("12345678901", future_date(), "Valid description")

def test_invalid_description_length():
    with pytest.raises(ValueError):
        Appointment("123", future_date(), "x" * 51)

def test_past_date_not_allowed():
    with pytest.raises(ValueError):
        Appointment("123", past_date(), "Test description")

def test_update_date_valid():
    appointment = Appointment("123", future_date(2), "Description")
    new_date = future_date(5)
    appointment.update(date=new_date)
    assert appointment.date == new_date

def test_update_description_valid():
    appointment = Appointment("123", future_date(2), "Old Description")
    new_description = "Updated Description"
    appointment.update(description=new_description)
    assert appointment.description == new_description

def test_update_with_invalid_description():
    appointment = Appointment("123", future_date(2), "Valid")
    with pytest.raises(ValueError):
        appointment.update(description=None)

def test_update_with_past_date():
    appointment = Appointment("123", future_date(2), "Valid")
    with pytest.raises(ValueError):
        appointment.update(date=past_date())