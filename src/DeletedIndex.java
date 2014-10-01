/**
 * Stefano Prezioso
 * COSC 311 Project 1
 * Fall 2014
 */

/**
 * Holds an array of integer indices of the deleted records from the database.
 * 
 */
public class DeletedIndex {
	private int numberOfElements;
	private int[] deletedIndexArray;

	public DeletedIndex() {
		deletedIndexArray = new int[200];
		numberOfElements = 0;
	}

	public DeletedIndex(int size) {
		deletedIndexArray = new int[size];
		numberOfElements = 0;
	}

	public int getNumberOfElements() {
		return numberOfElements;
	}

	/**
	 * Adds an index to the stack of deleted indices.
	 * 
	 * @param indexToAdd
	 */
	public void addIndex(int indexToAdd) {
		deletedIndexArray[numberOfElements] = indexToAdd;
		numberOfElements++;
	}

	/**
	 * Peek at the top of the DeletedIndex stack
	 * 
	 * @return Index at the top of the stack. -1 if empty.
	 */
	public int getIndexByPeeking() {
		if (this.isEmpty()) {
			return -1;
		} else {
			return deletedIndexArray[numberOfElements - 1];
		}
	}

	/**
	 * Pop the next index from the DeletedIndex stack.
	 * 
	 * @return Index at the top of the stack. -1 if empty.
	 */
	public int getIndex() {
		if (this.isEmpty()) {
			return -1;
		} else {
			numberOfElements--;
			return deletedIndexArray[numberOfElements];
		}
	}

	/**
	 * 
	 * @return true if DeletedIndex is empty. False if not empty.
	 */
	public boolean isEmpty() {
		return (numberOfElements == 0);
	}

	/**
	 * Dump contents of DeletedIndex to console. For debugging purposes.
	 */
	public void print() {
		for (int i = 0; i < numberOfElements; i++) {
			System.out.println(deletedIndexArray[i]);
		}
	}
}
