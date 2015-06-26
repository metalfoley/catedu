package controller.lessons;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		int lpid = Integer.parseInt(request.getParameter("lpid"));
		request.setAttribute("lp", DaoLessonPlan.createLessonPlanFull(lpid));
		request.getRequestDispatcher("/lessonplandashboard.jsp").forward(request, response);
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
