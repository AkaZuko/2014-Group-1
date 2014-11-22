package participant;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import common.AccData;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class UpdateProfileFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel txtName;
	private JTextField txtIns;
	private JTextField txtAge;
	private JTextField txtEmailAddress;
	private JTextField txtPassword;
	JButton saveButton;
	private String id;
	private JTextField txtname;
	private JTextField txtinst;
	private JTextField txtage;
	private JTextField txtemail;
	private JTextField txtpass;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	
	public UpdateProfileFrame(final String id) {
		this.id = id;
		
		getContentPane().setLayout(null);
		Participant par = new Participant(id);
		txtName = new JLabel("Name :");
		txtName.setBounds(36, 29, 48, 20);
		getContentPane().add(txtName);
		txtName.setBorder(null);
		
		
		saveButton = new JButton("Save");
		/*saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				ParticipantProfileFrame parFrame = new ParticipantProfileFrame(id);
				parFrame.setVisible(true);  
	            dispose(); 
			}
		});*/
		saveButton.setBounds(292, 208, 89, 23);
		getContentPane().add(saveButton);
		Handler handle = new Handler();
		saveButton.addActionListener(handle);
		
		txtIns = new JTextField();
		txtIns.setText("Institution :");
		txtIns.setBounds(36, 60, 96, 20);
		getContentPane().add(txtIns);
		txtIns.setColumns(10);
		txtIns.setEditable(false);
		txtIns.setBorder(null);
		
		
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
		
		txtPassword = new JTextField();
		txtPassword.setText("Password :");
		txtPassword.setBounds(39, 153, 86, 20);
		getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		txtPassword.setEditable(false);
		txtPassword.setBorder(null);
		
		txtname = new JTextField();
		txtname.setBounds(142, 29, 218, 20);
		getContentPane().add(txtname);
		txtname.setColumns(10);
		
		txtinst = new JTextField();
		txtinst.setBounds(142, 60, 218, 20);
		getContentPane().add(txtinst);
		txtinst.setColumns(10);
		
		txtage = new JTextField();
		txtage.setBounds(142, 91, 218, 20);
		getContentPane().add(txtage);
		txtage.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setBounds(142, 122, 218, 20);
		getContentPane().add(txtemail);
		txtemail.setColumns(10);
		
		txtpass = new JTextField();
		txtpass.setBounds(142, 153, 218, 20);
		getContentPane().add(txtpass);
		txtpass.setColumns(10);
		
		label1 = new JLabel("");
		label1.setBounds(10, 32, 28, 14);
		getContentPane().add(label1);
		
		label2 = new JLabel("");
		label2.setBounds(10, 63, 46, 14);
		getContentPane().add(label2);
		
		label3 = new JLabel("");
		label3.setBounds(10, 94, 46, 14);
		getContentPane().add(label3);
		
		label4 = new JLabel("");
		label4.setBounds(10, 125, 46, 14);
		getContentPane().add(label4);
		
		label5 = new JLabel("");
		label5.setBounds(10, 156, 46, 14);
		getContentPane().add(label5);
		setTitle("Update Profile");
		setBounds(100, 100, 450, 300);
	}
	
	class Handler implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(e.getSource().equals(saveButton)){
				//sequence : name id pass email address age inst
				Boolean status = false;
					try {
						Connection conn = DriverManager.getConnection(AccData.getHost(), AccData.getUser(), AccData.getPass());
						Statement s = conn.createStatement();
						String query = "Update participantdata SET Name=\"" + txtname.getText() + 
								"\",Password=\"" + txtpass.getText() + 
								"\",Email=\"" + txtemail.getText() + 
								"\",Age=" + txtage.getText() + 
								",Institute=\"" + txtinst.getText() + 
								"\" WHERE ID=\"" + id + "\";" ;
						
						String query2 = "Update logindata SET Name=\"" + txtname.getText() + 
								"\",Password=\"" + txtpass.getText() + 
								"\",Email=\"" + txtemail.getText() +  
								"\" WHERE ID=\"" + id + "\";" ;
						
						if(validate())  {
							status = s.execute(query);
							status = s.execute(query2);
							setVisible(false);
							ParticipantProfileFrame par = new ParticipantProfileFrame(id);
							par.setVisible(true);
							}
						s.close();
						conn.close();
					} catch (SQLException e1) {
						System.out.println(e1.toString());
					}
				
				//frame.setVisible(false);
							
			}
		}
			private Boolean validate(){
					
				if(!txtname.getText().matches("([a-zA-Z]){1,} ([a-zA-Z]){1,}")) label1.setText("*");
				else label1.setText("");	
				
				if(!txtemail.getText().matches("^[\\w-]+(?:\\.[\\w-]+)*@(?:[\\w-]+\\.)+[a-zA-Z]{2,7}$")) label4.setText("*");
				else label4.setText("");				
				
				if(txtpass.getText().isEmpty() || txtpass.getText().getBytes().length<6 ) label5.setText("*");
				else label5.setText("");
				
				if(!txtage.getText().matches("[1-9][0-9]?[0-9]?")) label3.setText("*");
				else label3.setText("");
				
				if(!txtinst.getText().matches("([a-zA-Z ^0-9]){1,}")) label2.setText("*");
				else label2.setText("");
				
				if(label1.getText().equals("") && label2.getText().equals("") && label3.getText().equals("") && label4.getText().equals("") && label5.getText().equals("")) return true;
				else return false;

			}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateProfileFrame window = new UpdateProfileFrame("");
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
