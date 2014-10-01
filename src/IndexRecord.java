/**
 * Stefano Prezioso
 * COSC 311 Project 1
 * Fall 2014
 */

/**
 * Contains a String named "data" and an int reference to the index of the
 * record in the database.
 * 
 */
public class IndexRecord {
	private String data;
	private int databaseIndex;

	public IndexRecord(String data, int databaseIndex) {
		this.data = data.toLowerCase();
		this.databaseIndex = databaseIndex;
	}

	public String getData() {
		return data;
	}

	public int getDatabaseIndex() {
		return databaseIndex;
	}

	@Override
	public String toString() {
		return data + " " + databaseIndex;
	}

}
