package Program;
import Window.Alert;
import Window.Login;
import Window.UserInterFace;

import java.sql.SQLException;
import java.util.ArrayList;

import Window.Register;
import Base.DBConn;
import Base.Filo;

public class Program {

	public static ArrayList<Place> Places = new ArrayList<Place>();
	public static ArrayList<Person> People = new ArrayList<Person>();
	public static void main(String[] args) throws SQLException {
		DBConn.createDB();
		Filo.log("Initializing Program");
		//Login l = new Login();
		UserInterFace i = new UserInterFace();
	}
}