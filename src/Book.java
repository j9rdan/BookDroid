import java.util.Date;

public class Book implements Comparable<Book> {
	
	private long ISBN;
	private String type;
	private String title;
	private String language;
	private String genre;
	private String releaseDate;
	private Float price; // to allow for sorting
	private int quantity;
	private float data_8; // 8th index of book data (either pageCount or listenLength)
	private String data_9; // 9th index of book data (either condition or format)

	public Book(long ISBN, 
			String type, 
			String title, 
			String language, 
			String genre, 
			String releaseDate, 
			Float price, 
			int quantity, 
			float data_8,
			String data_9) {
		
		this.ISBN = ISBN;
		this.type = type;
		this.title = title;
		this.language = language;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.price = price;
		this.quantity = quantity;	
		this.data_8 = data_8;
		this.data_9 = data_9;
	}
	
	public long getISBN() {
		return ISBN;
	}
	
	public String getType() {
		return type;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public String getReleaseDate() {
		return releaseDate;
	}
	
	public Float getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public float getData_8() {
		return data_8;
	}
	
	public String getData_9() {
		return data_9;
	}
	

	@Override
	public String toString() {
		return Long.toString(getISBN()) + ", " +
				getType() + ", " +
				getTitle() + ", " +
				getLanguage() + ", " +
				getGenre() + ", " +
				getReleaseDate() + ", " +
				Float.toString(getPrice()) + ", " +
				Integer.toString(getQuantity()) + ", " +
				Float.toString(getData_8()) + ", " +
				getData_9();
	}

	@Override
	public int compareTo(Book b) {
		
		return this.getPrice().compareTo(b.getPrice());
	}

}
