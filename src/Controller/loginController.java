package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoLesson;
import dao.DaoLessonPlan;
import program.CurrentUser;
import base.DBConn;
import base.Filo;

/**
 * Servlet implementation class loginController
 */
@WebServlet("/login")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean error = true;
	CurrentUser currentUser;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		currentUser = (CurrentUser) session.getAttribute("currentUser");

		if(currentUser == null) 
			request.getRequestDispatcher("WEB-INF/login.jsp").forward(request,response);
		else
			response.sendRedirect("home");
			
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		

	}
	
	/**
	 * Sets an error message at the login page
	 * @param request
	 * @param response
	 */
	private void setError(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("error", error);
		try {
			request.getRequestDispatcher("WEB-INF/login.jsp").forward(request,response);
		} catch (ServletException | IOException e) {
			Filo.log(e.getMessage());
		}
	}

}
