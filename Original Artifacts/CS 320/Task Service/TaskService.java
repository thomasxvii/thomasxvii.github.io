package mod4.snhu;
import java.util.ArrayList;

public class TaskService {
	
	ArrayList<Task> list = new ArrayList<Task>();
	
	//ID must be unique
	public boolean addTask(Task task) {
		boolean didAdd = false; 
		
		//Empty list
		if (list.size() == 0) {
			list.add(task);
			didAdd = true;
		}
		else {
			for(Task t : list) {
				if (task.getId().equalsIgnoreCase(t.getId())) {
					return didAdd;
				}
			}//End for Loop
			list.add(task);
			didAdd = true;
		}
		return didAdd;
	}
	public boolean deleteTask (String id) {
		boolean didRemove = false;
		for(Task t : list) {
			if (t.getId().equalsIgnoreCase(t.getId())) {
				didRemove = list.remove(t);
				if(didRemove) {
					System.out.println("Task deleted.");
					return didRemove;
				}
			}
		}//End for Loop
		System.out.println("Unable to find task to delete.");
		return false;
	}
	public boolean updateName (String id, String name) {
		for (Task t : list) {
			if (t.getId().equals(id)) {
				t.setName(name);
				System.out.println("Task name updated.");
				return true;
			}
		}
		System.out.println("Unable to find task.");
		return false;
	}
	public boolean updateDescription (String id, String description) {
		for (Task t : list) {
			if (t.getId().equals(id)) {
				t.setDescription(description);
				System.out.println("Task description updated.");
				return true;
			}
		}
		System.out.println("Unable to find task.");
		return false;
	}
}// end class ContactService
