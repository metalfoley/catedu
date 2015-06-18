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
import program.CurrentUser;
import base.DBConn;
import base.Filo;

/**
 * Servlet implementation class loginController
 */
@WebServlet("/home")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean error = true;
	CurrentUser currentUser;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		currentUser = (CurrentUser) session.getAttribute("currentUser");

		if(currentUser == null) 
			response.sendRedirect("login.jsp");
		else
			request.getRequestDispatcher("index.jsp").forward(request,response);
			
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
//		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
//		response.setDateHeader("Expires", 0); // Proxies.
		HttpSession session = request.getSession();
		@SuppressWarnings("unused")
		DBConn db = new DBConn();
		currentUser = new CurrentUser();
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		String userQuery = "SELECT Account.UserName, Account.Password, Person.ID, Person.FirstName, " +
				   "Person.LastName, Person.Address, Person.City, Person.State, Person.Zipcode, " +
				   "Person.Phone1, Person.Email, Roles.Role, Person.Active FROM Account " +
				   "INNER JOIN Person ON Account.Person_ID = Person.ID INNER JOIN Roles ON Person.role = Roles.ID " +
				   "WHERE UserName='"+userName+"' AND Password='"+password+"'";
		DBConn.openConn();
		ResultSet rs = DBConn.query(userQuery);
		try {
			if(rs.isBeforeFirst() && !userName.equals("") && !password.equals("")){
				while(rs.next()) {
					currentUser.setId(rs.getInt("ID"));
					currentUser.setFirstName(rs.getString("FirstName"));
					currentUser.setLastName(rs.getString("LastName"));
					currentUser.setAddress(rs.getString("Address"));
					currentUser.setCity(rs.getString("City"));
					currentUser.setState(rs.getString("State"));
					currentUser.setZipCode(rs.getString("Zipcode"));
					currentUser.setPhoneOne(rs.getString("Phone1"));
					currentUser.setEmail(rs.getString("Email"));
					currentUser.setRole(rs.getString("Role"));
					currentUser.setActive(rs.getBoolean("Active"));
					currentUser.setUserName(userName);
					currentUser.setPassword(password);
				}
				if(currentUser.getRole().equalsIgnoreCase("student")){
					setError(request,response);
				}
				else {
					DaoLesson dl = new DaoLesson();
					request.setAttribute("allLessons", dl.getAllLessons());
					session.setAttribute("currentUser", currentUser);
					request.getRequestDispatcher("index.jsp").forward(request,response);
				}
			}
			else{
				setError(request,response);
			}
		} catch (SQLException e) {
			Filo.log(e.getMessage());
		} finally {
			DBConn.closeConn();
		}

	}
	
	/**
	 * Sets an error message at the login page
	 * @param request
	 * @param response
	 */
	private void setError(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("error", error);
		try {
			request.getRequestDispatcher("login.jsp").forward(request,response);
		} catch (ServletException | IOException e) {
			Filo.log(e.getMessage());
		}
	}

}
