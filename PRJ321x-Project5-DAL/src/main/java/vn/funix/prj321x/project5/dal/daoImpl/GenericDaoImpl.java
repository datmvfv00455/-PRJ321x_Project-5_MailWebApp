package vn.funix.prj321x.project5.dal.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;

import vn.funix.prj321x.project5.dal.dao.GenericDao;
import vn.funix.prj321x.project5.dal.utils.HibernateUtil;

public class GenericDaoImpl<T> implements GenericDao<T> {

	private Class<T> entityClass;

	public GenericDaoImpl(Class<T> enityClass) {
		this.entityClass = enityClass;
	}

	@Override
	public void delete(T entity) {
		Session session = HibernateUtil.getSessionFactory()
				.openSession();

		Transaction transaction = session.beginTransaction();
		try {
			session.delete(entity);

			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();

			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public void update(T entity) {
		Session session = HibernateUtil.getSessionFactory()
				.openSession();

		Transaction transaction = session
				.beginTransaction();
		try {
			session.merge(entity);

			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();

			throw e;
		} finally {
			session.close();
		}

	}

	@Override
	public List<T> getAll() {
		List<T> list = new ArrayList<T>();

		Session session = HibernateUtil.getSessionFactory()
				.openSession();

		Transaction transaction = session
				.beginTransaction();
		try {
			StringBuilder hql = new StringBuilder();
			hql.append("from ");
			hql.append(entityClass.getSimpleName());
			hql.append(" e ");
			hql.append("order by ");
			hql.append("e.createdDate ");
			hql.append("DESC");

			list = session.createQuery(hql.toString())
					.getResultList();

			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();

			throw e;
		} finally {
			session.close();
		}
		return list;

	}

	@Override
	public void save(T entity) {
		Session session = HibernateUtil.getSessionFactory()
				.openSession();

		Transaction transaction = session
				.beginTransaction();
		try {
			session.save(entity);

			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();

			throw e;
		} finally {
			session.close();
		}

	}

	@Override
	public T findById(Integer id) {
		Session session = HibernateUtil.getSessionFactory()
				.openSession();

		Transaction transaction = session
				.beginTransaction();

		T result = null;
		try {
			result = (T) session.get(entityClass, id);
			if (result == null) {
				throw new ObjectNotFoundException(
						" NOT FOUND " + id, null);
			}
		} catch (HibernateException e) {
			transaction.rollback();

			throw e;
		} finally {
			session.close();
		}
		return result;
	}

}
