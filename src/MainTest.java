import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class MainTest {

	public static void main(String[] args) throws IOException {

		
//		FileReader userAccounts = new FileReader("src/UserAccounts.txt");
//		BufferedReader reader = new BufferedReader(userAccounts);
//		
//		ArrayList<String> usernameList = new ArrayList<String>();
//		String row = null;		
//		User user = null;
//		
//		while ((row = reader.readLine()) != null) {
//			
//			String[] rowList = row.split(",");
//			int userID = Integer.parseInt(rowList[0].strip());
//			String username = rowList[1].strip();
//			String surname = rowList[2].strip();
//			Address address = new Address(Integer.parseInt(rowList[3].strip()), rowList[4].strip(), rowList[5].strip());
//			String accountType = rowList[6].strip();
//			
//			user = new User(userID, username, surname, address, accountType); // create user for each row
//			usernameList.add(user.getUsername());
//
//		}
//		reader.close();
		
//		FileReader allBooks = new FileReader("src/Stock.txt");
//		BufferedReader reader = new BufferedReader(allBooks);
//		
//		ArrayList<String> bookList = new ArrayList<String>();
//		String row = null;		
//		
//		float lastPrice = 0;
//		while ((row = reader.readLine()) != null) {
//			String[] rowList = row.split(",");
//			bookList.add(Arrays.toString(rowList));
//			float min = Float.parseFloat(rowList[6].strip());
//			if (min < lastPrice) {
//				bookList.set(0, row);
//			}
//			min = lastPrice;
//			System.out.println(rowList[6]);
//		}
//		reader.close();
////		for (int i = 0; i < bookList.size(); i++) {
////			System.out.println(bookList.get(i));
////		}
		
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
		for (int i = 0; i < bookList.size(); i++) {
			System.out.println(bookList.get(i));
		}
		
	}

}
