package common;

/*
 * This class provides functionality for 
 * viewing the inventory.
 * 
 * @author Group1_Spree
 * @version 1.0
 */

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
import java.io.IOException;

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
	 * Create the application.
	 * @throws IOException 
	 */
	public ViewInventoryFrame() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
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
