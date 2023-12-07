import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JFrame;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Connection conn = null;
				
				try {
					Main window = new Main();
					window.frame.setVisible(true);
					Class.forName("org.sqlite.JDBC");
					
					conn = DriverManager.getConnection("jdbc:sqlite:C:\\\\konek\\\\tagal.db");
					conn.setAutoCommit(false);
				} catch (Exception e) {
					System.out.println("Successfully Connected");
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 643, 298);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
