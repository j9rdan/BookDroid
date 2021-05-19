import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Logger {	

	public static void saveBook(ArrayList<Book> bookList, Book b) throws IOException {
		
		FileWriter output = new FileWriter("src/Stock.txt", true);
		BufferedWriter writer = new BufferedWriter(output);
		writer.write("\n");
		writer.write(b.toString());
		writer.close();
				
	}
	
	public static void saveCheckout(User u, Book b) throws IOException {
		
		FileWriter output = new FileWriter("src/logTest.txt", true);
		BufferedWriter writer = new BufferedWriter(output);
		writer.write("\n");
		String[] addressSplit = u.getAddress().strip().split(",");
		String postcode = addressSplit[1];
		writer.write(u.getUserID() + ", "
					+ postcode + ", " 
					+ Long.toString(b.getISBN()) + ", " 
					+ Float.toString(b.getPrice()) + ", "
					+ Integer.toString(b.getQuantity()) + ", purchased, "
					+ u.getPaymentMethod() + ", ");
					// + currentDate stuff
		writer.close();
	}
	
	public static void saveCancel(User u, Book b) throws IOException {
		
	}

}
