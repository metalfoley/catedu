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
		Lesson tempLesson = (Lesson) session.getAttribute("tempLesson");
		
		String[] scienceCore = request.getParameterValues("Science");
		String[] mathCore = request.getParameterValues("Math");
		String[] historyCore = request.getParameterValues("History");
		
		if(scienceCore.length > 0 && scienceCore != null) {
			tempHash.put("Science", new ArrayList<String>(Arrays.asList(scienceCore)));
			// Add to DB
		}
		if(mathCore.length > 0 && mathCore != null) {
			tempHash.put("Math", new ArrayList<String>(Arrays.asList(mathCore)));
			// Add to DB
		}
		if(historyCore.length > 0 && historyCore != null) {
			tempHash.put("History", new ArrayList<String>(Arrays.asList(historyCore)));
			// Add to DB
		}
		tempLesson.setClassCoreLink(tempHash);

		assessments = createAssessmentTypes();
		
		request.setAttribute("assessments", assessments);
		request.getRequestDispatcher("/lessoncreatewiz5.jsp").forward(request, response);
	}
	
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

}
