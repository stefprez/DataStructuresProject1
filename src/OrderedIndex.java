/**
 * Stefano Prezioso COSC 311 Project 1 Fall 2014
 */

public class OrderedIndex {
	private int numberOfRecords;
	private IndexRecord[] orderedIndex;

	public OrderedIndex() {
		numberOfRecords = 0;
		orderedIndex = new IndexRecord[200];
	}

	public OrderedIndex(int sizeOfIndex) {
		numberOfRecords = 0;
		orderedIndex = new IndexRecord[sizeOfIndex];
	}

	public IndexRecord getIndexRecord(int indexOfRecordToReturn) {
		return orderedIndex[indexOfRecordToReturn];
	}

	public int getNumberOfRecords() {
		return numberOfRecords;
	}

	/**
	 * Dump out the contents of the OrderedIndex to the console. For debugging
	 * purposes.
	 */
	public void print() {
		for (int i = 0; i < numberOfRecords; i++)
			System.out.println(orderedIndex[i].toString());
	}

	/**
	 * Add an IndexRecord to the OrderedIndex
	 * 
	 * @param recordToAdd
	 */
	public void addRecord(IndexRecord recordToAdd) {
		// Add record to end of orderedIndex
		orderedIndex[numberOfRecords] = recordToAdd;

		IndexRecord temp; // For swapping
		boolean recordInCorrectLocation;

		// Sort recordToAdd into appropriate place in OrderedIndex using
		// Insertion algorithm
		for (int currentIndex = numberOfRecords - 1; currentIndex >= 0; currentIndex--) {
			recordInCorrectLocation = (recordToAdd.getData().compareTo(
					orderedIndex[currentIndex].getData()) > 0);

			if (recordInCorrectLocation)
				break;
			else {
				// Swap recordToAdd up a spot in the OrderedIndex
				temp = orderedIndex[currentIndex];
				orderedIndex[currentIndex] = orderedIndex[currentIndex + 1];
				orderedIndex[currentIndex + 1] = temp;
			}
		}

		numberOfRecords++;
	}

	/**
	 * Search for and delete record in an OrderedIndex
	 * 
	 * @param databaseIndexToDelete
	 *            Unique database index to search for and delete
	 */
	public void deleteRecord(int databaseIndexToDelete) {
		int iterator;

		// Linear search to find the proper record to delete
		for (iterator = 0; iterator < numberOfRecords; iterator++) {
			if (this.getIndexRecord(iterator).getDatabaseIndex() == databaseIndexToDelete)
				break;
		}

		// Shift all the records after the record to delete up one space,
		// overwriting the deleted record.
		while (iterator < numberOfRecords) {
			this.orderedIndex[iterator] = this.getIndexRecord(iterator + 1);
			iterator++;
		}

		numberOfRecords--;
	}
}
