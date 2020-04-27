import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Class_Routine extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Class_Routine frame = new Class_Routine();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 Connection connection=null;
	 private JButton btnNewButton;
	 private JLabel lblNewLabel;
	 private JLabel lblDay;
	 private JLabel lblSecond;
	 private JLabel lblThird;
	 private JLabel lblFourth;
	 private JLabel lblFifth;
	 private JLabel lblSixth;
	 private JLabel lblSeventh;
	 private JLabel lblEighth;
	 private JLabel lblNine;
	 private JTextField textField;
	 private JTextField textField_1;
	 private JTextField textField_2;
	 private JTextField textField_3;
	 private JTextField textField_4;
	 private JTextField textField_5;
	 private JTextField textField_6;
	 private JTextField textField_7;
	 private JTextField textField_8;
	 private JTextField textField_9;
	 private JButton btnUpdate;
	 private JButton btnDelete;
	 public void refreshTable() {
		 ///refreshTable
		 try {
				String query="select Day,First,Second,Third,Fourth,Fifth,Sixth,Seventh,Eighth,Nine from Class_routine_all_new_update";
				PreparedStatement pst=connection.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				pst.close();
				rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
	 }
	 public void fillComboBox() {
		 ///comboBox_class
		 try {
			 String query="select * from Class_routine_all_new_update";
			 PreparedStatement pst=connection.prepareStatement(query);
			 ResultSet rs=pst.executeQuery();
			 while(rs.next()) {
				 comboBox.addItem(rs.getString("Day"));
			 }
		 }catch(Exception ab)
		 {
			 ab.printStackTrace();
		 }
	 }
	/**
	 * Create the frame.
	 */
	public Class_Routine() {
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1270, 761);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoadTable = new JButton("Load Data");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				///load_data
				try {
					String query="select Day,First,Second,Third,Fourth,Fifth,Sixth,Seventh,Eighth,Nine from Class_routine_all_new_update";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnLoadTable.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLoadTable.setBounds(578, 38, 202, 25);
		contentPane.add(btnLoadTable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(330, 169, 898, 470);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//mouse_click_event
				try {
					int row=table.getSelectedRow();
					String Day_=(table.getModel().getValueAt(row, 0)).toString();
			   String query="select * from Class_routine_all_new_update where Day='"+Day_+"'";
				PreparedStatement pst=connection.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				while(rs.next()) {
					textField.setText(rs.getString("Day"));
					textField_1.setText(rs.getString("First"));
					textField_2.setText(rs.getString("Second"));
					textField_3.setText(rs.getString("Third"));
					textField_4.setText(rs.getString("Fourth"));
					textField_5.setText(rs.getString("Fifth"));
					textField_6.setText(rs.getString("Sixth"));
					textField_7.setText(rs.getString("Seventh"));
					textField_8.setText(rs.getString("Eighth"));
					textField_9.setText(rs.getString("Nine"));
				}
				pst.close();
				}catch(Exception am) {
					am.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//save
				try {
					String query="insert into Class_routine_all_new_update (Day,First,Second,Third,Fourth,Fifth,Sixth,Seventh,Eighth,Nine) values(?,?,?,?,?,?,?,?,?,?) ";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,textField.getText());
					pst.setString(2,textField_1.getText());
					pst.setString(3,textField_2.getText());
					pst.setString(4,textField_3.getText());
					pst.setString(5,textField_4.getText());
					pst.setString(6,textField_5.getText());
					pst.setString(7,textField_6.getText());
					pst.setString(8,textField_7.getText());
					pst.setString(9,textField_8.getText());
					pst.setString(10,textField_9.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data Saved");
					pst.close();
					
				}catch(Exception em) {
					em.printStackTrace();
				}
				refreshTable();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(1043, 38, 117, 25);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("First");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(22, 266, 106, 25);
		contentPane.add(lblNewLabel);
		
		lblDay = new JLabel("Day");
		lblDay.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblDay.setBounds(22, 217, 106, 25);
		contentPane.add(lblDay);
		
		lblSecond = new JLabel("Second");
		lblSecond.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblSecond.setBounds(22, 304, 106, 25);
		contentPane.add(lblSecond);
		
		lblThird = new JLabel("Third");
		lblThird.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblThird.setBounds(22, 342, 106, 25);
		contentPane.add(lblThird);
		
		lblFourth = new JLabel("Fourth");
		lblFourth.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblFourth.setBounds(22, 380, 106, 25);
		contentPane.add(lblFourth);
		
		lblFifth = new JLabel("Fifth");
		lblFifth.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblFifth.setBounds(22, 418, 106, 25);
		contentPane.add(lblFifth);
		
		lblSixth = new JLabel("Sixth");
		lblSixth.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblSixth.setBounds(22, 456, 106, 25);
		contentPane.add(lblSixth);
		
		lblSeventh = new JLabel("Seventh");
		lblSeventh.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblSeventh.setBounds(22, 494, 106, 25);
		contentPane.add(lblSeventh);
		
		lblEighth = new JLabel("Eighth");
		lblEighth.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblEighth.setBounds(22, 532, 106, 25);
		contentPane.add(lblEighth);
		
		lblNine = new JLabel("Nine");
		lblNine.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNine.setBounds(22, 570, 106, 25);
		contentPane.add(lblNine);
		
		textField = new JTextField();
		textField.setBounds(138, 221, 135, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(140, 258, 135, 22);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(138, 304, 135, 22);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(140, 346, 135, 22);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(140, 384, 135, 22);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(140, 422, 135, 22);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(138, 460, 135, 22);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(140, 498, 135, 22);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(140, 536, 135, 22);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(138, 574, 135, 22);
		contentPane.add(textField_9);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//update
				try {
					String query="Update Class_routine_all_new_update set Day='"+textField.getText() +"',First='"+textField_1.getText() +"',Second='"+textField_2.getText() +"',Third='"+textField_3.getText() +"',Fourth='"+textField_4.getText() +"',Fifth='"+textField_5.getText() +"',Sixth='"+textField_6.getText() +"',Seventh='"+textField_7.getText() +"',Eighth='"+textField_8.getText() +"',Nine='"+textField_9.getText() +"' where Day='"+textField.getText() +"' ";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data Updated");
					pst.close();
				
				}catch(Exception eb) {
					eb.printStackTrace();
				}
				refreshTable();
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnUpdate.setBounds(1043, 73, 117, 25);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//delete
				int action=JOptionPane.showConfirmDialog(null,"Do You really Want To Delete","Delete",JOptionPane.YES_NO_OPTION);
				if(action==0) {
					
				
				try {
					String query="delete from Class_routine_all_new_update where Day='"+textField.getText() +"' ";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data Deleted");
					pst.close();
				
				}catch(Exception eb) {
					eb.printStackTrace();
				}
				refreshTable();
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.setBounds(1043, 108, 117, 25);
		contentPane.add(btnDelete);
		
		 comboBox = new JComboBox();
		 comboBox.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		///comboBox
		 		try {
					String query="select * from Class_routine_all_new_update where Day=?";
				PreparedStatement pst=connection.prepareStatement(query);
				pst.setString(1,(String)comboBox.getSelectedItem());
				ResultSet rs=pst.executeQuery();
				while(rs.next()) {
					textField.setText(rs.getString("Day"));
					textField_1.setText(rs.getString("First"));
					textField_2.setText(rs.getString("Second"));
					textField_3.setText(rs.getString("Third"));
					textField_4.setText(rs.getString("Fourth"));
					textField_5.setText(rs.getString("Fifth"));
					textField_6.setText(rs.getString("Sixth"));
					textField_7.setText(rs.getString("Seventh"));
					textField_8.setText(rs.getString("Eighth"));
					textField_9.setText(rs.getString("Nine"));
				}
				pst.close();
				}catch(Exception am) {
					am.printStackTrace();
				}	
		 	}
		 });
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 20));
		comboBox.setBounds(52, 53, 202, 22);
		contentPane.add(comboBox);
		refreshTable();
		fillComboBox();
		
	}
}
