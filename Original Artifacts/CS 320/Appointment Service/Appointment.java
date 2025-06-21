package mod5.snhu;

import java.util.Date;

public class Appointment {
	private String id;
	private String description;
	private Date date;
	
	public Appointment(String id, Date d, String desc) {
		Date today = new Date();
		
		if (id == null || id.length()>10) {
			throw new IllegalArgumentException("Invalid id");
		}
		if (d == null) {
			throw new IllegalArgumentException("Invalid date, date is null");
		}
		else if(d.before(today)) {
			throw new IllegalArgumentException("Invalid date, past date");
		}
		if (desc == null || desc.length()>50) {
			throw new IllegalArgumentException("Invalid description");
		}
		
		this.id = id;
		this.date = d;
		this.description = desc;
	}
	public String getId() {
		return id;
	}
	
	public Date getDate() {return date;}
	
	public void setDate(Date d) {
		Date today = new Date ();
		if (d == null) {
			throw new IllegalArgumentException("Invalid date, date is null");
		}
		else if(d.before(today)) {
			throw new IllegalArgumentException("Invalid date, past date");
		}
		this.date = d;
	}
	
	public String getDescription() {return description;}
	
	public void setDescription(String description) {
		if (description == null || description.length()>50) {
			throw new IllegalArgumentException("Invalid description");
		}
		this.description = description;
	}
	
}