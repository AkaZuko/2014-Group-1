package eventManager;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;

/*
 * @author monalika
 */

public class ViewResultFrame extends JFrame {
	private String ID;

	public ViewResultFrame(String id) {
		this.ID = id;
		initialize();
	}
	String[] x = new String[100];
	static int i= 0;
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		try{
			FileReader inputFile = new FileReader("\\Group-1\\res\\results.txt");
		
		 BufferedReader bufferReader = new BufferedReader(inputFile);
		 String line;
		 while ((line = bufferReader.readLine()) != null)   {
			 
			//to store all the lines
			x[i] = line;
			 i++;
	            System.out.println(line);
	        
	    }
		
	    bufferReader.close();
	    }

	catch(Exception e){
	            System.out.println("Error while reading file line by line:" 
	            + e.getMessage());                      
	    }
		 
	
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblResults = new JLabel("Results");
		lblResults.setBounds(170, 12, 70, 15);
		getContentPane().add(lblResults);
	
		
		String message = "   ";
		int p=i;
	
		if(p>7){
			message = x[i-1]+'\n'+x[i-2]+'\n'+x[i-3]+'\n'+x[i-4]+'\n'+x[i-5]+x[i-6]+'\n'+x[i-7] + '\n' + x[i-8];
		}
		else if (p==7){
			message = x[i-1]+'\n'+x[i-2]+'\n'+x[i-3]+'\n'+x[i-4]+'\n'+x[i-5]+x[i-6]+'\n'+x[i-7];

		}
		else if(p==6){
			message = x[i-1]+'\n'+x[i-2]+'\n'+x[i-3]+'\n'+x[i-4]+'\n'+x[i-5]+x[i-6];

		}
		else if(p==5){
			message = x[i-1]+'\n'+x[i-2]+'\n'+x[i-3]+'\n'+x[i-4]+'\n'+x[i-5];

		}
		else if(p==4){
			message = x[i-1]+'\n'+x[i-2]+'\n'+x[i-3]+'\n'+x[i-4];

		}
		else if(p==3){
			message = x[i-1]+'\n'+x[i-2]+'\n'+x[i-3];

		}
		else if(p==2){
			message = x[i-1] + '\n' + x[i-2];

		}
		else if(p==1){
			message = x[i-1];

		}
		else if(p<1){
			message = " ";

		}
		
		
		
		//this is let us see the results for last 6 matches
		JTextArea textArea = new JTextArea(message);
		textArea.setBounds(47, 37, 364, 159);
		getContentPane().add(textArea);
		
		
		JButton btnEmHome = new JButton("EM Home");
		btnEmHome.setBounds(155, 223, 117, 25);
		getContentPane().add(btnEmHome);
		btnEmHome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EventManagerFrame fr = new EventManagerFrame(ID);
				setVisible(false);
			}
		});

}
}
