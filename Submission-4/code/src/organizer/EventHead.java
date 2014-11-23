package organizer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import common.AccData;

/**
 * This class is for the events head
 * @author spree_group1
 *
 */
public class EventHead implements  OrganizingCommitte {
	
	private String Name=null;
	private String emailID=null;
	private String ID = null;
	
	Connection conn;
	
	/**
	 * constructor of EventHead class, fetches details of the convenor from organizerdata database
	 * @param ID
	 */
	public EventHead(String ID){
		Statement stmt=null;
		try{
			conn = DriverManager.getConnection(AccData.getHost(), AccData.getUser(), AccData.getPass());
			stmt=conn.createStatement();
			String query = "Select * from organizerdata;";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				if(rs.getString("ID").equals(ID)){
				this.Name = rs.getString("Name");
				this.emailID = rs.getString("EmailID");
				this.ID = ID;
				}
			}
			
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		
	}
	
/**
 * get method for id for the events head
 * @return ID 
 */
	public String getID() {
		return ID;
	}

	/**
 * get method for the email id of the events head
 * @return
 */
	public String getEmailID() {
		return emailID;
	}

/**
 * Get method for event head's name
 * @return
 */
	public String getName() {
		return Name;
	}
	
	
	/**Used by events head to add items into the inventory
	 * 
	 * @param itemName name of the item that needs to be pushed
	 * @param quantity number of items that need to be pushed
	 */
	public void pushItem(String itemName ,int quantity){
		Statement s=null;
		//String query;
		try{
		conn=DriverManager.getConnection(AccData.getHost(), AccData.getUser(), AccData.getPass());
		s=conn.createStatement();
		String query = "Select * from inventory;";
		ResultSet rs = s.executeQuery(query);
		while(rs.next()){
			if(rs.getString("Name").equals(itemName))
			{
			
			int q=rs.getInt("NoOfItems");
			int max=rs.getInt("MaxCap");
			q=q+quantity;
			
			if(q<=max){
			System.out.println(q);
			java.util.Date utilDate = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			query = "UPDATE Inventory set NoOfItems = "+Integer.toString(q)+", LastModified='" +sqlDate+"'  where Name=\"" +
			itemName + "\";";
		//	, Last Date of Modification='" +sqlDate+"'
			s.executeUpdate(query);
			}
			else {
				q=max;
				System.out.println(q);
				java.util.Date utilDate = new java.util.Date();
				java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
				query = "UPDATE Inventory set NoOfItems = "+Integer.toString(q)+"  where Name=\"" +
				itemName + "\";";
			//	, Last Date of Modification='" +sqlDate+"'
				s.executeUpdate(query);
		
				
			/// NEW
				
				try{
					conn = DriverManager.getConnection(AccData.getHost(), AccData.getUser(), AccData.getPass());
					s = conn.createStatement();
					query = "Select Count from messagecount;";
					rs = s.executeQuery(query);
					int count = 0;
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					Date date = new Date();
					String data = dateFormat.format(date);
					while(rs.next()) count = rs.getInt("Count");
					
					if(count == 7){
						query = "Select * from messagedata;";
						rs = s.executeQuery(query);
						int i = 2;
						while(rs.next() && i <=7){
							query = "UPDATE messagedata " +
									"SET Body=\"" + rs.getString("Body")+ "\"," +
									"Date = \"" + rs.getString("Date") +
									"\" WHERE No="+ Integer.toString(i)+";";	
							i = i+1;
							System.out.println(i);
							s.addBatch(query);
						}
						s.executeBatch();
						query = "UPDATE messagedata " +
								"SET Body=\"" + "Database reached its maximum limit"+ "\"," +
								"Date = \"" + data +
								"\" WHERE No=1;";
						s.executeUpdate(query);
					}
					else{
						count = count + 1;
						query = "UPDATE messagedata " +
								"SET Body=\"" +"Database reached its maximum limit"+ "\"," +
								"Date = \"" + data +
								"\" WHERE No="+Integer.toString(count) + ";";

						s.executeUpdate(query);

						query = "UPDATE messagecount " +
								"SET Count="+Integer.toString(count)+";";

						s.execute(query);
					}
			//	textArea.setText(getMessage());	
					
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			}
		}
		
		s.close();
		conn.close();
		
		}catch(SQLException e){
			System.out.println(e.toString());
		}
	}
	
	/**
	 * Used to approve the inventory Request(which was requested by EM) by Events Head 
	 */
	public void popItem(){
		String query;
		int value[]=new int[10];
		String name[]=new String[10] ;
		Statement s=null;
		try{
		conn=DriverManager.getConnection(AccData.getHost(), AccData.getUser(), AccData.getPass());
		s=conn.createStatement();
		String sql = "Select * from RequestInventory;";
		ResultSet rs1 = s.executeQuery(sql);
		//
		int count=0;
		while(rs1.next()){
			System.out.println("executing");
			name[count]=rs1.getString("ItamName");
			value[count]=rs1.getInt("Quantity");
			System.out.println(value[count]);
			++count;
		}
		
		}catch(SQLException e){
			System.out.println(e.toString());
		}
			int quan[]=new int[10];
			int i=0;
			
			try{
				Connection conn=DriverManager.getConnection(AccData.getHost(), AccData.getUser() ,AccData.getPass());
				s=conn.createStatement();
			
			String sql2= "Select NoOfItems from inventory WHERE Name=\"" + name[i]+ "\";";
			ResultSet rs2=s.executeQuery(sql2);
			while(rs2.next()){
			quan[i]=rs2.getInt("NoOfItems");
			
			if(value[i] <=quan[i])
			{
			quan[i]=quan[i]-value[i];
			query = "UPDATE Inventory set NoOfItems = "+Integer.toString(quan[i])+" where Name=\"" + name[i] + "\";";
			s.executeUpdate(query);
			}
			else{
				quan[i]=0;
			query = "UPDATE Inventory set NoOfItems = "+Integer.toString(quan[i])+" where Name=\"" + name[i] + "\";";
			s.executeUpdate(query);
			}
			String sql = "DELETE from requestinventory where Number="+Integer.toString(quan[i])+";";
	         s.executeUpdate(sql);
	         ++i;
	         
	         
			}	
		
		rs2.close();
		s.close();
		conn.close();
	
		}catch(SQLException e){
			System.out.println(e.toString());
		}
	}
}
