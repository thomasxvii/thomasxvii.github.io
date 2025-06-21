/* 
 * Michael Thomas
 * CS 499
 * 6/1/2025
 * ContactService.java
 * Application for adding, deleting, and updating contacts
*/

package mod3.snhu;
import java.util.HashMap;
import java.util.Map;

// Manages contacts using a HashMap for efficient lookup, addition, and deletion.
public class ContactService {

    // Use HashMap for O(1) average-time complexity on lookup
    private final Map<String, Contact> contacts = new HashMap<>();

    // Adds a new contact if the ID is not already present
    public boolean addContact(Contact contact) {
        if (contact == null || contacts.containsKey(contact.getId())) {
            return false;
        }
        contacts.put(contact.getId(), contact);
        return true;
    }

    // Deletes a contact based on the ID
    public boolean deleteContact(String id) {
        return contacts.remove(id) != null;
    }

    // Updates a contact’s fields if it exists
    public boolean updateContact(String id, String firstName, String lastName, String phone, String address) {
        Contact contact = getContactById(id);
        if (contact == null) {
            return false;
        }

        // Update fields using setters with validation
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhone(phone);
        contact.setAddress(address);
        return true;
    }

    // Returns a contact if it exists by ID
    public Contact getContactById(String id) {
        return contacts.get(id);
    }
}