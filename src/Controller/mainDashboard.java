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
       
    public mainDashboard() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id == null) {
			response.sendRedirect("/login.jsp");
		}
		else {
			String firstName = null;
			ResultSet rs = DBConn.query("SELECT Person.firstName From Person WHERE ID='"+id+"'");
			try {
				while(rs.next()) {
					firstName = rs.getString("FirstName");
				}
			} catch (SQLException e) {
				Filo.log("SQLException - MainDashboard: "+e.getMessage());
			}
			request.setAttribute("firstName", firstName);
			request.getRequestDispatcher("/index.jsp").forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
