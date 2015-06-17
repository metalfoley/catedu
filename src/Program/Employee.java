package program;

public abstract class Employee extends Person {
	
	public Employee(int id, String firstName, String lastName, String address,
			String city, String state, String zipCode, String phoneOne,
			String phoneTwo, String email, String role, boolean active) {
		super(id, firstName, lastName, address, city, state, zipCode, phoneOne,
				phoneTwo, email, active);
	}
	
	public Employee(){}

	private District district;

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}
	
}
