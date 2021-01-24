package vn.funix.prj321x.project5.dal.daoImpl;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import vn.funix.prj321x.project5.core.dto.UserDto;
import vn.funix.prj321x.project5.dal.dao.UserDao;
import vn.funix.prj321x.project5.dal.enity.UserEntity;
import vn.funix.prj321x.project5.dal.utils.HibernateUtil;

public class UserDaoImpl extends GenericDaoImpl<UserEntity> implements UserDao {

	public UserDaoImpl() {
		super(UserEntity.class);
	}

	@Override
	public boolean authenticate(UserDto userDto) {
		Session session = HibernateUtil.getSessionFactory()
				.openSession();

		Transaction transaction = session.beginTransaction();

		String  name     = userDto.getUserName();
		String  password = userDto.getUserPassword();
		boolean isAuthen = false;

		try {
			StringBuilder hql = new StringBuilder();

			hql.append("from UserEntity ue ");
			hql.append("WHERE ue.userName= :name ");
			hql.append("AND ue.userPassword= :password");

			Query<UserEntity> query = session.createQuery(hql.toString())
					.setParameter("name", name)
					.setParameter("password", password);

			isAuthen = (query.list().size() == 1);

		} catch (HibernateException e) {
			transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
		return isAuthen;
	}
}
