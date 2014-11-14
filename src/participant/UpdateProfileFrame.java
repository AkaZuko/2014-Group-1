package participant;
import javax.swing.JFrame;


public class UpdateProfileFrame extends JFrame {
	private JTextField txtName;
	private JTextField textUpName;
	private JTextField txtIns;
	private JTextField textUpIns;
	private JTextField txtAge;
	private JTextField txtEmailAddress;
	private JTextField textUpAge;
	private JTextField textUpEmail;
	private JTextField txtPassword;
	private JTextField textUpPswd;
	private JButton btnBack;
	
	private String id;
	public UpdateProfileFrame(final String id) throws SQLException {
		this.id = id;
		
		getContentPane().setLayout(null);
		final Participant par = new Participant(id);
		txtName = new JTextField();
		txtName.setText("Name :");
		txtName.setBounds(36, 29, 48, 20);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		txtName.setEditable(false);
		txtName.setBorder(null);
		
		textUpName = new JTextField();
		textUpName.setBounds(150, 29, 86, 20);
		getContentPane().add(textUpName);
		textUpName.setColumns(10);
		textUpName.setText(par.getName());
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					par.setName(textUpName.getText());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					par.setInstitution(textUpIns.getText());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					par.setAge(Integer.parseInt(textUpAge.getText()));
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					par.setEmail(textUpEmail.getText());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					par.setPassword(textUpPswd.getText());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ParticipantProfileFrame parFrame = new ParticipantProfileFrame(id);
				parFrame.setVisible(true);  
	            dispose(); 
			}
		});
		saveButton.setBounds(292, 208, 89, 23);
		getContentPane().add(saveButton);
		
		txtIns = new JTextField();
		txtIns.setText("Institution :");
		txtIns.setBounds(36, 60, 96, 20);
		getContentPane().add(txtIns);
		txtIns.setColumns(10);
		txtIns.setEditable(false);
		txtIns.setBorder(null);
		
		textUpIns = new JTextField();
		textUpIns.setBounds(150, 60, 86, 20);
		getContentPane().add(textUpIns);
		textUpIns.setColumns(10);
		textUpIns.setText(par.getInstitution());
		
		txtAge = new JTextField();
		txtAge.setText("Age:");
		txtAge.setBounds(36, 91, 86, 20);
		getContentPane().add(txtAge);
		txtAge.setColumns(10);
		txtAge.setEditable(false);
		txtAge.setBorder(null);
		
		txtEmailAddress = new JTextField();
		txtEmailAddress.setText(" Email Address :");
		txtEmailAddress.setBounds(36, 122, 89, 20);
		getContentPane().add(txtEmailAddress);
		txtEmailAddress.setColumns(10);
		txtEmailAddress.setEditable(false);
		txtEmailAddress.setBorder(null);
		
		textUpAge = new JTextField();
		textUpAge.setBounds(150, 91, 86, 20);
		getContentPane().add(textUpAge);
		textUpAge.setColumns(10);
		textUpAge.setText(String.valueOf(par.getAge()));
		
		textUpEmail = new JTextField();
		textUpEmail.setBounds(150, 122, 86, 20);
		getContentPane().add(textUpEmail);
		textUpEmail.setColumns(10);
		textUpEmail.setText(par.getEmail());
		
		txtPassword = new JTextField();
		txtPassword.setText("Password :");
		txtPassword.setBounds(39, 153, 86, 20);
		getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		txtPassword.setEditable(false);
		txtPassword.setBorder(null);
		
		textUpPswd = new JTextField();
		textUpPswd.setBounds(150, 153, 86, 20);
		getContentPane().add(textUpPswd);
		textUpPswd.setColumns(10);
		textUpPswd.setText(par.getPassword());
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ParticipantProfileFrame parFrame = new ParticipantProfileFrame(id);
				parFrame.setVisible(true);  
	            dispose();
			}
		});
		btnBack.setBounds(43, 208, 89, 23);
		getContentPane().add(btnBack);
		setTitle("Update Profile");
		setBounds(100, 100, 450, 300);
	}
	
	
}
