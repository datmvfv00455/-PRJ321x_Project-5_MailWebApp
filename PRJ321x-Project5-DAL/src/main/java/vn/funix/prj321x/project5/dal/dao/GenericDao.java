package vn.funix.prj321x.project5.dal.dao;

import java.util.List;

public interface GenericDao<T> {

	void delete(T ennity);

	void update(T ennity);

	void save(T ennity);

	T findById(Integer id);

	List<T> getAll();
}
