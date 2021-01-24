package vn.funix.prj321x.project5.dal.utils;

import vn.funix.prj321x.project5.dal.dao.UserDao;
import vn.funix.prj321x.project5.dal.daoImpl.UserDaoImpl;

public class DaoUtil {

	private static volatile UserDao userDao = null;

	public static final UserDao getUserDaoInstance() {
		if (userDao == null) {
			synchronized (UserDao.class) {
				if (userDao == null) {
					userDao = new UserDaoImpl();
				}
			}
		}
		return userDao;
	}

}
