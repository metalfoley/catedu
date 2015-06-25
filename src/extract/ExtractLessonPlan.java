package extract;

import java.sql.ResultSet;
import java.sql.SQLException;

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
}
