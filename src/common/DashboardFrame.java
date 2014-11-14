package common;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DashboardFrame {

	private JFrame frame;
	String[] x = new String[100];
	
	static int i= 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardFrame window = new DashboardFrame();
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
	public DashboardFrame() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		 String results = "";
		try{
			FileReader inputFile = new FileReader("\\Group-1\\res\\message.txt");
			FileReader inputFile2 = new FileReader("\\Group-1\\res\\results.txt");
		 BufferedReader bufferReader = new BufferedReader(inputFile);
		 BufferedReader bufferReader2 = new BufferedReader(inputFile2);
		 String line;
		
		 while ((line = bufferReader.readLine()) != null)   {
			 
			//to store all the lines
			x[i] = line;
			 i++;
			 System.out.println(line);
	        
	    }
		 while ((line=bufferReader2.readLine()) != null){
			 results = results + line + '\n';
		 }
		
	    bufferReader.close();
	    }catch(Exception e){
            System.out.println("Error while reading file line by line:" 
            + e.getMessage());                      
    }
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

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrResult = new JTextArea();
		txtrResult.setBackground(SystemColor.control);
		txtrResult.setBounds(10, 89, 414, 136);
		frame.getContentPane().add(txtrResult);
		txtrResult.setText(results);
		
		JLabel lblDashboard = new JLabel("----------------------------DASHBOARD-------------------------");
		lblDashboard.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDashboard.setBounds(10, 11, 414, 31);
		frame.getContentPane().add(lblDashboard);
		
		JLabel lblResults = new JLabel("Results");
		lblResults.setBounds(195, 53, 56, 25);
		frame.getContentPane().add(lblResults);
		
		JLabel lblMessages = new JLabel("Messages");
		lblMessages.setBounds(195, 250, 56, 14);
		frame.getContentPane().add(lblMessages);
		lblMessages.setText("Message");
		
		JTextArea txtrMessage = new JTextArea();
		txtrMessage.setBackground(SystemColor.control);
		txtrMessage.setText(message);
		txtrMessage.setBounds(10, 275, 414, 147);
		frame.getContentPane().add(txtrMessage);
		
		JLabel lblSchedule = new JLabel("Schedule");
		lblSchedule.setBounds(195, 444, 80, 14);
		frame.getContentPane().add(lblSchedule);
		
		JTextArea txtrSchedule = new JTextArea();
		txtrSchedule.setBackground(SystemColor.control);
		txtrSchedule.setText("");
		txtrSchedule.setBounds(10, 469, 414, 181);
		frame.getContentPane().add(txtrSchedule);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnClose.setBounds(315, 53, 89, 23);
		frame.getContentPane().add(btnClose);
		
		
	}
}
