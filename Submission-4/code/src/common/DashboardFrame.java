package common;
/*
 * This class provides functionality for 
 * displaying the dashboard frame.
 * 
 * @author Group1_Spree
 * @version 1.0
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.SystemColor;

import javax.swing.JLabel;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;

import eventManager.SendMessageFrame;
import eventManager.SubmitScheduleFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DashboardFrame {

	private JFrame frame;
	String message = "";
	
	static int i= 0;
	JButton btnRefresh;
	JTextArea txtrMessage;
	JTable table;
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardFrame window = new DashboardFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public DashboardFrame() throws IOException {
		initialize();
		frame.setVisible(true);
		
		message = "";
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		
		AccData.addToLog("Dashboard viewed");
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrResult = new JTextArea();
		txtrResult.setBackground(SystemColor.control);
		txtrResult.setBounds(10, 89, 414, 31);
		frame.getContentPane().add(txtrResult);
		String results = "";
		txtrResult.setText(results);
		
		JLabel lblDashboard = new JLabel("----------------------------DASHBOARD-------------------------");
		lblDashboard.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDashboard.setBounds(10, 11, 414, 31);
		frame.getContentPane().add(lblDashboard);
		
		JLabel lblResults = new JLabel("Results");
		lblResults.setBounds(195, 53, 56, 25);
		frame.getContentPane().add(lblResults);
		
		JLabel lblMessages = new JLabel("Messages");
		lblMessages.setBounds(195, 131, 56, 14);
		frame.getContentPane().add(lblMessages);
		lblMessages.setText("Message");
		
		txtrMessage = new JTextArea();
		txtrMessage.setBackground(SystemColor.control);
		SendMessageFrame sm = new SendMessageFrame("");
		String message1 = sm.getMessage();
		txtrMessage.setText(message1);
		txtrMessage.setBounds(10, 156, 414, 147);
		frame.getContentPane().add(txtrMessage);
		
		JLabel lblSchedule = new JLabel("Schedule");
		lblSchedule.setBounds(194, 325, 80, 14);
		frame.getContentPane().add(lblSchedule);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnClose.setBounds(315, 53, 89, 23);
		frame.getContentPane().add(btnClose);
		
		btnRefresh = new JButton("Refresh");
		Handler handle = new Handler();
		btnRefresh.addActionListener(handle);
		btnRefresh.setBounds(20, 53, 89, 23);
		frame.getContentPane().add(btnRefresh);
		
		String columnNames[] = {"Time Slots","Day1","Day2","Day3","Game"};
		
		Object[][] data = new Object[11][5];
		try {
			Connection conn = DriverManager.getConnection(AccData.getHost(),  AccData.getUser(),  AccData.getPass());
			Statement s = conn.createStatement();
			String query = "Select * from scheduletable;";
			ResultSet rs = s.executeQuery(query);
			
			int i = 0;
			
			while(rs.next()){
				
				data[i][0] = (String)rs.getString("Time");
				data[i][1] = (String)rs.getString("D1");
				data[i][2] = (String)rs.getString("D2");
				data[i][3] = (String)rs.getString("D3");
				data[i][4] = (String)rs.getString("Game");
				
				++i;
			}
			
			rs.close();
			s.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		
		table = new JTable(data,columnNames);
		table.setBounds(22, 353, 382, 176);
		frame.getContentPane().add(table);
		
	}
	class Handler implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(e.getSource().equals(btnRefresh)){
				SendMessageFrame sm = new SendMessageFrame("");
				String newMessage = sm.getMessage();
				txtrMessage.setText(newMessage);				
			}
		}
}
}
