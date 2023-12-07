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
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Information extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private static Connection conn;
	private JTextField searchbar;
	private DefaultTableModel model;

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
		setBounds(100, 100, 935, 444);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 663, 405);
		contentPane.add(scrollPane);

		table = new JTable();
		model = new DefaultTableModel(new Object[][] {}, new String[] { "First Name", "Middle Name", "Last Name",
				"Birthday", "Age", "Gender", "Contact", "Email", "Strand", "Lrn" });
		table.setModel(model);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.setBackground(new Color(64, 128, 128));

		scrollPane.setViewportView(table);

		searchbar = new JTextField();
		searchbar.setBounds(789, 50, 116, 25);
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
		search.setBounds(800, 12, 96, 27);
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
					conn.commit();
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

		delete.setBounds(673, 15, 106, 25);
		contentPane.add(delete);

		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		update.setBounds(722, 353, 140, 41);
		contentPane.add(update);

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
