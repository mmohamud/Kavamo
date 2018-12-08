package mytips.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mytips.database.*;
import mytips.model.ReadingTip;

public class ReadingTipDao implements Dao {

    private Database db;

    public ReadingTipDao(Database db) {
        this.db = db;
    }

// Mallista AiheDao korvattu "Aihe" sanalla "BookTip" ja "nimi" sanalla "author"
// Katsotaan, löytyykö booktip nimen ja id:n yhdistelmällä tai ID:llä
    @Override
    public Object findOne(Object key) throws SQLException {
        ReadingTip readingTip = (ReadingTip) key;
        Connection conn = db.getConnection();
        PreparedStatement stmt = conn.prepareStatement(
                "SELECT * FROM ReadingTip WHERE id = ?"
        );
//        stmt.setString(1, bookTip.getTitle());
//        stmt.setInt(2, etsittavaAihe.getKurssiId());
        stmt.setInt(1, readingTip.getId());

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
        String isbn = rs.getString("isbn");
        String type = rs.getString("type");
        String url = rs.getString("url");
        ReadingTip returnReadingTip
                = new ReadingTip(author, title, summary, comment, type);
  
        returnReadingTip.setIsbn(isbn);
        returnReadingTip.setUrl(url);
        stmt.close();
        rs.close();
        conn.close();

        return returnReadingTip;
    }

        public Object findOneByValues(Object key) throws SQLException { 
        ReadingTip readingTip = (ReadingTip) key;
        Connection conn = db.getConnection();
        PreparedStatement stmt = conn.prepareStatement(
            "SELECT * FROM ReadingTip WHERE title = ? and author = ?"
        );
        stmt.setString(1, readingTip.getTitle());
        stmt.setString(2, readingTip.getAuthor());

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
        String isbn = rs.getString("isbn");
        String type = rs.getString("type");
        String url = rs.getString("url");
        
        ReadingTip returnReadingTip 
                = new ReadingTip(author, title, summary, comment, type);       
        returnReadingTip.setIsbn(isbn);
        returnReadingTip.setUrl(url);
        
        stmt.close();
        rs.close();
        conn.close();

        return returnReadingTip;
    }

    @Override
    public List findAll() throws SQLException {
        List readingTips = new ArrayList<>();
        Connection conn = db.getConnection();
        PreparedStatement stmt = conn.prepareStatement(
                "SELECT * FROM ReadingTip");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String author = rs.getString("author");
            String title = rs.getString("title");
            String summary = rs.getString("summary");
            String comment = rs.getString("comment");
            String isbn = rs.getString("isbn");
            String type = rs.getString("type");
            String url = rs.getString("url");
            ReadingTip returnReadingTip
                = new ReadingTip(author, title, summary, comment, type);
            returnReadingTip.setUrl(url);     
            returnReadingTip.setId(id);
            readingTips.add(returnReadingTip);
        }
        return readingTips;
    }

    public ArrayList<ReadingTip> findBySearch(String key) throws SQLException { 
        ArrayList readingTips = new ArrayList<>();
        Connection conn = db.getConnection();
        PreparedStatement stmt;
        String search = "'" + "%" + key + "%" + "'";
        String searchCond = "SELECT * FROM ReadingTip WHERE author like " + search +
                    " or title like " + search +
                    " or summary like " + search +
                    " or comment like " + search +
                    " or isbn like " + search +
                    " or url like " + search +
                    " or type like "  + search;
        
        stmt = conn.prepareStatement(searchCond);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String author = rs.getString("author");
            String title = rs.getString("title");
            String summary = rs.getString("summary");
            String comment = rs.getString("comment");
            String isbn = rs.getString("isbn");
            String type = rs.getString("type");
            String url = rs.getString("url");
            ReadingTip returnReadingTip
                = new ReadingTip(author, title, summary, comment, type);
            returnReadingTip.setUrl(url);     
            returnReadingTip.setId(id);
            readingTips.add(returnReadingTip);
        }
        return readingTips;
        
    }
    @Override
    public Object saveOrUpdate(Object object) throws SQLException {
        ReadingTip tip = (ReadingTip) object;

        try (Connection conn = db.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO ReadingTip "
                    + "(author, title, summary, comment, isbn, url, type) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)"
            );

            stmt.setString(1, tip.getAuthor());
            stmt.setString(2, tip.getTitle());
            stmt.setString(3, tip.getSummary());
            stmt.setString(4, tip.getComment());
            stmt.setString(5, tip.getIsbn());
            stmt.setString(6, tip.getUrl());
            stmt.setString(7, tip.getType());
            stmt.executeUpdate();
        }
        return findOneByValues(tip); 
    }

    @Override
    public void delete(Object key) throws SQLException {
        if (findOne(key) == null) {
            return;
        }
        ReadingTip readingTip = (ReadingTip) findOne(key);

        Connection conn = db.getConnection();
        PreparedStatement stmt = conn.prepareStatement(
                "DELETE FROM ReadingTip WHERE id = ?"
        );

        stmt.setInt(1, readingTip.getId());
        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }

    @Override
    public Object findOneById(int key) throws SQLException {
        Connection conn = db.getConnection();
        PreparedStatement stmt = conn.prepareStatement(
                "SELECT * FROM ReadingTip WHERE id = ?"
        );
//        stmt.setString(1, bookTip.getTitle());
//        stmt.setInt(2, etsittavaAihe.getKurssiId());
        stmt.setInt(1, key);

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
        String isbn = rs.getString("isbn");
        String type = rs.getString("type");
        String url = rs.getString("url");
        ReadingTip returnReadingTip
                = new ReadingTip(author, title, summary, comment, type);
  
        returnReadingTip.setIsbn(isbn);
        returnReadingTip.setUrl(url);
        returnReadingTip.setId(id);
        stmt.close();
        rs.close();
        conn.close();

        return returnReadingTip;
    }

}