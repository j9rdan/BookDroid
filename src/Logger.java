import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Logger {
	
	LocalDate today = LocalDate.now();
	String today_f = today.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	
	public LocalDate getToday() {
		return today;
	}
	
	public String getToday_f() {
		return today_f;
	}
	
	

	public void saveBook(ArrayList<Book> bookList, Book b) throws IOException {
		
		FileWriter output = new FileWriter("src/Stock.txt", true);
		BufferedWriter writer = new BufferedWriter(output);
		writer.write("\n");
		writer.write(b.toString());
		writer.close();
				
	}
	
	public void saveCheckout(User u, Book b) throws IOException {
		
		FileWriter output = new FileWriter("src/ActivityLog.txt", true);
		BufferedWriter writer = new BufferedWriter(output);
		writer.write("\n");
		String[] addressSplit = u.getAddress().strip().split(",");
		String postcode = addressSplit[1];
		writer.write(u.getUserID() + ", "
					+ postcode.strip() + ", " 
					+ Long.toString(b.getISBN()) + ", " 
					+ Float.toString(b.getPrice()) + ", "
					+ Integer.toString(b.getQuantity()) + ", purchased, "
					+ u.getPaymentMethod() + ", "
					+ today_f.toString());
		writer.close();
	}
	
	public void saveCancel(User u, Book b) throws IOException {
		
		FileWriter output = new FileWriter("src/ActivityLog.txt", true);
		BufferedWriter writer = new BufferedWriter(output);
		writer.write("\n");
		String[] addressSplit = u.getAddress().strip().split(",");
		String postcode = addressSplit[1];
		writer.write(u.getUserID() + ", "
					+ postcode.strip() + ", " 
					+ Long.toString(b.getISBN()) + ", " 
					+ Float.toString(b.getPrice()) + ", "
					+ Integer.toString(b.getQuantity()) + ", cancelled, , "
					+ today_f.toString()); 
		writer.close();
		
	}
	
	

}
