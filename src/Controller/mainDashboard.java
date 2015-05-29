package Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Base.DBConn;
import Base.Filo;

/**
 * Servlet implementation class mainDashboard
 */
@WebServlet("/mainDashboard")
public class mainDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String firstName;
	String role;
       
    public mainDashboard() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		ResultSet rs = DBConn.query("SELECT Person.FirstName, Roles.Role FROM Person INNER JOIN Roles ON Person.Role = Roles.ID WHERE Person.ID='"+id+"'");
		try {
			while(rs.next()) {
				firstName = rs.getString("FirstName");
				role = rs.getString("Role");
			}
		} catch (SQLException e) {
			Filo.log("SQLException - MainDashboard: "+e.getMessage());
		}
		// Make sure user is 
		if(role.toLowerCase().equals("principle") || role.toLowerCase().equals("teacher") || 
			role.toLowerCase().equals("councelor") || role.toLowerCase().equals("sysadmin")) {
			request.setAttribute("firstName", firstName);
			request.setAttribute("role", role.toLowerCase());
			request.getRequestDispatcher("/index.jsp").forward(request,response);
		}
		else {
			response.sendRedirect("login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
