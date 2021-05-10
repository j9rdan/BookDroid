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
	private JTextField ISBNfield_2;
	private JTextField releaseDateField_2;
	private JTextField bookTypeField_2;
	private JTextField priceField_2;
	private JTextField titleField_2;
	private JTextField quantityField_2;
	private JTextField languageField_2;
	private JTextField pageCountField_2;
	private JTextField genreField_2;
	private JTextField formatField_1;
	private JTextField ISBNfield_3;
	private JTextField releaseDateField_3;
	private JTextField bookTypeField_3;
	private JTextField priceField_3;
	private JTextField titleField_3;
	private JTextField quantityField_3;
	private JTextField languageField_3;
	private JTextField listenLengthField;
	private JTextField genreField_3;
	private JTextField textField_9;

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
		bookTypeField_1.setText("paperback");
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
		addEbookPanel.setLayout(null);
		
		JLabel addEbookLbl = new JLabel("Add an ebook");
		addEbookLbl.setLabelFor(addEbookPanel);
		addEbookLbl.setFont(new Font("Poppins", Font.PLAIN, 70));
		addEbookLbl.setBounds(259, 51, 493, 74);
		addEbookPanel.add(addEbookLbl);
		
		JLabel ISBNLbl_2 = new JLabel("ISBN");
		ISBNLbl_2.setFont(new Font("Montserrat", Font.PLAIN, 20));
		ISBNLbl_2.setBounds(99, 180, 49, 25);
		addEbookPanel.add(ISBNLbl_2);
		
		ISBNfield_2 = new JTextField();
		ISBNfield_2.setHorizontalAlignment(SwingConstants.CENTER);
		ISBNfield_2.setFont(new Font("Montserrat", Font.PLAIN, 25));
		ISBNfield_2.setColumns(10);
		ISBNfield_2.setBounds(160, 165, 310, 45);
		addEbookPanel.add(ISBNfield_2);
		
		JLabel releaseDateLbl_2 = new JLabel("Release Date");
		releaseDateLbl_2.setFont(new Font("Montserrat", Font.PLAIN, 20));
		releaseDateLbl_2.setBounds(482, 180, 131, 25);
		addEbookPanel.add(releaseDateLbl_2);
		
		releaseDateField_2 = new JTextField();
		releaseDateLbl_2.setLabelFor(releaseDateField_2);
		releaseDateField_2.setHorizontalAlignment(SwingConstants.CENTER);
		releaseDateField_2.setFont(new Font("Montserrat", Font.PLAIN, 25));
		releaseDateField_2.setColumns(10);
		releaseDateField_2.setBounds(625, 165, 310, 45);
		addEbookPanel.add(releaseDateField_2);
		
		JLabel bookTypeLbl_3 = new JLabel("Book Type");
		bookTypeLbl_3.setFont(new Font("Montserrat", Font.PLAIN, 20));
		bookTypeLbl_3.setBounds(42, 247, 106, 25);
		addEbookPanel.add(bookTypeLbl_3);
		
		bookTypeField_2 = new JTextField();
		bookTypeField_2.setText("ebook");
		bookTypeLbl_3.setLabelFor(bookTypeField_2);
		bookTypeField_2.setHorizontalAlignment(SwingConstants.CENTER);
		bookTypeField_2.setFont(new Font("Montserrat", Font.PLAIN, 25));
		bookTypeField_2.setColumns(10);
		bookTypeField_2.setBounds(160, 238, 310, 45);
		addEbookPanel.add(bookTypeField_2);
		
		JLabel priceLbl_2 = new JLabel("Price");
		priceLbl_2.setFont(new Font("Montserrat", Font.PLAIN, 20));
		priceLbl_2.setBounds(563, 247, 50, 25);
		addEbookPanel.add(priceLbl_2);
		
		priceField_2 = new JTextField();
		priceLbl_2.setLabelFor(priceField_2);
		priceField_2.setHorizontalAlignment(SwingConstants.CENTER);
		priceField_2.setFont(new Font("Montserrat", Font.PLAIN, 25));
		priceField_2.setColumns(10);
		priceField_2.setBounds(625, 238, 310, 45);
		addEbookPanel.add(priceField_2);
		
		JLabel titleLbl_2 = new JLabel("Title");
		titleLbl_2.setFont(new Font("Montserrat", Font.PLAIN, 20));
		titleLbl_2.setBounds(107, 325, 41, 25);
		addEbookPanel.add(titleLbl_2);
		
		titleField_2 = new JTextField();
		titleLbl_2.setLabelFor(titleField_2);
		titleField_2.setHorizontalAlignment(SwingConstants.CENTER);
		titleField_2.setFont(new Font("Montserrat", Font.PLAIN, 25));
		titleField_2.setColumns(10);
		titleField_2.setBounds(160, 310, 310, 45);
		addEbookPanel.add(titleField_2);
		
		JLabel quantityLbl_2 = new JLabel("Quantity");
		quantityLbl_2.setFont(new Font("Montserrat", Font.PLAIN, 20));
		quantityLbl_2.setBounds(525, 320, 88, 25);
		addEbookPanel.add(quantityLbl_2);
		
		quantityField_2 = new JTextField();
		quantityLbl_2.setLabelFor(quantityField_2);
		quantityField_2.setHorizontalAlignment(SwingConstants.CENTER);
		quantityField_2.setFont(new Font("Montserrat", Font.PLAIN, 25));
		quantityField_2.setColumns(10);
		quantityField_2.setBounds(625, 310, 310, 45);
		addEbookPanel.add(quantityField_2);
		
		JLabel languageLbl_2 = new JLabel("Language");
		languageLbl_2.setFont(new Font("Montserrat", Font.PLAIN, 20));
		languageLbl_2.setBounds(42, 395, 106, 25);
		addEbookPanel.add(languageLbl_2);
		
		languageField_2 = new JTextField();
		languageLbl_2.setLabelFor(languageField_2);
		languageField_2.setHorizontalAlignment(SwingConstants.CENTER);
		languageField_2.setFont(new Font("Montserrat", Font.PLAIN, 25));
		languageField_2.setColumns(10);
		languageField_2.setBounds(160, 385, 310, 45);
		addEbookPanel.add(languageField_2);
		
		JLabel pageCountLbl_2 = new JLabel("Page Count");
		pageCountLbl_2.setFont(new Font("Montserrat", Font.PLAIN, 20));
		pageCountLbl_2.setBounds(494, 395, 119, 25);
		addEbookPanel.add(pageCountLbl_2);
		
		pageCountField_2 = new JTextField();
		pageCountLbl_2.setLabelFor(pageCountField_2);
		pageCountField_2.setHorizontalAlignment(SwingConstants.CENTER);
		pageCountField_2.setFont(new Font("Montserrat", Font.PLAIN, 25));
		pageCountField_2.setColumns(10);
		pageCountField_2.setBounds(625, 385, 310, 45);
		addEbookPanel.add(pageCountField_2);
		
		JLabel genreLbl_2 = new JLabel("Genre");
		genreLbl_2.setFont(new Font("Montserrat", Font.PLAIN, 20));
		genreLbl_2.setBounds(87, 470, 61, 25);
		addEbookPanel.add(genreLbl_2);
		
		genreField_2 = new JTextField();
		genreLbl_2.setLabelFor(genreField_2);
		genreField_2.setHorizontalAlignment(SwingConstants.CENTER);
		genreField_2.setFont(new Font("Montserrat", Font.PLAIN, 25));
		genreField_2.setColumns(10);
		genreField_2.setBounds(160, 460, 310, 45);
		addEbookPanel.add(genreField_2);
		
		JLabel formatLbl_1 = new JLabel("Condition");
		formatLbl_1.setFont(new Font("Montserrat", Font.PLAIN, 20));
		formatLbl_1.setBounds(513, 470, 100, 25);
		addEbookPanel.add(formatLbl_1);
		
		formatField_1 = new JTextField();
		formatLbl_1.setLabelFor(formatField_1);
		formatField_1.setHorizontalAlignment(SwingConstants.CENTER);
		formatField_1.setFont(new Font("Montserrat", Font.PLAIN, 25));
		formatField_1.setColumns(10);
		formatField_1.setBounds(625, 460, 310, 45);
		addEbookPanel.add(formatField_1);
		
		JButton addBtn_2 = new JButton("Add");
		addBtn_2.setOpaque(true);
		addBtn_2.setForeground(Color.WHITE);
		addBtn_2.setFont(new Font("Poppins", Font.PLAIN, 20));
		addBtn_2.setBorderPainted(false);
		addBtn_2.setBackground(new Color(0, 45, 151));
		addBtn_2.setBounds(471, 546, 94, 38);
		addEbookPanel.add(addBtn_2);
		
		JPanel addAudioBookPanel = new JPanel();
		addAudioBookPanel.setBounds(0, 0, 980, 611);
		contentPane.add(addAudioBookPanel);
		addAudioBookPanel.setBackground(new Color(224, 236, 253));
		addAudioBookPanel.setLayout(null);
		
		JLabel addAudiobookLbl = new JLabel("Add an audiobook");
		addAudiobookLbl.setLabelFor(addAudioBookPanel);
		addAudiobookLbl.setFont(new Font("Poppins", Font.PLAIN, 70));
		addAudiobookLbl.setBounds(159, 51, 650, 74);
		addAudioBookPanel.add(addAudiobookLbl);
		
		JLabel ISBNLbl_3 = new JLabel("ISBN");
		ISBNLbl_3.setFont(new Font("Montserrat", Font.PLAIN, 20));
		ISBNLbl_3.setBounds(98, 180, 49, 25);
		addAudioBookPanel.add(ISBNLbl_3);
		
		ISBNfield_3 = new JTextField();
		ISBNLbl_3.setLabelFor(ISBNfield_3);
		ISBNfield_3.setHorizontalAlignment(SwingConstants.CENTER);
		ISBNfield_3.setFont(new Font("Montserrat", Font.PLAIN, 25));
		ISBNfield_3.setColumns(10);
		ISBNfield_3.setBounds(159, 165, 310, 45);
		addAudioBookPanel.add(ISBNfield_3);
		
		JLabel releaseDateLbl_3 = new JLabel("Release Date");
		releaseDateLbl_3.setFont(new Font("Montserrat", Font.PLAIN, 20));
		releaseDateLbl_3.setBounds(481, 180, 131, 25);
		addAudioBookPanel.add(releaseDateLbl_3);
		
		releaseDateField_3 = new JTextField();
		releaseDateLbl_3.setLabelFor(releaseDateField_3);
		releaseDateField_3.setHorizontalAlignment(SwingConstants.CENTER);
		releaseDateField_3.setFont(new Font("Montserrat", Font.PLAIN, 25));
		releaseDateField_3.setColumns(10);
		releaseDateField_3.setBounds(624, 165, 310, 45);
		addAudioBookPanel.add(releaseDateField_3);
		
		JLabel bookTypeLbl_4 = new JLabel("Book Type");
		bookTypeLbl_4.setFont(new Font("Montserrat", Font.PLAIN, 20));
		bookTypeLbl_4.setBounds(41, 247, 106, 25);
		addAudioBookPanel.add(bookTypeLbl_4);
		
		bookTypeField_3 = new JTextField();
		bookTypeLbl_4.setLabelFor(bookTypeField_3);
		bookTypeField_3.setText("audiobook");
		bookTypeField_3.setHorizontalAlignment(SwingConstants.CENTER);
		bookTypeField_3.setFont(new Font("Montserrat", Font.PLAIN, 25));
		bookTypeField_3.setColumns(10);
		bookTypeField_3.setBounds(159, 238, 310, 45);
		addAudioBookPanel.add(bookTypeField_3);
		
		JLabel priceLbl_3 = new JLabel("Price");
		priceLbl_3.setFont(new Font("Montserrat", Font.PLAIN, 20));
		priceLbl_3.setBounds(562, 247, 50, 25);
		addAudioBookPanel.add(priceLbl_3);
		
		priceField_3 = new JTextField();
		priceLbl_3.setLabelFor(priceField_3);
		priceField_3.setHorizontalAlignment(SwingConstants.CENTER);
		priceField_3.setFont(new Font("Montserrat", Font.PLAIN, 25));
		priceField_3.setColumns(10);
		priceField_3.setBounds(624, 238, 310, 45);
		addAudioBookPanel.add(priceField_3);
		
		JLabel titleLbl_3 = new JLabel("Title");
		titleLbl_3.setFont(new Font("Montserrat", Font.PLAIN, 20));
		titleLbl_3.setBounds(106, 325, 41, 25);
		addAudioBookPanel.add(titleLbl_3);
		
		titleField_3 = new JTextField();
		titleLbl_3.setLabelFor(titleField_3);
		titleField_3.setHorizontalAlignment(SwingConstants.CENTER);
		titleField_3.setFont(new Font("Montserrat", Font.PLAIN, 25));
		titleField_3.setColumns(10);
		titleField_3.setBounds(159, 310, 310, 45);
		addAudioBookPanel.add(titleField_3);
		
		JLabel quantityLbl_3 = new JLabel("Quantity");
		quantityLbl_3.setFont(new Font("Montserrat", Font.PLAIN, 20));
		quantityLbl_3.setBounds(524, 320, 88, 25);
		addAudioBookPanel.add(quantityLbl_3);
		
		quantityField_3 = new JTextField();
		quantityLbl_3.setLabelFor(quantityField_3);
		quantityField_3.setHorizontalAlignment(SwingConstants.CENTER);
		quantityField_3.setFont(new Font("Montserrat", Font.PLAIN, 25));
		quantityField_3.setColumns(10);
		quantityField_3.setBounds(624, 310, 310, 45);
		addAudioBookPanel.add(quantityField_3);
		
		JLabel languageLbl_3 = new JLabel("Language");
		languageLbl_3.setFont(new Font("Montserrat", Font.PLAIN, 20));
		languageLbl_3.setBounds(41, 395, 106, 25);
		addAudioBookPanel.add(languageLbl_3);
		
		languageField_3 = new JTextField();
		languageLbl_3.setLabelFor(languageField_3);
		languageField_3.setHorizontalAlignment(SwingConstants.CENTER);
		languageField_3.setFont(new Font("Montserrat", Font.PLAIN, 25));
		languageField_3.setColumns(10);
		languageField_3.setBounds(159, 385, 310, 45);
		addAudioBookPanel.add(languageField_3);
		
		JLabel listenLengthLbl = new JLabel("Listen Length");
		listenLengthLbl.setFont(new Font("Montserrat", Font.PLAIN, 20));
		listenLengthLbl.setBounds(470, 395, 142, 25);
		addAudioBookPanel.add(listenLengthLbl);
		
		listenLengthField = new JTextField();
		listenLengthLbl.setLabelFor(listenLengthField);
		listenLengthField.setHorizontalAlignment(SwingConstants.CENTER);
		listenLengthField.setFont(new Font("Montserrat", Font.PLAIN, 25));
		listenLengthField.setColumns(10);
		listenLengthField.setBounds(624, 385, 310, 45);
		addAudioBookPanel.add(listenLengthField);
		
		JLabel genreLbl_3 = new JLabel("Genre");
		genreLbl_3.setFont(new Font("Montserrat", Font.PLAIN, 20));
		genreLbl_3.setBounds(86, 470, 61, 25);
		addAudioBookPanel.add(genreLbl_3);
		
		genreField_3 = new JTextField();
		genreLbl_3.setLabelFor(genreField_3);
		genreField_3.setHorizontalAlignment(SwingConstants.CENTER);
		genreField_3.setFont(new Font("Montserrat", Font.PLAIN, 25));
		genreField_3.setColumns(10);
		genreField_3.setBounds(159, 460, 310, 45);
		addAudioBookPanel.add(genreField_3);
		
		JLabel formatLbl_2 = new JLabel("Format");
		formatLbl_2.setFont(new Font("Montserrat", Font.PLAIN, 20));
		formatLbl_2.setBounds(537, 470, 75, 25);
		addAudioBookPanel.add(formatLbl_2);
		
		textField_9 = new JTextField();
		formatLbl_2.setLabelFor(textField_9);
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setFont(new Font("Montserrat", Font.PLAIN, 25));
		textField_9.setColumns(10);
		textField_9.setBounds(624, 460, 310, 45);
		addAudioBookPanel.add(textField_9);
		
		JButton addBtn_3 = new JButton("Add");
		addBtn_3.setOpaque(true);
		addBtn_3.setForeground(Color.WHITE);
		addBtn_3.setFont(new Font("Poppins", Font.PLAIN, 20));
		addBtn_3.setBorderPainted(false);
		addBtn_3.setBackground(new Color(0, 45, 151));
		addBtn_3.setBounds(470, 546, 94, 38);
		addAudioBookPanel.add(addBtn_3);
	}
}
