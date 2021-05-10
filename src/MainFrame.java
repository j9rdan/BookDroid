import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("BookDroid: Home of the Bookworm");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel startupPanel = new JPanel();
		startupPanel.setBackground(new Color(224, 236, 253));
		startupPanel.setBounds(0, 0, 980, 611);
		contentPane.add(startupPanel);
		startupPanel.setLayout(null);
		
		JLabel bookDroidTitle = new JLabel("bookDroid");
		bookDroidTitle.setLabelFor(startupPanel);
		bookDroidTitle.setFont(new Font("Poppins", Font.BOLD, 90));
		bookDroidTitle.setBounds(117, 56, 480, 96);
		startupPanel.add(bookDroidTitle);
		
		JLabel droidIcon = new JLabel("{>_<}");
		droidIcon.setForeground(new Color(0, 45, 151));
		droidIcon.setFont(new Font("Poppins", Font.BOLD, 90));
		droidIcon.setLabelFor(startupPanel);
		droidIcon.setBounds(609, 45, 259, 119);
		startupPanel.add(droidIcon);
		
		JLabel quote = new JLabel("'Home of the Bookworm'");
		quote.setFont(new Font("Poppins", Font.ITALIC, 35));
		quote.setBounds(272, 164, 429, 45);
		startupPanel.add(quote);
		
		JComboBox userDropdown = new JComboBox();
		userDropdown.setMaximumRowCount(4);
		userDropdown.setFont(new Font("Montserrat", Font.PLAIN, 15));
		userDropdown.setBounds(337, 315, 181, 27);
		startupPanel.add(userDropdown);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setForeground(Color.WHITE);
		loginBtn.setOpaque(true);
		loginBtn.setBorderPainted(false);
		loginBtn.setBackground(new Color(0, 45, 151));
		loginBtn.setFont(new Font("Poppins", Font.PLAIN, 20));
		loginBtn.setBounds(530, 309, 98, 38);
		startupPanel.add(loginBtn);
		
		JButton viewBooksBtn = new JButton("View books");
		viewBooksBtn.setOpaque(true);
		viewBooksBtn.setForeground(Color.WHITE);
		viewBooksBtn.setFont(new Font("Poppins", Font.PLAIN, 15));
		viewBooksBtn.setBorderPainted(false);
		viewBooksBtn.setBackground(new Color(0, 45, 151));
		viewBooksBtn.setBounds(834, 556, 129, 38);
		startupPanel.add(viewBooksBtn);
		
		JPanel pickBookTypePanel = new JPanel();
		pickBookTypePanel.setBackground(new Color(224, 236, 253));
		pickBookTypePanel.setBounds(0, 0, 980, 611);
		contentPane.add(pickBookTypePanel);
		
		JPanel addPaperbackPanel = new JPanel();
		addPaperbackPanel.setBackground(new Color(224, 236, 253));
		addPaperbackPanel.setBounds(0, 0, 980, 611);
		contentPane.add(addPaperbackPanel);
		
		JPanel addEbookPanel = new JPanel();
		addEbookPanel.setBackground(new Color(224, 236, 253));
		addEbookPanel.setBounds(0, 0, 980, 611);
		contentPane.add(addEbookPanel);
		
		JPanel addAudioBookPanel = new JPanel();
		addAudioBookPanel.setBackground(new Color(224, 236, 253));
		addAudioBookPanel.setBounds(0, 0, 980, 611);
		contentPane.add(addAudioBookPanel);
		
		JPanel bookSearchPanel = new JPanel();
		bookSearchPanel.setBackground(new Color(224, 236, 253));
		bookSearchPanel.setBounds(0, 0, 980, 611);
		contentPane.add(bookSearchPanel);
		
		JPanel searchResultPanel = new JPanel();
		searchResultPanel.setBackground(new Color(224, 236, 253));
		searchResultPanel.setBounds(0, 0, 980, 611);
		contentPane.add(searchResultPanel);
		
		JPanel basketPanel = new JPanel();
		basketPanel.setBackground(new Color(224, 236, 253));
		basketPanel.setBounds(0, 0, 980, 611);
		contentPane.add(basketPanel);
		
		JPanel checkoutPanel = new JPanel();
		checkoutPanel.setBackground(new Color(224, 236, 253));
		checkoutPanel.setBounds(0, 0, 980, 611);
		contentPane.add(checkoutPanel);
	}
}
