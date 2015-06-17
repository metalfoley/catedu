package controller.lessons;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		response.sendRedirect("lessonwizard");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Lesson tempLesson = (Lesson) session.getAttribute("tempLesson");
		Lesson lesson;
		ArrayList<Lesson> lessons = new ArrayList<Lesson>();
		
		String enhancements = request.getParameter("enhancements");
		String extentions = request.getParameter("extentions");
		String details = request.getParameter("details");
		String materials = request.getParameter("materials");
		boolean success = true;
		ResultSet rs;
		
		@SuppressWarnings("unused")
		DBConn conn = new DBConn();
		DBConn.openConn();
		rs = DBConn.query("SELECT Lesson.ID, Lesson.Name FROM Lesson");
		
		try {
			while(rs.next()) {
				lesson = new Lesson();
				lesson.setId(rs.getInt("ID"));
				lesson.setName(rs.getString("Name"));
				lessons.add(lesson);
			}
		} catch (SQLException e1) {
			Filo.log(e1.getMessage());
		}
		
		try {
			DBConn.update("UPDATE Lesson SET Enhancements='"+enhancements+"', Extentions='"+extentions+"', Details='"+details+"', Materials='"+materials+"' WHERE ID='"+tempLesson.getId()+"'");
		} catch (SQLException e) {
			Filo.log(e.getMessage());
			success = false;
		} finally {
			DBConn.closeConn();
		}
		
		if(success == true) {	
			tempLesson.setEnhancements(enhancements);
			tempLesson.setExtensions(extentions);
			tempLesson.setDetails(details);
			tempLesson.setMaterials(materials);

			request.setAttribute("lessons", lessons);
			request.getRequestDispatcher("/lessoncreatewiz3.jsp").forward(request, response);
		}
		else {
			request.setAttribute("error", true);
			request.getRequestDispatcher("/lessoncreatewiz2.jsp").forward(request, response);
		}
	}

}
