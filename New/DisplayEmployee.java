// Java program to read from file "friendsContact.txt"
// and display the contacts

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.NumberFormatException;

class DisplayEmployee {

	public static String main(String data[])
	{

		try {

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

			// Traversing the file
			// getFilePointer() give the current offset
			// value from start of the file.
			System.out.println("displaying employeee detals");
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("FIRSTNAME   ||    LASTNAME   ||  DEPARTMENT   ||   ID   ||    JOB TITLE    || ");
			System.out.println("-------------------------------------------------------------------------------------");
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

								jtitle1 = nameNumberString.substring((index+1),index1);


             System.out.println(fname1+"        :"+lname1+"         :"+dept1+"   :"+empid1+"     :"+jtitle1);
System.out.println("\n\n");


			}
}
			catch (IOException ioe)
			{

				System.out.println(ioe);
			}
			catch (NumberFormatException nef)
			{

				System.out.println(nef);
			}
	return "employees displayed";
	}
	}
