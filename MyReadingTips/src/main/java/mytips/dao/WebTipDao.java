/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytips.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import mytips.database.Database;
import mytips.model.WebTip;

/**
 *
 * @author mmohamud
 */
public class WebTipDao {

    private Database db;

    public WebTipDao(Database db) {
        this.db = db;
    }

    public Object findOne(Object key) throws SQLException {
        WebTip webTip = (WebTip) key;
        Connection conn = db.getConnection();
        PreparedStatement stmt 
                = conn.prepareStatement("SELECT * FROM WebTip WHERE id = ?");
        stmt.setInt(1, webTip.getId());

        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }

        int id = rs.getInt("id");
        String author = rs.getString("author");
        String title = rs.getString("title");
        String summary = rs.getString("summary");
        String comment = rs.getString("comment");

        WebTip returnWebTip = new WebTip(id, author, title, summary, comment);

        stmt.close();
        rs.close();
        conn.close();
        return returnWebTip;
    }

    public List findAll() throws SQLException {
        List webTips = new ArrayList<>();
        Connection conn = db.getConnection();
        PreparedStatement stmt = conn.prepareCall("SELECT * FROM WebTip");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String author = rs.getString("author");
            String title = rs.getString("title");
            String summary = rs.getString("summary");
            String comment = rs.getString("comment");

            WebTip returnWebTip 
                    = new WebTip(id, author, title, summary, comment);
            webTips.add(returnWebTip);
        }
        return webTips;
    }

    public Object saveOrUpdate(Object object) throws SQLException {
        WebTip webTip = (WebTip) object;
        
        WebTip compareTo = (WebTip) findOne(webTip);
        if (compareTo != null) {
            return webTip;
        }
        
        try (Connection conn = db.getConnection()) {
            PreparedStatement stmt 
                    = conn.prepareStatement("INSERT INTO WebTip " 
                    + "(id, author, title, summmary, comment, type)");
            stmt.setInt(1, webTip.getId());
            stmt.setString(2, webTip.getAuthor());
            stmt.setString(3, webTip.getTitle());
            stmt.setString(4, webTip.getSummary());
            stmt.setString(5, webTip.getComment());
            stmt.setString(6, "web");            
        }
        return findOne(webTip);
    }
    
    public void delete(Object key) throws SQLException {
        if (findOne(key) == null) {
            return;
        }
        WebTip webTip = (WebTip) findOne(key);
        
        Connection conn = db.getConnection();
        PreparedStatement stmt 
                = conn.prepareStatement("DELETE FROM WebTip WHERE id = ?");
        stmt.setInt(1, webTip.getId());
        
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }
}
