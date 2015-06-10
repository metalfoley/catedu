package controller.lessons;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import program.Lesson;
import base.DBConn;
import base.Filo;

/**
 * Servlet implementation class LessonWizardThree
 */
@WebServlet("/lessonwizardthree")
public class LessonWizardThree extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LessonWizardThree() {
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
		Lesson tempLesson = (Lesson) request.getSession().getAttribute("tempLesson");
		@SuppressWarnings("unused")
		DBConn conn = new DBConn();
		String enhancements = request.getParameter("enhancements");
		String extensions = request.getParameter("extentions");
		String details = request.getParameter("details");
		String materials = request.getParameter("materials");
		boolean success = true;

		String query = "UPDATE Lesson SET Enhancements='"+enhancements+"', Extensions='"+extensions+"', Details='"+details+"', Materials='"+materials+"' WHERE ID="+tempLesson.getId();
		DBConn.openConn();
		try {
			System.out.println(query);
			DBConn.update(query);
		} catch (SQLException e) {
			Filo.log(e.getMessage());
			success = false;
		} finally {
			DBConn.closeConn();
		}
		
		if(success == true) {	
			tempLesson.setEnhancements(enhancements);
			tempLesson.setExtensions(extensions);
			tempLesson.setDetails(details);
			tempLesson.setMaterials(materials);
			request.setAttribute("tempLesson", tempLesson);
			request.getRequestDispatcher("/lessoncreatewiz3.jsp").forward(request, response);
		}
		else {
			request.setAttribute("tempLesson", tempLesson);
			request.setAttribute("error", true);
			request.getRequestDispatcher("/lessoncreatewiz2.jsp").forward(request, response);
		}
	}

}
