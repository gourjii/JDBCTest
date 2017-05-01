package dao;
import java.sql.SQLException;

public interface DaoObj<T>{
	boolean add(T t)  throws SQLException;
    boolean remove(T t) throws SQLException;
    boolean update(T t) throws SQLException;
}
