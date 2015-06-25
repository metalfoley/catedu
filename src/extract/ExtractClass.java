package extract;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import program.Subject;
import base.Filo;

public class ExtractClass {
	
	public static ArrayList<Subject> extractClasses(ResultSet rs) {
		ArrayList<Subject> classes = new ArrayList<Subject>();
		try {
			while(rs.next()) {
				classes.add(new Subject(rs.getInt("ID"),rs.getString("Name")));
			}
		} catch (SQLException e1) {
			Filo.log(e1.getMessage());
		}
		return classes;
	}
	
}
