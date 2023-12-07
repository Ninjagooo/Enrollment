package Enrollment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Main {
	Application_System frame2 = new Application_System();
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Connector.connect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
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
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.getContentPane().setBackground(new Color(128, 255, 255));
		frame.setBounds(100, 100, 577, 281);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 0));
		panel.setBounds(42, 44, 481, 62);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Welcome to Holy Rosary Academy of Las Piñas City");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(0, 128, 64));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Online Enrollment System");
		lblNewLabel_1.setForeground(new Color(0, 128, 64));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(79, 132, 404, 47);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome to Holy Rosary Academy Online Enrollment");
		lblNewLabel_2.setBounds(20, 11, 384, 20);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("ENROLL\r\n");
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame2.show();
				
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(189, 190, 166, 41);
		frame.getContentPane().add(btnNewButton);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(0, 255, 255));
		menuBar.setBackground(new Color(0, 255, 255));
		menuBar.setBounds(0, 0, 49, 22);
		frame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Admin");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Login\r\n");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin_login frame3 = new admin_login();
				
				frame3.setVisible(true);
				
				frame.setVisible(false);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		frame.setTitle("Holy Rosary Academy Online Enrollment");
	}

	public void show() {
		// TODO Auto-generated method stub

		Application_System app = new Application_System();
		frame.setVisible(true);
		app.dispose();
		
		
		
	}
}
