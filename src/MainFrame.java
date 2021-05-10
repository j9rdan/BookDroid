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
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JTextField ISBNfield_1;
	private JTextField bookTypeField_1;
	private JTextField titleField_1;
	private JTextField languageField_1;
	private JTextField genreField_1;
	private JTextField releaseDateField_1;
	private JTextField priceField_1;
	private JTextField quantityField_1;
	private JTextField pageCountField_1;
	private JTextField conditionField_1;

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
	
	public void switchPanel(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setType(Type.UTILITY);
		setTitle("BookDroid: Home of the Bookworm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel addPaperbackPanel = new JPanel();
		addPaperbackPanel.setBounds(0, 0, 980, 611);
		contentPane.add(addPaperbackPanel);
		addPaperbackPanel.setBackground(new Color(224, 236, 253));
		addPaperbackPanel.setLayout(null);
		
		JLabel addPaperbackLbl = new JLabel("Add a paperback");
		addPaperbackLbl.setLabelFor(addPaperbackPanel);
		addPaperbackLbl.setFont(new Font("Poppins", Font.PLAIN, 70));
		addPaperbackLbl.setBounds(182, 48, 614, 74);
		addPaperbackPanel.add(addPaperbackLbl);
		
		JLabel ISBNLbl_1 = new JLabel("ISBN");
		ISBNLbl_1.setFont(new Font("Montserrat", Font.PLAIN, 20));
		ISBNLbl_1.setLabelFor(ISBNfield_1);
		ISBNLbl_1.setBounds(99, 177, 49, 25);
		addPaperbackPanel.add(ISBNLbl_1);
		
		ISBNfield_1 = new JTextField();
		ISBNfield_1.setHorizontalAlignment(SwingConstants.CENTER);
		ISBNfield_1.setFont(new Font("Montserrat", Font.PLAIN, 25));
		ISBNfield_1.setBounds(160, 162, 310, 45);
		addPaperbackPanel.add(ISBNfield_1);
		ISBNfield_1.setColumns(10);
		
		JLabel bookTypeLbl_2 = new JLabel("Book Type");
		bookTypeLbl_2.setFont(new Font("Montserrat", Font.PLAIN, 20));
		bookTypeLbl_2.setBounds(42, 244, 106, 25);
		addPaperbackPanel.add(bookTypeLbl_2);
		
		bookTypeField_1 = new JTextField();
		bookTypeLbl_2.setLabelFor(bookTypeField_1);
		bookTypeField_1.setHorizontalAlignment(SwingConstants.CENTER);
		bookTypeField_1.setFont(new Font("Montserrat", Font.PLAIN, 25));
		bookTypeField_1.setColumns(10);
		bookTypeField_1.setBounds(160, 235, 310, 45);
		addPaperbackPanel.add(bookTypeField_1);
		
		JLabel titleLbl_1 = new JLabel("Title");
		titleLbl_1.setFont(new Font("Montserrat", Font.PLAIN, 20));
		titleLbl_1.setBounds(107, 322, 41, 25);
		addPaperbackPanel.add(titleLbl_1);
		
		titleField_1 = new JTextField();
		titleLbl_1.setLabelFor(titleField_1);
		titleField_1.setHorizontalAlignment(SwingConstants.CENTER);
		titleField_1.setFont(new Font("Montserrat", Font.PLAIN, 25));
		titleField_1.setColumns(10);
		titleField_1.setBounds(160, 307, 310, 45);
		addPaperbackPanel.add(titleField_1);
		
		JLabel languageLbl_1 = new JLabel("Language");
		languageLbl_1.setFont(new Font("Montserrat", Font.PLAIN, 20));
		languageLbl_1.setBounds(42, 392, 106, 25);
		addPaperbackPanel.add(languageLbl_1);
		
		languageField_1 = new JTextField();
		languageField_1.setHorizontalAlignment(SwingConstants.CENTER);
		languageField_1.setFont(new Font("Montserrat", Font.PLAIN, 25));
		languageField_1.setColumns(10);
		languageField_1.setBounds(160, 382, 310, 45);
		addPaperbackPanel.add(languageField_1);
		
		JLabel genreLbl_1 = new JLabel("Genre");
		genreLbl_1.setLabelFor(genreField_1);
		genreLbl_1.setFont(new Font("Montserrat", Font.PLAIN, 20));
		genreLbl_1.setBounds(87, 467, 61, 25);
		addPaperbackPanel.add(genreLbl_1);
		
		genreField_1 = new JTextField();
		genreField_1.setHorizontalAlignment(SwingConstants.CENTER);
		genreField_1.setFont(new Font("Montserrat", Font.PLAIN, 25));
		genreField_1.setColumns(10);
		genreField_1.setBounds(160, 457, 310, 45);
		addPaperbackPanel.add(genreField_1);
		
		JLabel releaseDateLbl_1 = new JLabel("Release Date");
		releaseDateLbl_1.setLabelFor(releaseDateField_1);
		releaseDateLbl_1.setFont(new Font("Montserrat", Font.PLAIN, 20));
		releaseDateLbl_1.setBounds(482, 177, 131, 25);
		addPaperbackPanel.add(releaseDateLbl_1);
		
		releaseDateField_1 = new JTextField();
		releaseDateField_1.setHorizontalAlignment(SwingConstants.CENTER);
		releaseDateField_1.setFont(new Font("Montserrat", Font.PLAIN, 25));
		releaseDateField_1.setColumns(10);
		releaseDateField_1.setBounds(625, 162, 310, 45);
		addPaperbackPanel.add(releaseDateField_1);
		
		JLabel priceLbl_1 = new JLabel("Price");
		priceLbl_1.setLabelFor(priceField_1);
		priceLbl_1.setFont(new Font("Montserrat", Font.PLAIN, 20));
		priceLbl_1.setBounds(563, 244, 50, 25);
		addPaperbackPanel.add(priceLbl_1);
		
		priceField_1 = new JTextField();
		priceField_1.setHorizontalAlignment(SwingConstants.CENTER);
		priceField_1.setFont(new Font("Montserrat", Font.PLAIN, 25));
		priceField_1.setColumns(10);
		priceField_1.setBounds(625, 235, 310, 45);
		addPaperbackPanel.add(priceField_1);
		
		JLabel quantityLbl_1 = new JLabel("Quantity");
		quantityLbl_1.setLabelFor(quantityField_1);
		quantityLbl_1.setFont(new Font("Montserrat", Font.PLAIN, 20));
		quantityLbl_1.setBounds(525, 317, 88, 25);
		addPaperbackPanel.add(quantityLbl_1);
		
		quantityField_1 = new JTextField();
		quantityField_1.setHorizontalAlignment(SwingConstants.CENTER);
		quantityField_1.setFont(new Font("Montserrat", Font.PLAIN, 25));
		quantityField_1.setColumns(10);
		quantityField_1.setBounds(625, 307, 310, 45);
		addPaperbackPanel.add(quantityField_1);
		
		JLabel pageCountLbl_1 = new JLabel("Page Count");
		pageCountLbl_1.setLabelFor(pageCountField_1);
		pageCountLbl_1.setFont(new Font("Montserrat", Font.PLAIN, 20));
		pageCountLbl_1.setBounds(494, 392, 119, 25);
		addPaperbackPanel.add(pageCountLbl_1);
		
		pageCountField_1 = new JTextField();
		pageCountField_1.setHorizontalAlignment(SwingConstants.CENTER);
		pageCountField_1.setFont(new Font("Montserrat", Font.PLAIN, 25));
		pageCountField_1.setColumns(10);
		pageCountField_1.setBounds(625, 382, 310, 45);
		addPaperbackPanel.add(pageCountField_1);
		
		JLabel conditionLbl = new JLabel("Condition");
		conditionLbl.setLabelFor(conditionField_1);
		conditionLbl.setFont(new Font("Montserrat", Font.PLAIN, 20));
		conditionLbl.setBounds(513, 467, 100, 25);
		addPaperbackPanel.add(conditionLbl);
		
		conditionField_1 = new JTextField();
		conditionField_1.setHorizontalAlignment(SwingConstants.CENTER);
		conditionField_1.setFont(new Font("Montserrat", Font.PLAIN, 25));
		conditionField_1.setColumns(10);
		conditionField_1.setBounds(625, 457, 310, 45);
		addPaperbackPanel.add(conditionField_1);
		
		JButton addBtn_1 = new JButton("Add");
		addBtn_1.setOpaque(true);
		addBtn_1.setForeground(Color.WHITE);
		addBtn_1.setFont(new Font("Poppins", Font.PLAIN, 20));
		addBtn_1.setBorderPainted(false);
		addBtn_1.setBackground(new Color(0, 45, 151));
		addBtn_1.setBounds(471, 543, 94, 38);
		addPaperbackPanel.add(addBtn_1);
		
		JPanel addEbookPanel = new JPanel();
		addEbookPanel.setBounds(0, 0, 980, 611);
		contentPane.add(addEbookPanel);
		addEbookPanel.setBackground(new Color(224, 236, 253));
		
		JPanel addAudioBookPanel = new JPanel();
		addAudioBookPanel.setBounds(0, 0, 980, 611);
		contentPane.add(addAudioBookPanel);
		addAudioBookPanel.setBackground(new Color(224, 236, 253));
		
		JPanel bookSearchPanel = new JPanel();
		bookSearchPanel.setBounds(0, 0, 980, 611);
		contentPane.add(bookSearchPanel);
		bookSearchPanel.setBackground(new Color(224, 236, 253));
		
		JPanel searchResultPanel = new JPanel();
		searchResultPanel.setBounds(0, 0, 980, 611);
		contentPane.add(searchResultPanel);
		searchResultPanel.setBackground(new Color(224, 236, 253));
		
		JPanel basketPanel = new JPanel();
		basketPanel.setBounds(0, 0, 980, 611);
		contentPane.add(basketPanel);
		basketPanel.setBackground(new Color(224, 236, 253));
		
		JPanel checkoutPanel = new JPanel();
		checkoutPanel.setBounds(0, 0, 980, 611);
		contentPane.add(checkoutPanel);
		checkoutPanel.setBackground(new Color(224, 236, 253));
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1, 1);
		contentPane.add(layeredPane);
		
		JPanel startupPanel = new JPanel();
		startupPanel.setBounds(0, 0, 980, 611);
		contentPane.add(startupPanel);
		startupPanel.setBackground(new Color(224, 236, 253));
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
		pickBookTypePanel.setBounds(0, 0, 980, 611);
		contentPane.add(pickBookTypePanel);
		pickBookTypePanel.setBackground(new Color(224, 236, 253));
		pickBookTypePanel.setLayout(null);
		pickBookTypePanel.setVisible(false);
		
		JLabel selectBookTypeLbl = new JLabel("Select a book type");
		selectBookTypeLbl.setBounds(156, 81, 642, 74);
		selectBookTypeLbl.setFont(new Font("Poppins", Font.PLAIN, 70));
		selectBookTypeLbl.setLabelFor(pickBookTypePanel);
		pickBookTypePanel.add(selectBookTypeLbl);
		
		JButton confirmBookBtn = new JButton("Confirm");
		confirmBookBtn.setBounds(564, 305, 125, 38);
		confirmBookBtn.setOpaque(true);
		confirmBookBtn.setForeground(Color.WHITE);
		confirmBookBtn.setFont(new Font("Poppins", Font.PLAIN, 20));
		confirmBookBtn.setBorderPainted(false);
		confirmBookBtn.setBackground(new Color(0, 45, 151));
		pickBookTypePanel.add(confirmBookBtn);
		
		JComboBox bookTypeDropdown = new JComboBox();
		bookTypeDropdown.setMaximumRowCount(4);
		bookTypeDropdown.setFont(new Font("Montserrat", Font.PLAIN, 15));
		bookTypeDropdown.setBounds(346, 311, 181, 27);
		pickBookTypePanel.add(bookTypeDropdown);
		
		JLabel bookTypeLbl_1 = new JLabel("Book Type");
		bookTypeLbl_1.setFont(new Font("Montserrat", Font.PLAIN, 13));
		bookTypeLbl_1.setBounds(266, 316, 75, 16);
		pickBookTypePanel.add(bookTypeLbl_1);
	}
}
