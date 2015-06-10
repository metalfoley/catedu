package program;

public class Student extends Employee {

	public Student(int id, String firstName, String lastName, String address,
			String city, String state, String zipCode, String phoneOne,
			String phoneTwo, String email, String role, boolean active) {
		super(id, firstName, lastName, address, city, state, zipCode, phoneOne,
				phoneTwo, email, role, active);
	}

	private Teacher teacher;

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
}
