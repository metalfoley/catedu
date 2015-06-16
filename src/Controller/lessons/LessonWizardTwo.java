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

import base.DBConn;
import base.Filo;
import program.CurrentUser;
import program.Employee;
import program.Lesson;
import program.Teacher;

/**
 * Servlet implementation class LessonWizardTwo
 */
@WebServlet("/lessonwizardtwo")
public class LessonWizardTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LessonWizardTwo() {
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
		CurrentUser user = (CurrentUser) session.getAttribute("currentUser");
		@SuppressWarnings("unused")
		DBConn db = new DBConn();
		String name = request.getParameter("name");
		String shortDescription = request.getParameter("shortdescription");
		String fullDescription = request.getParameter("fulldescription");
		Lesson tempLesson = null;
		boolean isAdvanced = (request.getParameter("advanced") != null);
		ResultSet rs = null;
		
		if(!name.equals("")) {
			tempLesson = new Lesson(name, isAdvanced);
			tempLesson.setAuthor(user);
			tempLesson.setShortDescription(shortDescription);
			tempLesson.setFullDescription(fullDescription);
			DBConn.openConn();
			rs = DBConn.query("INSERT INTO Lesson (Name, Short_Description, Full_Description, Advanced, Author) VALUES ('"+name+"','"+shortDescription+"','"+fullDescription+"','"+isAdvanced+"','"+user.getId()+"') SELECT SCOPE_IDENTITY() AS [ID]");
			try {
				while(rs.next()) {
						tempLesson.setId(rs.getInt("ID"));
				}
			} catch (SQLException e) {
				Filo.log(e.getMessage());
			} finally {
				DBConn.closeConn();
			}
			session.setAttribute("tempLesson", tempLesson);
			request.getRequestDispatcher("/lessoncreatewiz2.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("LessonWizard");
		}
			
	}

}
