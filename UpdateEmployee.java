// Java program to update in the file "friendsContact.txt"
// and change the number of an old contact

import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.NumberFormatException;

class UpdateEmployee {

	public static String main(String data[])
	{

// Java program to update in the file "friendsContact.txt"
// and change the number of an old contact



        try {
			Scanner sc=new Scanner(System.in);

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
			String jtitle=sc.next();;

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
									.substring(index1 + 1);

							// if condition to find existence of record.
							if (fname1 == fname &&lname1 == lname &&dept1 == dept &&empid1 == empid && jtitle1 == jtitle) {
								found = true;
								break;
                }
            }

            // Update the contact if record exists.
            if (found == false) {

                // Creating a temporary file
                // with file pointer as tmpFile.
                File tmpFile = new File("temp.txt");

                // Opening this temporary file
                // in ReadWrite Mode
                RandomAccessFile tmpraf
                    = new RandomAccessFile(tmpFile, "rw");

                // Set file pointer to start
                raf.seek(0);

                // Traversing the friendsContact.txt file
                index=0;
                index1=0;
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
										.substring(index1 + 1);


                    if (empid==empid1) {

                        // Update the number of this contact
                        				nameNumberString
											= fname
											+ "!"
					+ lname+"!"+dept+"!"+String.valueOf(empid)+"!"+jtitle+"!";
                    }

                    // Add this contact in the temporary file
                    tmpraf.writeBytes(nameNumberString);

                    // Add the line separator in the temporary file
                    tmpraf.writeBytes(System.lineSeparator());
                }

                // The contact has been updated now
                // So copy the updated content from
                // the temporary file to original file.

                // Set both files pointers to start
                raf.seek(0);
                tmpraf.seek(0);

                // Copy the contents from
                // the temporary file to original file.
                while (tmpraf.getFilePointer() < tmpraf.length()) {
                    raf.writeBytes(tmpraf.readLine());
                    raf.writeBytes(System.lineSeparator());
                }

                // Set the length of the original file
                // to that of temporary.
                raf.setLength(tmpraf.length());

                // Closing the resources.
                tmpraf.close();
                raf.close();

                // Deleting the temporary file
                tmpFile.delete();

                System.out.println(" employee updated. ");
                return "employee updated";
            }

            // The contact to be updated
            // could not be found
            else {

                // Closing the resources.
                raf.close();

                // Print the message
                System.out.println(" Input name"
                                   + " does not exists. ");
            return "input name does not exist";
            }
        }

        catch (IOException ioe) {
            System.out.println(ioe);
        }

        catch (NumberFormatException nef) {
            System.out.println(nef);
        }
    return "employee updated";
	}
	
	
}

