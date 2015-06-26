package extract;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import program.Lesson;
import program.LessonPlan;
import base.Filo;

public class ExtractLessonPlan {
	
	public static int extractUpdateLessonPlan(ResultSet rs) {
		int subjectNum = 0;
		try{
			while(rs.next()){
				subjectNum = rs.getInt("ID");
			}
		} catch(SQLException e) {
			Filo.log(e.getMessage());
		}
		return subjectNum;
	}
	
	public static LessonPlan extractLessonPlanFull(ResultSet rs) {
		LessonPlan lp = null;
		Lesson lesson;
		boolean lpComplete = false;
		try {
			while(rs.next()) {
				if(lpComplete == false) {
					lp = new LessonPlan();
					lp.setName(rs.getString("LPName"));
					lp.setShortDescription(rs.getString("ShortDescription"));
					lp.setFullDescription(rs.getString("FullDescription"));
					lp.setSubject(rs.getString("LPSubject"));
					lpComplete = true;
				}
				if(lpComplete == true){
					lesson = new Lesson();
					lesson.setId(rs.getInt("LessonID"));
					lesson.setName(rs.getString("LessonName"));
					lp.getLessons().add(lesson);
				}
			}
		} catch(SQLException e) {
			Filo.log("extractLessonPlanFull" + e.getMessage());
		}
		return lp;
	}
	
	public static ArrayList<LessonPlan> extractAllLessonPlans(ResultSet rs) {
		ArrayList<LessonPlan> lessonPlans = new ArrayList<LessonPlan>();
		LessonPlan lp;
		try{
			while(rs.next()) {
				lp = new LessonPlan();
				lp.setId(rs.getInt("ID"));
				lp.setName(rs.getString("LPName"));
				lp.setShortDescription(rs.getString("ShortDescription"));
				lp.setSubject(rs.getString("LPSubject"));
				lessonPlans.add(lp);
			}
		} catch(SQLException e) {
			Filo.log("extractAllLessonPlans" + e.getMessage());
		}
		return lessonPlans;
	}
}
