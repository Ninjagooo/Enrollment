package Enrollment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class admin_login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private static Connection conn;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_login login = new admin_login();
					login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public admin_login() {
	 conn = Connector.connect();

			
	
		Scanner s = new Scanner(System.in);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(47, 53, 118, 28);
		contentPane.add(lblNewLabel);
		
		username = new JTextField();
		username.setBounds(175, 53, 144, 26);
		contentPane.add(username);
		username.setColumns(10);
		
		
		JLabel lblpassword = new JLabel("Password :");
		lblpassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblpassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblpassword.setBounds(47, 87, 118, 28);
		contentPane.add(lblpassword);
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("ADMIN ONLY");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(111, 11, 173, 28);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(175, 90, 144, 25);
		contentPane.add(passwordField);
		
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "SELECT * FROM admin Where user = ? and pass = ?";
                try (PreparedStatement preparedstatement = conn.prepareStatement(query)) {
                      preparedstatement.setString(1,username.getText().toString());
                      preparedstatement.setString(2,passwordField.getText().toString());
                      ResultSet resultSet = preparedstatement.executeQuery();
                      
                if (resultSet.next()) {
                      JOptionPane.showMessageDialog(null, "Login Succesfully");
                  	Information info = new Information();
                      
                      
                      info.setVisible(true);
                      
                     
                      
            
                } else {
                	JOptionPane.showMessageDialog(null, "Incorrect User or Pass","ERROR",JOptionPane.ERROR_MESSAGE);
                }     
              
               } catch (Exception r) {
           		r.printStackTrace();
               }
		
          
			}});
    
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(247, 145, 108, 28);
		contentPane.add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				username.setText("");
				passwordField.setText("");
				
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClear.setBounds(129, 145, 108, 28);
		contentPane.add(btnClear);
		

		
		
		
	}
}
