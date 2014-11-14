package organizer;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import registration.LoginFrame;

public class OrganizerProfileFrame {

	private JFrame frame;
	private JButton btnUpdate;
	Convenor convenor = null;
	EventHead eventHead = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrganizerProfileFrame window = new OrganizerProfileFrame("");
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
	public OrganizerProfileFrame(String ID) {
		//instantiates the user based upon ID
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
		lblProfile.setBounds(193, 11, 65, 30);
		frame.getContentPane().add(lblProfile);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(83, 53, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblEmailId = new JLabel("E-mail ID");
		lblEmailId.setBounds(83, 104, 65, 14);
		frame.getContentPane().add(lblEmailId);
		
		JLabel lblInstitutionName = new JLabel("Institution Name");
		lblInstitutionName.setBounds(83, 132, 97, 14);
		frame.getContentPane().add(lblInstitutionName);
		
		JLabel lblPost = new JLabel("Post");
		lblPost.setBounds(83, 79, 46, 14);
		frame.getContentPane().add(lblPost);
		
		
		
		JButton btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(276, 227, 127, 23);
		frame.getContentPane().add(btnDashboard);
		
		JLabel txtName = new JLabel();
		txtName.setBackground(SystemColor.control);
		txtName.setBounds(223, 52, 200, 23);
		frame.getContentPane().add(txtName);
		
		JLabel textAge = new JLabel();
		textAge.setBackground(SystemColor.control);
		textAge.setBounds(223, 70, 200, 23);
		frame.getContentPane().add(textAge);
		
		JLabel textEmailID = new JLabel();
		textEmailID.setBackground(SystemColor.control);
		textEmailID.setBounds(223, 96, 200, 23);
		frame.getContentPane().add(textEmailID);
		
		JLabel textInstName = new JLabel();
		textInstName.setBackground(SystemColor.control);
		textInstName.setBounds(223, 117, 200, 44);
		frame.getContentPane().add(textInstName);
		textInstName.setText("BITS PILANI KK BIRLA GOA Campus");
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginFrame login = new LoginFrame();
				frame.dispose();
			}
		});
		btnLogOut.setBounds(22, 18, 89, 23);
		frame.getContentPane().add(btnLogOut);
	}
	
	class Handler implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(e.getSource().equals(btnUpdate)){
							
			}
			
		}
	}
}
