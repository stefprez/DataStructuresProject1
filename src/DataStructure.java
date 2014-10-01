/**
 * Stefano Prezioso
 * COSC 311 Project 1
 * Fall 2014
 */

import java.util.Scanner;

public class DataStructure {
	private DataStructureRecord[] database;
	private OrderedIndex firstNameIndex;
	private OrderedIndex lastNameIndex;
	private OrderedIndex IDIndex;
	private DeletedIndex deletedIndex;
	int numberOfRecords;

	public DataStructure() {
		database = new DataStructureRecord[200];
		firstNameIndex = new OrderedIndex();
		lastNameIndex = new OrderedIndex();
		IDIndex = new OrderedIndex();
		deletedIndex = new DeletedIndex();
		numberOfRecords = 0;
	}

	public DataStructure(int sizeOfDatabase) {
		database = new DataStructureRecord[sizeOfDatabase];
		firstNameIndex = new OrderedIndex(sizeOfDatabase);
		lastNameIndex = new OrderedIndex(sizeOfDatabase);
		IDIndex = new OrderedIndex(sizeOfDatabase);
		deletedIndex = new DeletedIndex(sizeOfDatabase);
		numberOfRecords = 0;
	}

	public OrderedIndex getFirstNameIndex() {
		return firstNameIndex;
	}

	public OrderedIndex getLastNameIndex() {
		return lastNameIndex;
	}

	public OrderedIndex getIDIndex() {
		return IDIndex;
	}

	public DeletedIndex getDeletedIndex() {
		return deletedIndex;
	}

	public DataStructureRecord getDatabaseRecord(int indexOfRecordToReturn) {
		return database[indexOfRecordToReturn];
	}

	public int getNumberOfRecords() {
		return numberOfRecords;
	}

	/**
	 * Finds and deletes a record with a matching ID
	 * 
	 * @param deleteID
	 *            ID to be deleted. Should be numeric, positive, and no more
	 *            than 9 digits long
	 * @return Index of deleted record or -1 if not found
	 */
	public int deleteRecord(String deleteID) {
		// Format ID properly
		deleteID = deleteID.trim();
		deleteID = String.format("%09d", Integer.parseInt(deleteID));

		int index = this.find(deleteID);
		boolean found = (index >= 0);

		if (found) {
			// Add index to deletedIndex stack
			deletedIndex.addIndex(index);

			// Remove from OrderedIndexes
			firstNameIndex.deleteRecord(index);
			lastNameIndex.deleteRecord(index);
			IDIndex.deleteRecord(index);

			numberOfRecords--;
		}

		return index;
	}

	/**
	 * Dumps the entire database to the console with indices. For debugging
	 * purposes only.
	 */
	public void print() {
		int i = 0;
		while (database[i] != null) {
			System.out.println("[" + i + "] " + database[i].toString());
			i++;
		}
	}

	/**
	 * Prints out the database in a specified order of a specified field
	 * 
	 * @param field
	 *            1, 2, or 3 corresponds to first name, last name, and ID
	 *            respectively
	 * @param order
	 *            1 or 2 corresponds to increasing and decreasing order
	 *            respectively
	 */
	public void listIt(int field, int order) {
		OrderedIndex indexToPrint = null;

		// Determine which OrderedIndex to list
		switch (field) {
		case 1:
			indexToPrint = firstNameIndex;
			break;
		case 2:
			indexToPrint = lastNameIndex;
			break;
		case 3:
			indexToPrint = IDIndex;
			break;
		default:
			System.err.println("Invalid field input for listIt");
			break;
		}

		// Determine which order to list it in, if at all
		if (indexToPrint.getNumberOfRecords() == 0) {
			System.out.println("Database is empty.\n");
		} else if (order == 1) {
			// Code for increasing order
			for (int i = 0; i < indexToPrint.getNumberOfRecords(); i++) {
				System.out.println(database[indexToPrint.getIndexRecord(i)
						.getDatabaseIndex()].toString());
			}
			System.out.println();
		} else if (order == 2) {
			// Code for decreasing order
			for (int i = indexToPrint.getNumberOfRecords() - 1; i >= 0; i--) {
				System.out.println(database[indexToPrint.getIndexRecord(i)
						.getDatabaseIndex()].toString());
			}
			System.out.println();
		} else
			System.err.println("Invalid order input for listIt");
	}

