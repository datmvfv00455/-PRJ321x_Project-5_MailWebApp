package vn.funix.prj321x.project5.gui.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import vn.funix.prj321x.project5.bll.service.MailService;
import vn.funix.prj321x.project5.bll.utils.ServiceUtil;
import vn.funix.prj321x.project5.core.common.CoreConstant;
import vn.funix.prj321x.project5.core.dto.MessageDto;
import vn.funix.prj321x.project5.core.dto.UserDto;
import vn.funix.prj321x.project5.core.utils.ObjectUtils;
import vn.funix.prj321x.project5.gui.common.WebConstant;
import vn.funix.prj321x.project5.gui.model.MessageModel;
import vn.funix.prj321x.project5.gui.utils.SessionUtil;

@WebServlet(urlPatterns = {
		WebConstant.URL_MAIL_NEW
})
public class MailNewController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		CoreConstant.info(req, resp, this.getClass(), "doGet");

		req.getRequestDispatcher("views/mailNew.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		CoreConstant.info(req, resp, this.getClass(), "doPost");

		Map<String, Object> jsonResponse = new HashMap<String, Object>();

		req.setCharacterEncoding("UTF-8");

		MessageModel messageModel = ObjectUtils.populate(
				MessageModel.class,
				req);

		MessageDto bean = messageModel.getBean();

		MailService mailService = ServiceUtil.getMailServiceInstance();

		try {

			MimeMessage emailMessage = mailService.createEmailMessage(
					bean.getEmailTo(),
					bean.getEmailCC(),
					bean.getEmailSubject(),
					bean.getEmailMessage());

			UserDto user = (UserDto) SessionUtil.getSessionInstance()
					.getAttribute(
							req,
							WebConstant.USER_MAIL);

			mailService.sendEmail(
					user.getUserName(), 
					user.getUserPassword(),
					emailMessage);

			jsonResponse.put(WebConstant.STATUS, WebConstant.SUCCESS);
		} catch (Exception e) {

			jsonResponse.put(WebConstant.ERROR, e.getMessage());
			e.printStackTrace();
		}

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(new Gson().toJson(jsonResponse));
	}

}
