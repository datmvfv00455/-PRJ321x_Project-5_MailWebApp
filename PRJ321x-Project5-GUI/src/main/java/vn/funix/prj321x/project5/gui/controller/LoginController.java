package vn.funix.prj321x.project5.gui.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import vn.funix.prj321x.project5.bll.service.UserService;
import vn.funix.prj321x.project5.bll.utils.ServiceUtil;
import vn.funix.prj321x.project5.core.common.CoreConstant;
import vn.funix.prj321x.project5.core.dto.UserDto;
import vn.funix.prj321x.project5.core.utils.ObjectUtils;
import vn.funix.prj321x.project5.gui.common.WebConstant;
import vn.funix.prj321x.project5.gui.model.UserModel;
import vn.funix.prj321x.project5.gui.utils.SessionUtil;

@WebServlet(urlPatterns = {
		WebConstant.URL_SYSTEM_LOGIN,
		WebConstant.URL_SYSTEM_LOGOUT
})
public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		CoreConstant.info(req, resp, this.getClass(), "doGet");

		SessionUtil session = SessionUtil.getSessionInstance();

		if (req.getRequestURI().contains(WebConstant.URL_SYSTEM_LOGIN)) {
			req.getRequestDispatcher("views/login.jsp").forward(req, resp);

			session.setAttribute(
					req,
					WebConstant.URL_REFERER,
					req.getHeader("referer"));
		} else {
			session.remove(req, WebConstant.USER);
			session.remove(req, WebConstant.USER_MAIL);
			resp.sendRedirect("login");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		CoreConstant.info(req, resp, this.getClass(), "doPost");

		Map<String, Object> jsonResponse = new HashMap<String, Object>();

		UserModel userModel = ObjectUtils.populate(UserModel.class, req);
		UserDto   bean      = userModel.getBean();

		UserService userService = ServiceUtil.getUserServiceInstance();
		boolean     checkLogin  = userService.authenticate(bean);

		SessionUtil session = SessionUtil.getSessionInstance();

		if (checkLogin) {
			session.setAttribute(
					req,
					WebConstant.USER,
					bean.getUserName());

			jsonResponse.put(
					WebConstant.URL_REFERER,
					"mail-new.html");
		} else {
			String passwordWrongMsg = WebConstant.MESSAGES_BUNDLE
					.getString("label.error.password.wrong");

			jsonResponse.put(
					WebConstant.ERROR,
					passwordWrongMsg);

		}

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(new Gson().toJson(jsonResponse));

	}
}
