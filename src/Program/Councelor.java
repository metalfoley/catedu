package program;

public class Councelor extends Employee{

	public Councelor(int id, String firstName, String lastName, String address,
			String city, String state, String zipCode, String phoneOne,
			String phoneTwo, String email, String role, boolean active) {
		super(id, firstName, lastName, address, city, state, zipCode, phoneOne,
				phoneTwo, email, role, active);
	}
	
	public Councelor(){}
	
}
