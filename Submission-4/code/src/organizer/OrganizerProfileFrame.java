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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import registration.LoginFrame;
import departments.*;
import eventManager.*;

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
				new DashboardFrame();
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
					new AddToInventoryFrame(ID).main(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
				setVisible(false);
			}
		});
	}
}
}
