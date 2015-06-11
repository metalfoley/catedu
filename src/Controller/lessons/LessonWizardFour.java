package controller.lessons;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import program.Lesson;
import base.DBConn;

/**
 * Servlet implementation class LessonWizardFour
 */
@WebServlet("/lessonwizardfour")
public class LessonWizardFour extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LessonWizardFour() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("lessonwizard");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Lesson tempLesson = (Lesson) request.getSession().getAttribute("tempLesson");
		String leadLesson = request.getParameter("leadLesson");
		
		if(tempLesson.isAdvanced() == false) {
			response.sendRedirect("lessonwizardfive");
		} 
		else {	
			@SuppressWarnings("unused")
			DBConn conn = new DBConn();
		}
	}

}
