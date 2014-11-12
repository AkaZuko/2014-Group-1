package registration;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class RegisterationDetailFrame {

	private JFrame frame;
	private JTextField txtNamefield;
	private JTextField txtPassfield;
	private JTextField txtAgefield;
	private JTextField txtInstfield;
	private JTextField txtEmailfield;
	JLabel label1 ;
	JLabel label2 ;
	JLabel label3 ;
	JLabel label4 ;
	JLabel label5 ;
	JLabel label6 ;
	JButton btnRegister ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterationDetailFrame window = new RegisterationDetailFrame();
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
	public RegisterationDetailFrame() {
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
		
		JLabel labelHead = new JLabel("REGISTERATION FORM");
		labelHead.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelHead.setBounds(151, 11, 177, 22);
		frame.getContentPane().add(labelHead);
		
		JLabel lblName = new JLabel("Name\t:");
		lblName.setBounds(50, 52, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblEMail = new JLabel("E Mail");
		lblEMail.setBounds(50, 77, 46, 14);
		frame.getContentPane().add(lblEMail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(50, 102, 81, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblInstitution = new JLabel("Institution");
		lblInstitution.setBounds(50, 152, 65, 14);
		frame.getContentPane().add(lblInstitution);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(50, 127, 46, 14);
		frame.getContentPane().add(lblAge);
		
		txtNamefield = new JTextField();
		txtNamefield.setBounds(185, 51, 200, 22);
		frame.getContentPane().add(txtNamefield);
		txtNamefield.setColumns(10);
		
		txtPassfield = new JTextField();
		txtPassfield.setBounds(185, 102, 200, 22);
		frame.getContentPane().add(txtPassfield);
		txtPassfield.setColumns(10);
		
		txtAgefield = new JTextField();
		txtAgefield.setBounds(185, 128, 200, 22);
		frame.getContentPane().add(txtAgefield);
		txtAgefield.setColumns(10);
		
		txtInstfield = new JTextField();
		txtInstfield.setBounds(185, 152, 200, 22);
		frame.getContentPane().add(txtInstfield);
		txtInstfield.setColumns(10);
		
		btnRegister = new JButton("Register");
		btnRegister.setBounds(296, 227, 89, 23);
		frame.getContentPane().add(btnRegister);
		Handler handle = new Handler();
		btnRegister.addActionListener(handle);
		
		txtEmailfield = new JTextField();
		txtEmailfield.setBounds(185, 77, 200, 22);
		frame.getContentPane().add(txtEmailfield);
		txtEmailfield.setColumns(10);
		
		 label1 = new JLabel("");
		label1.setBounds(10, 52, 29, 14);
		frame.getContentPane().add(label1);
		
		 label2 = new JLabel("");
		label2.setBounds(10, 77, 29, 14);
		frame.getContentPane().add(label2);
		
		 label3 = new JLabel("");
		label3.setBounds(10, 102, 29, 14);
		frame.getContentPane().add(label3);
		
		 label4 = new JLabel("");
		label4.setBounds(10, 127, 29, 14);
		frame.getContentPane().add(label4);
		
		 label5 = new JLabel("");
		label5.setBounds(10, 152, 23, 14);
		frame.getContentPane().add(label5);
		
		 label6 = new JLabel("");
		label6.setBounds(10, 175, 29, 14);
		frame.getContentPane().add(label6);
	}
	
	class Handler implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(e.getSource().equals(btnRegister)){
				
				if(validate()) System.out.println("it works!");
				//frame.setVisible(false);
							
			}
		}
			private Boolean validate(){
				Boolean status = false;
				String s1 = "([a-zA-Z]){1,} ([a-zA-Z]){1,}";
				String s2 = "([:alnum:]){1,}+@([:lower:])+.com";
				/*if(txtNamefield.getText().matches(s1)){
					status = true;
				}*/
				if(txtEmailfield.getText().matches(s2)){
					status = true;
				}
				return status;
			}
	}
}
