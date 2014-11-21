package organizer;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import registration.LoginFrame;
import eventManager.*;

import common.AccData;
import common.DashboardFrame;


public class OrganizerProfileFrame extends JFrame{

	private String Id;
	private Convenor convenor;
	private EventHead eventhead;
	private String Name,emailID,ID;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
			String Id = "C_Head";
				try {
					OrganizerProfileFrame window = new OrganizerProfileFrame(Id);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		
	
	public OrganizerProfileFrame(String Id) {
		
			
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
				DashboardFrame dash = new DashboardFrame();
			}
		});
		btnDashboard.setBounds(276, 227, 127, 23);
		this.getContentPane().add(btnDashboard);
		
		

		
		JLabel txtName = new JLabel();
		txtName.setBackground(SystemColor.control);
		txtName.setBounds(221, 44, 200, 23);
		this.getContentPane().add(txtName);
		txtName.setText(Name);
		
		JLabel textPost = new JLabel();
		textPost.setBackground(SystemColor.control);
		textPost.setBounds(221, 70, 200, 23);
		this.getContentPane().add(textPost);
		textPost.setText(ID.charAt(0)=='C'?"Convenor":"EventHead");
		
		JLabel textEmailID = new JLabel();
		textEmailID.setBackground(SystemColor.control);
		textEmailID.setBounds(221, 95, 200, 23);
		this.getContentPane().add(textEmailID);
		textEmailID.setText(emailID);
		
		JLabel textInstName = new JLabel();
		textInstName.setBackground(SystemColor.control);
		textInstName.setBounds(221, 114, 200, 44);
		this.getContentPane().add(textInstName);
		textInstName.setText("BITS PILANI KK BIRLA GOA Campus");
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginFrame login = new LoginFrame();
				dispose();
			}
		});
		btnLogOut.setBounds(10, 18, 89, 23);
		getContentPane().add(btnLogOut);
		
		if(ID.charAt(0)=='C'){
		JButton btnFinance = new JButton("Finance");
		btnFinance.setBounds(28, 227, 101, 23);
		getContentPane().add(btnFinance);
		
		JButton btnAccomodation = new JButton("Accomodation");
		btnAccomodation.setBounds(141, 227, 117, 23);
		getContentPane().add(btnAccomodation);
		
		JButton btnPublicity = new JButton("Publicity");
		btnPublicity.setBounds(28, 183, 101, 23);
		getContentPane().add(btnPublicity);
		}	
		if(ID.charAt(1)=='E'){
		JButton btnSendMessageFrame = new JButton("SendMessageFrame");
		btnSendMessageFrame.setBounds(141, 183, 117, 23);
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

		
		JButton btnViewResultFrame = new JButton("ViewResultFrame");
		btnViewResultFrame.setBounds(276, 183, 127, 23);
		getContentPane().add(btnViewResultFrame);
		btnViewResultFrame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ViewResultFrame vr =  new ViewResultFrame(ID);
				vr.setVisible(true);
				setVisible(false);
				
			}
		});
	}
		}
}
