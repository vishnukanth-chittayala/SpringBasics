// Java program to create a file "friendsContact.txt"
// and add a new contact in the file

import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.NumberFormatException;

public class Employee{

	public static String main(String data[])
	{

		try {
			Scanner sc=new Scanner(System.in);

			// Get the name of the contact to be updated
			// from the Command line argument
			System.out.println("enter employeee details");
			System.out.println("enter the first name");
			String fname = sc.next();


			// Get the number to be updated
			// from the Command line argument
			System.out.println("enter the last name");

			String lname=sc.next();
			System.out.println("enter the department");
			String dept=sc.next();
			System.out.println("enter the employee id");
			long empid = sc.nextLong();
			System.out.println("enter the job title");
			String jtitle=sc.next();

			String nameNumberString;
			String fname1;
			String lname1;
			String dept1;
			long empid1;
			String jtitle1;


			int index;
			int index1;

			// Using file pointer creating the file.
			File file = new File("employeedetails.txt");

			if (!file.exists()) {

				// Create a new file if not exists.
				file.createNewFile();
			}

			// Opening file in reading and write mode.

			RandomAccessFile raf
				= new RandomAccessFile(file, "rw");
			boolean found = false;

			// Checking whether the name
			// of contact already exists.
			// getFilePointer() give the current offset
			// value from start of the file.
			while (raf.getFilePointer() < raf.length()) {

				// reading line from the file.
				nameNumberString = raf.readLine();

				// finding the position of '!'
				index = nameNumberString.indexOf('!');

				// separating name and number.
				fname1 = nameNumberString
										.substring(0, index);
										index1 = nameNumberString.indexOf('!',(index+1));
								lname1 = nameNumberString
										.substring((index + 1),index1);
										index=index1;
										index1 = nameNumberString.indexOf('!',(index+1));
										dept1 = nameNumberString
										.substring((index + 1),index1);
								index=index1;
										index1 = nameNumberString.indexOf('!',(index+1));

								empid1
									= Long
										.parseLong(
											nameNumberString
												.substring((index+1),index1));
				                            index=index1;
										index1 = nameNumberString.indexOf('!',(index+1));

								jtitle1 = nameNumberString
						.substring((index+1),index1);

				// if condition to find existence of record.
				if (fname1 == fname ||lname1 == lname ||dept1 == dept ||empid1 == empid || jtitle1 == jtitle) {
					found = true;
					break;
				}
			}

			if (found == false) {

				// Enter the if block when a record
				// is not already present in the file.
				nameNumberString
					= fname
					+ "!"
					+ lname+"!"+dept+"!"+String.valueOf(empid)+"!"+jtitle+"!";

				// writeBytes function to write a string
				// as a sequence of bytes.
				raf.writeBytes(nameNumberString);

				// To insert the next record in new line.
				raf.writeBytes(System.lineSeparator());

				// Print the message

                System.out.println("employee added");
				// Closing the resources.
				raf.close();
			return "employee added";
			}
			// The contact to be updated
			// could not be found
			else {

				// Closing the resources.
				raf.close();

				// Print the message
				System.out.println("input does not exist");
				return " Input name"
								+ " exists. ";
			}

}

		catch (IOException ioe) {

			System.out.println(ioe);
		}
		catch (NumberFormatException nef) {

			System.out.println(nef);
		}
return "employee added";
	}
}

