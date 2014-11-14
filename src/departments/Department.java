package departments;

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
