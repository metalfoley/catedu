package Program;
import java.util.ArrayList;

public class School extends Place{
	
	ArrayList<String> teachers;
	District district;
	Principle principle;
	
	public School(int id, String name, String address, String city,
			String state, String zipCode, String phone, String email,
			String fax, boolean active) {
		super(id, name, address, city, state, zipCode, phone, email, fax, active);
		teachers = new ArrayList<String>();
	}

	public ArrayList<String> getTeachers() {
		return teachers;
	}

	public void setTeachers(ArrayList<String> teachers) {
		this.teachers = teachers;
	}
	
	public void setDistrict(District district) {
		this.district = district;
	}

	public Principle getPrinciple() {
		return principle;
	}

	public void setPrinciple(Principle principle) {
		this.principle = principle;
		principle.setSchool(this);
	}

	public District getDistrict() {
		return district;
	}
	
	
}
