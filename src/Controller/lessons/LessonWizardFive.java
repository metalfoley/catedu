package controller.lessons;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		request.getRequestDispatcher("/lessoncreatewiz5.jsp").forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Lesson tempLesson = (Lesson) request.getSession().getAttribute("tempLesson");
		
		String scienceCore[] = request.getParameterValues("Science");
		String mathCore[] = request.getParameterValues("Math");
		String historyCore[] = request.getParameterValues("History");
		
		for(int i = 0; i < mathCore.length; i++) {
			Filo.log(mathCore[i]);
		}
		
		addToLessonHashMap(tempLesson, "Science", scienceCore);
		addToLessonHashMap(tempLesson, "Math", mathCore);
		addToLessonHashMap(tempLesson, "History", historyCore);
		
		Filo.log(tempLesson.getClassCoreLink().get("Math").get(0));
		
		HashMap<String,Integer> assessments = new HashMap<String,Integer>();
		ResultSet rs;
		@SuppressWarnings("unused")
		DBConn db = new DBConn();
		
		// Fill assessments ArrayList with assessments to display
		DBConn.openConn();
		rs = DBConn.query("SELECT * FROM Assessment_Types");
		try {
			while(rs.next()) {
				assessments.put(rs.getString("Assessment_Type"),rs.getInt("ID"));
			}
		} catch (SQLException e) {
			Filo.log(e.getMessage());
		} finally {
			DBConn.closeConn();
		}
		
		request.getSession().setAttribute("tempLesson", tempLesson);
		request.setAttribute("assessments", assessments);
		request.getRequestDispatcher("/lessoncreatewiz5.jsp").forward(request, response);
	}

	private void addToLessonHashMap(Lesson lesson, String subject, String[] str) {
		if(str.length > 0) {
			for(String s : str) {
				tempArr.add(s);
			}
			lesson.getClassCoreLink().put(subject, tempArr);
		}
	}
}
