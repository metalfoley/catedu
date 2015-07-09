package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import program.Guardian;
import program.Student;
import base.DBConn;
import base.Filo;
import extract.ExtractStudent;

public class DaoStudent {
	
	/**
	 * Decide which method to use depending on wizard page
	 * @param pStudent - Student being updated
	 * @param stage - Wizard page being used
	 * @return Updated student object
	 */
	public static Student createNewWiz(Student pStudent, int stage) {
		Student student = null;
		DBConn.openConn();
		switch(stage) {
			case 1:
				student = addStudentOne(pStudent);
				break;
			case 2:
				student = addStudentTwo(pStudent);
				break;
		}
		DBConn.closeConn();
		return student;
	}
	
	/**
	 * Student object based off information from AddStudentWiz1
	 * @param pStudent The student to be updated
	 * @return
	 */
	private static Student addStudentOne(Student pStudent) {
		Student student = pStudent;
		String columns, columns2, scope, query, query2;
		columns = "FirstName,MiddleName,LastName,Address,City,State,Zipcode,Phone1,Phone2,Role,Active";
		columns2 = "Student_School_ID,Person_ID";
		scope = "SELECT SCOPE_IDENTITY() AS [ID]";
		query = String.format("INSERT INTO Person (%s) VALUES('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s') %s", 
							   columns,student.getFirstName(),student.getMiddleName(),student.getLastName(),
							   student.getAddress(),student.getCity(),student.getState(),student.getZipCode(),
							   student.getPhoneOne(),student.getPhoneTwo(),4,true,scope);
		ResultSet rs = DBConn.query(query);
		
		// Get the id returned from insert and create students school id from it
		int id = ExtractStudent.getRecordId(rs);
		student.createStudentId(id);
		
		query2 = String.format("INSERT INTO Student (%s) VALUES ('%s','%s') %s", columns2,student.getStudentID(),id,scope);
		student.setId(ExtractStudent.getRecordId(DBConn.query(query2)));
		return student;
	}
	
	/**
	 * Updates student object based off information from AddStudentWiz2
	 * @param pStudent The student to be updated
	 * @return Student
	 */
	private static Student addStudentTwo(Student pStudent) {
		String columns,scope,query,query2,query3;
		columns = "FirstName,MiddleName,LastName,Address,City,State,Zipcode,Phone1,Phone2,Role,Active";
		scope = "SELECT SCOPE_IDENTITY() AS [ID]";
		
		for(Guardian guardian : pStudent.getGuardians()) {
			query = String.format("INSERT INTO Person (%s) VALUES('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s') %s", 
								   columns,guardian.getFirstName(),guardian.getMiddleName(),guardian.getLastName(),
								   guardian.getAddress(),guardian.getCity(),guardian.getState(),guardian.getZipCode(),
								   guardian.getPhoneOne(),guardian.getPhoneTwo(),6,true,scope);
			
			
			// Get the id returned from insert
			guardian.setId(ExtractStudent.getRecordId(DBConn.query(query)));
			
			query2 = String.format("INSERT INTO Guardian (Relationship,PersonID) VALUES ('%s','%s') %s", guardian.getRelationship(),guardian.getId(),scope);
			guardian.setGuardianID(ExtractStudent.getRecordId(DBConn.query(query2)));
			
			query3 = String.format("INSERT INTO Link_Student_Guardian (Student,Guardian) VALUES ('%s','%s')", pStudent.getId(),guardian.getGuardianID());
			Filo.log(query3);
			try {
				DBConn.update(query3);
			} catch (SQLException e) {
				Filo.log("addStudentTwo: " + e.getMessage());
			}
		}
		return pStudent;
	}
}
