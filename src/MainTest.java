import java.io.*;
import java.util.ArrayList;

public class MainTest {

	public static void main(String[] args) throws IOException {

		
		FileReader userAccounts = new FileReader("src/UserAccounts.txt");
		BufferedReader reader = new BufferedReader(userAccounts);
		
		ArrayList<String> usernameList = new ArrayList<String>();
		String row = null;		
		User user = null;
		
		while ((row = reader.readLine()) != null) {
			
			String[] rowList = row.split(",");
			int userID = Integer.parseInt(rowList[0].strip());
			String username = rowList[1].strip();
			String surname = rowList[2].strip();
			Address address = new Address(Integer.parseInt(rowList[3].strip()), rowList[4].strip(), rowList[5].strip());
			String accountType = rowList[6].strip();
			
			user = new User(userID, username, surname, address, accountType); // create user for each row
			usernameList.add(user.getUsername());

		}
		reader.close();
		
	}

}
