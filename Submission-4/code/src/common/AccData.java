package common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccData {
	private final static String url = "jdbc:mysql://localhost:3306/Spree";
	private final static String user = "root";
	private final static String pass = "12345";	
	
	public static String getHost() {
		return url;
	}
	
	public static String getUser() {
		return user;
	}
	
	public static String getPass() {
		return pass;
	}
	public void addToLog(String a) throws IOException{
		
 		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		java.sql.Time sqlTime = new java.sql.Time(utilDate.getTime());
		
		File file=new File("./res/logFile");
		file.createNewFile();
		BufferedWriter bw=new BufferedWriter(new FileWriter(file));
		
		bw.append("Log entered --- Time : "+String.valueOf(sqlTime)+" ---- Date : "+String.valueOf(sqlDate)+" ---- Entry :"+a);
		
		bw.flush();
		bw.close();
		
	    
}

}
