package registration;
import common.AccData;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;

public class LoginFrame {
	private AccData acc;
	private JFrame frame;
	private JPasswordField passwordField;
	private JLabel lblSpree;
	private JLabel lblLoginId;
	private JLabel lblpasswd;
	private JButton btnLogin;
	private JButton btnregister;
	private JFormattedTextField formattedTextField;
	private JLabel lblNewLabel;

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
		initialize();
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
		
		Handler handle = new Handler();
		btnLogin = new JButton("LogIn");
		btnLogin.setBounds(157, 137, 142, 34);
		frame.getContentPane().add(btnLogin);
		btnLogin.addActionListener(handle);
		
		btnregister = new JButton("Register");
		btnregister.setBounds(292, 226, 127, 25);
		frame.getContentPane().add(btnregister);
		
		btnregister.addActionListener(handle);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(180, 96, 163, 25);
		frame.getContentPane().add(passwordField);
		
		formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(180, 71, 163, 25);
		frame.getContentPane().add(formattedTextField);
		
		lblNewLabel = new JLabel("New participant?");
		lblNewLabel.setBounds(163, 231, 127, 15);
		frame.getContentPane().add(lblNewLabel);
	}
	
	class Handler implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(e.getSource().equals(btnregister)){
				Registeration win = new Registeration();
				frame.setVisible(false);
				frame = null;				
			}
			if(e.getSource().equals(btnLogin)){
				
			}
			}
			
		}
	}

