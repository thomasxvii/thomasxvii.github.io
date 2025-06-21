package mod3.snhu;
import java.util.ArrayList;

public class ContactService {
	
	ArrayList<Contact> list = new ArrayList<Contact>();
	
	//ID must be unique
	public boolean addContact(Contact contact) {
		boolean didAdd = false; 
		
		//Empty list
		if (list.size() == 0) {
			list.add(contact);
			didAdd = true;
		}
		else {
			for(Contact c : list) {
				if (contact.getId().equalsIgnoreCase(c.getId())) {
					return didAdd;
				}
			}//End for Loop
			list.add(contact);
			didAdd = true;
		}
		return didAdd;
	}
	public boolean deleteContact (String id) {
		boolean didRemove = false;
		for(Contact c : list) {
			if (c.getId().equalsIgnoreCase(c.getId())) {
				didRemove = list.remove(c);
				if(didRemove) {
					System.out.println("Contact deleted.");
					return didRemove;
				}
			}
		}//End for Loop
		System.out.println("Unable to find contact to delete.");
		return false;
	}
	
	public boolean updateContactFirstName (String id, String firstName) {
		for (Contact c : list) {
			if (c.getId().equals(id)) {
				c.setFirstName(firstName);
				System.out.println("Contact first name updated.");
				return true;
			}
		}
		System.out.println("Unable to find contact.");
		return false;
	}
	public boolean updateContactLastName (String id, String lastName) {
		for (Contact c : list) {
			if (c.getId().equals(id)) {
				c.setLastName(lastName);
				System.out.println("Contact last name updated.");
				return true;
			}
		}
		System.out.println("Unable to find contact.");
		return false;
	}
	public boolean updateContactPhone (String id, String phone) {
		for (Contact c : list) {
			if (c.getId().equals(id)) {
				c.setPhone(phone);
				System.out.println("Contact phone number updated.");
				return true;
			}
		}
		System.out.println("Unable to find contact.");
		return false;
	}
	public boolean updateContactAddress (String id, String address) {
		for (Contact c : list) {
			if (c.getId().equals(id)) {
				c.setAddress(address);
				System.out.println("Contact address updated.");
				return true;
			}
		}
		System.out.println("Unable to find contact.");
		return false;
	}
}// end class ContactService
