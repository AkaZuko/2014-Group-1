package departments;
/**
* The Department class program provides a framework for the specific Departments  
* that is Accomodation , Finance and Publicity.
*
*
* @author  Group 1_ spree 
* @version 1.0
* 
*/

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import common.AccData;

public class Department {

	AccData acc;
	File file;
	FileReader fr;
	
	
	public Department() throws IOException{
		file =new File("res/LogFile");
	    file.createNewFile();
	    fr = new FileReader(file); 
	      
	}
	
	
	/**
	   * This is the viewLog() method which reads the log file.
	   * @param none
	   * @return String  the returned value is the contents of the log file
	   * @exception IOException On file IO error.
	   * @see IOException
	   */
	public String viewLog() throws IOException{
		
	      
	      String outp =null;
	     
	      char [] a = new char[50];
	      while(fr.read(a)!=-1){
	    	    // reads the content to the array
	          outp=outp+String.valueOf(a);
	    	  
	      }
	     
	      fr.close();
	      return outp;
	      		
	}
	
}
