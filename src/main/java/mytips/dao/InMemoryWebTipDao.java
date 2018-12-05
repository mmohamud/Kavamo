/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytips.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import mytips.model.BookTip;
import mytips.model.WebTip;

/**
 *
 * @author vseppane
 */
public class InMemoryWebTipDao implements Dao {

    private ArrayList<WebTip> webTips = new ArrayList<>();

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
        WebTip webTip = (WebTip) object;
        webTips.add(webTip);
        return webTip;
    }

    @Override
    public void delete(Object key) throws SQLException {
        //To change body of generated methods, choose Tools | Templates.
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object findOneById(int key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
