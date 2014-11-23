package common;
/*
 * This class provides functionality for 
 * accessing and managing the database.
 * It acts as a pathway for others to get information 
 * to access the database.
 * 
 * @author Group1_Spree
 * @version 1.0
 */
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
	private final static String url = "jdbc:mysql://127.0.0.1:3306/Spree";
	//private final static String url = "jdbc:mysql://sql4.freemysqlhosting.net:3306/sql458738";
	private final static String user = "root";
	//private final static String user = "sql458738";
	private final static String pass = "12345";	
	//private final static String pass = "dD9*gY3*";	
	
	
	/*
	 * This function provides get function 
	 * to get url 
	 * 
	 * @return String
	 * @param none
	 * 
	 */
	public static String getHost() {
		return url;
	}
	
	/*
	 * This function provides get function 
	 * to get username 
	 * 
	 * @return String
	 * @param none
	 */
	public static String getUser() {
		return user;
	}
	
	

	/*
	 * This function provides get function 
	 * to get password 
	 * @param none 
	 * @return String
	 * 
	 */
	public static String getPass() {
		return pass;
	}
	
	
	/*
	 * This function is called whenever a task occurs 
	 * and adds it to the Log File 
	 * @return void
	 * @param String the parameter is the message to be printed in the log file 
	 * 
	 * 
	 */
	public static void addToLog(String a) throws IOException{
		
 		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		java.sql.Time sqlTime = new java.sql.Time(utilDate.getTime());
		
		File file=new File("./res/logFile");
		file.createNewFile();
		BufferedWriter bw=new BufferedWriter(new FileWriter(file,true));
		
		bw.append("Log entered --- Time : "+String.valueOf(sqlTime)+" ---- Date : "+String.valueOf(sqlDate)+" ---- Entry :"+a);
		
		bw.flush();
		bw.close();
		
	    
}

}
