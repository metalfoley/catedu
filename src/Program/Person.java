package Program;

public class Person {
	
	private String firstName;
	private String lastName;
	private String fullName;
	private String userName;
	private int id;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String phoneOne;
	private String email;
	private String role;
	private boolean active;
	

	public Person(int id, String firstName, String lastName,
			String userName, String address, String city, String state, String zipCode,
			String phoneOne, String email, String role, boolean active) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneOne = phoneOne;
		this.email = email;
		this.role = role;
		this.active = active;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	public String getPhoneOne() {
		return phoneOne;
	}


	public void setPhoneOne(String phoneOne) {
		this.phoneOne = phoneOne;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}
}