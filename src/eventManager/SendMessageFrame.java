package eventManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import common.AccData;

/*
 * @author Spree_Group 1
 */

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
	public static void main(String[] args){
		SendMessageFrame fr = new SendMessageFrame("EM_TT");
		
		
	}
	
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
		
		JButton btnEmHome = new JButton("EM Home");
		btnEmHome.setBounds(168, 339, 127, 23);
		getContentPane().add(btnEmHome);
		
		
		
		JLabel lblNewLabel = new JLabel("User:" + u);
		lblNewLabel.setBounds(313, 12, 106, 15);
		getContentPane().add(lblNewLabel);
		
		
		
		btnEmHome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EventManagerFrame fr = new EventManagerFrame(u);
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
	