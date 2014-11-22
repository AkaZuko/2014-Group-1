package eventManager;

import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import common.AccData;
import eventManager.SubmitScheduleFrame.Handler;

/*
 * @author monalika
 */


public class SubmitResultsFrame extends JFrame {
	private String ID;
	Vector<String> list1;
	Vector<String> list2;
	static String team1;
	static String team2;
	JButton btnGetTeams;
	static JComboBox comboBox;
	JComboBox comboBox_1;
	JRadioButton rdbtnNewRadioButton;
	Connection conn = null;
	Statement s1 = null;
	Statement s2 = null;
	ResultSet rs = null;
	JRadioButton rdbtnNewRadioButton_1;
	JButton btnSubmit ;
	static String a = "";
	static String b = "";
	
	public  static void main(String[] args){
		SubmitResultsFrame sb = new SubmitResultsFrame("EM_TT");
	}
	
	public SubmitResultsFrame(String id){
		this.ID = id;
		list1 = new Vector<>();
		list2 = new Vector<>();
		try{
			conn = DriverManager.getConnection(AccData.getHost(), AccData.getUser(), AccData.getPass());
			s1 = conn.createStatement();
			
			String query1 = "Select Time from scheduletable WHERE Game =\"" + this.ID.substring(this.ID.lastIndexOf("_") + 1) + "\";";
			System.out.println(query1);
			rs = s1.executeQuery(query1);
			
			while(rs.next()){ 
				if(rs.getString("Time") !=null)
				list1.add(rs.getString("Time"));
			
			}
			list2 = list1;
			
			rs.close();
			s1.close();
			conn.close();
			
			
			}catch(SQLException e){
				System.out.println(e.toString());
			}
	
		initialize();
		setVisible(true);
		
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame = new JFrame();
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblSubmitResults = new JLabel("Submit Results");
		lblSubmitResults.setBounds(151, 23, 142, 15);
		this.getContentPane().add(lblSubmitResults);
		
		btnSubmit = new JButton("Set Result");
		btnSubmit.setBounds(151, 204, 117, 25);
		getContentPane().add(btnSubmit);
		Handler handle = new Handler();
		btnSubmit.addActionListener(handle);
		
		JButton btnEmHome = new JButton("EM Home");
		btnEmHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				EventManagerFrame fr = new EventManagerFrame(ID);
				setVisible(false);
			}
		});
		btnEmHome.setBounds(292, 51, 117, 25);
		getContentPane().add(btnEmHome);
		
		comboBox = new JComboBox(new DefaultComboBoxModel(new String[] {"D1","D2","D3"}));
		comboBox.setBounds(61, 51, 76, 25);
		getContentPane().add(comboBox);
	//	comboBox.
		
		JLabel lblNewLabel = new JLabel("Day:");
		lblNewLabel.setBounds(23, 51, 28, 25);
		getContentPane().add(lblNewLabel);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Time");
		lblNewLabel_1.setBounds(23, 87, 58, 25);
		getContentPane().add(lblNewLabel_1);
		
		comboBox_1 = new JComboBox(list2);
		comboBox_1.setBounds(61, 87, 76, 25);
		getContentPane().add(comboBox_1);
		
		btnGetTeams = new JButton("Get Teams");
		btnGetTeams.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGetTeams.setBounds(292, 88, 117, 24);
		getContentPane().add(btnGetTeams);
		Handler handle1 = new Handler();
		btnGetTeams.addActionListener(handle1);
		
		
		rdbtnNewRadioButton = new JRadioButton(team1);
		rdbtnNewRadioButton.setBounds(84, 153, 109, 23);
		getContentPane().add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton(team2);
		rdbtnNewRadioButton_1.setBounds(224, 153, 109, 23);
		getContentPane().add(rdbtnNewRadioButton_1);
		
		
		JLabel lblNewLabel_2 = new JLabel(a + "   " + b);
		lblNewLabel_2.setBounds(61, 132, 100, 14);
		getContentPane().add(lblNewLabel_2);
		

	
	
	}
	
	
		class Handler implements ActionListener{
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource().equals(btnGetTeams)){
					team1 = "";
					team2 = "";
					Connection conn = null;
					try {
						conn = DriverManager.getConnection(AccData.getHost(), AccData.getUser(),AccData.getPass());
					} catch (SQLException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
					Statement s2 = null;
					try {
						s2 = conn.createStatement();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					String query2 = "Select "+  comboBox.getSelectedItem().toString() +" from scheduletable WHERE Time =\"" + comboBox_1.getSelectedItem().toString() + "\";";
					System.out.println(query2);
					try {
						rs = s2.executeQuery(query2);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					try {
						while(rs.next()){ 
							if(rs.getString(comboBox.getSelectedItem().toString()) !=null)
								
							try{
							team1 = (rs.getString(comboBox.getSelectedItem().toString())).substring(rs.getString(comboBox.getSelectedItem().toString()).lastIndexOf(",")+1);
							team2 = (rs.getString(comboBox.getSelectedItem().toString())).substring(0, (rs.getString(comboBox.getSelectedItem().toString()).lastIndexOf(",")));
							
							}catch(NullPointerException e1){
								setVisible(false);
								SubmitResultsFrame sr = new SubmitResultsFrame(ID);
							}
							
							System.out.println(team1);
							System.out.println(team2);
							
						};
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}
					System.out.println("out");

					a = comboBox.getSelectedItem().toString();
					b = comboBox_1.getSelectedItem().toString();
					
					setVisible(false);
					SubmitResultsFrame srf = new SubmitResultsFrame(ID);
					
				
				}
				
				if(e.getSource().equals(btnSubmit)){
					

					
					Connection conn = null;
					try {
						conn = DriverManager.getConnection(AccData.getHost(), AccData.getUser(),AccData.getPass());
					} catch (SQLException e3) {
						
						e3.printStackTrace();
					}
					
					try {
						s2 = conn.createStatement();
					} catch (SQLException e2) {
						
						e2.printStackTrace();
					}
					
					
					if(rdbtnNewRadioButton.isSelected()){
						rdbtnNewRadioButton_1.disable();
						setVisible(false);
						SubmitResultsFrame srf1 = new SubmitResultsFrame(ID);
						String query1 = "UPDATE participantdata SET W_" + ID.substring(ID.lastIndexOf("_") + 1) + " = \"FALSE\"" + " WHERE " + ID.substring(ID.lastIndexOf("_") + 1) + " = '" + team2 + "';";
						System.out.println(query1);
			
						try {
							s2.executeUpdate(query1);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						
					}
					
					else if(rdbtnNewRadioButton_1.isSelected()){
						rdbtnNewRadioButton.disable();
						setVisible(false);
						SubmitResultsFrame srf1 = new SubmitResultsFrame(ID);
						String query1 = "UPDATE participantdata SET W_" + ID.substring(ID.lastIndexOf("_") + 1) + " = \"FALSE\"" + " WHERE " + ID.substring(ID.lastIndexOf("_") + 1) + " = '" + team1 + "';";
						System.out.println(query1);
			
						try {
							s2.executeUpdate(query1);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						team1 = "";
						team2 = "";
						
						
					}	
					
				
				}
				
			}}	
}



