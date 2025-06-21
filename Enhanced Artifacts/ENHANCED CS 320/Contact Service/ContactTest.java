/* 
 * Michael Thomas
 * CS 499
 * 6/1/2025
 * ContactTest.java
 * Application for testing the adding, deleting, and updating of contacts
*/

package mod3.testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {

    private ContactService service;

    @BeforeEach
    public void setup() {
        service = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("001", "John", "Doe", "1234567890", "123 Main St");
        assertTrue(service.addContact(contact));
        assertFalse(service.addContact(contact)); // Duplicate ID should fail
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("002", "Jane", "Doe", "0987654321", "456 Elm St");
        service.addContact(contact);
        assertTrue(service.deleteContact("002"));
        assertFalse(service.deleteContact("002")); // Already deleted
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("003", "Mike", "Smith", "5555555555", "789 Oak St");
        service.addContact(contact);

        assertTrue(service.updateContact("003", "Mikey", "Smithers", "6666666666", "999 Pine Rd"));
        Contact updated = service.getContactById("003");
        assertEquals("Mikey", updated.getFirstName());
        assertEquals("Smithers", updated.getLastName());
        assertEquals("6666666666", updated.getPhone());
        assertEquals("999 Pine Rd", updated.getAddress());
    }

    @Test
    public void testUpdateNonexistentContact() {
        assertFalse(service.updateContact("999", "Test", "User", "0000000000", "Nowhere"));
    }

    @Test
    public void testGetContactById() {
        Contact contact = new Contact("004", "Anna", "Jones", "1112223333", "101 Maple Ave");
        service.addContact(contact);
        assertNotNull(service.getContactById("004"));
        assertNull(service.getContactById("999")); // Non-existent
    }
}