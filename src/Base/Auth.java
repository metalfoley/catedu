package base;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Auth {
	
	public static boolean checkAuth(HttpSession session, HttpServletRequest request) {
		session = request.getSession(false);
		if(session.getAttribute("currentUser") == null || session == null) {
			return false;
		}
		return true;
	}
}
