/* 
 * Michael Thomas
 * CS 499
 * 6/1/2025
 * ContactServiceTest.java
 * Application for testing the adding, deleting, and updating of contacts with information
*/

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

        assertTrue(service.addContact(contact));
        assertTrue(service.addContact(contact2));
        assertFalse(service.addContact(contact2)); // Duplicate
        assertTrue(service.addContact(contact3));
        assertFalse(service.addContact(contact3)); // Duplicate
    }

    @Test
    void testDeleteContact() {
        Contact contact = new Contact("georgeW", "George", "Washington", "9135551776", "74 Independence Ave");
        Contact contact2 = new Contact("benF", "Benjamin", "Franklin", "8165551776", "57 Independence Ave");
        Contact contact3 = new Contact("thomasJ", "Thomas", "Jefferson", "4175551776", "35 Independence Ave");
        ContactService service = new ContactService();

        service.addContact(contact);
        service.addContact(contact2);
        service.addContact(contact3);

        assertTrue(service.deleteContact("georgeW"));
        assertTrue(service.deleteContact("benF"));
        assertTrue(service.deleteContact("thomasJ"));
        assertFalse(service.deleteContact("nonExistent")); // Non-existent
    }

    @Test
    void testUpdateContact() {
        Contact contact = new Contact("georgeW", "George", "Washington", "9135551776", "74 Independence Ave");
        ContactService service = new ContactService();
        service.addContact(contact);

        // Perform full update
        assertTrue(service.updateContact("georgeW", "GeorgeAnt", "Wash", "3165551776", "19 Independence Ave"));

        // Validate updates
        Contact updated = service.getContactById("georgeW");
        assertEquals("GeorgeAnt", updated.getFirstName());
        assertEquals("Wash", updated.getLastName());
        assertEquals("3165551776", updated.getPhone());
        assertEquals("19 Independence Ave", updated.getAddress());
    }

    @Test
    void testUpdateNonExistentContact() {
        ContactService service = new ContactService();

        // Attempt to update non-existent contact
        assertFalse(service.updateContact("notHere", "Test", "User", "9999999999", "Nowhere Street"));
    }
}