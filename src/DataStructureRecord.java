/**
 * Stefano Prezioso 
 * COSC 311 
 * Project 1 
 * Fall 2014
 */

public class DataStructureRecord {
	private String firstName;
	private String lastName;
	private String ID;

	public DataStructureRecord() {
		firstName = "";
		lastName = "";
		ID = "";
	}

	public DataStructureRecord(String firstName, String lastName, String ID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ID = ID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getID() {
		return ID;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + " " + ID;
	}
}
