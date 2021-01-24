package vn.funix.prj321x.project5.bll.service;

import java.util.List;

public interface GenericService<T> {
	List<T> getAll();

	void update(T dto);

	void save(T dto);

	T findById(Integer id);
}
