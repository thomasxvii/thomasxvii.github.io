package mod3.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mod3.snhu.Contact;
import mod3.snhu.ContactService;

class ContactServiceTest {

	@Test
	void testAddContact() {
		Contact contact = new Contact("georgeW", "George", "Washington", "9135551776", "74 Independence Ave");
		Contact contact2 = new Contact("benF", "Benjamin", "Franklin", "8165551776", "57 Independence Ave");
		Contact contact3 = new Contact("thomasJ", "Thomas", "Jefferson", "4175551776", "35 Independence Ave");
		ContactService service = new ContactService();
		
		assertEquals(true, service.addContact(contact));
		assertEquals(true, service.addContact(contact2));
		assertEquals(false, service.addContact(contact2));
		assertEquals(true, service.addContact(contact3));
		assertEquals(false, service.addContact(contact3)); 
	}
	
	@Test
	void testDeleteContact() {
		Contact contact = new Contact("georgeW", "George", "Washington", "9135551776", "74 Independence Ave");
		Contact contact2 = new Contact("benF", "Benjamin", "Franklin", "8165551776", "57 Independence Ave");
		Contact contact3 = new Contact("thomasJ", "Thomas", "Jefferson", "4175551776", "35 Independence Ave");
		ContactService service = new ContactService();
		
		assertEquals(true, service.addContact(contact));
		assertEquals(true, service.addContact(contact2));
		assertEquals(true, service.addContact(contact3));
		assertEquals(true, service.deleteContact("georgeW"));
		assertEquals(true, service.deleteContact("benF"));
		assertEquals(true, service.deleteContact("thomasJ"));
	}
	
	@Test
	void testUpdateContactFirstName() {
		Contact contact = new Contact("georgeW", "George", "Washington", "9135551776", "74 Independence Ave");
		ContactService service = new ContactService();
		
		assertEquals(true, service.addContact(contact));
		
		//Test first name update
		assertEquals(true, service.updateContactFirstName("georgeW", "GeorgeAnt"));
		assertEquals(contact.getFirstName(), "GeorgeAnt");
	}
	
	@Test
	void testUpdateContactLastName() {
		Contact contact = new Contact("georgeW", "George", "Washington", "9135551776", "74 Independence Ave");
		ContactService service = new ContactService();
		
		assertEquals(true, service.addContact(contact));
		
		//Test last name update
		assertEquals(true, service.updateContactLastName("georgeW", "Wash"));
		assertEquals(contact.getLastName(), "Wash");
	}
	
	@Test
	void testUpdateContactPhone() {
		Contact contact = new Contact("georgeW", "George", "Washington", "9135551776", "74 Independence Ave");
		ContactService service = new ContactService(); 
		
		assertEquals(true, service.addContact(contact));
		
		//Test phone number update
		assertEquals(true, service.updateContactPhone("georgeW", "3165551776"));
		assertEquals(contact.getPhone(), "3165551776");
	}
	
	@Test
	void testUpdateContactAddress() {
		Contact contact = new Contact("georgeW", "George", "Washington", "9135551776", "74 Independence Ave");
		ContactService service = new ContactService();
		
		assertEquals(true, service.addContact(contact));
		
		//Test address update
		assertEquals(true, service.updateContactAddress("georgeW", "19 Independence Ave"));
		assertEquals(contact.getAddress(), "19 Independence Ave");
	}

}
