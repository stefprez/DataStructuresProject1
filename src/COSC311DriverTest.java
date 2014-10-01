/**
 * Stefano Prezioso
 * COSC 311 Project 1
 * Fall 2014
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class COSC311DriverTest {

	@Test
	public void testAddRecordToDataStructure() throws Exception {
		DataStructure dataStructure = new DataStructure();
		assertNull(dataStructure.getDatabaseRecord(0));
		assertEquals(0, dataStructure.getNumberOfRecords());
		dataStructure.insert("joe", "smith", "123");
		assertEquals(1, dataStructure.getNumberOfRecords());
		assertTrue(dataStructure.getDatabaseRecord(0).getFirstName()
				.equalsIgnoreCase("joe"));
		assertTrue(dataStructure.getDatabaseRecord(0).getLastName()
				.equalsIgnoreCase("smith"));
		assertTrue(dataStructure.getDatabaseRecord(0).getID()
				.equalsIgnoreCase("123"));
	}

	@Test
	public void testInsertAndDeleteRecord() throws Exception {
		DataStructure dataStructure = new DataStructure();

		dataStructure.insert("joe", "smith", "123");
		assertTrue(dataStructure.getDatabaseRecord(0).getFirstName()
				.equalsIgnoreCase("joe"));
		assertTrue(dataStructure.getDatabaseRecord(0).getLastName()
				.equalsIgnoreCase("smith"));
		assertTrue(dataStructure.getDatabaseRecord(0).getID()
				.equalsIgnoreCase("123"));
		assertEquals(1, dataStructure.getNumberOfRecords());

		dataStructure.deleteRecord("123");
		assertEquals(0, dataStructure.getDeletedIndex().getIndexByPeeking());
		assertEquals(0, dataStructure.getNumberOfRecords());

		dataStructure.insert("mike", "johnson", "007");
		dataStructure.insert("doug", "zilch", "456");
		dataStructure.insert("mark", "davis", "777");
		assertEquals(3, dataStructure.getNumberOfRecords());

		dataStructure.deleteRecord("456");
		assertEquals(2, dataStructure.getNumberOfRecords());
		assertEquals(1, dataStructure.getDeletedIndex().getIndexByPeeking());

		dataStructure.insert("shark", "bait", "006");
		assertEquals(1, dataStructure.getIDIndex().getIndexRecord(0)
				.getDatabaseIndex());
	}

	// This is code from the FileReader main method that was used for testing
	// purposes.

	/**
	 * public static void main(String[] args) {
	 * 
	 * DataStructure dataStructure = new DataStructure();
	 * 
	 * try { fillDataStructure(dataStructure); } catch (IOException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * //THIS CRAP IS FOR TESTING
	 * 
	 * // testOrderedIndex();
	 * 
	 * // testDataStructure();
	 * 
	 * System.out.println("Data Structure"); dataStructure.print();
	 * 
	 * System.out.println("\nDeleted Index");
	 * dataStructure.getDeletedIndex().print();
	 * 
	 * }
	 * 
	 * @SuppressWarnings("unused") private static void testOrderedIndex() {
	 *                             OrderedIndex orderedIndex = new
	 *                             OrderedIndex(); IndexRecord recordToAdd = new
	 *                             IndexRecord("mike", 0); IndexRecord
	 *                             anotherRecordToAdd = new IndexRecord("doug",
	 *                             1); IndexRecord recordToAdd2 = new
	 *                             IndexRecord("anne", 2); IndexRecord
	 *                             recordToAdd3 = new IndexRecord("steve", 3);
	 *                             IndexRecord recordToAdd4 = new
	 *                             IndexRecord("frank", 4); IndexRecord
	 *                             recordToAdd5 = new IndexRecord("aaa", 5);
	 * 
	 *                             orderedIndex.addRecord(recordToAdd);
	 *                             orderedIndex.print();
	 *                             System.out.println("---");
	 * 
	 *                             orderedIndex.addRecord(anotherRecordToAdd);
	 *                             orderedIndex.print();
	 *                             System.out.println("---");
	 * 
	 *                             orderedIndex.addRecord(recordToAdd2);
	 *                             orderedIndex.print();
	 *                             System.out.println("---");
	 * 
	 *                             orderedIndex.addRecord(recordToAdd3);
	 *                             orderedIndex.print();
	 *                             System.out.println("---");
	 * 
	 *                             orderedIndex.addRecord(recordToAdd4);
	 *                             orderedIndex.print();
	 *                             System.out.println("---");
	 * 
	 *                             orderedIndex.addRecord(recordToAdd5);
	 *                             orderedIndex.print(); }
	 * @SuppressWarnings("unused") private static void testDataStructure() {
	 *                             DataStructure dataStructure = new
	 *                             DataStructure(); dataStructure.insert("Doug",
	 *                             "Jones", "12345");
	 *                             dataStructure.insert("Mike", "Adams",
	 *                             "11221"); dataStructure.insert("Anne",
	 *                             "Carr", "23456");
	 *                             dataStructure.insert("Frank", "Smith",
	 *                             "13423"); dataStructure.insert("Steve",
	 *                             "Davis", "00145");
	 * 
	 *                             System.out.println("Data Structure");
	 *                             dataStructure.print();
	 * 
	 *                             // System.out.println("\nFirst Name Index");
	 *                             // dataStructure.firstNameIndex.print(); //
	 *                             // System.out.println("\nLast Name Index");
	 *                             // dataStructure.lastNameIndex.print(); // //
	 *                             System.out.println("\nID Index"); //
	 *                             dataStructure.IDIndex.print();
	 * 
	 *                             System.out.println("---------");
	 *                             System.out.println("fName increasing");
	 *                             dataStructure.listIt(1, 1);
	 * 
	 *                             System.out.println("\nfName decreasing");
	 *                             dataStructure.listIt(1, 2);
	 * 
	 *                             System.out.println(dataStructure.search(
	 *                             "12345"));
	 *                             System.out.println(dataStructure.search
	 *                             ("11221"));
	 *                             System.out.println(dataStructure.search
	 *                             ("23456"));
	 *                             System.out.println(dataStructure.search
	 *                             ("13423"));
	 *                             System.out.println(dataStructure.search
	 *                             ("00145"));
	 * 
	 *                             System.out.println(dataStructure.search(
	 *                             "98733"));
	 *                             System.out.println(dataStructure.search
	 *                             ("92163"));
	 *                             System.out.println(dataStructure.search
	 *                             ("2"));
	 * 
	 * 
	 * 
	 *                             }
	 */
}
