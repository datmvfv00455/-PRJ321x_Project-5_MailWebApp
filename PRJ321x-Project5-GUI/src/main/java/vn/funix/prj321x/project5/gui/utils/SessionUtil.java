package vn.funix.prj321x.project5.gui.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {
	private static SessionUtil sessionUtil = null;

	public static SessionUtil getSessionInstance() {
		if (sessionUtil == null) {
			sessionUtil = new SessionUtil();
		}
		return sessionUtil;
	}

	public void setAttribute(HttpServletRequest request, String key,
			Object value) {
		HttpSession session = request.getSession();

		session.setAttribute(key, value);
	}

	public Object getAttribute(HttpServletRequest request, String key) {
		HttpSession session = request.getSession();

		return session.getAttribute(key);
	}

	public void remove(HttpServletRequest request, String key) {
		HttpSession session = request.getSession();

		session.removeAttribute(key);
	}

	public long getLastAccessedTime(HttpServletRequest request, String key) {
		HttpSession session = request.getSession();

		return session.getLastAccessedTime();
	}

}
