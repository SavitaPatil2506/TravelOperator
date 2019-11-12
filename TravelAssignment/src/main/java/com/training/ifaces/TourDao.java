package com.training.ifaces;

import java.sql.SQLException;
import java.util.List;

public interface TourDao<T> {
	public int add(T t)throws SQLException;
	public List<T>findAll()throws SQLException;
	public T findById(String source,String destination)throws SQLException;
	public int update(T t)throws SQLException;
	public int remove(long id)throws SQLException;
}


