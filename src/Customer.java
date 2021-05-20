import java.util.ArrayList;

public class Customer extends User {
	
	
	private static ArrayList<Book> basket = new ArrayList<Book>();
	

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
	
	public static ArrayList<Book> filterGenre(String input, ArrayList<Book> searchResult) {
		
		ArrayList<Book> results = new ArrayList<Book>();
		
		for (int i = 0; i < searchResult.size(); i++) {
			
			if (searchResult.get(i).getGenre().toLowerCase().contains(input))
				results.add(searchResult.get(i));
		}
				
		return results;
		
	}
	
	public static ArrayList<Book> filterAudio(ArrayList<Book> searchResult) {
		
		ArrayList<Book> results = new ArrayList<Book>();
		
		for (Book book : searchResult) {
			if (book.getType().equals("audiobook") && book.getData_8() > 5) // listen length
				results.add(book);
		}
		
		return results;
		
	}
	
	
	
	public static ArrayList<Book> getBasket() {
		return basket;
	}
	
	public static void setBasket(ArrayList<Book> basket) {
		Customer.basket = basket;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	

}
