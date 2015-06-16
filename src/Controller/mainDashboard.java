package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Auth;
import base.Filo;
import program.CurrentUser;

/**
 * Servlet implementation class mainDashboard
 */
@WebServlet("/mainDashboard")
public class mainDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CurrentUser currentUser;
    public mainDashboard() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		currentUser = (CurrentUser) request.getSession().getAttribute("currentUser");
		Filo.log(currentUser.getUserName());
		if(Auth.checkAuth(currentUser) == true) {
			request.getRequestDispatcher("/index.jsp").forward(request,response);
		}
		else
			response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
