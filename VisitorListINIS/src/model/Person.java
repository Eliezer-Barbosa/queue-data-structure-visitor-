package model;

import java.time.LocalDate;

import model.enums.PriorityLevel;

public class Person {
	
	private Integer id;
	private String firstName;
	private String lastName;
	private String passportNumber;
	private String priorityLevel;
	private LocalDate dateOfArrival;
	private static int count = 0;
	private int level;
	
	public Person(Integer id, String firstName, String lastName, String passportNumber, String priorityLevel) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.passportNumber = passportNumber;
		this.priorityLevel = priorityLevel.toString();
		//this.id = (int) (Math.random() * 1000 + 1);
		//count++;
		//this.id = count;
		
		if (this.getPriorityLevel().equals("HIGH"))
			this.setLevel(3);
		if (this.getPriorityLevel().equals("MEDIUM"))
			this.setLevel(2);
		if (this.getPriorityLevel().equals("LOW"))
			this.setLevel(1);
		
	}
	
	public Person(String firstName, String lastName, String passportNumber, String priorityLevel) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.passportNumber = passportNumber;
		this.priorityLevel = priorityLevel.toString();
		//this.id = (int) (Math.random() * 1000 + 1);
		//count++;
		//this.id = count;
		
		if (this.getPriorityLevel().equals("HIGH"))
			this.setLevel(3);
		if (this.getPriorityLevel().equals("MEDIUM"))
			this.setLevel(2);
		if (this.getPriorityLevel().equals("LOW"))
			this.setLevel(1);
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfArrival() {
		return dateOfArrival;
	}

	public void setDateOfArrival(LocalDate dateOfArrival) {
		this.dateOfArrival = dateOfArrival;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getPriorityLevel() {
		return priorityLevel;
	}

	public void setPriorityLevel(String priorityLevel) {
		this.priorityLevel = priorityLevel;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		
		return "ID: " + this.getId() + " Name: " + this.getFirstName();
	}
	
}
