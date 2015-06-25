package dao;

import java.util.ArrayList;

import program.Subject;
import extract.ExtractClass;
import base.DBConn;

public class DaoClass {
	
	public static ArrayList<Subject> getClasses(){
		DBConn.openConn();
		ArrayList<Subject> classes = ExtractClass.extractClasses(DBConn.query("Select * FROM Classes"));
		DBConn.closeConn();
		return classes;
	}
	
	
	
	
}
