package eventManager;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

/*
 * @author monalika
 */


public class SubmitResultsFrame extends JFrame {

	//private JFrame frame;
	private JTextField textField;
	private String ID;
	
	public SubmitResultsFrame(String id) {
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
		
		JLabel lblSubmitResults = new JLabel("Submit Results");
		lblSubmitResults.setBounds(154, 23, 142, 15);
		this.getContentPane().add(lblSubmitResults);
		
		JLabel lblResult = new JLabel("Result:");
		lblResult.setBounds(31, 98, 70, 15);
		this.getContentPane().add(lblResult);
		
		textField = new JTextField();
		textField.setBounds(104, 96, 148, 19);
		this.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(298, 93, 117, 25);
		getContentPane().add(btnSubmit);
		
		JButton btnEmHome = new JButton("EM Home");
		btnEmHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				EventManagerFrame fr = new EventManagerFrame(ID);
				setVisible(false);
			}
		});
		btnEmHome.setBounds(179, 181, 117, 25);
		getContentPane().add(btnEmHome);
		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String text = textField.getText();
			
		       try {
		   
		         BufferedWriter output = new BufferedWriter(new FileWriter("\\Group-1\\res\\results.txt",true));
		        
		         output.append(text+'\n');
		        // output.newLine();
		         
		         output.close();
		       } catch ( IOException e ) {
		          e.printStackTrace();
		       }
			}
		});
	}

}
