package eventManager;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * @author monalika
 */

public class SubmitScheduleFrame extends JFrame{

	//private JFrame frame;
	String ID;
	
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
		lblSchedule.setBounds(173, 27, 70, 15);
		this.getContentPane().add(lblSchedule);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(164, 178, 117, 25);
		this.getContentPane().add(btnSubmit);
		
		JButton btnEmHome = new JButton("EM Home");
		btnEmHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventManagerFrame fr = new EventManagerFrame(ID);
				setVisible(false);
			}
		});
		btnEmHome.setBounds(164, 225, 117, 25);
		getContentPane().add(btnEmHome);
	}

}
