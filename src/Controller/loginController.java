package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Base.DBConn;
import Base.Filo;
import Program.Person;

/**
 * Servlet implementation class loginController
 */
@WebServlet("/login")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int id;
	boolean error = true;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request,response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConn db = new DBConn();
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
				
		ResultSet rs = DBConn.query("SELECT * FROM Account WHERE UserName='"+userName+"' AND Password='"+password+"'");
		try {
			if(rs.isBeforeFirst() && !userName.equals("") && !password.equals("")){
				while(rs.next()) {
					id = rs.getInt("Person_ID");
				}
				response.sendRedirect(String.format("mainDashboard?id=%d", id));
			}
			else{
				request.setAttribute("error", error);
				request.getRequestDispatcher("/login.jsp").forward(request,response);
			}
		} catch (SQLException e) {
			Filo.log(e.getMessage());
		}
		DBConn.closeConn();

	}

}
