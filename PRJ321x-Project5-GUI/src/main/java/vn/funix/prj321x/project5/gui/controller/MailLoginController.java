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

import vn.funix.prj321x.project5.bll.service.MailService;
import vn.funix.prj321x.project5.bll.service.UserService;
import vn.funix.prj321x.project5.bll.utils.ServiceUtil;
import vn.funix.prj321x.project5.core.common.CoreConstant;
import vn.funix.prj321x.project5.core.dto.UserDto;
import vn.funix.prj321x.project5.core.utils.ObjectUtils;
import vn.funix.prj321x.project5.gui.common.WebConstant;
import vn.funix.prj321x.project5.gui.model.UserModel;
import vn.funix.prj321x.project5.gui.utils.SessionUtil;

@WebServlet(urlPatterns = {
		WebConstant.URL_MAIL_LOGIN,
		WebConstant.URL_MAIL_LOGOUT
})
public class MailLoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		if (req.getRequestURI().endsWith(WebConstant.URL_MAIL_LOGOUT)) {
			SessionUtil.getSessionInstance().remove(req, WebConstant.USER_MAIL);
			resp.sendRedirect(req.getHeader("referer"));
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		CoreConstant.info(req, resp, this.getClass(), "doPost");
		Map<String, Object> jsonResponse = new HashMap<String, Object>();

		UserModel userModel = ObjectUtils.populate(UserModel.class, req);
		UserDto   bean      = userModel.getBean();

		MailService mailService = ServiceUtil.getMailServiceInstance();

		try {
			boolean checkLogin = mailService.isLoggedIn(
					bean.getUserName(),
					bean.getUserPassword());

			if (checkLogin) {
				SessionUtil.getSessionInstance().setAttribute(
						req,
						WebConstant.USER_MAIL, bean);

				jsonResponse.put(
						WebConstant.URL_REFERER,
						req.getHeader("referer"));
			}

		} catch (Exception e) {
			jsonResponse.put(
					WebConstant.ERROR,
					WebConstant.MESSAGES_BUNDLE
							.getString("label.error.password.wrong"));

		}

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(new Gson().toJson(jsonResponse));

	}

}
