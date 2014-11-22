package registration;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;

import common.Admin;


import eventManager.EventManagerFrame;


import organizer.OrganizerProfileFrame;

import participant.ParticipantProfileFrame;

public class LoginFrame {
	private Admin admin;
	private JFrame frame;
	private JPasswordField passwordField;
	private JLabel lblSpree;
	private JLabel lblLoginId;
	private JLabel lblpasswd;
	private JButton btnLogin;
	private JButton btnregister;
	private JFormattedTextField formattedTextField;
	private JLabel lblNewLabel;
	JLabel lblStatus;
	
	OrganizerProfileFrame organizer = null;
	ParticipantProfileFrame participant = null;
	EventManagerFrame EM = null;
	
	private String ID;
	private String password;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame window = new LoginFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginFrame() {
		admin = new Admin(ID,password);
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblSpree = new JLabel("Spree");
		lblSpree.setFont(new Font("Purisa", Font.BOLD | Font.ITALIC, 30));
		lblSpree.setBounds(180, 24, 110, 41);
		frame.getContentPane().add(lblSpree);
		
		lblLoginId = new JLabel("Login ID    :");
		lblLoginId.setBounds(74, 74, 89, 15);
		frame.getContentPane().add(lblLoginId);
		
		lblpasswd = new JLabel("Password :");
		lblpasswd.setBounds(74, 101, 89, 15);
		frame.getContentPane().add(lblpasswd);
		
		Handler handle1 = new Handler();
		btnLogin = new JButton("LogIn");
		btnLogin.setBounds(157, 137, 142, 34);
		frame.getContentPane().add(btnLogin);
		btnLogin.addActionListener(handle1);
		
		btnregister = new JButton("Register");
		btnregister.setBounds(292, 226, 127, 25);
		frame.getContentPane().add(btnregister);
		Handler handle2 = new Handler();
		btnregister.addActionListener(handle2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(180, 96, 163, 25);
		frame.getContentPane().add(passwordField);
		
		formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(180, 71, 163, 25);
		frame.getContentPane().add(formattedTextField);
		
		lblNewLabel = new JLabel("New participant?");
		lblNewLabel.setBounds(163, 231, 127, 15);
		frame.getContentPane().add(lblNewLabel);
		
		lblStatus = new JLabel("");
		lblStatus.setBounds(146, 201, 171, 14);
		frame.getContentPane().add(lblStatus);
	}
	
	private void createUser(){
		RegisterationDetailFrame win = new RegisterationDetailFrame();
		frame.setVisible(false);
		frame = null;
	}
	
	class Handler implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(e.getSource().equals(btnregister)){
				createUser();				
			}
			if(e.getSource().equals(btnLogin)){
				password = new String(passwordField.getPassword());
				ID = formattedTextField.getText();
				Boolean result = admin.authenticateLogin(ID, password);
				
				if(result) {
					//ProfileFrame is displayed based upon the type of user
					if(ID.charAt(0) == 'C' || ID.charAt(1) == 'H' ){
						organizer = new OrganizerProfileFrame(ID);
					}
					if(ID.charAt(1) == 'M'){
						EM = new EventManagerFrame(ID);
					}
					if(ID.charAt(0) == 'P'){
						participant = new ParticipantProfileFrame(ID);
					}
					frame.setVisible(false);
					frame = null;
					
				}
				else{
					//error message is displayed
					lblStatus.setText("Invalid ID/PASSWORD");
				}
			}
			}
			
		}
	}

