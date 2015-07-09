package controller.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoStudent;
import program.Student;
import base.Auth;
import base.Filo;

/**
 * Servlet implementation class AddStudentWiz1
 */
@WebServlet("/addstudentwizard")
public class AddStudentWiz1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentWiz1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(Auth.checkAuth(session, request)) {
			request.getRequestDispatcher("WEB-INF/newstudentwiz1.jsp").forward(request, response);
		} else {
			response.sendRedirect("login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(Auth.checkAuth(session, request)) {
			Student student = new Student();
			student.setFirstName(request.getParameter("fname"));
			student.setMiddleName(request.getParameter("mname"));
			student.setLastName(request.getParameter("lname"));
			student.setAddress(request.getParameter("address"));
			student.setCity(request.getParameter("city"));
			student.setState(request.getParameter("state"));
			student.setZipCode(request.getParameter("zip"));
			student.setPhoneOne(request.getParameter("phone1"));
			student.setPhoneTwo(request.getParameter("phone2"));
			session.setAttribute("student", DaoStudent.createNewWiz(student, 1));
			response.sendRedirect("addstudentwizardtwo");
		} else {
			response.sendRedirect("login");
		}
	}

}
