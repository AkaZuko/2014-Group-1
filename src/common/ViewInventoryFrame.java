package common;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTable;
import java.awt.Font;

public class ViewInventoryFrame {

	private JFrame frame;
	private AccData account;
	private JTable table;
	private JLabel lblName;
	private JLabel lblMaxcapacity;
	private JLabel lblMincapacity;
	private JLabel lblNoofitems;
	private JLabel lblLastmodified;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewInventoryFrame window = new ViewInventoryFrame();
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
	public ViewInventoryFrame() {
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
		
		JLabel labelName = new JLabel("INVENTORY");
		labelName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelName.setBounds(172, 21, 172, 14);
		frame.getContentPane().add(labelName);
		Object[][] data;
		Inventory inventory = new Inventory();
		
		data = (Object[][]) inventory.viewInventory();
		
		String[] columnNames = {"Name",
                "Maximum Capacity",
                "Minimum Capacity",
                "No Of Items",
                "Last Date of Modification"};
		
		table = new JTable(data,columnNames);
		table.setBounds(20, 70, 382, 160);
		frame.getContentPane().add(table);
		
		lblName = new JLabel("Name");
		lblName.setBounds(37, 45, 46, 14);
		frame.getContentPane().add(lblName);
		
		lblMaxcapacity = new JLabel("MaxCapacity");
		lblMaxcapacity.setBounds(93, 45, 71, 14);
		frame.getContentPane().add(lblMaxcapacity);
		
		lblMincapacity = new JLabel("MinCapacity");
		lblMincapacity.setBounds(172, 46, 68, 14);
		frame.getContentPane().add(lblMincapacity);
		
		lblNoofitems = new JLabel("NoOfItems");
		lblNoofitems.setBounds(250, 46, 63, 14);
		frame.getContentPane().add(lblNoofitems);
		
		lblLastmodified = new JLabel("LastModified");
		lblLastmodified.setBounds(323, 46, 79, 14);
		frame.getContentPane().add(lblLastmodified);
		
	}
}
