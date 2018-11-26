/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myTips.dao;

import java.sql.*;
import java.util.*;
/**
 *
 * @author mmohamud
 */
public interface Dao<T, K> {
    T findOne(Object key) throws SQLException;

    List<T> findAll() throws SQLException;

    T saveOrUpdate(T object) throws SQLException;

    void delete(K key) throws SQLException;
}
