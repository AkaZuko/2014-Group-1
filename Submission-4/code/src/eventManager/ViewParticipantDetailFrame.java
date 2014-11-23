package eventManager;

/**
 * <h1>ViewParticipantDetail</h1>
* The ViewParticipantDetailFrame class provides a view that shows various participant details
* that is Name ID,Institute and Email Address
*
*
* @author  Group 1_ spree 
* @version 1.0
* 
*/
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;

import participant.*;

import common.AccData;
import registration.RegisterationDetailFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ViewParticipantDetailFrame extends JFrame {

	private JFrame frame;
	String ID;
	private AccData account;
	private JTable table;
	private JLabel lblName;
	private JLabel lblID;	
	private JLabel lblEmail;	
	private JLabel lblInstitute;
	private JButton btnBack;

	

	public ViewParticipantDetailFrame(String id) {
		this.ID = id;
		initialize();
		setVisible(true);
	}

	
	/**
	   * This is the initialize() method Initialize the contents of the frame.
	   * 
	   * @param none
	   * @return void	   
	   */
	
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(150, 150, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);

		JLabel labelName = new JLabel("PARTICIPANT DETAILS");
		labelName.setBounds(172, 21, 172, 14);
		labelName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(labelName);
		labelName.setVisible(true);

		JLabel lblParticipantDetails = new JLabel("Participant Details");
		lblParticipantDetails.setBounds(142, 30, 205, 29);
		getContentPane().add(lblParticipantDetails);

		Object[][] data;
		
		data = (Object[][]) this.viewParticipantDetails();
		String[] columnNames = { "Name", "ID", "Email",	"Institute" };

		table = new JTable(data, columnNames);
		table.setBounds(20, 70, 450, 346);
		frame.getContentPane().add(table);
		table.setVisible(true);
		lblName = new JLabel("Name");
		lblName.setBounds(54, 45, 57, 14);
		frame.getContentPane().add(lblName);

		lblID = new JLabel("ID");
		lblID.setBounds(182, 45, 27, 14);
		frame.getContentPane().add(lblID);		

		lblEmail = new JLabel("Email");
		lblEmail.setBounds(281, 46, 45, 14);
		frame.getContentPane().add(lblEmail);		

		lblInstitute = new JLabel("Institute");
		lblInstitute.setBounds(370, 42, 74, 21);
		frame.getContentPane().add(lblInstitute);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			EventManagerFrame fr = new EventManagerFrame(ID);
				setVisible(false);
				frame.dispose();
			}
		});
		btnBack.setBounds(212, 427, 89, 23);
		frame.getContentPane().add(btnBack);

	}
	
	/**
	   * This is viewParticipantDetails() method takes data from the database to display it 
	   * 
	   * @return Object[][]
	   *  @exception SQL Exception On database error.
	   * @see SQL Exception	
	   */

	private Object[][] viewParticipantDetails() {
		// TODO Auto-generated method stub
		Object[][] data = new Object[1000][4];
		try {
			
			Connection conn = DriverManager.getConnection(AccData.getHost(), AccData.getUser(), AccData.getPass());
			Statement s = conn.createStatement();
			String query = "Select Name,ID,Email,Institute from participantdata";
			ResultSet rs = s.executeQuery(query);

			int i = 0;

			while (rs.next()) {

				data[i][0] = (String) rs.getString("Name");
				data[i][1] = (String) rs.getString("ID");				
				data[i][2] = (String) rs.getString("Email");				
				data[i][3] = (String) rs.getString("Institute");
				++i;
			}

			rs.close();
			s.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return data;

	}
}
