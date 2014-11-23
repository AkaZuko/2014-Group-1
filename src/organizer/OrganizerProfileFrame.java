package organizer;

/**
 *The OrganizerProfileFrame class provides a view that shows Event Head Details 
 *and Convenor Details and allows to navigate through all the accessible classes
 *
 */
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import registration.LoginFrame;
import departments.*;
//import eventManager.*;

import common.AccData;
import common.DashboardFrame;
import javax.swing.JTextField;

import participant.*;


import registration.LoginFrame;
import eventManager.*;

import common.AccData;
import common.DashboardFrame;
import javax.swing.JTextField;


public class OrganizerProfileFrame extends JFrame{

	private Convenor convenor;
	private EventHead eventhead;
	private String Name,emailID,ID;
	private JTextField textField;
	
	public class ViewDepartmentDetailsFrame extends JFrame {

		private JFrame frame;		
		String department;
		private JList list;
		private JLabel lblName;
		

		

		public ViewDepartmentDetailsFrame(String Deparment) {
			
			this.department = Deparment;
			initialize();
		}

		
		String temp[];
		
		/**
		   * This is the initialize() method Initialize the contents of the frame.
		   * 
		   * @param none
		   * @return void	   
		   */
		private void initialize() {

			frame = new JFrame("Department Details");
			frame.setBounds(100, 100, 700, 350);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			frame.getContentPane().setLayout(null);

			JLabel labelName = new JLabel("DEAPARTMENT DETAILS");
			labelName.setBounds(250, 20, 211, 14);
			labelName.setFont(new Font("Tahoma", Font.PLAIN, 16));
			frame.getContentPane().add(labelName);
			labelName.setVisible(true);
			
			
			
			lblName = new JLabel("Name");
			lblName.setBounds(76, 45, 61, 14);
			lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
			frame.getContentPane().add(lblName);
			
			
			JButton btnBack = new JButton("Back");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					OrganizerProfileFrame fr = new OrganizerProfileFrame("C_Head");
					fr.setVisible(true);
					setVisible(false);
					frame.dispose();
				}
			});
			btnBack.setBounds(250, 239, 89, 23);
			frame.getContentPane().add(btnBack);

		}

		/**
		   * This is the viewDepartmentDetails() method which shows the Department details 
		   * 
		   * @param none
		   * @return none
		   * @exception IO Exception
		   * @see IO Exception	   
		   */
		private void viewDepartmentDetails() throws IOException {
			// TODO Auto-generated method stub
			

				if (department.equals("Accomodation")) {
					Accomodation acc = new Accomodation();
					temp=acc.getDetails();
					list = new JList(temp);
					list.setBounds(22, 70, 600, 160);
					frame.getContentPane().add(list);
					list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
					list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
					list.setVisible(true);
				}
					

				if (department.equals("Publicity")) {
					Publicity pub = new Publicity();
					temp=pub.getDetails();
					list = new JList(temp);
					list.setBounds(22, 70, 600, 160);
					frame.getContentPane().add(list);
					list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
					list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
					list.setVisible(true);
					
			} 
				if (department.equals("Finance")) {
					Finance fin = new Finance();
					temp=fin.getDetails();
					list = new JList(temp);
					list.setBounds(22, 70, 600, 160);
					frame.getContentPane().add(list);
					list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
					list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
					list.setVisible(true);
			} 
		}
		
		

		
	}

	
	
	
		
	/**
	 * 
	 * Displays basic information and 
	 */
	public OrganizerProfileFrame(String Id) {
		
		this.ID=Id;	
		try{
			Connection conn = DriverManager.getConnection(AccData.getHost(), AccData.getUser(), AccData.getPass());
			Statement s1 = conn.createStatement();
			String query1 = "Select ID from organizerdata;";
			ResultSet rs1 = s1.executeQuery(query1);

			if(Id.charAt(0) == 'C'){
				convenor = new Convenor(Id);
				this.Name = convenor.getName();
				this.emailID = convenor.getEmailID();
				this.ID = Id;
			}else{
			while(rs1.next()){
			if(rs1.getString("ID").equals(Id)){
				eventhead = new EventHead(Id);
				this.Name = eventhead.getName();
				this.emailID = eventhead.getEmailID();
				this.ID = Id;
			}
				}
			}
			
			rs1.close();
			s1.close();
			conn.close();
			
			}catch(SQLException e){
				System.out.println(e.toString());
			}
		init();
		setVisible(true);
	}
	
	
		private void init() {
		
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblProfile = new JLabel("Profile");
		lblProfile.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblProfile.setBounds(193, 11, 65, 30);
		this.getContentPane().add(lblProfile);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(83, 53, 46, 14);
		this.getContentPane().add(lblName);
		
		
		JLabel lblEmailId = new JLabel("E-mail ID");
		lblEmailId.setBounds(83, 104, 65, 14);
		this.getContentPane().add(lblEmailId);
		
		JLabel lblInstitutionName = new JLabel("Institution Name");
		lblInstitutionName.setBounds(83, 129, 97, 14);
		this.getContentPane().add(lblInstitutionName);
		
		JLabel lblPost = new JLabel("Post");
		lblPost.setBounds(83, 79, 46, 14);
		this.getContentPane().add(lblPost);
		
		
		JButton btnDashboard = new JButton("Dashboard");
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new DashboardFrame();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDashboard.setBounds(276, 205, 127, 23);
		this.getContentPane().add(btnDashboard);
		
		JLabel txtName = new JLabel();
		txtName.setBackground(SystemColor.control);
		txtName.setBounds(221, 52, 200, 15);
		this.getContentPane().add(txtName);
		txtName.setText(Name);
		
		JLabel textPost = new JLabel();
		textPost.setBackground(SystemColor.control);
		textPost.setBounds(221, 75, 200, 23);
		this.getContentPane().add(textPost);
		textPost.setText(ID.charAt(0)=='C'?"Convenor":"EventHead");
		
		JLabel textEmailID = new JLabel();
		textEmailID.setBackground(SystemColor.control);
		textEmailID.setBounds(221, 104, 200, 14);
		this.getContentPane().add(textEmailID);
		textEmailID.setText(emailID);
		
		JLabel textInstName = new JLabel();
		textInstName.setBackground(SystemColor.control);
		textInstName.setBounds(221, 129, 200, 14);
		this.getContentPane().add(textInstName);
		textInstName.setText("BITS PILANI KK BIRLA GOA Campus");
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new LoginFrame();
				dispose();
			}
		});
		btnLogOut.setBounds(10, 18, 89, 23);
		getContentPane().add(btnLogOut);
		
		if(ID.charAt(0)=='C'){
		JButton btnFinance = new JButton("Finance");
		btnFinance.setBounds(28, 205, 101, 23);
		getContentPane().add(btnFinance);
		btnFinance.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("button clicked");
				ViewDepartmentDetailsFrame dept = new ViewDepartmentDetailsFrame( "Finance");
				setVisible(false);
				System.out.println("frame created");
				try {
					dept.viewDepartmentDetails();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		
		JButton btnAccomodation = new JButton("Accomodation");
		btnAccomodation.setBounds(28, 238, 101, 23);
		getContentPane().add(btnAccomodation);
		
		
		
		JButton btnPublicity = new JButton("Publicity");
		btnPublicity.setBounds(28, 171, 101, 23);
		getContentPane().add(btnPublicity);
		btnAccomodation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ViewDepartmentDetailsFrame dept = new ViewDepartmentDetailsFrame("Accomodation");
				setVisible(false);
				try {
					dept.viewDepartmentDetails();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		btnPublicity.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ViewDepartmentDetailsFrame dept = new ViewDepartmentDetailsFrame("Publicity");
				setVisible(false);
				try {
					dept.viewDepartmentDetails();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});


		
		}	
		if(ID.charAt(0)=='E'){
		JButton btnSendMessageFrame = new JButton("SendMessageFrame");
		btnSendMessageFrame.setBounds(268, 18, 153, 23);
		getContentPane().add(btnSendMessageFrame);
		btnSendMessageFrame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				SendMessageFrame smf = new SendMessageFrame(ID);
				smf.setVisible(true);
				setVisible(false);
				//EventManagerFrame ef;
				}
		});

		
		JButton btnViewResultFrame = new JButton("ViewResultFrame");		// View result frame
		btnViewResultFrame.setBounds(276, 169, 127, 23);
		getContentPane().add(btnViewResultFrame);
		
		textField = new JTextField();
		textField.setBounds(155, 172, 86, 30);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnApproveIventoryRequest = new JButton("Approve Iventory Request");
		btnApproveIventoryRequest.setBounds(276, 239, 127, 23);
		getContentPane().add(btnApproveIventoryRequest);
		
		btnApproveIventoryRequest.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EventHead eh =new EventHead(ID);
				eh.popItem();
				textField.setText("Request Approved!!");
				
			}
		});
		
		btnViewResultFrame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ViewResultFrame vr =  new ViewResultFrame(ID);
				vr.setVisible(true);
				setVisible(false);
				
			}
		});
		JButton btnAddToInventory = new JButton("Add To Inventory");
		btnAddToInventory.setBounds(139, 238, 127, 23);
		getContentPane().add(btnAddToInventory);
		
		btnAddToInventory.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					//AddToInventoryFrame window = new AddToInventoryFrame(ID);
					//window.setVisible(true);
					String[] parameter={ID,""};
					new AddToInventoryFrame(ID).main(parameter);
				} catch (Exception e) {
					e.printStackTrace();
				}
				setVisible(false);
			}
		});
	}
}
		
		public class SendMessageFrame extends JFrame {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private JTextField textField;
			String u ;
			JTextArea textArea;
			public SendMessageFrame(String usern) {
				u = usern;
				init();
				if(!u.equals(""))
				this.setVisible(true);
				else
					this.setVisible(false);
			}

			/**
			 * Initialize the contents of the frame.
			 */
			
			
			public void init(){
				this.setBounds(100, 100, 450, 400);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				getContentPane().setLayout(null);
				
				JLabel lblMessanger = new JLabel("MESSENGER");
				lblMessanger.setBounds(168, 12, 113, 36);
				getContentPane().add(lblMessanger);
				
				JLabel lblMessage = new JLabel("Message:");
				lblMessage.setBounds(45, 80, 70, 15);
				getContentPane().add(lblMessage);
				
				textField = new JTextField();
				textField.setBounds(142, 78, 251, 17);
				getContentPane().add(textField);
				textField.setColumns(10);
				
			
				
				JButton btnSubmit = new JButton("Submit");
				btnSubmit.setBounds(283, 109, 117, 25);
				getContentPane().add(btnSubmit);
				btnSubmit.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						if(!textField.getText().equals("")){
						try{
							Connection conn = DriverManager.getConnection(AccData.getHost(), AccData.getUser(), AccData.getPass());
							Statement s = conn.createStatement();
							String query = "Select Count from messagecount;";
							ResultSet rs = s.executeQuery(query);
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
										"SET Body=\"" + textField.getText()+ "\"," +
										"Date = \"" + data +
										"\" WHERE No=1;";
								s.executeUpdate(query);
							}
							else{
								count = count + 1;
								query = "UPDATE messagedata " +
										"SET Body=\"" + textField.getText()+ "\"," +
										"Date = \"" + data +
										"\" WHERE No="+Integer.toString(count) + ";";

								s.executeUpdate(query);

								query = "UPDATE messagecount " +
										"SET Count="+Integer.toString(count)+";";

								s.execute(query);
							}
						textArea.setText(getMessage());	
							
						}catch(SQLException e){
							e.printStackTrace();
						}
						
						
					}}
				});

				
				
				JButton btnShowRecentMessages = new JButton("Show Recent Messages");
				btnShowRecentMessages.setBounds(33, 146, 218, 25);
				
				
				textArea = new JTextArea(this.getMessage());
				textArea.setBounds(45, 161, 374, 150);
				getContentPane().add(textArea);
				
				JLabel lblRecentMessages = new JLabel("Recent Messages");
				lblRecentMessages.setBounds(43, 139, 163, 15);
				getContentPane().add(lblRecentMessages);
				
				JButton btnEmHome = new JButton("EH Home");
				btnEmHome.setBounds(168, 339, 127, 23);
				getContentPane().add(btnEmHome);
				
				
				
				JLabel lblNewLabel = new JLabel("User:" + u);
				lblNewLabel.setBounds(313, 12, 106, 15);
				getContentPane().add(lblNewLabel);
				
				
				
				btnEmHome.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						OrganizerProfileFrame fr = new OrganizerProfileFrame(ID);
						fr.setVisible(true);
						dispose();
					}
				});
			}
			
			public String getMessage(){
				String message = "";
				try{
					Connection conn = DriverManager.getConnection(AccData.getHost(), AccData.getUser(), AccData.getPass());
					Statement s = conn.createStatement();
					String query = "Select Body from messagedata ORDER BY Date DESC;";
					ResultSet rs = s.executeQuery(query);
					while(rs.next()) message = message + rs.getString("Body") + "\n";
					}catch(SQLException e){
					e.printStackTrace();
				}
				
				return message;
			}
			
			
		}
		
		public class ViewResultFrame extends JFrame {
			private String ID;

			public ViewResultFrame(String id) {
				this.ID = id;
				initialize();
			}
			String[] x = new String[100];
			
			/**
			 * Initialize the contents of the frame.
			 */
			private void initialize() {
				
				
				 
			
				this.setBounds(100, 100, 450, 300);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				getContentPane().setLayout(null);
				
				JLabel lblResults = new JLabel("Results");
				lblResults.setBounds(170, 12, 70, 15);
				getContentPane().add(lblResults);
			
				
				String message = "";
				try{
					Connection conn = DriverManager.getConnection(AccData.getHost(), AccData.getUser(), AccData.getPass());
					Statement s = conn.createStatement();
					String query = "Select Body from messagedata ORDER BY Date DESC;";
					ResultSet rs = s.executeQuery(query);
					while(rs.next()) message = message + rs.getString("Body") + "\n";
					}catch(SQLException e){
					e.printStackTrace();
				}
				
				
				
				
				//this is let us see the results for last 6 matches
				JTextArea textArea = new JTextArea(message);
				textArea.setBounds(47, 37, 364, 159);
				getContentPane().add(textArea);
				
				
				JButton btnEmHome = new JButton("EH Home");
				btnEmHome.setBounds(155, 223, 117, 25);
				getContentPane().add(btnEmHome);
				btnEmHome.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						OrganizerProfileFrame fr = new OrganizerProfileFrame(ID);
						fr.setVisible(true);
						dispose();
					}
				});

		}
		}
}
