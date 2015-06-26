package controller.lessons;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoLesson;
import dao.DaoLessonPlan;
import program.LessonPlan;

/**
 * Servlet implementation class LessonPlanWizardTwo
 */
@WebServlet("/LessonPlanWizardTwo")
public class LessonPlanWizardTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LessonPlanWizardTwo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoLesson dl = new DaoLesson();
		request.setAttribute("lessons", dl.getAllLessons());
		request.getRequestDispatcher("/lessonplancreatewiz2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoLesson dl = new DaoLesson();
		LessonPlan lp = DaoLessonPlan.createLessonPlanWiz(request);
		request.getSession().setAttribute("lessonPlan", lp);
		request.setAttribute("lessonPlan", lp);
		request.setAttribute("lessons", dl.getAllLessons());
		request.getRequestDispatcher("/lessonplancreatewiz2.jsp").forward(request, response);
	}

}
