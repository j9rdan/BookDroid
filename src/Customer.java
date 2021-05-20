import java.util.ArrayList;

public class Customer extends User {
	
	
	static ArrayList<Book> basket = new ArrayList<Book>();

	public Customer(int userID, String username, String surname, Address address, String accountType) {
		super(userID, username, surname, address, accountType);
	}
	
	
	public static ArrayList<Book> searchTitle(String input, ArrayList<Book> bookList) {
		
		ArrayList<Book> results = new ArrayList<Book>();
		
		for (Book book : bookList) {
			if (book.getTitle().toLowerCase().contains(input.toLowerCase()))
				results.add(book);
		}
		
		return results;
		
	}
	
	
	
	public ArrayList<Book> getBasket() {
		return basket;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	
	

	

	
	

}
