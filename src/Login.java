import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 Connection connection=null;
	 private JTextField textFieldUN;
	 private JPasswordField passwordField;
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		connection=sqliteConnection.dbConnector(); 
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1063, 583);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(280, 143, 172, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblPassword.setBounds(280, 199, 172, 29);
		frame.getContentPane().add(lblPassword);
		
		textFieldUN = new JTextField();
		textFieldUN.setBounds(490, 149, 183, 22);
		frame.getContentPane().add(textFieldUN);
		textFieldUN.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(490, 205, 183, 22);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//login
				try {
					String query="select * from Class_routine_all_new_update where Username=? and password=?";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, textFieldUN.getText());
					pst.setString(2,passwordField.getText());
					ResultSet rs=pst.executeQuery();
					int count=0;
					while(rs.next()) {
						count=count+1;
					}
					if(count==1) {
						JOptionPane.showMessageDialog(null, "UserName and Password is Correct");
						frame.dispose();
						Class_Routine c=new Class_Routine();
						c.setVisible(true);
					}
					else if(count>1)
					{
						JOptionPane.showMessageDialog(null, "Duplicate UserName and Password is Correct");
					}
					else {
						JOptionPane.showMessageDialog(null, " UserName and Password is not Correct");
					}
					rs.close();
					pst.close();
					
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null,e);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(402, 378, 204, 39);
		frame.getContentPane().add(btnNewButton);
		
		JLabel label = new JLabel("");
		
		Image img=new ImageIcon(this.getClass().getResource("/Download-to-laptop-icon.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(49, 143, 219, 235);
		frame.getContentPane().add(label);
	}
}
