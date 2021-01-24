package vn.funix.prj321x.project5.bll.utils;

import vn.funix.prj321x.project5.bll.service.MailService;
import vn.funix.prj321x.project5.bll.service.UserService;
import vn.funix.prj321x.project5.bll.serviceImpl.MailServiceImpl;
import vn.funix.prj321x.project5.bll.serviceImpl.UserServiceImpl;

public class ServiceUtil {

	private static volatile UserService userService = null;

	private static volatile MailService mailService = null;

	public static UserService getUserServiceInstance() {
		if (userService == null) {
			synchronized (UserService.class) {
				if (userService == null) {
					userService = new UserServiceImpl();
				}
			}
		}
		return userService;
	}

	public static MailService getMailServiceInstance() {
		if (mailService == null) {
			synchronized (MailService.class) {
				if (mailService == null) {
					mailService = new MailServiceImpl();
				}
			}
		}

		return mailService;
	}

}
