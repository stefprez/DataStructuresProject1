DataStructuresProject1
======================

COSC 311 Project 1 - Array Based Data Structure


The following is by Bill Sverdlik of Eastern Michigan University
http://www.emunix.emich.edu/~sverdlik/COSC311/COSC311Program1.html

COSC 311
Programming Assignment #1

Database with Sorted Arrays as Indexes


You *MUST* demonstrate your program to me on the day it is due or earlier. You should come to your demo with a laptop and the program ready to execute or it should be runnable on a lab machine. Your well documented program listing is due in class at the start of class (didn't put your name on it ? No comments? Sloppy style ? You'll lose points). You will have 5 minutes to demo the program to me and should expect me to ask you questions regarding the program.

What to do:

Use the sample database (three fields - ID, LastName, FirstName) as the database. You should define a class called DataStructureRecord (an inner class or seperate file) that has three private String elements (the three fields), along with the appropriate constructors, toString methods, etc. 

Define an IndexRecordClass that has two fields: a Key (String) and a RecordNumber (int); define appropriate constructors,etc.

Next, define a DataStructure class that is comprised of an array of DataStructureRecord (let us say large enough to hold 100 records) and three indexes. Each index is a SortedArrayClass as discussed in class. You should have an index for the ID, for the LastName, and for the FirstName. Each index should keep data ordered by the key.

Suppose we inserted the following into a new DataStructure:


12345  Smith  Dave
11223  Jones   Harry
55555  Adams Joe

Then the corresponding data structures should look like the following:

DataBase
12345    Smith     Dave
11223    Jones      Harry
55555    Adams    Joe


ID index
11223      1
12345      0
55555      2

LastName index
Adams       2
Jones         1
Smith         0


FirstName index
Dave      0
Harry      1
Joe         2

You MUST use the driver program I have provided , and make some addition. Remember, you should NOT be permitted to add a record with a duplicate index number.
You MUST implement all methods as I have indicated.

But, what do I do about deleted records ?

Good question! Read CAREFULLY! Deleted IDs, first names, and last names should be deleted from their respective indexes (sorted arrays for this assignment). In addition, the record number of the deleted record should be pushed onto a statically declared stack called deleteStack. When your program wants to add a new record to the database, it should first check to see if deleteStack is empty. If deleteStack is empty, just add the new record at the end of the large array (we assume you are using an integer pointer to reference the end of the database array). If deleteStack is not empty, pop the stack to get the record number of where to insert the next element. 
