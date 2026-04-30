package model;

public class Patient implements Comparable<Patient>{
	private String name;
	private String surname;
	private int priority;
	
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Patient() {}
	
	public Patient(String newName, String newSurname , int newPriority) {
		setName(newSurname);
		setSurname(newSurname);
		setPriority(newPriority);
	}
	
	
	public String toString() {
		return name + " " + priority;
	}
	
	@Override
	public int compareTo(Patient arg) {
		if(priority > arg.priority) {
			return 1;
		}
		else if(priority < arg.priority) {
			return -1;
		}
		else
		{
			return 0;
		}
	}
}
