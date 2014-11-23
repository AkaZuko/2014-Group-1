package eventManager;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;

import common.AccData;

public class RequestInventoryFrame extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private  String ID;

	/**
	 * Launch the application.
	 */
public static void main(String[] args) {
		
				try {
					RequestInventoryFrame window = new RequestInventoryFrame(args[0]);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
		
	}

	/**
	 * Create the application.
	 */
	public RequestInventoryFrame(String id) {
		this.ID = id;
		initialize();
		setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
	//	final String id=ID;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRequestInventory = new JLabel("Put Request in Inventory");
		lblRequestInventory.setBounds(156, 32, 160, 14);
		frame.getContentPane().add(lblRequestInventory);
		
		String[] items = new String[100];
		try {
			Connection conn = DriverManager.getConnection(AccData.getHost(),  AccData.getUser(),  AccData.getPass());
			Statement s = conn.createStatement();
			String query = "Select Name from inventory";
			ResultSet rs = s.executeQuery(query);
			
			int i = 0;
			
			while(rs.next()){
				
				items[i] = (String)rs.getString("Name");
				
				
				++i;
			}
			
			rs.close();
			s.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		
		final JComboBox itemSelect = new JComboBox();
		itemSelect.setModel(new DefaultComboBoxModel(items));
		itemSelect.setBounds(219, 74, 111, 20);
		frame.getContentPane().add(itemSelect);
		
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setBounds(82, 77, 68, 14);
		frame.getContentPane().add(lblItemName);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(82, 121, 68, 14);
		frame.getContentPane().add(lblQuantity);
		
		final JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner.setBounds(239, 118, 43, 20);
		frame.getContentPane().add(spinner);
		
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBounds(82, 197, 89, 17);
		frame.getContentPane().add(btnSubmit);
		
		final JLabel lblResponse = new JLabel("");
		lblResponse.setBounds(82, 172, 248, 14);
		frame.getContentPane().add(lblResponse);
		
		JButton btnnewRequest = new JButton("Put another Request");
		btnnewRequest.setBounds(248, 197, 176, 17);
		frame.getContentPane().add(btnnewRequest);
		
		JButton btnEmHome = new JButton("EM Home");
		btnEmHome.setBounds(164, 225, 89, 23);
		frame.getContentPane().add(btnEmHome);
		
		btnEmHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventManagerFrame fr = new EventManagerFrame(ID);
				setVisible(false);
				
			}
		});
		
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String a = (String) itemSelect.getSelectedItem();
				System.out.println(a);
				int b= (int) spinner.getValue();
				System.out.println(b);
				lblResponse.setText("your request is forwaded to event head");
				spinner.setValue(0);
				requestInventory(a,b);
				
			}
		});
		
		
	}

	protected void requestInventory(String item, int value) {
		
		try {
			Connection conn = DriverManager.getConnection(AccData.getHost(), AccData.getUser(), AccData.getPass());
			Statement stmt = conn.createStatement();
			String query = "Select * from RequestInventory";
			ResultSet rs = stmt.executeQuery(query);
			
			int i = 1;
			
			while(rs.next()){
				++i;
			}
		//	query = "UPDATE Inventory set NoOfItems = "+Integer.toString(i)+" where Name=\"" + item + "\";";
			String sql = "INSERT INTO requestinventory(Number,ItamName,Quantity)"
					+ " VALUES ("+Integer.toString(i)+",\""+ item +"\","+Integer.toString(value)+");"; 
		
	         stmt.executeUpdate(sql);
	         
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
}
