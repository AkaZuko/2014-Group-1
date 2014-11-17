package departments;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;


/**
* <h1>Publicity</h1>
* This class defines the functionality of the Publicity department.<p>
* 
* @author  Group_1 spree
* @version 1.0
*/



public class Publicity extends Department {

	public Publicity() throws IOException {
		super();

	}

	/**
	   * This is the getDetail() method which returns the details of members of the 
	   * Publicity department
	   * @param none
	   * @return String[]  the returned value is of an array of member names
	   * @exception IO Exception On file manipulation error.
	   * @see IO Exception
	   */
	
	public String[] getDetails() throws IOException {

		File pub = new File("res/Publicity");
		String details[] = new String[10];

		int i = 0;

		BufferedReader br = new BufferedReader(new FileReader(pub));
		String line;
		while ((line = br.readLine()) != null) {

			details[i] = line;
			i++;

		}
		br.close();
		return details;

	}

}
