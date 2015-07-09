package program;

import java.util.ArrayList;

public class Student extends Person {

	private Teacher teacher;
	private String studentID;
	private Guardian[] eContacts = new Guardian[3];
	private Guardian[] guardians = new Guardian[2];
	private int grade;
	private boolean isEll;
	private String language;
	private String notes;
	
	
	public Student() {}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public Guardian[] geteContacts() {
		return eContacts;
	}

	public void seteContacts(Guardian[] eContacts) {
		this.eContacts = eContacts;
	}

	public Guardian[] getGuardians() {
		return guardians;
	}

	public void setGuardians(Guardian[] guardians) {
		this.guardians = guardians;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public boolean isEll() {
		return isEll;
	}

	public void setEll(boolean isEll) {
		this.isEll = isEll;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	/**
	 * Creates a student Id EX: SCH2870
	 * @param id
	 */
	public void createStudentId(Integer id) {
		this.studentID = "SCH" + (id + new Integer(243).toString());
	}
}
