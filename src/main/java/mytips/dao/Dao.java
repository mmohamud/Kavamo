
package mytips.dao;

import java.sql.*;
import java.util.*;

public interface Dao<T, K> {

    //T findOne(Object key) throws SQLException;

    T findOneById(int key) throws SQLException;

    List<T> findAll() throws SQLException;

    T saveOrUpdate(T object) throws SQLException;

    T findBySearch(String key) throws SQLException;

    T findBySelection(int key) throws SQLException;
    
    //void delete(K key) throws SQLException;
}