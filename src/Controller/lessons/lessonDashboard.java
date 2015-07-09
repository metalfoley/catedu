package controller.lessons;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.DaoLesson;

import base.Auth;


/**
 * Servlet implementation class lessonDashboard
 */
@WebServlet("/lessondashboard")
public class lessonDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lessonDashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoLesson dl;
		int id;
		if(Auth.checkAuth(request.getSession(), request)){
			dl = new DaoLesson();
			id = Integer.parseInt(request.getParameter("lid"));
			request.setAttribute("lesson", dl.createLesson(id));
			request.getRequestDispatcher("WEB-INF/lessonDashboard.jsp").forward(request, response);
		} else {
			response.sendRedirect("login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
