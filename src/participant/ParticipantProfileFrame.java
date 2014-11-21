package participant;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import common.DashboardFrame;

import registration.EventRegisterationFrame;
import registration.LoginFrame;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.SQLException;
import javax.swing.JLabel;

public class ParticipantProfileFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ID;
	private Participant par; 
	
	// Create and set up the window.

	public ParticipantProfileFrame(String id) {
		this.ID = id;
		setVisible(true);
		par = new Participant(this.ID);
		
		setTitle("Participant Profile");
		getContentPane().setLayout(null);
		setBounds(100, 100, 450, 300);

		JButton btnNewButton_1 = new JButton("Update Profile");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					par.updateProfile();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
			}
		});

		btnNewButton_1.setBounds(36, 183, 133, 28);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Register an Event");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				par.doEventRegPar();
				dispose();
			}
		});
		btnNewButton_2.setBounds(216, 222, 183, 28);
		getContentPane().add(btnNewButton_2);

		JButton btnNewButton = new JButton("View Dashboard");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				par.displayDash();
				// dashFrame.setVisible(true);
			}
		});
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(36, 222, 133, 28);
		getContentPane().add(btnNewButton);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(36, 54, 46, 14);
		getContentPane().add(lblName);
		
		JLabel lblId = new JLabel("ID : " + ID);
		lblId.setBounds(303, 11, 46, 14);
		getContentPane().add(lblId);
		
		JLabel lblEMail = new JLabel("E Mail");
		lblEMail.setBounds(36, 79, 46, 14);
		getContentPane().add(lblEMail);
		
		JLabel lblNamedisp = new JLabel(par.getName());
		lblNamedisp.setBounds(180, 54, 169, 14);
		getContentPane().add(lblNamedisp);
		
		JLabel lblEmaildisp = new JLabel(par.getEmail());
		lblEmaildisp.setBounds(180, 79, 169, 14);
		getContentPane().add(lblEmaildisp);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(36, 104, 46, 14);
		getContentPane().add(lblAge);
		
		JLabel lblAgedisp = new JLabel(par.getAge());
		lblAgedisp.setBounds(180, 104, 169, 14);
		getContentPane().add(lblAgedisp);
		
		JLabel lblInstitution = new JLabel("Institution");
		lblInstitution.setBounds(36, 135, 107, 14);
		getContentPane().add(lblInstitution);
		
		JLabel lblInstdisp = new JLabel(par.getInstitution());
		lblInstdisp.setBounds(180, 135, 169, 14);
		getContentPane().add(lblInstdisp);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginFrame login = new LoginFrame();
				dispose();
			}
		});
		btnLogOut.setBounds(36, 20, 89, 23);
		getContentPane().add(btnLogOut);
		final JPanel panel = new JPanel();

	}

	public static void main(String[] args) {

		final String id= "P_6";
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();

			}

			private void createAndShowGUI() {

				ParticipantProfileFrame ex = new ParticipantProfileFrame(id);
				ex.setVisible(true);
			}
		});

	}
}
