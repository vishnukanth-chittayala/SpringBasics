// Java program to update in the file "friendsContact.txt"
// and change the number of an old contact

import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.NumberFormatException;

class DelEmployee {

	public static String main(String data[])
	{

// Java program to update in the file "friendsContact.txt"
// and change the number of an old contact



        try {
			Scanner sc=new Scanner(System.in);

            //String fname = data[0];

						// Get the number to be updated
						// from the Command line argument
						//String lname=data[1];
						//String dept=data[2];
						System.out.println("enter employee id");
						long empid = sc.nextLong();
						//String jtitle=data[4];

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
									.substring((index + 1),index1);

							// if condition to find existence of record.
							if (empid1 == empid) {
								found = true;
								break;
                }
            }

            // Update the contact if record exists.
            if (found == true ) {

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
									.substring((index + 1),index1);

					// Check if the fetched contact
					// is the one to be deleted
					if (empid==empid1) {

						// Skip inserting this contact
						// into the temporary file
						continue;
					}

					// Add this contact in the temporary file
					tmpraf.writeBytes(nameNumberString);

					// Add the line separator in the temporary file
					tmpraf.writeBytes(System.lineSeparator());
				}

				// The contact has been deleted now
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

				System.out.println(" employee deleted. ");


return "employee deleted";

            }

            else {

                // Closing the resources.
                raf.close();

                // Print the message
                System.out.println(" Input name"
                                   + " does not exists. ");
                return " input name does not exists";
            }
        }

        catch (IOException ioe) {
            System.out.println(ioe);
        }

        catch (NumberFormatException nef) {
            System.out.println(nef);
        }
        return "employee deleted";
    }
}

