package example.demoBank.service;

import java.util.List;

public interface IService<T, ID> {
	
	long count();
	void delete(long ID);
	void deleteAll();
//	void addNewEntity(T entity);
	T findByID(ID id);
	List<T> findAllEntities();
	boolean exists(T entity);
}
