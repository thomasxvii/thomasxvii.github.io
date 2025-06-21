package mod3.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import mod3.snhu.Contact;

class ContactTest {

	@Test
	void testContact() {
		Contact contact = new Contact("georgeW", "George", "Washington", "9135551776", "74 Independence Ave");
		assertTrue(contact.getId().equals("georgeW"));
		assertTrue(contact.getFirstName().equals("George"));
		assertTrue(contact.getLastName().equals("Washington"));
		assertTrue(contact.getPhone().equals("9135551776"));
		assertTrue(contact.getAddress().equals("74 Independence Ave")); 
	}
	
	@Test
	void testContactIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("georgeWashington", "George", "Washington", "9135551776", "74 Independence Ave");
		});	
	}
	@Test
	void testContactIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "George", "Washington", "9135551776", "74 Independence Ave");
		});	
	}
	
	@Test
	void testContactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("georgeW", "GeorgeAnthony", "Washington", "9135551776", "74 Independence Ave");
		});	
	}
	
	@Test
	void testContactFirstNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("georgeW", null, "Washington", "9135551776", "74 Independence Ave");
		});	
	}
	
	@Test
	void testContactLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("georgeW", "George", "Washingtony", "9135551776", "74 Independence Ave");
		});	
	}
	
	@Test
	void testContactLastNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("georgeW", "George", null, "9135551776", "74 Independence Ave");
		});	
	}
	
	@Test
	void testContactPhoneWrongLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("georgeW", "George", "Washington", "19135551776", "74 Independence Ave");
		});	
	}
	
	@Test
	void testContactPhoneIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("georgeW", "George", "Washington", null, "74 Independence Ave");
		});	
	}
	
	@Test
	void testContactAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("georgeW", "George", "Washington", "9135551776", "74 Independence Ave, Kansas City");
		});	
	}
	
	@Test
	void testContactAddressIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("georgeW", "George", "Washington", "9135551776", null);
		});	
	}
}
