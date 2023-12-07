package Enrollment;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

import com.github.lgooddatepicker.components.DatePicker;

public class Application_System extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField FirstName;
	private JTextField MiddleName;
	private JTextField LastName;
	private JTextField Age;
	private JTextField contact;
	private JTextField email;
	private static Connection con;
	private JTextField LRN;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
	//	Connector();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Class.forName("org.sqlite.JDBC");
					Application_System frame2 = new Application_System();
					frame2.setVisible(true);
					frame2.setTitle("Registration");
					
					//con = DriverManager.getConnection("jdbc:sqlite:C:\\konek\\tagal.db");
					//con.setAutoCommit(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static void Connector() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Create the frame.
	 */
	public Application_System() {
		con = Connector.connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 966, 396);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel image = new JLabel("");
		image.setIcon(new ImageIcon("C:\\Users\\rhonj\\Downloads\\nyaw.png"));
		image.setBounds(26, 26, 255, 279);
		contentPane.add(image);
		
		JLabel lblFirstName = 
				new JLabel("FirstName :");
		lblFirstName.setForeground(new Color(0, 0, 0));
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstName.setBounds(285, 24, 95, 21);
		contentPane.add(lblFirstName);
		
		FirstName = new JTextField();
		FirstName.setBounds(390, 26, 115, 21);
		contentPane.add(FirstName);
		FirstName.setColumns(10);
		
		JLabel lblMiddleName = new JLabel("MiddleName :");
		lblMiddleName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMiddleName.setForeground(Color.BLACK);
		lblMiddleName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMiddleName.setBounds(285, 58, 95, 21);
		contentPane.add(lblMiddleName);
		
		MiddleName = new JTextField();
		MiddleName.setColumns(10);
		MiddleName.setBounds(390, 58, 115, 21);
		contentPane.add(MiddleName);
		
		JLabel lblLastname = new JLabel("LastName :");
		lblLastname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastname.setForeground(Color.BLACK);
		lblLastname.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLastname.setBounds(285, 90, 95, 21);
		contentPane.add(lblLastname);
		
		LastName = new JTextField();
		LastName.setColumns(10);
		LastName.setBounds(390, 90, 115, 21);
		contentPane.add(LastName);
		
		JLabel lblBirthday = new JLabel("Birthday :");
		lblBirthday.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBirthday.setForeground(Color.BLACK);
		lblBirthday.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBirthday.setBounds(285, 122, 95, 21);
		contentPane.add(lblBirthday);
		
		JLabel lblAge = new JLabel("Age :");
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setForeground(Color.BLACK);
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAge.setBounds(285, 154, 95, 21);
		contentPane.add(lblAge);
		
		Age = new JTextField();
		Age.setColumns(10);
		Age.setBounds(390, 154, 115, 21);
		((AbstractDocument)Age.getDocument()).setDocumentFilter(new DocumentFilter() {
			  public void insertString(FilterBypass fb, int offset, String string, javax.swing.text.AttributeSet attr) throws BadLocationException {
			        fb.insertString(offset, string.replaceAll("[^0-9]", ""), attr);
			      }
			      
			      public void replace(FilterBypass fb, int offset, int length, String string, javax.swing.text.AttributeSet attr) throws BadLocationException {
			        fb.replace(offset, length, string.replaceAll("[^0-9]", ""), attr);
			      }
			    });
	     
		
		contentPane.add(Age);
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGender.setForeground(Color.BLACK);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGender.setBounds(285, 186, 95, 21);
		contentPane.add(lblGender);
		
		JLabel lblContact = new JLabel("Contact :");
		lblContact.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContact.setForeground(Color.BLACK);
		lblContact.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContact.setBounds(285, 218, 95, 21);
		contentPane.add(lblContact);
		
		contact = new JTextField();
		contact.setColumns(10);
		contact.setBounds(390, 220, 115, 21);
		contentPane.add(contact);
		((AbstractDocument)contact.getDocument()).setDocumentFilter(new DocumentFilter() {
			  public void insertString(FilterBypass fb, int offset, String string, javax.swing.text.AttributeSet attr) throws BadLocationException {
			        fb.insertString(offset, string.replaceAll("[^0-9]", ""), attr);
			      }
			      
			      public void replace(FilterBypass fb, int offset, int length, String string, javax.swing.text.AttributeSet attr) throws BadLocationException {
			        fb.replace(offset, length, string.replaceAll("[^0-9]", ""), attr);
			      }
			    });
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(285, 250, 95, 21);
		contentPane.add(lblEmail);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(390, 252, 115, 21);
		contentPane.add(email);
		
		JLabel lblStrand = new JLabel("Strand :");
		lblStrand.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStrand.setForeground(Color.BLACK);
		lblStrand.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStrand.setBounds(527, 57, 95, 21);
		contentPane.add(lblStrand);
		
		JComboBox strand = new JComboBox();
		strand.setFont(new Font("Tahoma", Font.BOLD, 14));
		strand.setModel(new DefaultComboBoxModel(new String[] {"ABM", "STEM", "GAS", "TVL-HE", "TVL-ICT"}));
		strand.setBounds(632, 57, 115, 21);
		contentPane.add(strand);
		
		JComboBox gender = new JComboBox();
		gender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Prefer not to say"}));
		gender.setFont(new Font("Tahoma", Font.BOLD, 14));
		gender.setBounds(390, 186, 115, 21);
		contentPane.add(gender);
		
		JLabel lblLrn = new JLabel("LRN :");
		lblLrn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLrn.setForeground(Color.BLACK);
		lblLrn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLrn.setBounds(527, 24, 95, 21);
		contentPane.add(lblLrn);
		
		DatePicker datePicker = new DatePicker();
		datePicker.setBounds(390, 123, 139, 20);
		contentPane.add(datePicker);
		
		
		
		LRN = new JTextField();
		LRN.setColumns(10);
		LRN.setBounds(632, 26, 115, 21);
		contentPane.add(LRN);
		((AbstractDocument)LRN.getDocument()).setDocumentFilter(new DocumentFilter() {
			  public void insertString(FilterBypass fb, int offset, String string, javax.swing.text.AttributeSet attr) throws BadLocationException {
			        fb.insertString(offset, string.replaceAll("[^0-9]", ""), attr);
			      }
			      
			      public void replace(FilterBypass fb, int offset, int length, String string, javax.swing.text.AttributeSet attr) throws BadLocationException {
			        fb.replace(offset, length, string.replaceAll("[^0-9]", ""), attr);
			      }
			    });
		
		JButton btnNewButton = new JButton("ENROLL");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String fname = FirstName.getText();
				String Mname = MiddleName.getText();
				String Lname = LastName.getText();
				String date = datePicker.getDateStringOrEmptyString();
				String age = Age.getText();
				String Gender = gender.getSelectedItem().toString();
				String Contact = contact.getText();
				String Email = email.getText();
				String Strand = strand.getSelectedItem().toString();
				String lrn = LRN.getText();
				JOptionPane.showMessageDialog(null, "Successfully Enrolled");
				
				
				String sql = "INSERT INTO StudentInformation(FirstName, MiddleName, LastName,"
						+ " Birthday, Age, Gender, Contact, Email, Strand, LRN) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					
					try {
						
						PreparedStatement pst = con.prepareStatement(sql);
						
						pst.setString(1, fname);
						pst.setString(2, Mname);
						pst.setString(3, Lname);
						pst.setString(4, date);
						pst.setString(5, age);
						pst.setString(6, Gender);
						pst.setString(7, Contact);
						pst.setString(8, Email);
						pst.setString(9, Strand);
						pst.setString(10, lrn);
						
						pst.executeUpdate();
						
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
						
				
			}

			private String getText(String string) {
				// TODO Auto-generated method stub
				return null;
			}

			private Connection connect() {
				// TODO Auto-generated method stub
				return null;
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(774, 293, 138, 39);
		contentPane.add(btnNewButton);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FirstName.setText("");
				MiddleName.setText("");
				LastName.setText("");
				datePicker.setDate(null);
				Age.setText("");
				gender.setSelectedItem(null);
				contact.setText("");
				email.setText("");
				strand.setSelectedItem(null);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClear.setBounds(604, 293, 138, 39);
		contentPane.add(btnClear);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(537, 90, 400, 189);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Subject Offered");
		lblNewLabel_1.setForeground(new Color(255, 53, 53));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(140, 11, 105, 19);
		panel1.add(lblNewLabel_1);
		
		JLabel sub1 = new JLabel("Business Finance");
		sub1.setFont(new Font("Tahoma", Font.BOLD, 13));
		sub1.setBounds(27, 34, 114, 25);
		panel1.add(sub1);
		
		JLabel sub2 = new JLabel("GenMath");
		sub2.setFont(new Font("Tahoma", Font.BOLD, 13));
		sub2.setBounds(27, 70, 114, 25);
		panel1.add(sub2);
		
		JLabel sub3 = new JLabel("Practical Research");
		sub3.setFont(new Font("Tahoma", Font.BOLD, 13));
		sub3.setBounds(27, 106, 129, 25);
		panel1.add(sub3);
		
		JLabel sub4 = new JLabel("Physical Education");
		sub4.setFont(new Font("Tahoma", Font.BOLD, 13));
		sub4.setBounds(27, 142, 129, 25);
		panel1.add(sub4);
		
		JLabel sub5 = new JLabel("Entrepreneurship");
		sub5.setFont(new Font("Tahoma", Font.BOLD, 13));
		sub5.setBounds(200, 34, 129, 25);
		panel1.add(sub5);
		
		JLabel sub6 = new JLabel("PerDev");
		sub6.setFont(new Font("Tahoma", Font.BOLD, 13));
		sub6.setBounds(200, 70, 129, 25);
		panel1.add(sub6);
		
		JLabel sub7 = new JLabel("21st Century Literature\r\n");
		sub7.setFont(new Font("Tahoma", Font.BOLD, 13));
		sub7.setBounds(200, 106, 166, 25);
		panel1.add(sub7);
		

		
		
		
	
		
	}
}


