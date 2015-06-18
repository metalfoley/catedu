package controller.lessons;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

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
 * Servlet implementation class LessonWizardFinal
 */
@WebServlet("/lessonwizardfinal")
public class LessonWizardFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LessonWizardFinal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Lesson tempLesson = (Lesson) session.getAttribute("tempLesson");
		int id = tempLesson.getId();
		String assessmentType = request.getParameter("assessments");
		String assessmentLink = request.getParameter("file");
		String assessmentInfo = request.getParameter("assessInfo");
		@SuppressWarnings("unused")
		DBConn db = new DBConn();
		DBConn.openConn();
		try {
			DBConn.update("UPDATE Lesson SET AssessmentType='"+assessmentType+"', AssessmentLink='"+assessmentLink+"', AssessmentInfo='"+assessmentInfo+"' WHERE ID='"+tempLesson.getId()+"'");
		} catch (SQLException e) {
			Filo.log(e.getMessage());
		} finally {
			DBConn.closeConn();
		}
		tempLesson.setAssessType(assessmentType);
		tempLesson.setAssessLink(assessmentLink);
		tempLesson.setAssessInfo(assessmentInfo);
		session.removeAttribute("tempLesson");
		
		response.sendRedirect("lessondashboard?lid="+id);
	}

}
