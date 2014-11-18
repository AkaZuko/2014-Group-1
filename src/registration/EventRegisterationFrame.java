package registration;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;

import common.AccData;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EventRegisterationFrame {

	private JFrame frame;
	private String ID;
	private String Inst; 
	String[] listOfParticipant;
	JList list;
	JButton btnRegister;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventRegisterationFrame window = new EventRegisterationFrame("","BITS GOA");
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
	public EventRegisterationFrame(String id, String inst ) {
		this.ID = id;
		this.Inst = inst;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Vector<String> participantname = new Vector<>();
		try{
			Connection conn = DriverManager.getConnection(AccData.getHost(), "root", "12345");
			Statement s = conn.createStatement();
			String query = "Select ID,Name from participantdata where Institute=\""+this.Inst+"\";";
			ResultSet rs = s.executeQuery(query);
			int i = 0;
			while (rs.next()) participantname.add(rs.getString("Name"));
			rs.close();
			s.close();
			conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Basketball", "Cricket", "Football", "TableTennis"}));
		comboBox.setBounds(181, 67, 146, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblEventName = new JLabel("Event Name");
		lblEventName.setBounds(64, 67, 72, 17);
		frame.getContentPane().add(lblEventName);
		
		JLabel lblEventRegistration = new JLabel("Event Registration");
		lblEventRegistration.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEventRegistration.setBounds(156, 11, 146, 33);
		frame.getContentPane().add(lblEventRegistration);

		list = new JList();
		list.setBounds(64, 98, 263, 114);
		frame.getContentPane().add(list);
		list.setListData(participantname);
		
		btnRegister = new JButton("Register");
		btnRegister.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnRegister);
		Handler handle = new Handler();
		btnRegister.addActionListener(handle);
		
	}
	class Handler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource().equals(btnRegister)){
				int i = 0;
				
				
				try{
					listOfParticipant = (String[]) list.getSelectedValues();
					System.out.println(listOfParticipant.length);
				while(i<listOfParticipant.length){
					if(listOfParticipant[i]!=null)
				System.out.println(listOfParticipant[i]);
				++i;
				}}catch(NullPointerException f){
					System.out.println(f.toString());
				}
			}
	}
}
}
