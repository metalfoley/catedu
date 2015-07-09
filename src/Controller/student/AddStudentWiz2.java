package controller.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoStudent;
import program.Guardian;
import program.Student;
import base.Auth;

/**
 * Servlet implementation class AddStudentWiz2
 */
@WebServlet("/addstudentwizardtwo")
public class AddStudentWiz2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentWiz2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(Auth.checkAuth(session, request)) {
			request.getRequestDispatcher("WEB-INF/newstudentwiz2.jsp").forward(request, response);
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
			Student student = (Student) session.getAttribute("student");
			Guardian guardOne = new Guardian();
			Guardian guardTwo = new Guardian();
			
			guardOne.setFirstName(request.getParameter("guardfOne"));
			guardOne.setMiddleName(request.getParameter("guardmOne"));
			guardOne.setLastName(request.getParameter("guardlOne"));
			guardOne.setAddress(request.getParameter("address1"));
			guardOne.setCity(request.getParameter("city1"));
			guardOne.setState(request.getParameter("state1"));
			guardOne.setZipCode(request.getParameter("zip1"));
			guardOne.setPhoneOne(request.getParameter("phone1"));
			guardOne.setEmail(request.getParameter("email1"));
			guardOne.setRelationship(request.getParameter("relationship1"));
			
			guardTwo.setFirstName(request.getParameter("guardfTwo"));
			guardTwo.setMiddleName(request.getParameter("guardmTwo"));
			guardTwo.setLastName(request.getParameter("guardlTwo"));
			guardTwo.setAddress(request.getParameter("address2"));
			guardTwo.setCity(request.getParameter("city2"));
			guardTwo.setState(request.getParameter("state2"));
			guardTwo.setZipCode(request.getParameter("zip2"));
			guardTwo.setPhoneOne(request.getParameter("phone2"));
			guardTwo.setEmail(request.getParameter("email2"));
			guardTwo.setRelationship(request.getParameter("relationship2"));
			
			
			student.getGuardians()[0] = guardOne;
			student.getGuardians()[1] = guardTwo;
			
			session.setAttribute("student", DaoStudent.createNewWiz(student, 2));
			response.sendRedirect("addstudentwizardthree");
			
		} else {
			response.sendRedirect("login");
		}
	}

}
