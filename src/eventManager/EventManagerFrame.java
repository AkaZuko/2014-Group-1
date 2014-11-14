package eventManager;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;


public class EventManagerFrame {

	private JFrame frame;
	private JButton btnUpdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventManagerFrame window = new EventManagerFrame("");
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
	public EventManagerFrame(String ID) {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblProfile = new JLabel("Profile");
		lblProfile.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblProfile.setBounds(189, 24, 65, 30);
		frame.getContentPane().add(lblProfile);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(48, 52, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblEmailId = new JLabel("E-mail ID");
		lblEmailId.setBounds(48, 105, 65, 14);
		frame.getContentPane().add(lblEmailId);
		
		JLabel lblInstitutionName = new JLabel("Institution Name");
		lblInstitutionName.setBounds(83, 133, 118, 14);
		frame.getContentPane().add(lblInstitutionName);
		
		JLabel lblPost = new JLabel("Post");
		lblPost.setBounds(48, 78, 46, 14);
		frame.getContentPane().add(lblPost);
		
		
		
		JButton btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(276, 227, 127, 23);
		frame.getContentPane().add(btnDashboard);
		
		JLabel txtName = new JLabel();
		txtName.setBackground(SystemColor.control);
		txtName.setBounds(203, 52, 200, 23);
		frame.getContentPane().add(txtName);
		
		JLabel textAge = new JLabel();
		textAge.setBackground(SystemColor.control);
		textAge.setBounds(189, 78, 234, 23);
		frame.getContentPane().add(textAge);
		
		JLabel textEmailID = new JLabel();
		textEmailID.setBackground(SystemColor.control);
		textEmailID.setBounds(189, 96, 234, 23);
		frame.getContentPane().add(textEmailID);
		
		JLabel textInstName = new JLabel();
		textInstName.setBackground(SystemColor.control);
		textInstName.setBounds(178, 121, 260, 38);
		frame.getContentPane().add(textInstName);
		textInstName.setText("BITS PILANI KK BIRLA GOA Campus");
		
		JButton btnSchedule = new JButton("Schedule");
		btnSchedule.setBounds(48, 226, 117, 25);
		frame.getContentPane().add(btnSchedule);
	}
	
	class Handler implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(e.getSource().equals(btnUpdate)){
							
			}
			
		}
	}
}