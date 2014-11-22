package eventManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import common.AccData;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import participant.*;

import java.awt.Color;

/**
* <h1>SubmitScheduleFrame</h1>
* This class provide functionality to Event Manager to schedule events
* 
* @author  Group_1 spree
* @version 1.0
*/

public class SubmitScheduleFrame extends JFrame {


	String ID;
	JButton btnSubmit;
	JComboBox comboBox;
	JComboBox comboBox_1;
	Vector<String> list1;
	Vector<String> list2;
	JButton btnAdd;
	JTable table;
	JComboBox comboBox_2;
	JComboBox comboBox_3;
	String[] query = new String[3];
	int count = 0;

	public static void main(String[] args) {
		SubmitScheduleFrame sb = new SubmitScheduleFrame("EM_TT");
	}

	public SubmitScheduleFrame(String id) {
		this.ID = id;

		list1 = new Vector<>();
		list2 = new Vector<>();
		try {
			Connection conn = DriverManager.getConnection(AccData.getHost(),
					AccData.getUser(), AccData.getPass());
			Statement s1 = conn.createStatement();
			String query1 = "Select DISTINCT "
					+ this.ID.substring(this.ID.lastIndexOf("_") + 1)
					+ " from participantdata where W_"
					+ this.ID.substring(this.ID.lastIndexOf("_") + 1)
					+ " = \"True\";";
			// System.out.println(query1);
			ResultSet rs = s1.executeQuery(query1);

			while (rs.next()) {
				if (rs.getString(this.ID.substring(this.ID.lastIndexOf("_") + 1)) != null)
					list1.add(rs.getString(this.ID.substring(this.ID
							.lastIndexOf("_") + 1)));

			}
			list2 = list1;

			rs.close();
			s1.close();
			conn.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		initialize();
		this.setVisible(true);
	}
	/**
	   * This is the initialize() method Initialize the contents of the frame.
	   * 
	   * @param none
	   * @return void	   
	   */
	private void initialize() {

		Object[][] data;
		data = (Object[][]) this.getData();
		String[] columnNames = { "Name", "BB", "TT", "CR", "FB"
				 };
		// frame = new JFrame();
		this.setBounds(100, 100, 1200, 1200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);

		JLabel lblSchedule = new JLabel("Schedule");
		lblSchedule.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSchedule.setBounds(170, 22, 86, 25);
		this.getContentPane().add(lblSchedule);

		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(307, 326, 117, 25);
		this.getContentPane().add(btnSubmit);
		Handler handle1 = new Handler();
		btnSubmit.addActionListener(handle1);

		JButton btnEmHome = new JButton("EM Home");
		btnEmHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventManagerFrame fr = new EventManagerFrame(ID);
				setVisible(false);
			}
		});
		btnEmHome.setBounds(21, 22, 117, 25);
		getContentPane().add(btnEmHome);

		comboBox = new JComboBox(new DefaultComboBoxModel(new String[] {
				"Day1", "Day2", "Day3" }));
		comboBox.setBounds(299, 24, 125, 20);
		getContentPane().add(comboBox);

		String one = "";
		String two = "";
		String three = "";
		if (ID.equals("EM_TT")) {
			one = "10-11";
			two = "1-2";
			three = "4-5";
		}

		if (ID.equals("EM_BB")) {
			one = "9-11";
			two = "12-2";
			three = "3-5";
		}

		if (ID.equals("EM_CR")) {
			one = "8-12";
			two = "2-5";
			three = "";
		}

		if (ID.equals("EM_FB")) {
			one = "8-10";
			two = "11-1";
			three = "2-4";
		}

		JLabel lblTimeSlot = new JLabel("Time Slot");
		lblTimeSlot.setBounds(44, 61, 79, 25);
		getContentPane().add(lblTimeSlot);

		JLabel lblTeamA = new JLabel("Team A");
		lblTeamA.setBounds(44, 97, 79, 25);
		getContentPane().add(lblTeamA);

		JLabel lblTeamB = new JLabel("Team B");
		lblTeamB.setBounds(44, 133, 70, 25);
		getContentPane().add(lblTeamB);

		comboBox_1 = new JComboBox(new DefaultComboBoxModel(new String[] { one,
				two, three }));
		comboBox_1.setBounds(202, 61, 222, 25);
		getContentPane().add(comboBox_1);

		comboBox_2 = new JComboBox(list2);
		comboBox_2.setBounds(202, 97, 222, 25);
		getContentPane().add(comboBox_2);

		comboBox_3 = new JComboBox(list2);
		comboBox_3.setBounds(202, 133, 222, 25);
		getContentPane().add(comboBox_3);

		btnAdd = new JButton("Add");
		Handler handle = new Handler();
		btnAdd.setBounds(144, 327, 96, 24);
		getContentPane().add(btnAdd);
		btnAdd.addActionListener(handle);

		JTextArea txtrDisplay = new JTextArea();
		txtrDisplay.setText("Display");
		txtrDisplay.setBounds(44, 187, 380, 128);
		getContentPane().add(txtrDisplay);

		table = new JTable(data, columnNames);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(515, 79, 500, 539);
		getContentPane().add(table);
		table.setRowHeight(25);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(522, 54, 46, 14);
		getContentPane().add(lblName);

		JLabel lblTt = new JLabel("BB");
		lblTt.setBounds(604, 54, 23, 14);
		getContentPane().add(lblTt);

		JLabel lblTt_1 = new JLabel("TT");
		lblTt_1.setBounds(669, 54, 29, 14);
		getContentPane().add(lblTt_1);

		JLabel lblCr = new JLabel("CR");
		lblCr.setBounds(754, 54, 29, 14);
		getContentPane().add(lblCr);

		JLabel lblFb = new JLabel("FB");
		lblFb.setBounds(820, 54, 23, 14);
		getContentPane().add(lblFb);

		JLabel lblTimeSlot_1 = new JLabel("Time Slot");
		lblTimeSlot_1.setBounds(874, 54, 46, 14);
		getContentPane().add(lblTimeSlot_1);

		JLabel lblTimeDuration = new JLabel("Time Duration");
		lblTimeDuration.setBounds(946, 54, 86, 14);
		getContentPane().add(lblTimeDuration);
		table.setVisible(true);
	}

	/**
	   * This is the getData() method which gets data from database to display on he frame
	   * 
	   * @return Object[][]
	   * @exception SQL Exception On database error.
	   * @see SQL Exception		   
	   */
	private Object[][] getData() {
		Object[][] data = new Object[10000][5];
		try {

			Connection conn = DriverManager.getConnection(AccData.getHost(),
					AccData.getUser(), AccData.getPass());
			Statement s = conn.createStatement();
			

			int i = 0;

			
			String query = "Select Name,BB,TT,CR,FB from participantdata";
			ResultSet rs = s.executeQuery(query);

			i = 0;

			while (rs.next()) {
				data[i][0] = (String) rs.getString("Name");
				data[i][1] = (String) rs.getString("BB");
				data[i][2] = (String) rs.getString("TT");
				data[i][3] = (String) rs.getString("CR");
				data[i][4] = (String) rs.getString("FB");
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

	class Handler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(btnAdd)) {
				String time, teamA, teamB, day;
				day = "";
				time = "";
				teamA = "";
				teamB = "";
				day = comboBox.getSelectedItem().toString();
				time = comboBox_1.getSelectedItem().toString();
				teamA = comboBox_2.getSelectedItem().toString();
				teamB = comboBox_3.getSelectedItem().toString();

				if (teamA.equals(teamB)) {
					int index = comboBox_2.getSelectedIndex();
					list2.removeElementAt(index);
					comboBox_2.setModel(new DefaultComboBoxModel(list2
							.toArray()));
					comboBox_3.setModel(new DefaultComboBoxModel(list2
							.toArray()));
				} else {
					int index = comboBox_2.getSelectedIndex();
					list2.removeElementAt(index);
					comboBox_2.setModel(new DefaultComboBoxModel(list2
							.toArray()));

					index = comboBox_3.getSelectedIndex();
					list2.removeElementAt(index);
					comboBox_3.setModel(new DefaultComboBoxModel(list2
							.toArray()));

				}
				query[count] = "UPDATE scheduletable set D"
						+ day.charAt(day.length() - 1) + "=\"" + teamA + ","
						+ teamB + "\" WHERE Game = \""
						+ ID.substring(ID.lastIndexOf("_") + 1)
						+ "\" AND Time = \"" + time + "\";";
				count = count + 1;
			}
			if (e.getSource().equals(btnSubmit)) {
				try {
					Connection conn = DriverManager.getConnection(
							AccData.getHost(), AccData.getUser(),
							AccData.getPass());
					Statement s = conn.createStatement();
					int i = 0;
					while (i < count) {
						s.addBatch(query[i]);
						i = i + 1;
					}
					s.executeBatch();
				} catch (SQLException e1) {
					System.out.println(this.getClass() + "ERROR"
							+ e1.toString());
				}
			}
		}
	}
}
