import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.awt.event.ActionEvent;

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
	private JTextField formatField_2;
	private JTextField bookSearchField;
	private JTextField genreField_4;
	private JTextField cardNoField;
	private JTextField emailField;
	private JTextField cvvField;
	private JPanel startupPanel;
	private JPanel bookViewPanel;
	private JPanel pickBookTypePanel;
	private JPanel addPaperbackPanel;
	private JPanel addEbookPanel;
	private JPanel addAudioBookPanel;
	private JPanel bookSearchPanel;
	private JPanel searchResultPanel;
	private JPanel basketPanel;
	private JPanel checkoutPanel;
	private User user;
	private User selectedUser;
	ArrayList<Book> searchResult;
	Float totalCost;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException {

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
		panel.setVisible(true);
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public MainFrame() throws IOException {
		setTitle("BookDroid: Home of the Bookworm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		///// VIEW OF ALL BOOKS /////

		FileReader allBooks = new FileReader("src/Stock.txt");
		BufferedReader reader = new BufferedReader(allBooks);
		ArrayList<Book> bookList = new ArrayList<Book>();
		Book book = null;
		String row = null;

		while ((row = reader.readLine()) != null) {
			String[] rowList = row.split(",");
			Long ISBN = Long.parseLong(rowList[0].strip());
			String type = rowList[1].strip();
			String title = rowList[2].strip();
			String language = rowList[3].strip();
			String genre = rowList[4].strip();
			String releaseDate = rowList[5].strip();
			Float price = Float.parseFloat(rowList[6].strip());
			int quantity = Integer.parseInt(rowList[7].strip());
			float data_8 = Float.parseFloat(rowList[8].strip());
			String data_9 = rowList[9].strip();
			book = new Book(ISBN, type, title, language, genre, releaseDate, price, quantity, data_8, data_9);
			bookList.add(book);
		}
		reader.close();

		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 980, 611);
		contentPane.add(layeredPane);

		startupPanel = new JPanel();
		startupPanel.setBounds(0, 0, 980, 611);
		layeredPane.add(startupPanel);
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

		JButton viewBooksBtn = new JButton("View books");
		viewBooksBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(bookViewPanel);
			}
		});
		viewBooksBtn.setOpaque(true);
		viewBooksBtn.setForeground(Color.WHITE);
		viewBooksBtn.setFont(new Font("Poppins", Font.PLAIN, 15));
		viewBooksBtn.setBorderPainted(false);
		viewBooksBtn.setBackground(new Color(0, 45, 151));
		viewBooksBtn.setBounds(834, 556, 129, 38);
		startupPanel.add(viewBooksBtn);

		bookViewPanel = new JPanel();
		bookViewPanel.setBounds(0, 0, 980, 611);
		layeredPane.add(bookViewPanel);
		bookViewPanel.setBackground(new Color(224, 236, 253));
		bookViewPanel.setLayout(null);
		bookViewPanel.setVisible(false); // hide until panel switch

		JLabel allBooksLbl = new JLabel("All books:");
		allBooksLbl.setLabelFor(bookViewPanel);
		allBooksLbl.setBounds(324, 34, 325, 106);
		allBooksLbl.setFont(new Font("Poppins", Font.PLAIN, 70));
		bookViewPanel.add(allBooksLbl);

		JScrollPane allBooksScroll = new JScrollPane();
		allBooksScroll.setBounds(65, 148, 860, 430);
		bookViewPanel.add(allBooksScroll);

		JButton backBtn_bookView = new JButton("Back");
		backBtn_bookView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(startupPanel);
			}
		});
		backBtn_bookView.setOpaque(true);
		backBtn_bookView.setForeground(Color.WHITE);
		backBtn_bookView.setFont(new Font("Poppins", Font.PLAIN, 15));
		backBtn_bookView.setBorderPainted(false);
		backBtn_bookView.setBackground(new Color(0, 45, 151));
		backBtn_bookView.setBounds(17, 22, 80, 38);
		bookViewPanel.add(backBtn_bookView);

		JList allBooksJList = new JList(bookList.toArray(new Book[0]));
		allBooksJList.setBounds(65, 152, 850, 390);
		allBooksJList.setFont(new Font("Montserrat", Font.PLAIN, 15));
		allBooksJList.setVisibleRowCount(10);
		allBooksScroll.setViewportView(allBooksJList);

		////// USER DROPDOWN //////

		FileReader userAccounts = new FileReader("src/UserAccounts.txt");
		reader = new BufferedReader(userAccounts);

		ArrayList<String> usernameList = new ArrayList<String>();
		HashMap<String, String> usernameAcctMap = new HashMap<String, String>(); // map user name to account type
		HashMap<String, User> usernameUserMap = new HashMap<String, User>(); // map user name to user object
		row = null;
		user = null;

		while ((row = reader.readLine()) != null) {

			String[] rowList = row.split(",");
			int userID = Integer.parseInt(rowList[0].strip());
			String username = rowList[1].strip();
			String surname = rowList[2].strip();
			Address address = new Address(Integer.parseInt(rowList[3].strip()), rowList[4].strip(), rowList[5].strip());
			String accountType = rowList[6].strip();

			user = new User(userID, username, surname, address, accountType); // create user for each row
			usernameList.add(user.getUsername());
			usernameAcctMap.put(username, accountType);
			usernameUserMap.put(username, user);

		}
		reader.close();

		JComboBox userDropdown = new JComboBox(usernameList.toArray(new String[0])); // convert ArrayList<String> to
																						// String[]
		userDropdown.setMaximumRowCount(4);
		userDropdown.setFont(new Font("Montserrat", Font.PLAIN, 15));
		userDropdown.setBounds(337, 315, 181, 27);
		startupPanel.add(userDropdown);
		JButton loginBtn = new JButton("Login");
		selectedUser = null;
		
		
		
		
		
		///// LOGIN BUTTON //////
		
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object chosenUsername = userDropdown.getSelectedItem();
				selectedUser = usernameUserMap.get(chosenUsername);
				if (usernameAcctMap.get(chosenUsername).equals("customer"))
					switchPanel(bookSearchPanel);
				else
					switchPanel(pickBookTypePanel);
			}
		});
		loginBtn.setForeground(Color.WHITE);
		loginBtn.setOpaque(true);
		loginBtn.setBorderPainted(false);
		loginBtn.setBackground(new Color(0, 45, 151));
		loginBtn.setFont(new Font("Poppins", Font.PLAIN, 20));
		loginBtn.setBounds(530, 309, 98, 38);
		startupPanel.add(loginBtn);



		pickBookTypePanel = new JPanel();
		pickBookTypePanel.setBounds(0, 0, 980, 611);
		layeredPane.add(pickBookTypePanel);
		pickBookTypePanel.setBackground(new Color(224, 236, 253));
		pickBookTypePanel.setLayout(null);
		pickBookTypePanel.setVisible(false);

		JLabel selectBookTypeLbl = new JLabel("Select a book type");
		selectBookTypeLbl.setBounds(156, 81, 642, 74);
		selectBookTypeLbl.setFont(new Font("Poppins", Font.PLAIN, 70));
		selectBookTypeLbl.setLabelFor(pickBookTypePanel);
		pickBookTypePanel.add(selectBookTypeLbl);
		
		
		

		///// BOOK TYPE DROPDOWN //////

		JComboBox bookTypeDropdown = new JComboBox(new String[] { "paperback", "ebook", "audiobook" });
		bookTypeDropdown.setMaximumRowCount(4);
		bookTypeDropdown.setFont(new Font("Montserrat", Font.PLAIN, 15));
		bookTypeDropdown.setBounds(346, 311, 181, 27);

		JButton confirmBookBtn = new JButton("Confirm");
		confirmBookBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bookTypeDropdown.getSelectedItem().equals("paperback"))
					switchPanel(addPaperbackPanel);
				else if (bookTypeDropdown.getSelectedItem().equals("audiobook"))
					switchPanel(addAudioBookPanel);
				else
					switchPanel(addEbookPanel);
			}
		});
		confirmBookBtn.setBounds(564, 305, 125, 38);
		confirmBookBtn.setOpaque(true);
		confirmBookBtn.setForeground(Color.WHITE);
		confirmBookBtn.setFont(new Font("Poppins", Font.PLAIN, 20));
		confirmBookBtn.setBorderPainted(false);
		confirmBookBtn.setBackground(new Color(0, 45, 151));
		pickBookTypePanel.add(confirmBookBtn);
		pickBookTypePanel.add(bookTypeDropdown);

		JLabel bookTypeLbl_1 = new JLabel("Book Type");
		bookTypeLbl_1.setFont(new Font("Montserrat", Font.PLAIN, 13));
		bookTypeLbl_1.setBounds(266, 316, 75, 16);
		pickBookTypePanel.add(bookTypeLbl_1);
		
		
		///// PAPERBACK PANEL //////

		addPaperbackPanel = new JPanel();
		addPaperbackPanel.setBounds(0, 0, 980, 611);
		layeredPane.add(addPaperbackPanel);
		addPaperbackPanel.setBackground(new Color(224, 236, 253));
		addPaperbackPanel.setLayout(null);
		addPaperbackPanel.setVisible(false);

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
		bookTypeField_1.setEditable(false); 	// prevent user from adding other book types in that section
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
		
		
		JButton addBtn_1 = new JButton("Add");					// add paperback
		addBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// save input values
				Long ISBN_pb = Long.parseLong(ISBNfield_1.getText().strip());
				String type_pb = bookTypeField_1.getText().strip();
				String title_pb = titleField_1.getText().strip();
				String language_pb = languageField_1.getText().strip();
				String genre_pb = genreField_1.getText().strip();
				String releaseDate_pb = releaseDateField_1.getText().strip();
				Float price_pb = Float.parseFloat(priceField_1.getText().strip());
				int quantity_pb = Integer.parseInt(quantityField_1.getText().strip());
				float pageCount_pb = Float.parseFloat(pageCountField_1.getText().strip());
				String condition_pb = conditionField_1.getText().strip();
				
				// create new paperback & add to collection
				Book paperback = new Book(ISBN_pb, type_pb, title_pb, language_pb, genre_pb, releaseDate_pb, price_pb, quantity_pb, pageCount_pb, condition_pb);
				bookList.add(paperback);
				try {
					Logger.saveBook(bookList, paperback);
					allBooksJList.setListData(bookList.toArray());;
				} catch(Exception ex) {
					ex.printStackTrace();
				} finally { // clear inputs
					ISBNfield_1.setText("");
					titleField_1.setText("");
					languageField_1.setText("");
					genreField_1.setText("");
					releaseDateField_1.setText("");
					priceField_1.setText("");
					quantityField_1.setText("");
					pageCountField_1.setText("");
					conditionField_1.setText("");
				}
				
				switchPanel(bookViewPanel);
			}
		});
		addBtn_1.setOpaque(true);
		addBtn_1.setForeground(Color.WHITE);
		addBtn_1.setFont(new Font("Poppins", Font.PLAIN, 20));
		addBtn_1.setBorderPainted(false);
		addBtn_1.setBackground(new Color(0, 45, 151));
		addBtn_1.setBounds(471, 543, 94, 38);
		addPaperbackPanel.add(addBtn_1);
		
		
		///// EBOOK PANEL /////
		

		addEbookPanel = new JPanel();
		addEbookPanel.setBounds(0, 0, 980, 611);
		layeredPane.add(addEbookPanel);
		addEbookPanel.setBackground(new Color(224, 236, 253));
		addEbookPanel.setLayout(null);
		addEbookPanel.setVisible(false);

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
		bookTypeField_2.setEditable(false);
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

		JLabel formatLbl_1 = new JLabel("Format");
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
		addBtn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// save input values
				Long ISBN_e = Long.parseLong(ISBNfield_2.getText().strip());
				String type_e = bookTypeField_2.getText().strip();
				String title_e = titleField_2.getText().strip();
				String language_e = languageField_2.getText().strip();
				String genre_e = genreField_2.getText().strip();
				String releaseDate_e = releaseDateField_2.getText().strip();
				Float price_e = Float.parseFloat(priceField_2.getText().strip());
				int quantity_e = Integer.parseInt(quantityField_2.getText().strip());
				float pageCount_e = Float.parseFloat(pageCountField_2.getText().strip());
				String format_e = formatField_1.getText().strip();
				
				// create new ebook & add to collection
				Book ebook = new Book(ISBN_e, type_e, title_e, language_e, genre_e, releaseDate_e, price_e, quantity_e, pageCount_e, format_e);
				bookList.add(ebook);
				try {
					Logger.saveBook(bookList, ebook);
					allBooksJList.setListData(bookList.toArray());;
				} catch(Exception ex) {
					ex.printStackTrace();
				} finally { // clear inputs
					ISBNfield_2.setText("");
					titleField_2.setText("");
					languageField_2.setText("");
					genreField_2.setText("");
					releaseDateField_2.setText("");
					priceField_2.setText("");
					quantityField_2.setText("");
					pageCountField_2.setText("");
					formatField_1.setText("");
				}
				
				switchPanel(bookViewPanel);
			}
		});
		addBtn_2.setOpaque(true);
		addBtn_2.setForeground(Color.WHITE);
		addBtn_2.setFont(new Font("Poppins", Font.PLAIN, 20));
		addBtn_2.setBorderPainted(false);
		addBtn_2.setBackground(new Color(0, 45, 151));
		addBtn_2.setBounds(471, 546, 94, 38);
		addEbookPanel.add(addBtn_2);
		
		
		///// AUDIO BOOK PANEL /////
		

		addAudioBookPanel = new JPanel();
		addAudioBookPanel.setBounds(0, 0, 980, 611);
		layeredPane.add(addAudioBookPanel);
		addAudioBookPanel.setBackground(new Color(224, 236, 253));
		addAudioBookPanel.setLayout(null);
		addAudioBookPanel.setVisible(false);

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
		bookTypeField_3.setEditable(false);
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

		formatField_2 = new JTextField();
		formatLbl_2.setLabelFor(formatField_2);
		formatField_2.setHorizontalAlignment(SwingConstants.CENTER);
		formatField_2.setFont(new Font("Montserrat", Font.PLAIN, 25));
		formatField_2.setColumns(10);
		formatField_2.setBounds(624, 460, 310, 45);
		addAudioBookPanel.add(formatField_2);

		JButton addBtn_3 = new JButton("Add");
		addBtn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// save input values
				Long ISBN_a = Long.parseLong(ISBNfield_3.getText().strip());
				String type_a = bookTypeField_3.getText().strip();
				String title_a = titleField_3.getText().strip();
				String language_a = languageField_3.getText().strip();
				String genre_a = genreField_3.getText().strip();
				String releaseDate_a = releaseDateField_3.getText().strip();
				Float price_a = Float.parseFloat(priceField_3.getText().strip());
				int quantity_a = Integer.parseInt(quantityField_3.getText().strip());
				float listenLength_a = Float.parseFloat(listenLengthField.getText().strip());
				String format_a = formatField_2.getText().strip();
				
				// create new audiobook & add to collection
				Book audiobook = new Book(ISBN_a, type_a, title_a, language_a, genre_a, releaseDate_a, price_a, quantity_a, listenLength_a, format_a);
				bookList.add(audiobook);
				try {
					Logger.saveBook(bookList, audiobook);
					allBooksJList.setListData(bookList.toArray());
				} catch(Exception ex) {
					ex.printStackTrace();
				} finally { // clear inputs
					ISBNfield_3.setText("");
					titleField_3.setText("");
					languageField_3.setText("");
					genreField_3.setText("");
					releaseDateField_3.setText("");
					priceField_3.setText("");
					quantityField_3.setText("");
					listenLengthField.setText("");
					formatField_2.setText("");
				}
				
				switchPanel(bookViewPanel);
			}
		});
		addBtn_3.setOpaque(true);
		addBtn_3.setForeground(Color.WHITE);
		addBtn_3.setFont(new Font("Poppins", Font.PLAIN, 20));
		addBtn_3.setBorderPainted(false);
		addBtn_3.setBackground(new Color(0, 45, 151));
		addBtn_3.setBounds(470, 546, 94, 38);
		addAudioBookPanel.add(addBtn_3);
		
		
		///// BOOK SEARCH PANEL /////

		bookSearchPanel = new JPanel();
		bookSearchPanel.setBounds(0, 0, 980, 611);
		layeredPane.add(bookSearchPanel);
		bookSearchPanel.setBackground(new Color(224, 236, 253));
		bookSearchPanel.setLayout(null);
		bookSearchPanel.setVisible(false);

		JLabel bookSearchLbl = new JLabel("Search a book");
		bookSearchLbl.setLabelFor(bookSearchPanel);
		bookSearchLbl.setBounds(227, 32, 502, 106);
		bookSearchLbl.setFont(new Font("Poppins", Font.PLAIN, 70));
		bookSearchPanel.add(bookSearchLbl);

		bookSearchField = new JTextField();
		bookSearchField.setFont(new Font("Montserrat", Font.ITALIC, 25));
		bookSearchField.setText(" Book title..");
		bookSearchField.setBounds(133, 236, 705, 46);
		bookSearchPanel.add(bookSearchField);
		bookSearchField.setColumns(10);

		JLabel genreLbl_4 = new JLabel("Genre");
		genreLbl_4.setLabelFor(genreField_4);
		genreLbl_4.setFont(new Font("Montserrat", Font.PLAIN, 20));
		genreLbl_4.setBounds(141, 330, 61, 25);
		bookSearchPanel.add(genreLbl_4);

		genreField_4 = new JTextField();
		genreField_4.setFont(new Font("Montserrat", Font.PLAIN, 25));
		genreField_4.setColumns(10);
		genreField_4.setBounds(214, 318, 280, 46);
		bookSearchPanel.add(genreField_4);

		JCheckBox audiobookFilterTick = new JCheckBox("Audiobooks (listen time > 5hrs)");
		audiobookFilterTick.setBackground(Color.WHITE);
		audiobookFilterTick.setFont(new Font("Montserrat", Font.PLAIN, 20));
		audiobookFilterTick.setBounds(506, 323, 342, 37);
		bookSearchPanel.add(audiobookFilterTick);
		

		///// SEARCH RESULT PANEL /////

		searchResultPanel = new JPanel();
		searchResultPanel.setBounds(0, 0, 980, 611);
		layeredPane.add(searchResultPanel);
		searchResultPanel.setBackground(new Color(224, 236, 253));
		searchResultPanel.setLayout(null);
		searchResultPanel.setVisible(false);

		JLabel searchResultLbl = new JLabel("Books found:");
		searchResultLbl.setLabelFor(searchResultPanel);
		searchResultLbl.setBounds(277, 40, 452, 106);
		searchResultLbl.setFont(new Font("Poppins", Font.PLAIN, 70));
		searchResultPanel.add(searchResultLbl);

		JScrollPane searchResultScroll = new JScrollPane();
		searchResultScroll.setBounds(103, 158, 770, 327);
		searchResultPanel.add(searchResultScroll);

		JList searchResultJList = new JList();
		searchResultJList.setFont(new Font("Montserrat", Font.PLAIN, 15));
		searchResultJList.setVisibleRowCount(10);
		searchResultScroll.setViewportView(searchResultJList);
		
		///// SEARCH FUNCTION /////
		
		searchResult = null;
		JButton searchBtn = new JButton("Search");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchResult = Customer.searchTitle(bookSearchField.getText().strip(), bookList);
				
				// neither filter
				if (genreField_4.getText().equals("") && !audiobookFilterTick.isSelected())
					searchResultJList.setListData(searchResult.toArray(new Book[0]));
				
				// filter only by genre
				else if (!genreField_4.getText().equals("") && !audiobookFilterTick.isSelected()) {
					searchResult = Customer.filterGenre(genreField_4.getText().strip(), searchResult);				}
				
				// filter only by audio book
				else if (genreField_4.getText().equals("") && audiobookFilterTick.isSelected())
					searchResult = Customer.filterAudio(searchResult);
				
				// both filters
				else 
					searchResult = Customer.filterAudio(Customer.filterGenre(genreField_4.getText().strip(), searchResult));

				searchResultJList.setListData(searchResult.toArray(new Book[0]));
				switchPanel(searchResultPanel);
			}
		});
		searchBtn.setOpaque(true);
		searchBtn.setForeground(Color.WHITE);
		searchBtn.setFont(new Font("Poppins", Font.PLAIN, 20));
		searchBtn.setBorderPainted(false);
		searchBtn.setBackground(new Color(0, 45, 151));
		searchBtn.setBounds(452, 401, 114, 38);
		bookSearchPanel.add(searchBtn);
		
	
		
		///// BASKET PANEL /////

		basketPanel = new JPanel();
		basketPanel.setBounds(0, 0, 980, 611);
		layeredPane.add(basketPanel);
		basketPanel.setBackground(new Color(224, 236, 253));
		basketPanel.setLayout(null);
		basketPanel.setVisible(false);

		JLabel basketLbl = new JLabel("Basket");
		basketLbl.setLabelFor(basketPanel);
		basketLbl.setFont(new Font("Poppins", Font.PLAIN, 70));
		basketLbl.setBounds(371, 40, 231, 106);
		basketPanel.add(basketLbl);
		JList basketJList = new JList();

		
		JButton addToBasketBtn = new JButton("Add to basket");
		addToBasketBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer.setBasket((ArrayList<Book>)searchResultJList.getSelectedValuesList());
				basketJList.setListData(searchResultJList.getSelectedValuesList().toArray(new Book[0]));
				switchPanel(basketPanel);
			}
		});
		addToBasketBtn.setOpaque(true);
		addToBasketBtn.setForeground(Color.WHITE);
		addToBasketBtn.setFont(new Font("Poppins", Font.PLAIN, 20));
		addToBasketBtn.setBorderPainted(false);
		addToBasketBtn.setBackground(new Color(0, 45, 151));
		addToBasketBtn.setBounds(404, 511, 182, 38);
		searchResultPanel.add(addToBasketBtn);

		JScrollPane basketScroll = new JScrollPane();
		basketScroll.setBounds(101, 158, 770, 327);
		basketPanel.add(basketScroll);

		basketJList.setFont(new Font("Montserrat", Font.PLAIN, 15));
		basketJList.setVisibleRowCount(10);
		basketScroll.setViewportView(basketJList);

		JButton checkoutBtn = new JButton("Checkout");
		checkoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(checkoutPanel);
			}
		});
		checkoutBtn.setOpaque(true);
		checkoutBtn.setForeground(Color.WHITE);
		checkoutBtn.setFont(new Font("Poppins", Font.PLAIN, 20));
		checkoutBtn.setBorderPainted(false);
		checkoutBtn.setBackground(new Color(0, 45, 151));
		checkoutBtn.setBounds(424, 511, 139, 38);
		basketPanel.add(checkoutBtn);

		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for (Book b : Customer.getBasket()) {
					try {
						Logger.saveCancel(selectedUser, b);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
				Customer.setBasket(new ArrayList<Book>()); // set to empty array list
				basketJList.setListData(Customer.getBasket().toArray(new Book[0]));
				switchPanel(searchResultPanel);
			}
		});
		cancelBtn.setOpaque(true);
		cancelBtn.setForeground(Color.WHITE);
		cancelBtn.setFont(new Font("Poppins", Font.PLAIN, 20));
		cancelBtn.setBorderPainted(false);
		cancelBtn.setBackground(new Color(251, 143, 143));
		cancelBtn.setBounds(101, 108, 115, 38);
		basketPanel.add(cancelBtn);
		
		
		///// CHECKOUT PANEL /////

		checkoutPanel = new JPanel();
		checkoutPanel.setBounds(0, 0, 980, 611);
		layeredPane.add(checkoutPanel);
		checkoutPanel.setBackground(new Color(224, 236, 253));
		checkoutPanel.setLayout(null);
		checkoutPanel.setVisible(false);

		JLabel checkoutLbl = new JLabel("Checkout");
		checkoutLbl.setLabelFor(checkoutPanel);
		checkoutLbl.setFont(new Font("Poppins", Font.PLAIN, 70));
		checkoutLbl.setBounds(326, 48, 335, 74);
		checkoutPanel.add(checkoutLbl);

		JLabel cardNoLbl = new JLabel("Card Number");
		cardNoLbl.setFont(new Font("Montserrat", Font.PLAIN, 20));
		cardNoLbl.setBounds(51, 245, 143, 25);
		checkoutPanel.add(cardNoLbl);

		cardNoField = new JTextField();
		cardNoLbl.setLabelFor(cardNoField);
		cardNoField.setHorizontalAlignment(SwingConstants.CENTER);
		cardNoField.setFont(new Font("Montserrat", Font.PLAIN, 25));
		cardNoField.setColumns(10);
		cardNoField.setBounds(196, 234, 193, 45);
		checkoutPanel.add(cardNoField);

		JLabel emailLbl = new JLabel("Email");
		emailLbl.setFont(new Font("Montserrat", Font.PLAIN, 20));
		emailLbl.setBounds(545, 280, 56, 25);
		checkoutPanel.add(emailLbl);

		emailField = new JTextField();
		emailLbl.setLabelFor(emailField);
		emailField.setHorizontalAlignment(SwingConstants.CENTER);
		emailField.setFont(new Font("Montserrat", Font.PLAIN, 25));
		emailField.setColumns(10);
		emailField.setBounds(613, 269, 310, 45);
		checkoutPanel.add(emailField);

		JLabel cvvLbl = new JLabel("CVV");
		cvvLbl.setLabelFor(emailField);
		cvvLbl.setFont(new Font("Montserrat", Font.PLAIN, 20));
		cvvLbl.setBounds(142, 316, 42, 25);
		checkoutPanel.add(cvvLbl);

		cvvField = new JTextField();
		cvvField.setHorizontalAlignment(SwingConstants.CENTER);
		cvvField.setFont(new Font("Montserrat", Font.PLAIN, 25));
		cvvField.setColumns(10);
		cvvField.setBounds(196, 307, 193, 45);
		checkoutPanel.add(cvvField);

		JLabel orLbl = new JLabel("or");
		orLbl.setFont(new Font("Montserrat", Font.PLAIN, 15));
		orLbl.setLabelFor(checkoutPanel);
		orLbl.setBounds(474, 286, 21, 16);
		checkoutPanel.add(orLbl);
		
		totalCost = 0f;
		JButton confirmCreditBtn = new JButton("Confirm Credit Card");
		confirmCreditBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!(cardNoField.getText().strip().equals("") || cvvField.getText().strip().equals("")))
					selectedUser.setPaymentMethod("Credit Card");
				
				for (Book b : Customer.getBasket()) {
					totalCost += b.getPrice(); 
					try {
						Logger.saveCheckout(selectedUser, b);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				Customer.setBasket(new ArrayList<Book>()); // set to empty array list
				basketJList.setListData(Customer.getBasket().toArray(new Book[0]));
				switchPanel(basketPanel);
			}
		});
		confirmCreditBtn.setOpaque(true);
		confirmCreditBtn.setForeground(Color.WHITE);
		confirmCreditBtn.setFont(new Font("Poppins", Font.PLAIN, 20));
		confirmCreditBtn.setBorderPainted(false);
		confirmCreditBtn.setBackground(new Color(0, 45, 151));
		confirmCreditBtn.setBounds(169, 422, 245, 38);
		checkoutPanel.add(confirmCreditBtn);

		JButton confirmPaypalBtn = new JButton("Confirm Paypal");
		confirmPaypalBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!(emailField.getText().strip().equals("")))
					selectedUser.setPaymentMethod("PayPal");
				
				for (Book b : Customer.getBasket()) {
					totalCost += b.getPrice(); 
					try {
						Logger.saveCheckout(selectedUser, b);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				Customer.setBasket(new ArrayList<Book>()); // set to empty array list
				basketJList.setListData(Customer.getBasket().toArray(new Book[0]));
				switchPanel(basketPanel);
			}
		});
		confirmPaypalBtn.setOpaque(true);
		confirmPaypalBtn.setForeground(Color.WHITE);
		confirmPaypalBtn.setFont(new Font("Poppins", Font.PLAIN, 20));
		confirmPaypalBtn.setBorderPainted(false);
		confirmPaypalBtn.setBackground(new Color(0, 45, 151));
		confirmPaypalBtn.setBounds(631, 422, 205, 38);
		checkoutPanel.add(confirmPaypalBtn);
	}
}
