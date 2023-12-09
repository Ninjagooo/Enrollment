package Enrollment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

import com.github.lgooddatepicker.components.DatePicker;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Information extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private static Connection conn;
	private JTextField searchbar;
	private DefaultTableModel model;
	private JTextField fname;
	private JTextField mname;
	private JTextField lname;
	private JTextField age;
	private JTextField contact;
	private JTextField email;
	private JTextField LRN;
	private JTextField Age;
	private JTextField Contact;
	private JTextField Email;
	private JTextField lrn;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Information() {
		conn = Connector.connect();
		admin_login login = new admin_login();
		
		login.setVisible(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 938, 476);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 660, 437);
		contentPane.add(scrollPane);

		fname = new JTextField();
		fname.setColumns(10);
		fname.setBounds(757, 81, 134, 20);
		contentPane.add(fname);
		
		JLabel lblFirstName = new JLabel("FirstName :");
		lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstName.setBounds(682, 81, 65, 20);
		contentPane.add(lblFirstName);
		
		JLabel lblMiddlename = new JLabel("MiddleName :");
		lblMiddlename.setHorizontalAlignment(SwingConstants.CENTER);
		lblMiddlename.setBounds(682, 112, 65, 20);
		contentPane.add(lblMiddlename);
		
		mname = new JTextField();
		mname.setColumns(10);
		mname.setBounds(757, 112, 134, 20);
		contentPane.add(mname);
		
		JLabel lblLastname = new JLabel("LastName :");
		lblLastname.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastname.setBounds(682, 143, 65, 20);
		contentPane.add(lblLastname);
		
		lname = new JTextField();
		lname.setColumns(10);
		lname.setBounds(757, 143, 134, 20);
		contentPane.add(lname);
		
		JLabel lblBirthday = new JLabel("Birthday :");
		lblBirthday.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirthday.setBounds(682, 174, 65, 20);
		contentPane.add(lblBirthday);
		
		table = new JTable();
		model = new DefaultTableModel(new Object[][] {}, new String[] { "First Name", "Middle Name", "Last Name",
				"Birthday", "Age", "Gender", "Contact", "Email", "Strand", "Lrn" });
		table.setModel(model);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.setBackground(new Color(64, 128, 128));

		scrollPane.setViewportView(table);

		searchbar = new JTextField();
		searchbar.setBounds(771, 11, 134, 25);
		contentPane.add(searchbar);
		searchbar.setColumns(10);

		JButton search = new JButton("Search\r\n");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {

					String student = searchbar.getText();
					
					PreparedStatement pr = conn.prepareStatement(
							"SELECT * FROM StudentInformation WHERE  LRN = ? ");

					pr.setString(1, student);
					

					ResultSet rs = pr.executeQuery();
					model.setRowCount(0);

					while (rs.next())
						
					{
						Object[] rowData = { rs.getString("FirstName"), rs.getString("MiddleName"),
								rs.getString("LastName"), rs.getString("Birthday"), rs.getString("Age"),
								rs.getString("Gender"), rs.getString("Contact"), rs.getString("Email"),
								rs.getString("Strand"), rs.getString("LRN")

						};
						model.addRow(rowData);

					}

				} catch (Exception r) {
					r.printStackTrace();
				}

			}

		});
		search.setFont(new Font("Tahoma", Font.PLAIN, 15));
		search.setBounds(670, 9, 91, 25);
		contentPane.add(search);

		JButton delete = new JButton("Delete Record");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String query = "DELETE FROM StudentInformation WHERE LRN =?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, searchbar.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Deleted");

					populateTable();

				} catch (Exception s) {
					s.printStackTrace();
				}
			}

		});

		delete.setBounds(771, 42, 134, 25);
		contentPane.add(delete);
		
		DatePicker birthday = new DatePicker();
		birthday.setBounds(756, 174, 135, 20);
		contentPane.add(birthday);
		
		JLabel lblAge = new JLabel("Age :");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setBounds(682, 205, 65, 20);
		contentPane.add(lblAge);
		
		Age = new JTextField();
		Age.setColumns(10);
		Age.setBounds(757, 205, 134, 20);
		contentPane.add(Age);
		((AbstractDocument)Age.getDocument()).setDocumentFilter(new DocumentFilter() {
			  public void insertString(FilterBypass fb, int offset, String string, javax.swing.text.AttributeSet attr) throws BadLocationException {
			        fb.insertString(offset, string.replaceAll("[^0-9]", ""), attr);
			      }
			      
			      public void replace(FilterBypass fb, int offset, int length, String string, javax.swing.text.AttributeSet attr) throws BadLocationException {
			        fb.replace(offset, length, string.replaceAll("[^0-9]", ""), attr);
			      }
			    });
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setBounds(682, 236, 65, 20);
		contentPane.add(lblGender);
		
		JComboBox gender = new JComboBox();
		gender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Prefer Not To Say"}));
		gender.setBounds(757, 236, 134, 20);
		contentPane.add(gender);
		
		JLabel lblContact = new JLabel("Contact :");
		lblContact.setHorizontalAlignment(SwingConstants.CENTER);
		lblContact.setBounds(682, 267, 65, 20);
		contentPane.add(lblContact);
		
		Contact = new JTextField();
		Contact.setColumns(10);
		Contact.setBounds(757, 267, 134, 20);
		contentPane.add(Contact);
		((AbstractDocument)Contact.getDocument()).setDocumentFilter(new DocumentFilter() {
			  public void insertString(FilterBypass fb, int offset, String string, javax.swing.text.AttributeSet attr) throws BadLocationException {
			        fb.insertString(offset, string.replaceAll("[^0-9]", ""), attr);
			      }
			      
			      public void replace(FilterBypass fb, int offset, int length, String string, javax.swing.text.AttributeSet attr) throws BadLocationException {
			        fb.replace(offset, length, string.replaceAll("[^0-9]", ""), attr);
			      }
			    });
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(682, 298, 65, 20);
		contentPane.add(lblEmail);
		
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(757, 298, 134, 20);
		contentPane.add(Email);
		
		JLabel lblLrn = new JLabel("Strand :");
		lblLrn.setHorizontalAlignment(SwingConstants.CENTER);
		lblLrn.setBounds(682, 329, 65, 20);
		contentPane.add(lblLrn);
		
		JButton Update = new JButton("Update");
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Update.setBounds(757, 391, 134, 32);
		contentPane.add(Update);
		
		JComboBox strand = new JComboBox();
		strand.setModel(new DefaultComboBoxModel(new String[] {"ABM", "STEM", "HUMSS", "GAS", "TVL-ICT", "TVL-HE"}));
		strand.setBounds(757, 329, 134, 20);
		contentPane.add(strand);
		
		JLabel lblLrn_2 = new JLabel("LRN :");
		lblLrn_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLrn_2.setBounds(682, 360, 65, 20);
		contentPane.add(lblLrn_2);
		
		lrn = new JTextField();
		lrn.setColumns(10);
		lrn.setBounds(757, 360, 134, 20);
		contentPane.add(lrn);
		((AbstractDocument)lrn.getDocument()).setDocumentFilter(new DocumentFilter() {
			  public void insertString(FilterBypass fb, int offset, String string, javax.swing.text.AttributeSet attr) throws BadLocationException {
			        fb.insertString(offset, string.replaceAll("[^0-9]", ""), attr);
			      }
			      
			      public void replace(FilterBypass fb, int offset, int length, String string, javax.swing.text.AttributeSet attr) throws BadLocationException {
			        fb.replace(offset, length, string.replaceAll("[^0-9]", ""), attr);
			      }
			    });
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "UPDATE StudentInformation set FirstName ='"+fname.getText()+"',MiddleName='"+ mname.getText()+"',LastName='"+ lname.getText()+"',Birthday='"+ birthday.getDateStringOrEmptyString()+"', Age='"+ Age.getText()+"',Gender='"+ gender.getSelectedItem()+"',Contact='"+ Contact.getText()+"',Email = '"+ Email.getText()+"', Strand='"+ strand.getSelectedItem().toString()+"', LRN='"+ lrn.getText()+"' WHERE LRN='"+searchbar.getText()+"'";
					
				PreparedStatement pst = conn.prepareStatement(query);
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Updated");
					
					pst.close();							
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
				
			
		});


	}

	private void populateTable() {
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM StudentInformation");

			model = new DefaultTableModel();
			table.setModel(model);

			ResultSetMetaData metaData = resultSet.getMetaData();
			int columnCount = metaData.getColumnCount();

			for (int column = 1; column <= columnCount; column++) {
				model.addColumn(metaData.getColumnName(column));
			}

			while (resultSet.next()) {
				Object[] rowData = new Object[columnCount];
				for (int i = 1; i <= columnCount; i++) {
					rowData[i - 1] = resultSet.getObject(i);
				}
				model.addRow(rowData);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
