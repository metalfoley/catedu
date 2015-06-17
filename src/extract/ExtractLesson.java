package extract;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import program.Councelor;
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
	 * @return
	 */
	public static ArrayList<Lesson> extractAllLessons(ResultSet rs) {
		ArrayList<Lesson> lessonArr = new ArrayList<Lesson>();
		Lesson tempLesson = new Lesson();
		int lessonID;
		try {
			while(rs.next()) {
				lessonID = rs.getInt("ID");
				tempLesson.setId(lessonID);
				tempLesson.setName(rs.getString("Name"));
				tempLesson.setShortDescription(rs.getString("Short_Description"));
				tempLesson.setAuthor(DaoLesson.getLessonAuthor(rs.getInt("Author")));
				tempLesson.isAdvanced();
				tempLesson.setFullDescription("Full_Description");
				tempLesson.setEnhancements("Enhancements");
				tempLesson.setExtensions("Extentions");
				tempLesson.setDetails("Details");
				tempLesson.setMaterials("Materials");
				tempLesson.setLeadLesson("LeadLesson");
				tempLesson.setClassCoreLink(DaoLesson.getLessonHashMap(lessonID));
				lessonArr.add(tempLesson);
			}
		} catch (SQLException e) {
			Filo.log("extractLesson.extractAllLessons: " + e.getMessage());
		} 
		return lessonArr;
	}
	
	/**
	 * Extracts the lessons author and returns as the corresponding object
	 * @param rs
	 * @return
	 */
	public static Person extractAuthor(ResultSet rs) {
		Person person = new Teacher();
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
