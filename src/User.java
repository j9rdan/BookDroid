
public class User {
	
	private int userID;
	private String username;
	private String surname;
	private String address;
	private String accountType;
	private String paymentMethod;
	
	public User(int userID, String username, String surname, Address address, String accountType) {
		this.userID = userID;
		this.username = username;
		this.surname = surname;
		this.address = address.toString();
		this.accountType = accountType;
	}
	

	public int getUserID() {
		return userID;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public String getPaymentMethod() {
		return paymentMethod;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	@Override
	
	public String toString() {
		return getUserID() + ", " + getUsername() + ", " + getSurname() + ", " + getAddress() + ", " + getAccountType();
	}

}
