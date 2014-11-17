package departments;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
* <h1>Accomodation</h1>
* This class defines the functionality of the Accomodation department.<p>
* 
* @author  Group_1 spree
* @version 1.0
*/


public class Accomodation extends Department {

	static int max_acco_slots;
	static int count;

	public Accomodation() throws IOException {
		super();
		
	}

	
	/**
	   * This is the fillAccoSlots() method which increments the count of accomodated participants if
	   * the count is within the maximum number of students. 
	   * 
	   * @param none
	   * @return void
	   * @exception IO Exception On file manipulation error.
	   * @see IO Exception
	   */
	
	public void fillAccoSlots() throws IOException {
		File pub = new File("res/Accomodation");
		BufferedReader br = new BufferedReader(new FileReader(pub));

		if (count < max_acco_slots)
			count++;

		File c = new File("tmp");
		c.createNewFile();

		BufferedWriter bw = new BufferedWriter(new FileWriter(c));

		String names;
		names = br.readLine();
		bw.write(names);
		bw.newLine();
		bw.write(String.valueOf((Integer.valueOf(br.readLine())+1)));
		bw.newLine();
		

		while ((names = br.readLine()) != null) {
			bw.write(names);
			bw.newLine();

		}

		bw.flush();
		bw.close();

		pub.delete();
		pub.createNewFile();

		BufferedReader br1 = new BufferedReader(new FileReader(c));
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(pub));

		while ((names = br1.readLine()) != null) {
			bw1.write(names);
			bw1.newLine();

		}

		bw1.flush();
		bw1.close();
		br.close();
		br1.close();

		 c.delete();

	}
	
	/**
	   * This is the getDetail() method which returns the details of members of the 
	   * Accomodation department
	   * @param none
	   * @return String[]  the returned value is of an array of member names
	   * @exception IO Exception On file manipulation error.
	   * @see IO Exception
	   */

	public String[] getDetails() throws IOException {

		String details[] = new String[10];

		int i = 0;

		File pub = new File("res/Accomodation");
		BufferedReader br = new BufferedReader(new FileReader(pub));
		String line;
		String line1 = br.readLine();
		String line2 = br.readLine();
		max_acco_slots = Integer.getInteger(line1);
		count = Integer.getInteger(line2);

		while ((line = br.readLine()) != null) {

			details[i] = line;
			i++;

		}

		return details;

	}

}
