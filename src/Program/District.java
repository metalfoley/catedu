package Program;
import java.util.ArrayList;

public class District extends Place {
	ArrayList<School> schools;
	ArrayList<Employee> employees;
	
	public District(int id, String name, String address, String city,
			String state, String zipCode, String phone, String email,
			String fax, boolean active) {
		super(id, name, address, city, state, zipCode, phone, email, fax, active);
		schools = new ArrayList<School>();
		employees = new ArrayList<Employee>();
	}

	public ArrayList<School> getSchools() {
		return schools;
	}

	public void setSchools(ArrayList<School> schools) {
		this.schools = schools;
	}

	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	
	/**
	 * Adds a school to the district
	 * @param school to be added
	 */
	public void addSchool(School school) {
		school.setDistrict(this);
		if(!schools.contains(school))
			schools.add(school);
	}
	
	/**
	 * Removes a school from the district
	 * @param school to be removed
	 */
	public void removeSchool(School school) {
		school.setDistrict(null);
		if(schools.contains(school))
			schools.remove(school);
	}
	
	/**
	 * Adds an employee to the list of employees
	 * @param employee to be added
	 */
	public void addEmployee(Employee employee) {
		employee.setDistrict(this);
		if(!employees.contains(employee))
			employees.add(employee);
	}
	
	/**
	 * Removes an employee from the list of employees
	 * @param employee to be removed
	 */
	public void removeTeacher(Employee employee) {
		employee.setDistrict(null);
		if(employees.contains(employee))
			employees.remove(employee);
	}
}
