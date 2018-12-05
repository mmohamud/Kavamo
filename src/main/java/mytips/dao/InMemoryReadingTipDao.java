/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytips.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mytips.model.ReadingTip;

/**
 *
 * @author vseppane
 */
public class InMemoryReadingTipDao implements Dao {

    private ArrayList<ReadingTip> readingTips = new ArrayList<>();

    @Override
    public Object findOne(Object key) throws SQLException {
        //To change body of generated methods, choose Tools | Templates.
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List findAll() throws SQLException {
        //To change body of generated methods, choose Tools | Templates.
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object saveOrUpdate(Object object) throws SQLException {
        ReadingTip readingTip = (ReadingTip) object;
        readingTips.add(readingTip);
        return readingTip;
    }

    @Override
    public void delete(Object key) throws SQLException {
        //To change body of generated methods, choose Tools | Templates.
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
