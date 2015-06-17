package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import extract.ExtractLesson;
import program.Lesson;
import program.Person;
import base.DBConn;

public class DaoLesson {
	
	public static ArrayList<Lesson> getAllLessons() {
		ResultSet rs;
		rs = DBConn.query("SELECT * FROM Lesson");
		ArrayList<Lesson> lessons = ExtractLesson.extractAllLessons(rs);
		return lessons;
	}
	
	public static Person getLessonAuthor(int authorId) {
		ResultSet rs;
		rs = DBConn.query("SELECT * FROM Person INNER JOIN Roles ON Person.Role= Roles.ID WHERE Person.ID='"+authorId+"'");
		return ExtractLesson.extractAuthor(rs);
	}
	
	public static HashMap<String,ArrayList<String>> getLessonHashMap(int lessonId) {
		ResultSet rs;
		rs = DBConn.query("SELECT Core_Standards.Core_Standard, Classes.Name AS ClassName "
				+ "FROM CoreStandard_Class_Lesson_Link INNER JOIN Core_Standards ON CoreStandard_Class_Lesson_Link.CoreStandardID=Core_Standards.ID "
				+ "INNER JOIN Classes ON CoreStandard_Class_Lesson_Link.ClassID=Classes.ID "
				+ "WHERE LessonID='"+lessonId+"'");
		return ExtractLesson.extractLessonHashMap(rs);
	}
}
