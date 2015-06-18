package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import extract.ExtractLesson;
import program.Lesson;
import program.Person;
import base.DBConn;
import base.Filo;

public class DaoLesson {
	
	private ResultSet rs;
	private StringBuilder queryBuild;
	private String query;
	
	private String createLessonQuery() {
		StringBuilder queryBuild = new StringBuilder();
		queryBuild.append(" SELECT Lesson.ID AS LessonID,Lesson.Name,Lesson.Short_Description,Lesson.Full_Description,Lesson.Advanced,Enhancements,Lesson.Extensions,");
		queryBuild.append("Lesson.Details,Lesson.Materials,Lesson.LeadLesson,Assessment_Types.Assessment_Type,Lesson.AssessmentLink,Lesson.AssessmentInfo,");
		queryBuild.append("Person.ID AS PersonID,Person.FirstName AS AuthorFName,Person.LastName AS AuthorLName FROM Lesson ");
		queryBuild.append("INNER JOIN Person ON Lesson.Author=Person.ID ");
		queryBuild.append("INNER JOIN Assessment_Types ON Lesson.AssessmentType=Assessment_Types.ID");
		
		return queryBuild.toString();
	}
	
	public ArrayList<Lesson> getAllLessons() {
		query = createLessonQuery();
		rs = DBConn.query(query);
		ArrayList<Lesson> lessons = ExtractLesson.extractAllLessons(rs);
		return lessons;
	}
	
	public Lesson createLesson(int id) {
		query = createLessonQuery();
		DBConn.openConn();
		rs = DBConn.query(query + " WHERE Lesson.ID = " + id);
		Lesson lesson = ExtractLesson.extractLesson(rs);
		DBConn.closeConn();
		return lesson;
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
