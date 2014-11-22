package eventManager;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Font;

/*
 * @author monalika
 */

public class SubmitScheduleFrame extends JFrame{

	//private JFrame frame;
	String ID;
	JComboBox comboBox_1;
	
	public SubmitScheduleFrame(String id) {
		this.ID = id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
	
		//frame = new JFrame();
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblSchedule = new JLabel("Schedule");
		lblSchedule.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSchedule.setBounds(170, 22, 86, 25);
		this.getContentPane().add(lblSchedule);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(307, 225, 117, 25);
		this.getContentPane().add(btnSubmit);
		
		JButton btnEmHome = new JButton("EM Home");
		btnEmHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventManagerFrame fr = new EventManagerFrame(ID);
				setVisible(false);
			}
		});
		btnEmHome.setBounds(21, 22, 117, 25);
		getContentPane().add(btnEmHome);
		
		JComboBox comboBox = new JComboBox(new DefaultComboBoxModel(new String[] {"Day1", "Day2", "Day3"}));
		comboBox.setBounds(299, 24, 125, 20);
		getContentPane().add(comboBox);
		
		String one = "";
		String two = "";
		String three = "";
		if(ID.equals("EM_TT")){
			one  = "10-11";
			two = "1-2";
			three = "4-5";
		}
		
		
		if(ID.equals("EM_BB")){
			one = "9-11";
			two = "12-2";
			three = "3-5";
		}
		
		if(ID.equals("EM_CR")){
			one = "8-12";
			two = "2-5";
			three = "";
		}
		
		if(ID.equals("EM_FB")){
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
		
		comboBox_1 = new JComboBox(new DefaultComboBoxModel(new String[] {one,two,three}));
		comboBox_1.setBounds(202, 61, 222, 25);
		getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(202, 97, 222, 25);
		getContentPane().add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(202, 133, 222, 25);
		getContentPane().add(comboBox_3);
	}
}