	/**
	 * Search for instance of ID using binary search
	 * 
	 * @param tempID
	 *            ID to search for. Should be numeric, positive, and no more
	 *            than 9 digits long
	 * @return true if found, false if not.
	 */
	public boolean search(String tempID) {
		// Format ID properly
		tempID = tempID.trim();
		tempID = String.format("%09d", Integer.parseInt(tempID));

		// Set up for binary search
		int lo = 0;
		int hi = IDIndex.getNumberOfRecords() - 1;
		int mid;
		boolean found;

		// Binary search
		while (lo <= hi) {
			mid = (hi + lo) / 2;
			found = (IDIndex.getIndexRecord(mid).getData().compareTo(tempID) == 0);

			if (found)
				return true;
			else if (IDIndex.getIndexRecord(mid).getData().compareTo(tempID) > 0) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return false; // Not found
	}

	/**
	 * Locate record by ID
	 * 
	 * @param tempID
	 *            ID to find. Should be numeric, positive, and no more than 9
	 *            digits long
	 * @return Index of the ID in the database or -1 if not found.
	 */
	public int find(String tempID) {
		// Format ID properly
		tempID = tempID.trim();
		tempID = String.format("%09d", Integer.parseInt(tempID));

		// Set up for binary search
		int lo = 0;
		int hi = IDIndex.getNumberOfRecords() - 1;
		int mid;
		boolean found;

		// Binary search
		while (lo <= hi) {
			mid = (hi + lo) / 2;
			found = (IDIndex.getIndexRecord(mid).getData().compareTo(tempID) == 0);

			if (found)
				return IDIndex.getIndexRecord(mid).getDatabaseIndex();
			else if (IDIndex.getIndexRecord(mid).getData().compareTo(tempID) > 0) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return -1; // Not found
	}

	/**
	 * Add a record to the database using the given parameters for data. Checks
	 * to see if the ID is unique and will prompt user if ID is already in use.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param tempID
	 *            Should be numeric, positive, and no more than 9 digits long
	 */
	public void insert(String firstName, String lastName, String tempID) {

		// Trim whitespace
		firstName = firstName.trim();
		lastName = lastName.trim();
		tempID = tempID.trim();

		tempID = String.format("%09d", Integer.parseInt(tempID));

		// Check if ID is in use
		while (search(tempID)) {
			@SuppressWarnings("resource")
			Scanner keyboard = new Scanner(System.in);
			System.out.print("The ID " + tempID
					+ " is already in use.\nPlease enter a unique ID: ");
			tempID = keyboard.nextLine();
			System.out.println();

			// Format ID properly
			tempID = tempID.trim();
			tempID = String.format("%09d", Integer.parseInt(tempID));

		}

		DataStructureRecord record = new DataStructureRecord(firstName,
				lastName, tempID);
		int indexToInsertAt;

		// Use index from deletedIndex for next record location if available
		if (deletedIndex.isEmpty())
			indexToInsertAt = numberOfRecords;
		else
			indexToInsertAt = deletedIndex.getIndex();

		// Add record to database and OrderedIndexes
		database[indexToInsertAt] = record;
		firstNameIndex.addRecord(new IndexRecord(firstName, indexToInsertAt));
		lastNameIndex.addRecord(new IndexRecord(lastName, indexToInsertAt));
		IDIndex.addRecord(new IndexRecord(tempID, indexToInsertAt));

		numberOfRecords++;
	}
}
