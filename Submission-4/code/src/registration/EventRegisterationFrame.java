package registration;

import java.awt.EventQueue;

import javax.swing.ComboBoxModel;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;

import common.AccData;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JTextField;

import participant.ParticipantProfileFrame;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.sun.corba.se.spi.orbutil.fsm.State;

import departments.Finance;

public class EventRegisterationFrame {

	private JFrame frame;
	private String ID;
	private String Inst; 
	private String[] listOfParticipant;
	private JList list;
	private JButton btnRegister;
	private JTextField txtTeamname;
	private Vector<String> addedparticipants;
	private Vector<String> participantname;
	private JComboBox comboBox_1;
	private JButton btnAdd;
	private JComboBox comboBox;
	private JLabel lblWarning;
	private JButton btnBack;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventRegisterationFrame window = new EventRegisterationFrame("P_1","BITS GOA");
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
		participantname = new Vector<>();
		addedparticipants = new Vector<>();
		try{
			Connection conn = DriverManager.getConnection(AccData.getHost(), AccData.getUser(), AccData.getPass());
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
		frame.setVisible(true);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Basketball", "Cricket", "Football", "TableTennis"}));
		comboBox.setBounds(181, 45, 200, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblEventName = new JLabel("Event Name");
		lblEventName.setBounds(64, 47, 72, 17);
		frame.getContentPane().add(lblEventName);
		
		JLabel lblEventRegistration = new JLabel("Event Registration");
		lblEventRegistration.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEventRegistration.setBounds(156, 11, 146, 33);
		frame.getContentPane().add(lblEventRegistration);

		list = new JList();
		list.setBounds(181, 138, 200, 83);
		frame.getContentPane().add(list);
		//list.setListData(participantname);
		
		btnRegister = new JButton("Register");
		btnRegister.setBounds(64, 198, 89, 23);
		frame.getContentPane().add(btnRegister);
		
		JLabel lblTeamname = new JLabel("TeamName");
		lblTeamname.setBounds(64, 75, 72, 14);
		frame.getContentPane().add(lblTeamname);
		
		txtTeamname = new JTextField();
		txtTeamname.setBounds(181, 76, 200, 20);
		frame.getContentPane().add(txtTeamname);
		txtTeamname.setColumns(10);
		
		JLabel lblMember = new JLabel("Member");
		lblMember.setBounds(64, 106, 89, 14);
		frame.getContentPane().add(lblMember);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(181, 107, 200, 20);
		frame.getContentPane().add(comboBox_1);
		
		comboBox_1.setModel(new DefaultComboBoxModel(participantname.toArray()));
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(64, 158, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		lblWarning = new JLabel("");
		lblWarning.setBounds(64, 232, 317, 18);
		frame.getContentPane().add(lblWarning);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				ParticipantProfileFrame par = new ParticipantProfileFrame(ID);
				
			}
		});
		btnBack.setBounds(10, 13, 89, 23);
		frame.getContentPane().add(btnBack);
		
		
		Handler handle = new Handler();
		btnRegister.addActionListener(handle);
		btnAdd.addActionListener(handle);
		
	}
	class Handler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource().equals(btnRegister)){
				int noOfPart = participantname.size();
				if(validate(comboBox.getSelectedItem().toString(),noOfPart)) lblWarning.setText("Select apt number of players");
				else{
					try {
						Connection conn = DriverManager.getConnection(AccData.getHost(),AccData.getUser(), AccData.getPass());
						Statement s = conn.createStatement();
						String query;
						String game = "";
						if(comboBox.getSelectedItem().toString().equals("Basketball")) game = "BB";
						if(comboBox.getSelectedItem().toString().equals("Football")) game = "FB";
						if(comboBox.getSelectedItem().toString().equals("Cricket")) game = "CR";
						if(comboBox.getSelectedItem().toString().equals("TableTennis")) game = "TT";
						while(addedparticipants.size() != 0){
							query = "UPDATE participantdata SET "+game+"=\""+txtTeamname.getText()+
									"\" WHERE Name =\""+addedparticipants.get(0)+"\";";
							s.addBatch(query);
							addedparticipants.remove(0);
						}
						int count[] = s.executeBatch();
						/*DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
						Date date = new Date();
						String data = dateFormat.format(date);
						DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
						Date date2 = new Date();
						String data2 = dateFormat2.format(date2);
						String query2 = "";*/
						//quer2 is inside the following if, just commented outside
						//query2 = "INSERT INTO finance Values(\"" + data + "\",2500,\"" + data2 +"\");";
						if(!comboBox.getSelectedItem().toString().equals("TableTennis"))
							try {
								new Finance().addPayment("2500");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								System.out.println(this.getClass().toString() + " ERROR : " + e.toString());
							}
						else
							try {
								new Finance().addPayment("500");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								System.out.println(this.getClass().toString() + " ERROR : " + e.toString());
							}
						frame.dispose();
						ParticipantProfileFrame par = new ParticipantProfileFrame(ID);
						conn.close();
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.out.println(this.getClass().toString() + " ERROR : " + e.toString());
						e1.printStackTrace();
					}
					
				}
			}
			else if(e.getSource().equals(btnAdd)){
				int noOfPart = participantname.size();
				if(validate(comboBox.getSelectedItem().toString(),noOfPart)){
				addedparticipants.add((String) comboBox_1.getSelectedItem().toString());
				list.setListData(addedparticipants);
				int index = comboBox_1.getSelectedIndex();
				participantname.removeElementAt(index);
				comboBox_1.setModel(new DefaultComboBoxModel(participantname.toArray()));
				}
			}
	}
		private Boolean validate(String game,int number){
			if(game.equals("Basketball"))
				if(number<5) return true;
			if(game.equals("TableTennis"))
				if(number<1) return true;
			if(game.equals("Football"))
				if(number<11) return true;
			if(game.equals("Cricket"))
				if(number<11) return true;
			
			return false;
		}
}
}
