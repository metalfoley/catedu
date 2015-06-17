package program;
import java.util.ArrayList;

public class Teacher extends Employee {

	public Teacher(int id, String firstName, String lastName, String address,
			String city, String state, String zipCode, String phoneOne,
			String phoneTwo, String email, String role, boolean active) {
		super(id, firstName, lastName, address, city, state, zipCode, phoneOne,
				phoneTwo, email, role, active);
		students = new ArrayList<Student>();
	}
	
	public Teacher(){}

	private ArrayList<Student> students;
	

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	
	/**
	 * Adds a student to the teachers list of students
	 * @param student to be added
	 */
	public void addStudent(Student student) {
		student.setTeacher(this);
		students.add(student);
	}
	
	/**
	 * Removes a student from the teachers list of students
	 * @param student to be removed
	 */
	public void removeStudent(Student student) {
		student.setTeacher(null);
		students.remove(student);
	}
}
