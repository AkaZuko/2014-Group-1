package eventManager;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.SwingConstants;

import organizer.AddToInventoryFrame;

import registration.LoginFrame;

import common.DashboardFrame;

/**
* <h1>SubmitScheduleFrame</h1>
* This class provide provides the first frame to Event Manager after logging in
* 
* @author  Group_1 spree
* @version 1.0
*/


public class EventManagerFrame extends JFrame {
	EventManager em;
	JButton btnDashboard_1;
	/**
	 * This is the constructor for the the class EventManager
	 *  @param String ID of the the Eventmanager
	 */
	
	public EventManagerFrame(final String ID) {
		setVisible(true);
		em = new EventManager(ID);
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblProfile = new JLabel("Profile");
		lblProfile.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblProfile.setBounds(186, 66, 53, 15);
		this.getContentPane().add(lblProfile);
	
		
		JLabel lblEventManager = new JLabel("EVENT MANAGER");
		lblEventManager.setBounds(159, 39, 125, 15);
		getContentPane().add(lblEventManager);
		
		JLabel lblName_1 = new JLabel("Name:");
		lblName_1.setBounds(33, 96, 70, 15);
		getContentPane().add(lblName_1);
		
		JLabel lblGame = new JLabel("Game:");
		lblGame.setBounds(33, 139, 70, 15);
		getContentPane().add(lblGame);
		
		JLabel lblEmailid = new JLabel("EmailID:");
		lblEmailid.setBounds(33, 180, 70, 15);
		getContentPane().add(lblEmailid);
		
		JLabel lblBitsPilaniGoa = new JLabel("BITS PILANI GOA CAMPUS");
		lblBitsPilaniGoa.setBounds(128, 12, 191, 15);
		getContentPane().add(lblBitsPilaniGoa);
		
		JButton btnSendMessage = new JButton("Messenger");
		btnSendMessage.setBounds(260, 93, 162, 15);
		getContentPane().add(btnSendMessage);
		btnSendMessage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				SendMessageFrame smf = new SendMessageFrame(ID);
				smf.setVisible(true);
				setVisible(false);
				EventManagerFrame ef;
				
				
			}
		});
	
		
		JButton btnSubmitResults = new JButton("Submit Results");
		btnSubmitResults.setBounds(260, 120, 162, 15);
		getContentPane().add(btnSubmitResults);
		btnSubmitResults.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				SubmitResultsFrame srf = new SubmitResultsFrame(ID);
				srf.setVisible(true);
				setVisible(false);
				
			}
		});
		
		btnDashboard_1 = new JButton("Dashboard");
		btnDashboard_1.setBounds(260, 147, 162, 15);
		getContentPane().add(btnDashboard_1);
		Handler handle = new Handler();
		btnDashboard_1.addActionListener(handle);
		
		JButton btnSchedule_1 = new JButton("Schedule");
		btnSchedule_1.setBounds(260, 175, 162, 15);
		getContentPane().add(btnSchedule_1);
		btnSchedule_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				SubmitScheduleFrame s9 = new SubmitScheduleFrame(ID);
				s9.setVisible(true);
				setVisible(false);
				
			}
		});
		
		JButton btnParticipantDetails = new JButton("Participant Details");
		btnParticipantDetails.setBounds(260, 202, 166, 15);
		getContentPane().add(btnParticipantDetails);
		btnParticipantDetails.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ViewParticipantDetailFrame vv = new ViewParticipantDetailFrame(ID);
				vv.setVisible(true);
				setVisible(false);
				
			}
		});
		
		JLabel lblNewLabel = new JLabel(em.getName());
		lblNewLabel.setBounds(97, 96, 70, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(em.getGame());
		lblNewLabel_1.setBounds(97, 139, 113, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblEmail = new JLabel(em.getEmailID());
		lblEmail.setBounds(97, 180, 166, 15);
		getContentPane().add(lblEmail);
		
		JButton btnViewResults = new JButton("View Results");
		btnViewResults.setBounds(260, 229, 162, 15);
		getContentPane().add(btnViewResults);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginFrame login = new LoginFrame();
				dispose();
			}
		});
		btnLogOut.setBounds(14, 35, 89, 23);
		getContentPane().add(btnLogOut);
		
		JButton btnRequestInventory = new JButton("Request Inventory");
		btnRequestInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//AddToInventoryFrame window = new AddToInventoryFrame(ID);
					//window.setVisible(true);
					String[] parameter={ID,""};
					new RequestInventoryFrame(ID).main(parameter);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//RequestInventoryFrame ri = new RequestInventoryFrame(ID);
				//ri.setVisible(true);
				dispose();
			}
		});
		btnRequestInventory.setBounds(33, 225, 156, 23);
		getContentPane().add(btnRequestInventory);
		btnViewResults.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ViewResultFrame vr =  new ViewResultFrame(ID);
				vr.setVisible(true);
				setVisible(false);
				
			}
		});
	}
	

	private JButton btnUpdate;

	
	class Handler implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(e.getSource().equals(btnDashboard_1)){
							
			try {
				DashboardFrame dash = new DashboardFrame();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
}
}