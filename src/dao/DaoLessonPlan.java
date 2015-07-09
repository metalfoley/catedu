package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import program.LessonPlan;
import base.DBConn;
import base.Filo;
import extract.ExtractLessonPlan;

public class DaoLessonPlan {

	public static LessonPlan createLessonPlanWiz(HttpServletRequest request) {
		LessonPlan tempLP = new LessonPlan();
		tempLP.setName(request.getParameter("name"));
		tempLP.setShortDescription(request.getParameter("shortdescription"));
		tempLP.setFullDescription(request.getParameter("fulldescription"));
		if(request.getParameter("subject") != null)
			tempLP.setSubjectId(Integer.parseInt(request.getParameter("subject")));
		DBConn.openConn();
		String query = String.format("INSERT INTO LessonPlan (Name,SubjectID,ShortDescription,FullDescription) VALUES ('%s','%s','%s','%s') SELECT SCOPE_IDENTITY() AS [ID]", tempLP.getName(),tempLP.getSubjectId(),tempLP.getShortDescription(),tempLP.getFullDescription());
		int idReturned = ExtractLessonPlan.extractUpdateLessonPlan(DBConn.query(query));
		tempLP.setId(idReturned);
		DBConn.closeConn();
		return tempLP;
	}
	
	public static void addLessonsToLessonPlan(LessonPlan lp, HttpServletRequest request) {
		DBConn.openConn();
		lp = (LessonPlan) request.getSession().getAttribute("lessonPlan");
		String[] lessonsToAdd = request.getParameterValues("lesson");
		int i, n;
		for(i=0, n=lessonsToAdd.length;i<n;i++){
			try {
				DBConn.update(String.format("INSERT INTO LessonPlan_Lesson_Link (LessonID, LessonPlanID) VALUES ('%d','%d')", Integer.parseInt(lessonsToAdd[i]), lp.getId()));
			} catch (SQLException e) {
				Filo.log(e.getMessage());
			}
		}
		DBConn.closeConn();
	}
	
	public static LessonPlan createLessonPlanFull(int id) {
		
		String conditionIf,conditionElse,columns,table,join1,join2,join3,where,query;
		conditionIf = "IF EXISTS (SELECT * FROM LessonPlan_Lesson_Link WHERE ID = " + id + ")";
		conditionElse = "SELECT lp.Name AS LPName, lp.ShortDescription, lp.FullDescription, Classes.Name AS LPSubject FROM LessonPlan AS lp INNER JOIN Classes ON lp.SubjectID=Classes.ID WHERE lp.ID=" + id;
		columns = "l.ID AS LessonID, l.Name AS LessonName, lp.Name AS LPName, lp.ShortDescription, lp.FullDescription, Classes.Name AS LPSubject";
		table = "LessonPlan_Lesson_Link AS Link";
		join1 ="INNER JOIN Lesson As l ON Link.LessonID=l.ID";
		join2 = "INNER JOIN LessonPlan AS lp ON Link.LessonPlanID=lp.ID";
		join3 = "INNER JOIN Classes ON lp.SubjectID=Classes.ID";
		where = "WHERE LessonPlanID="+id;
		query = String.format("%s BEGIN SELECT %s FROM %s %s %s %s %s END ELSE BEGIN %s END", conditionIf,columns,table,join1,join2,join3,where,conditionElse);
		DBConn.openConn();
		LessonPlan tempLP = ExtractLessonPlan.extractLessonPlanFull(DBConn.query(query));
		DBConn.closeConn();
		return tempLP;
	}
	
	public static ArrayList<LessonPlan> getAllLessonPlans() {
		ArrayList<LessonPlan> lessonPlans = new ArrayList<LessonPlan>();
		DBConn.openConn();
		lessonPlans = ExtractLessonPlan.extractAllLessonPlans(DBConn.query("SELECT lp.ID, lp.Name AS LPName, lp.ShortDescription, Classes.Name AS LPSubject FROM LessonPlan lp INNER JOIN Classes ON lp.SubjectID=Classes.ID"));
		DBConn.closeConn();
		return lessonPlans;
	}
}
