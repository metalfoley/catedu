package dao;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import program.LessonPlan;
import extract.ExtractLessonPlan;
import base.DBConn;
import base.Filo;

public class DaoLessonPlan {

	public static LessonPlan createLessonPlanWiz(HttpServletRequest request) {
		LessonPlan tempLP = new LessonPlan();
		tempLP.setName(request.getParameter("name"));
		tempLP.setShortDescription(request.getParameter("shortdescription"));
		tempLP.setFullDescription(request.getParameter("fulldescription"));
		if(request.getParameter("subject") != null)
			tempLP.setSubjectId(Integer.parseInt(request.getParameter("subject")));
		DBConn.openConn();
		String query = String.format("INSERT INTO LessonPlan (Name,Subject,ShortDescription,FullDescription) VALUES ('%s','%s','%s','%s') SELECT SCOPE_IDENTITY() AS [ID]", tempLP.getName(),tempLP.getSubjectId(),tempLP.getShortDescription(),tempLP.getFullDescription());
		int idReturned = ExtractLessonPlan.extractUpdateLessonPlan(DBConn.query(query));
		tempLP.setId(idReturned);
		DBConn.closeConn();
		return tempLP;
	}
	
	public static void addLessonsToLessonPlan(LessonPlan lp, HttpServletRequest request) {
		DBConn.openConn();
		String[] lessonsToAdd = request.getParameterValues("lesson");
		try {
			DBConn.update("");
		} catch (SQLException e) {
			Filo.log(e.getMessage());
		}
		DBConn.closeConn();
	}
}
