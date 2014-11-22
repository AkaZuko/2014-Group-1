package registration;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;

import participant.ParticipantProfileFrame;

import common.AccData;
import common.Admin;
import javax.swing.JRadioButton;

import departments.Accomodation;

public class RegisterationDetailFrame {

	private Admin admin;
	public JFrame frame;
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
	private JButton btnBack;
	JRadioButton rdbtnAccomodation;
	private JLabel lblAccoavail;

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
		admin = new Admin("","");
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
		
		JLabel lblPassInst = new JLabel("*Password must be of 6 or more characters");
		lblPassInst.setBounds(20, 231, 266, 14);
		frame.getContentPane().add(lblPassInst);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginFrame login = new LoginFrame();
				frame.dispose();
			}
		});
		btnBack.setBounds(10, 13, 89, 23);
		frame.getContentPane().add(btnBack);
		
		rdbtnAccomodation = new JRadioButton("Accomodation");
		rdbtnAccomodation.setBounds(50, 192, 109, 23);
		frame.getContentPane().add(rdbtnAccomodation);
		
		lblAccoavail = new JLabel("");
		lblAccoavail.setBounds(185, 192, 200, 24);
		frame.getContentPane().add(lblAccoavail);
	}
	
	class Handler implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(e.getSource().equals(btnRegister)){
				//sequence : name id pass email address age institute
				
				if(validate()) {
					try {
						Connection conn = DriverManager.getConnection(AccData.getHost(), AccData.getUser(), AccData.getPass());
						Statement s = conn.createStatement();
						String query1 = "SELECT * FROM participantdata";
						ResultSet rs1 = s.executeQuery(query1);
						rs1.last();
					    int size = rs1.getRow();
					    int idno = size+1;
					    rs1.beforeFirst();
						
						String ID = "P_" + Integer.toString(idno);
						
						if(Registeration.submitData(txtNamefield.getText(), Integer.toString(idno), txtPassfield.getText(), txtEmailfield.getText(), txtAgefield.getText(), txtInstfield.getText())){
							if(rdbtnAccomodation.isSelected()){
								try {
									Boolean status = new Accomodation().fillAccoSlots(ID);
									if(status) {
										lblAccoavail.setText("");
										ParticipantProfileFrame participant = new ParticipantProfileFrame(ID);
										participant.setVisible(true);
										frame.dispose();
									}
									else {
										lblAccoavail.setText("No slots left. Uncheck!");
										
									}
									
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
							else{
								ParticipantProfileFrame participant = new ParticipantProfileFrame(ID);
								participant.setVisible(true);
								frame.dispose();
							}
							
						}
						rs1.close();
						s.close();
						conn.close();
						admin.updateTotalRegisterations();
						
					} catch (SQLException e1) {
						System.out.println(e1.toString());
					}
				}
				//frame.setVisible(false);
							
			}
		}
			private Boolean validate(){
				Boolean status = false;
					
				if(!txtNamefield.getText().matches("([a-zA-Z]){1,} ([a-zA-Z]){1,}")) label1.setText("*");
				else label1.setText("");	
				
				if(!txtEmailfield.getText().matches("^[\\w-]+(?:\\.[\\w-]+)*@(?:[\\w-]+\\.)+[a-zA-Z]{2,7}$")) label2.setText("*");
				else label2.setText("");				
				
				if(txtPassfield.getText().isEmpty() || txtPassfield.getText().getBytes().length<6 ) label3.setText("*");
				else label3.setText("");
				
				if(!txtAgefield.getText().matches("[1-9][0-9]?[0-9]?")) label4.setText("*");
				else label4.setText("");
				
				if(!txtInstfield.getText().matches("([a-zA-Z ^0-9]){1,}")) label5.setText("*");
				else label5.setText("");
				
				//if(txtNamefield.getText().matches("([a-zA-Z]){1,} ([a-zA-Z]){1,}") && txtEmailfield.getText().matches("^[\\w-]+(?:\\.[\\w-]+)*@(?:[\\w-]+\\.)+[a-zA-Z]{2,7}$") && txtInstfield.getText().matches("([a-zA-Z ^0-9]){1,}") && (txtPassfield.getText().isEmpty() || txtPassfield.getText().getBytes().length<6) && txtAgefield.getText().matches("[1-9][0-9]?[0-9]?")) return status =true;
				if(label1.getText().equals("") && label2.getText().equals("") && label3.getText().equals("")  && label4.getText().equals("") && label5.getText().equals("")) status = true;
				if(status) System.out.println("validation starts");
				return status;

			}
	}
}
