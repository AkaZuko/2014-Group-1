package departments;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import common.AccData;

public class Department {

	AccData acc;

	
	public String viewLog() throws IOException{
		File file =new File("LogFile");
	      file.createNewFile();
	      
	      //FileWriter writer = new FileWriter(file); 
	      String outp =null;
	      FileReader fr = new FileReader(file); 
	      char [] a = new char[50];
	      while(fr.read(a)!=-1){
	    	    // reads the content to the array
	          outp=outp+String.valueOf(a);
	    	  
	      }
	     
	      fr.close();
	      return outp;
	      		
	}
	
}
