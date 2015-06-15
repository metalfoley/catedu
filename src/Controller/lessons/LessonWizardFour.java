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

import program.Lesson;
import base.DBConn;
import base.Filo;

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
		Lesson tempLesson = (Lesson) request.getSession().getAttribute("tempLesson");
		int leadLesson;
		ArrayList<String> coreStandards = new ArrayList<String>();
		ArrayList<String> classes = new ArrayList<String>();
		ResultSet rs;
		@SuppressWarnings("unused")
		DBConn conn = new DBConn();
		DBConn.openConn();
		
		// See if a lead lesson was selected
		if(request.getParameter("leadLesson") != null) {
			leadLesson = Integer.parseInt(request.getParameter("leadLesson"));
			tempLesson.setLeadLesson(request.getParameter("leadLesson"));
			try {
				DBConn.update("UPDATE Lesson SET LeadLesson='"+leadLesson+"' WHERE ID='"+tempLesson.getId()+"'");
			} catch (SQLException e) {
				Filo.log(e.getMessage());
			}
		}
		
		//Redirect to wizard page 5 if this is not an advanced lesson
		
		else {	
			
			// Get all core standards
			rs = DBConn.query("SELECT Core_Standard FROM Core_Standards");
			try {
				while(rs.next()) {
					coreStandards.add(rs.getString("Core_Standard"));
				}
			} catch (SQLException e) {
				Filo.log(e.getMessage());
			}
			
			// Get all classes
			rs = DBConn.query("Select Name FROM Classes");
			try {
				while(rs.next()) {
					classes.add(rs.getString("Name"));
				}
			} catch (SQLException e1) {
				Filo.log(e1.getMessage());
			}
			
			DBConn.closeConn();
			
			request.setAttribute("classes", classes);
			request.setAttribute("coreStandards", coreStandards);
			request.getRequestDispatcher("/lessoncreatewiz4.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Lesson tempLesson = (Lesson) request.getSession().getAttribute("tempLesson");
		int leadLesson;
		ArrayList<String> coreStandards = new ArrayList<String>();
		ArrayList<String> classes = new ArrayList<String>();
		ResultSet rs;
		@SuppressWarnings("unused")
		DBConn conn = new DBConn();
		DBConn.openConn();
		
		// See if a lead lesson was selected
		if(request.getParameter("leadLesson") != null) {
			leadLesson = Integer.parseInt(request.getParameter("leadLesson"));
			tempLesson.setLeadLesson(request.getParameter("leadLesson"));
			try {
				DBConn.update("UPDATE Lesson SET LeadLesson='"+leadLesson+"' WHERE ID='"+tempLesson.getId()+"'");
			} catch (SQLException e) {
				Filo.log(e.getMessage());
			}
		}
		
		//Redirect to wizard page 5 if this is not an advanced lesson
		if(tempLesson.isAdvanced() == false) {
			response.sendRedirect("lessonwizardfive");
			DBConn.closeConn();
		} 
		else {	
			
			// Get all core standards
			rs = DBConn.query("SELECT Core_Standard FROM Core_Standards");
			try {
				while(rs.next()) {
					coreStandards.add(rs.getString("Core_Standard"));
				}
			} catch (SQLException e) {
				Filo.log(e.getMessage());
			}
			
			// Get all classes
			rs = DBConn.query("Select Name FROM Classes");
			try {
				while(rs.next()) {
					classes.add(rs.getString("Name"));
				}
			} catch (SQLException e1) {
				Filo.log(e1.getMessage());
			}
			
			DBConn.closeConn();
			
			request.setAttribute("classes", classes);
			request.setAttribute("coreStandards", coreStandards);
			request.getRequestDispatcher("/lessoncreatewiz4.jsp").forward(request, response);
		}
	}

}
