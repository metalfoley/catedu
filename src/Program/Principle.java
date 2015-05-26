package Program;

public class Principle extends Person{
	
	public Principle(int id, String firstName, String lastName, String address,
			String city, String state, String zipCode, String phoneOne,
			String phoneTwo, String email, String role, boolean active) {
		super(id, firstName, lastName, address, city, state, zipCode, phoneOne,
				phoneTwo, email, role, active);
	}

	School school;
	
	public void setSchool(School pSchool) {
		this.school = pSchool;
	}
	
	public School getSchool() {
		return this.school;
	}
}
