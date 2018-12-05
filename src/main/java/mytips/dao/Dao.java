
package mytips.dao;

import java.sql.*;
import java.util.*;

public interface Dao<T, K> {

    T findOne(Object key) throws SQLException;

    T findOneById(int key) throws SQLException;

    List<T> findAll() throws SQLException;

    T saveOrUpdate(T object) throws SQLException;

    void delete(K key) throws SQLException;
}