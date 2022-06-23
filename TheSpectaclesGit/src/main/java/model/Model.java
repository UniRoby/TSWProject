package model;

import java.sql.SQLException;
import java.util.*;

public interface Model<T, J> {
	
	public void setDB(J obj);
	
	public T doRetrieveByKey(ArrayList<String> keys) throws SQLException;
	
	public Collection<T> doRetrieveAll(String order) throws SQLException;
	
	public void doSave(T bean) throws SQLException;
	
	public void doUpdate(T bean) throws SQLException;
	
	public void doDelete(T bean) throws SQLException;
	
}
