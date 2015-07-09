package controller.lessons;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import base.Auth;
import dao.DaoLessonPlan;
import program.LessonPlan;

/**
 * Servlet implementation class LessonPlanDashboard
 */
@WebServlet("/lessonplandashboard")
public class LessonPlanDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LessonPlanDashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int lpid;
		if(Auth.checkAuth(session, request)) {
			lpid = Integer.parseInt(request.getParameter("lpid"));
			request.setAttribute("lp", DaoLessonPlan.createLessonPlanFull(lpid));
			request.getRequestDispatcher("WEB-INF/lessonplandashboard.jsp").forward(request, response);
		} else {
			response.sendRedirect("login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LessonPlan lp = (LessonPlan) request.getSession().getAttribute("lessonPlan");
		DaoLessonPlan.addLessonsToLessonPlan(lp, request);
		response.sendRedirect("lessonplandashboard?lpid=" + lp.getId());
		
	}

}
