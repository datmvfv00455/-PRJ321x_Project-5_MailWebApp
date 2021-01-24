package vn.funix.prj321x.project5.gui.common;

import java.util.Locale;
import java.util.ResourceBundle;

public class WebConstant {
	public static final String USER        = "user_system";
	public static final String URL_REFERER = "url_referer";

	public static final String USER_MAIL = "user_mail";

	/* ==================== Begin ResourceBundle ==================== */
	public static final ResourceBundle MESSAGES_BUNDLE = ResourceBundle
			.getBundle("messages", new Locale("en", "EN"));
	/* ==================== End ResourceBundle ==================== */

	/* ==================== Begin URL Patterns ==================== */
	public static final String URL_SYSTEM_LOGIN  = "/login";
	public static final String URL_SYSTEM_LOGOUT = "/logout";

	public static final String URL_MAIL_NEW    = "/mail-new.html";
	public static final String URL_MAIL_LOGIN  = "/mail-login.html";
	public static final String URL_MAIL_LOGOUT = "/mail-logout.html";

	/* ==================== End URL Patterns ==================== */

	/* ==================== Begin Filter ==================== */
	public static final String FILTER_LOGIN_HTML = "*.html";
	public static final String FILTER_LOGIN_JSP  = "*.jsp";
	/* ==================== End Filter ==================== */

	/* ==================== Begin JSP ==================== */
	public static final String MESSAGE_RESPONSE = "messageResponse";

	public static final String ERROR  = "error";
	public static final String STATUS = "status";

	public static final String SUCCESS = "success";

	public static final String MESSAGE = "message";

	public static final String VERIFY_USERNAME = "verifyUsername";
	public static final String VERIFY_PASSWORD = "verifyPassword";

	/* ==================== End JSP ==================== */

}
