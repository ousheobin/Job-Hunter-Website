package cn.gcu.dao;

import java.io.Serializable;
import java.util.List;

import cn.gcu.pojo.Page;

public abstract interface BaseDao<T, PrimaryKey extends Serializable> {

	public abstract T get(PrimaryKey id);

	public abstract List<T> getAll();

	public abstract void update(T entity);

	public abstract void save(T entity);

	public abstract void saveOrUpdate(T entity);

	public abstract void delete(T entity);
	
	public abstract long count();
	
	public abstract Page<T> queryByPage(int pageNumber,int prePage);

}
