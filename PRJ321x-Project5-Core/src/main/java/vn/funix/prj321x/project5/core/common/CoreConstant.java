package vn.funix.prj321x.project5.core.common;

import java.util.Collections;
import java.util.Date;
import java.util.function.Consumer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CoreConstant {

	/*
	 * ==================== Begin Info Of Request Response ====================
	 */
	public static <T> void info(HttpServletRequest req,
			HttpServletResponse resp, Class<T> clazz, String function) {
		System.out.println(
				"\n************************ ++++++ Info ++++++ ***********************\n");

		System.out.println("Class Name:" + clazz.getSimpleName());
		System.out.println("Function Name:" + function);

		sessionInfo(req.getSession());
		requestResponseInfo(req, resp);

		System.out.println(
				"\n************************ ------ Info ------ ************************\n");
	}

	public static <T> void sessionInfo(final HttpSession session) {
		sysout("+++++++++++++++++++ SessionInfo ++++++++++++++++++++");

		sysout("Session ID: " + session.getId());
		sysout("Creation Time: " + new Date(session.getCreationTime()));
		sysout("Last Accessed Time: "
				+ new Date(session.getLastAccessedTime()));
		sysout("AttributeNames: ");
		Collections.list(session.getAttributeNames())
				.forEach(new Consumer<String>() {
					public void accept(String attbName) {
						sysout(attbName + ": "
								+ session.getAttribute(attbName));
					}
				});

		sysout("+++++++++++++++++++ SessionInfo ++++++++++++++++++++\n");

	}

	public static void requestResponseInfo(final HttpServletRequest request,
			final HttpServletResponse response) {
		sysout("================ RequestResponseInfo ================");

		sysout("----- Request ---------");
		Collections.list(request.getHeaderNames())
				.forEach(new Consumer<String>() {

					public void accept(String n) {
						sysout(n + ": " + request.getHeader(n));
					}
				});

		Collections.list(request.getParameterNames())
				.forEach(new Consumer<String>() {

					public void accept(String n) {
						sysout(n + ": " + request.getParameter(n));
					}
				});

		sysout("--------- Response ---------");
		response.getHeaderNames().forEach(new Consumer<String>() {

			public void accept(String n) {
				sysout(n + ": " + response.getHeader(n));
			}
		});
		sysout("Status" + ": " + String.valueOf(response.getStatus()));

		sysout("================ RequestResponseInfo =================");
	}
	/* ==================== End Info Of Request Response ==================== */

	public static void sysout(String s) {
		System.out.println("\t" + s);

	}

}
