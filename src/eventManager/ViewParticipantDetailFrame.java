package eventManager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import registration.RegisterationDetailFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * @author monalika
 */

public class ViewParticipantDetailFrame extends JFrame{

//	private JFrame frame;
	String ID;
	/**
	 * Launch the application.
	 the application.
	 */
	public ViewParticipantDetailFrame(String id) {
		this.ID = id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblParticipantDetails = new JLabel("Participant Details");
		lblParticipantDetails.setBounds(142, 30, 205, 29);
		getContentPane().add(lblParticipantDetails);
		
		JButton btnEmHome = new JButton("EM Home");
		btnEmHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventManagerFrame fr = new EventManagerFrame(ID);
				setVisible(false);
				
			}
		});
		btnEmHome.setBounds(158, 193, 117, 25);
		getContentPane().add(btnEmHome);
	}
	
	

}
