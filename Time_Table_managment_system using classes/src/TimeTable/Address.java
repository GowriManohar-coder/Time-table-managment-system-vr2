package TimeTable;

public class Address {
    private String street;
    private String city;
    private String state;
    private int postalCode;
    
    public Address(String street, String city, String state, int postalCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }
    
    public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getStreet() {
        return street;
    }
    
    public String getCity() {
        return city;
    }
    
    public String getState() {
        return state;
    }
    
    public int getPostalCode() {
        return postalCode;
    }
    
    @Override
    public String toString() {
        return street + ", " + city + ", " + state + " " + postalCode;
    }
}
