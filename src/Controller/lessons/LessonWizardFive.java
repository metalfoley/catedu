package controller.lessons;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import program.Lesson;
import base.DBConn;
import base.Filo;

/**
 * Servlet implementation class LessonWizzardFive
 */
@WebServlet("/lessonwizardfive")
public class LessonWizardFive extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<String> tempArr = new ArrayList<String>();
	HashMap<String,Integer> assessments;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LessonWizardFive() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		assessments = createAssessmentTypes();
		request.setAttribute("assessments", assessments);
		request.getRequestDispatcher("/lessoncreatewiz5.jsp").forward(request, response);	
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		HashMap<String, ArrayList<String>> tempHash = new HashMap<String, ArrayList<String>>();
		ArrayList<String> tempArr = null;
		Lesson tempLesson = (Lesson) session.getAttribute("tempLesson");
		
		String[] scienceCore = request.getParameterValues("Science");
		String[] mathCore = request.getParameterValues("Math");
		String[] historyCore = request.getParameterValues("History");
		
		@SuppressWarnings("unused")
		DBConn db = new DBConn();
		DBConn.openConn();
		if(scienceCore.length > 0 && scienceCore != null) {
			addToDb(tempHash, scienceCore, tempLesson, tempArr, "Science");
		}
		if(mathCore.length > 0 && mathCore != null) {
			addToDb(tempHash, mathCore, tempLesson, tempArr, "Math");
		}
		if(historyCore.length > 0 && historyCore != null) {
			addToDb(tempHash, historyCore, tempLesson, tempArr, "History");
		}
		tempLesson.setClassCoreLink(tempHash);

		assessments = createAssessmentTypes();
		
		request.setAttribute("tempLesson", tempLesson);
		request.setAttribute("assessments", assessments);
		request.getRequestDispatcher("/lessoncreatewiz5.jsp").forward(request, response);
	}
	
	// Creates a HashMap of assessment types with their corresponding id
	private HashMap<String,Integer> createAssessmentTypes() {
		assessments = new HashMap<String,Integer>();
		ResultSet rs;
		@SuppressWarnings("unused")
		DBConn db = new DBConn();
		
		// Fill assessments ArrayList with assessments to display
		DBConn.openConn();
		rs = DBConn.query("SELECT * FROM Assessment_Types");
		try {
			while(rs.next()) {
				assessments.put(rs.getString("Assessment_Type"),new Integer(rs.getInt("ID")));
			}
		} catch (SQLException e) {
			Filo.log(e.getMessage());
		} finally {
			DBConn.closeConn();
		}
		
		return assessments;
	}
	
	/**
	 * Gets the ID of the current core standard
	 * @param core the core standard being used
	 * @return the id held in the database
	 */
	private int getCoreId(String core) {
		int val = 0;
		switch(core) {
			case "Core 1":
				val = 1;
				break;
			case "Core 2":
				val = 2;
				break;
			case "Core 3":
				val = 3;
				break;
			case "Core 4":
				val = 4;
				break;
			case "Core 5":
				val = 5;
				break;
			case "Core 6":
				val = 6;
				break;
		}
		return val;
	}
	
	/**
	 * Gets the id of the current class 
	 * @param classes the class being used
	 * @return the class record number in the database
	 */
	private int getClassId(String classes) {
		int val = 0;
		switch(classes.toLowerCase()) {
		case "science":
			val = 1;
			break;
		case "math":
			val = 2;
			break;
		case "history":
			val = 3;
			break;
		}
		return val;
	}
	
	/**
	 * Takes an array and adds it to the lessons HashMap, as well as the CoreStandard_Class_Lesson_Link table
	 * @param hash The HashMap to be used
	 * @param str The array of core standards
	 * @param lesson The lesson being updated
	 * @param tempArr The temporary ArrayList being used
	 */
	private void addToDb(HashMap<String, ArrayList<String>> hash, String[] str, Lesson lesson, ArrayList<String> tempArr, String className) {
		tempArr = new ArrayList<String>(Arrays.asList(str));
		hash.put("Science", tempArr);
		int lessonId = lesson.getId();
		for(String val : tempArr) {
			try {
				DBConn.update("INSERT INTO CoreStandard_Class_Lesson_Link (CoreStandardID,ClassID,LessonID) VALUES ('"+getCoreId(val)+"','"+getClassId(className)+"','"+lessonId+"')");
			} catch (SQLException e) {
				Filo.log(e.getMessage());
			}
		}
	}

}
