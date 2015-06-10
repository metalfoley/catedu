package program;

public class CurrentUser extends Person{

	public String userName;
	public String password;
	
	public CurrentUser(int id, String firstName, String lastName,
			String address, String city, String state,
			String zipCode, String phoneOne, String email, String role,
			boolean active, String userName, String password) {
		
		super(id, firstName, lastName, address, city, state, zipCode,
				phoneOne, email, role, active);
		this.userName = userName;
		this.password = password;
	}
	
	public CurrentUser(){}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
