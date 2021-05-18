
public class Address {

	private int houseNo;
	private String postcode;
	private String city;
	
	public Address(int houseNo, String postcode, String city) {
		this.houseNo = houseNo;
		this.postcode = postcode;
		this.city = city;
	}
	
	public int getHouseNo() {
		return houseNo;
	}
	
	public String getPostcode() {
		return postcode;
	}
	
	public String getCity() {
		return city;
	}
	
	@Override
	
	public String toString() {
		return Integer.toString(getHouseNo()) + ", " + getPostcode() + ", " + getCity();
	}
}
