package extract;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import program.Councelor;
import program.Employee;
import program.Lesson;
import program.Person;
import program.Principle;
import program.Teacher;
import base.Filo;
import dao.DaoLesson;

public class ExtractLesson {

	/**
	 * Creates an ArrayList of all lessons in the system
	 * @param rs
	 * @return An array of all lessons from the db
	 */
	public static ArrayList<Lesson> extractAllLessons(ResultSet rs) {
		ArrayList<Lesson> lessonArr = new ArrayList<Lesson>();
		Person author;
		Lesson tempLesson;
		int lessonID;
		try {
			while(rs.next()) {
				tempLesson = new Lesson();
				author = new Employee();
				lessonID = rs.getInt("LessonID");
				tempLesson.setId(lessonID);
				tempLesson.setName(rs.getString("Name"));
				tempLesson.setShortDescription(rs.getString("Short_Description"));
				author.setId(rs.getInt("PersonID"));
				author.setFirstName(rs.getString("AuthorFName"));
				author.setLastName(rs.getString("AuthorLName"));
				tempLesson.setAuthor(author);
				tempLesson.setAdvanced(rs.getBoolean("Advanced"));
				tempLesson.setFullDescription(rs.getString("Full_Description"));
				tempLesson.setEnhancements(rs.getString("Enhancements"));
				tempLesson.setExtensions(rs.getString("Extensions"));
				tempLesson.setDetails(rs.getString("Details"));
				tempLesson.setMaterials(rs.getString("Materials"));
				tempLesson.setLeadID(rs.getInt("LeadID"));
				tempLesson.setLeadLesson(rs.getString("LeadName"));
				tempLesson.setClassCoreLink(DaoLesson.getLessonHashMap(lessonID));
				lessonArr.add(tempLesson);
			}
		} catch (SQLException e) {
			Filo.log("extractLesson.extractAllLessons: " + e.getMessage());
		} 
		return lessonArr;
	}
	
	public static Lesson extractLesson(ResultSet rs) {
		Person author;
		Lesson tempLesson = null;
		int lessonID;
		try {
			while(rs.next()) {
				tempLesson = new Lesson();
				author = new Employee();
				lessonID = rs.getInt("LessonID");
				tempLesson.setId(lessonID);
				tempLesson.setName(rs.getString("Name"));
				tempLesson.setShortDescription(rs.getString("Short_Description"));
				author.setId(rs.getInt("PersonID"));
				author.setFirstName(rs.getString("AuthorFName"));
				author.setLastName(rs.getString("AuthorLName"));
				tempLesson.setAuthor(author);
				tempLesson.setAdvanced(rs.getBoolean("Advanced"));
				tempLesson.setFullDescription(rs.getString("Full_Description"));
				tempLesson.setEnhancements(rs.getString("Enhancements"));
				tempLesson.setExtensions(rs.getString("Extensions"));
				tempLesson.setDetails(rs.getString("Details"));
				tempLesson.setMaterials(rs.getString("Materials"));
				tempLesson.setLeadID(rs.getInt("LeadID"));
				tempLesson.setLeadLesson(rs.getString("LeadName"));
				tempLesson.setAssessInfo(rs.getString("AssessmentInfo"));
				tempLesson.setAssessLink(rs.getString("AssessmentLink"));
				tempLesson.setAssessType(rs.getString("Assessment_Type"));
				tempLesson.setClassCoreLink(DaoLesson.getLessonHashMap(lessonID));
			}
		} catch (SQLException e) {
			Filo.log("extractLesson.extractAllLessons: " + e.getMessage());
		}
		return tempLesson;
	}
	
	/**
	 * Extracts the lessons author and returns as the corresponding object
	 * @param rs
	 * @return
	 */
	public static Person extractAuthor(ResultSet rs) {
		Person person = null;
		try {
			if(rs.next()) {
				switch(rs.getString("Role").toLowerCase()) {
					case "teacher":
						person = new Teacher();
						break;
					case "councelor":
						person = new Councelor();
						break;
					case "principle":
						person = new Principle();
						break;
				}
				person.setFirstName(rs.getString("FirstName"));
				person.setLastName(rs.getString("LastName"));
				person.setAddress(rs.getString("Address"));
				person.setCity(rs.getString("City"));
				person.setState(rs.getString("State"));
				person.setZipCode(rs.getString("Zipcode"));
				person.setPhoneOne(rs.getString("Phone1"));
				person.setEmail(rs.getString("Email"));
				person.setRole(rs.getString("Role"));
				person.setActive(rs.getBoolean("Active"));
				
			}
		} catch (SQLException e) {
			Filo.log("extractLesson.extractAuthor: " + e.getMessage());
		}
		return person;
	}
	
	/**
	 * Returns a hashmap contain a class as the key and an ArrayList of Core_standards as the value
	 * @param rs
	 * @return
	 */
	public static HashMap<String,ArrayList<String>> extractLessonHashMap(ResultSet rs) {
		HashMap<String,ArrayList<String>> coreClass = new HashMap<String, ArrayList<String>>();
		try {
			while(rs.next()) {
				if(!coreClass.containsKey(rs.getString("ClassName"))) {
					coreClass.put(rs.getString("ClassName"), new ArrayList<String>());
				}
				coreClass.get(rs.getString("ClassName")).add(rs.getString("Core_Standard"));
			}
		} catch (SQLException e) {
			Filo.log("extractLesson.extractLessonHashMap: " + e.getMessage());
		}
		return coreClass;
	}
	
}
