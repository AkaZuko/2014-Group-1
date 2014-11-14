package participant;

import java.awt.event.ActionEvent;

public class ParticipantProfileFrame extends JFrame {

	private String id;

	// Create and set up the window.

	public ParticipantProfileFrame(final String id) {
		this.id = id;

		final Participant par = new Participant(id);
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

		btnNewButton_1.setBounds(48, 26, 147, 57);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Register an Event");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				par.doEventRegPar();
				dispose();
			}
		});
		btnNewButton_2.setBounds(48, 104, 147, 57);
		getContentPane().add(btnNewButton_2);

		JButton btnNewButton = new JButton("View Dashboard");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				par.displayDash();
				// dashFrame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(48, 177, 147, 57);
		getContentPane().add(btnNewButton);
		final JPanel panel = new JPanel();

	}

	public static void main(String[] args) {

		final String id= "a";
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
