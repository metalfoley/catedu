package base;

import program.CurrentUser;

public class Auth {
	
	public static boolean checkAuth(CurrentUser cu) {
		String userName = cu.getUserName();
		if(userName != null && !userName.equals("")) {
			return true;
		}
		return false;
	}
}
