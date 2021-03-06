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
@WebServlet("/loginController")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public loginController() {
    	DBConn db = new DBConn();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		int id = 0;
				
		ResultSet rs = DBConn.query("SELECT * FROM Account WHERE UserName='"+userName+"' AND Password='"+password+"'");
		try {
			if(rs.next() && userName != "" && password != ""){
				rs.beforeFirst();
				while(rs.next()) {
					id = rs.getInt("Person_ID");
				}
				System.out.println(id);
				response.sendRedirect(String.format("mainDashboard?id=%d", id));
			}
			else{
				response.sendRedirect("login.jsp");
			}
		} catch (SQLException e) {
			Filo.log(e.getMessage());
		}
		DBConn.closeConn();

	}

}
