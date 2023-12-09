package asdasd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
//import com.toedter.calendar.JDateChooser;

//import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class t2 {

	private JFrame frame;
	private JTextField textLRN;
	private JTextField textFN;
	private JTextField textMN;
	private JTextField textLN;
	private JTextField textAge;
	private JTextField textPast;
	private JTextField textGuardian;
	private JTable table;
	private String Strand;
	private int enrollmentYear;
	private JComboBox<String> strandComboBox;
    private JComboBox<String> yearComboBox;
	JTextArea subjectDisplayArea;
	DefaultTableModel tableModel;
	JTable displayTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					t2 window = new t2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private JTextField textAddress;
	/**
	 * Create the application.
	 */
	public t2() {
		initialize();
	//	connection = sqliteConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(143, 188, 143));
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblEnrollment = new JLabel("Enrollment System");
		lblEnrollment.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnrollment.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblEnrollment.setBounds(230, 0, 550, 37);
		frame.getContentPane().add(lblEnrollment);
		
		JLabel lblLRN = new JLabel("LRN :");
		lblLRN.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLRN.setBounds(30, 60, 80, 20);
		frame.getContentPane().add(lblLRN);
		
		textLRN = new JTextField();
		textLRN.setBounds(156, 60, 169, 20);
		frame.getContentPane().add(textLRN);
		textLRN.setColumns(10);
		
		JLabel lblFN = new JLabel("FirstName :");
		lblFN.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFN.setBounds(31, 100, 119, 20);
		frame.getContentPane().add(lblFN);
		
		textFN = new JTextField();
		textFN.setColumns(10);
		textFN.setBounds(156, 100, 169, 20);
		frame.getContentPane().add(textFN);
		
		JLabel lblMN = new JLabel("MiddleName :");
		lblMN.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMN.setBounds(31, 140, 119, 20);
		frame.getContentPane().add(lblMN);
		
		textMN = new JTextField();
		textMN.setColumns(10);
		textMN.setBounds(156, 140, 169, 20);
		frame.getContentPane().add(textMN);
		
		JLabel lblLN = new JLabel("LastName :");
		lblLN.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLN.setBounds(31, 180, 119, 20);
		frame.getContentPane().add(lblLN);
		
		textLN = new JTextField();
		textLN.setColumns(10);
		textLN.setBounds(156, 180, 169, 20);
		frame.getContentPane().add(textLN);
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGender.setBounds(31, 220, 86, 20);
		frame.getContentPane().add(lblGender);
		
		JComboBox cmbGender = new JComboBox();
		cmbGender.setModel(new DefaultComboBoxModel(new String[] {"Female", "Male"}));
		cmbGender.setBounds(156, 220, 169, 22);
		frame.getContentPane().add(cmbGender);
		
		JLabel lblAge = new JLabel("Age :");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAge.setBounds(30, 260, 53, 20);
		frame.getContentPane().add(lblAge);
		
		textAge = new JTextField();
		textAge.setColumns(10);
		textAge.setBounds(156, 260, 169, 20);
		frame.getContentPane().add(textAge);
		
		JLabel lblBirthday = new JLabel("Birthday :");
		lblBirthday.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBirthday.setBounds(450, 60, 80, 20);
		frame.getContentPane().add(lblBirthday);
		
	//	JDateChooser dateChooser = new JDateChooser();
	//	dateChooser.setBounds(550, 60, 167, 20);
	//	frame.getContentPane().add(dateChooser);
		
		JLabel lblStrand = new JLabel("Strand :");
		lblStrand.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStrand.setBounds(450, 100, 80, 20);
		frame.getContentPane().add(lblStrand);
		
		JTextArea subjectDisplayArea = new JTextArea();
		subjectDisplayArea.setBounds(731, 100, 243, 192);
		frame.getContentPane().add(subjectDisplayArea);
		
		JComboBox yearComboBox = new JComboBox();
		yearComboBox.setBounds(550, 141, 171, 22);
		yearComboBox.setModel(new DefaultComboBoxModel(new String[] {"11", "12"}));
		frame.getContentPane().add(yearComboBox);
		
		JComboBox strandComboBox = new JComboBox();
		strandComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedStrand = strandComboBox.getSelectedItem().toString();
	            int selectedYear = Integer.parseInt(yearComboBox.getSelectedItem().toString());
	            
	            displaySubjectsForCourse(selectedYear, selectedStrand);
				
			}

			private void displaySubjectsForCourse(int year, String Strand) {
				String subjects;
		        switch (Strand) {
		            case "STEM":
		                subjects = (year == 11) ? "Mathematics\r\n" 
		                						+ "Physics\r\n" + 
		                						"Chemistry\r\n" + 
		                						"Computer Science\r\n" : 
		                						"Advanced Mathematics\r\n" 
		                						+ "Advanced Physics\r\n" 
		                						+ "Advanced Chemistry\r\n" 
		                						+ "Advanced Computer Science\r\n";
		                break;
		            case "ABM":
		                subjects = (year == 11) ? "Applied Economics\r\n"
		                						+ "Business Ethics and Social Responsibility\r\n"
		                						+ "Fundamentals of Accountancy, Business, and Management 1\r\n"
		                						+ "Business Math" : 
		                						"Principles of Marketing\r\n"
		                						+ "Business Finance\r\n"
		                						+ "Business Enterprise Simulation\r\n"
		                						+ "Fundamentals of Accountancy, Business, and Management 2";
		                break;
		            case "HUMSS":
		                subjects = (year == 11) ? "Creative Writing/Media and Information Literacy\r\n"
		                						+ "Creative Nonfiction\r\n"
		                						+ "Trends, Networks, and Critical Thinking in the 21st Century Culture" :
		                						  "Creative Writing/Media and Information Literacy\r\n"
		                						+ "Disciplines and Ideas in the Applied Social Sciences\r\n"
		                						+ "Work Immersion/Research/Career Advocacy/Entrepreneurship";
		                break;
		            case "GAS":
		                subjects = (year == 11) ? "Applied Economics\r\n"
		                						+ "Organization and Management\r\n"
		                						+ "Fundamentals of Accountancy, Business, and Management 1" 
		                						: "Applied Economics\r\n"
		                						+ "Organization and Management\r\n"
		                						+ "Fundamentals of Accountancy, Business, and Management 2";
		            case "TVL - (JAVA)":
		                subjects = (year == 11) ? "Computer Programming NC IV\r\n"
		                						+ "Mobile App Development\r\n"
		                						+ "Web Development\r\n"
		                						+ "Entrepreneurship":
		                						"Computer Programming NC IV\r\n"
		                    					+ "Database Management System\r\n"
		                    					+ "Systems Analysis and Design\r\n"
		                    					+ "Entrepreneurship";
		                break;
		            default:
		                subjects = "No subjects available for the selected year and strand.";
		                break;
		        }
		        subjectDisplayArea.setText(subjects);
				
			}
		});
		strandComboBox.setModel(new DefaultComboBoxModel(new String[] {"STEM", "ABM","GAS","TVL-IT","TVL-HE","TVL-ANIMATION","HUMSS"}));
		strandComboBox.setBounds(550, 100, 171, 22);
		frame.getContentPane().add(strandComboBox);
		
		JLabel lblPast = new JLabel("PastSchool:");
		lblPast.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPast.setBounds(450, 180, 119, 20);
		frame.getContentPane().add(lblPast);
		
		textPast = new JTextField();
		textPast.setColumns(10);
		textPast.setBounds(552, 180, 169, 20);
		frame.getContentPane().add(textPast);
		
		JLabel lblGuardian = new JLabel("Guardian :");
		lblGuardian.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGuardian.setBounds(450, 220, 98, 20);
		frame.getContentPane().add(lblGuardian);
		
		textGuardian = new JTextField();
		textGuardian.setColumns(10);
		textGuardian.setBounds(552, 220, 169, 20);
		frame.getContentPane().add(textGuardian);
		
		tableModel = new DefaultTableModel();
		table = new JTable(tableModel);
		table.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane(displayTable);
		scrollPane.setBounds(10, 336, 964, 225);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
		
		
		
		
		JButton btnLOAD = new JButton("LOAD");
		btnLOAD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from tblStudentInfo";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();	
			//		table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
				
				
		});
		btnLOAD.setBounds(80, 302, 89, 23);
		frame.getContentPane().add(btnLOAD);
		
		JButton btnADD = new JButton("ADD");
		btnADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	//			connection = sqliteConnection.dbConnector();
				try {
					
					PreparedStatement statement = connection.prepareStatement("INSERT INTO tblStudentInfo(LRN, FirstName, MiddleName, "
							+ "LastName, Gender, Age, Birthday, Strand, Year, PastSchool, Guardian, Address) " 
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
					
					statement.setString(1, textLRN.getText());
					statement.setString(2, textFN.getText());
					statement.setString(3, textMN.getText());
					statement.setString(4, textLN.getText());
					statement.setString(5, cmbGender.getSelectedItem().toString());
					statement.setString(6, textAge.getText());
				//	statement.setString(7, dateChooser.getDate().toString());
					statement.setString(8, strandComboBox.getSelectedItem().toString());
					statement.setString(9, yearComboBox.getSelectedItem().toString());
					statement.setString(10, textPast.getText());
					statement.setString(11, textGuardian.getText());
					statement.setString(12, textAddress.getText());
					statement.execute();
					JOptionPane.showMessageDialog(null, "Student information saved successfuly!");
					
					btnADD.show();
					textLRN.enable(false);textFN.enable(false);textMN.enable(false);textLN.enable(false);cmbGender.enable(false);textAge.enable();
		//			dateChooser.show();strandComboBox.enable(false); yearComboBox.enable(false);
					textAddress.enable(false);textPast.enable(false);textGuardian.enable(false);//btnUpdate.hide();
					//dateChooser.hide();
					
					//String query = "select * from tblStudentInfo";
					String query = "select LRN, FirstName, MiddleName, LastName, Gender, Age, Birthday, Strand, Year, PastSchool, Guardian, Address from tblStudentInfo";
					PreparedStatement pst = connection.prepareStatement(query);
					
					ResultSet rs = pst.executeQuery();
					
				//	table.setModel(DbUtils.resultSetToTableModel(rs));
//					
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Something Wrong\nDouble check your inserted information.");
				}
			}
				
		});
		btnADD.setBounds(186, 302, 89, 23);
		frame.getContentPane().add(btnADD);
		
		
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddress.setBounds(450, 260, 98, 20);
		frame.getContentPane().add(lblAddress);
		
		textAddress = new JTextField();
		textAddress.setColumns(10);
		textAddress.setBounds(550, 262, 171, 20);
		frame.getContentPane().add(textAddress);
		
		JButton btnUPDATE = new JButton("UPDATE");
		btnUPDATE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//					String query = "Update tblStudentInfo set LRN ='"+textLRN.getText()+"',FirstName='"+ textFN.getText()+"',MiddleName='"+ textMN.getText()+"',LastName='"+ textLN.getText()+"', Gender='"+ cmbGender.getSelectedItem().toString()+"',Age='"+textAge.getText()+"',Birthday='"+dateChooser.getDate().toString()+"',Strand = '"+strandComboBox.getSelectedItem().toString()+"', Year='"+ yearComboBox.getSelectedItem().toString()+"', PastSchool='"+ textPast.getText()+"',Guardian='"+ textGuardian.getText()+"', Address ='"+ textAddress.getText()+"' where LRN='"+textLRN.getText()+"'";
					
			//		PreparedStatement pst = connection.prepareStatement(query);
					
				//	pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Updated");
					
			//		pst.close();							
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnUPDATE.setBounds(287, 302, 89, 23);
		frame.getContentPane().add(btnUPDATE);
		
		JLabel lblYear = new JLabel("Year :");
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblYear.setBounds(450, 140, 80, 20);
		frame.getContentPane().add(lblYear);
		
		JButton btnDELETE = new JButton("DELETE");
		btnDELETE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "delete from tblStudentInfo where LRN='"+textLRN.getText()+"'";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data Deleted");
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		
		
		btnDELETE.setBounds(387, 302, 89, 23);
		frame.getContentPane().add(btnDELETE);
		
		JLabel lblSubject = new JLabel("Subject :");
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSubject.setBounds(766, 60, 80, 20);
		frame.getContentPane().add(lblSubject);
		
		
	}
}
