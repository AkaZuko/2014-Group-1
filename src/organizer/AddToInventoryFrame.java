package organizer;

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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;

import common.AccData;

import eventManager.EventManagerFrame;

/**This Frame is used to add inventory items by the event manager
 * 
 * @author spree_group1
 * @version 1.0
 *
 */
public class AddToInventoryFrame extends JFrame{

	private JFrame frame;
	private String ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args){
		try{
			AddToInventoryFrame var = new AddToInventoryFrame(args[0]);
			var.frame.setVisible(true);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * Frame for addition of resources in inventory
	 @param id id number of Event Manager
	 */
	public AddToInventoryFrame(String id) {
		this.ID=id;
	//	this.setVisible(true);
		initialize();
	}

	/**
	 * Initializes the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAddToInventory = new JLabel("ADD TO INVENTORY");
		lblAddToInventory.setBounds(156, 27, 122, 14);
		frame.getContentPane().add(lblAddToInventory);
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setBounds(101, 70, 66, 14);
		frame.getContentPane().add(lblItemName);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(101, 110, 54, 14);
		frame.getContentPane().add(lblQuantity);
		
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
		itemSelect.setBounds(249, 70, 100, 17);
		frame.getContentPane().add(itemSelect);
		
		final JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner.setBounds(249, 107, 66, 20);
		frame.getContentPane().add(spinner);
		
		final JLabel lblUpdate = new JLabel("");
		lblUpdate.setBounds(141, 201, 137, 14);
		frame.getContentPane().add(lblUpdate);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBounds(177, 156, 66, 17);
		frame.getContentPane().add(btnAdd);
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String a = (String) itemSelect.getSelectedItem();
				System.out.println(a);
				int b= (int) spinner.getValue();
				System.out.println(b);
				spinner.setValue(1);
				lblUpdate.setText("INVENTORY UPDATED");
				EventHead evh=new EventHead(ID);
				evh.pushItem(a,b);
			}
		});
		
		JButton btnEhHome = new JButton("EH Home");
		btnEhHome.setBounds(20, 23, 89, 18);
		frame.getContentPane().add(btnEhHome);
		
		btnEhHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			System.out.println(ID);
				OrganizerProfileFrame opf = new OrganizerProfileFrame(ID);
				opf.setVisible(true);
				
			}
		});
	}
}
