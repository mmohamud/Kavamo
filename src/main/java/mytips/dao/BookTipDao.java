package mytips.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mytips.database.*;
import mytips.model.BookTip;

public class BookTipDao implements Dao {

    private Database db;

    public BookTipDao(Database db) {
        this.db = db;
    }

// Mallista AiheDao korvattu "Aihe" sanalla "BookTip" ja "nimi" sanalla "author"
// Katsotaan, löytyykö booktip nimen ja id:n yhdistelmällä tai ID:llä
    @Override
    public Object findOne(Object key) throws SQLException {
        BookTip bookTip = (BookTip) key;
        Connection conn = db.getConnection();
        PreparedStatement stmt = conn.prepareStatement(
                "SELECT * FROM BookTip WHERE id = ?"
        );
//        stmt.setString(1, bookTip.getTitle());
//        stmt.setInt(2, etsittavaAihe.getKurssiId());
        stmt.setInt(1, bookTip.getId());

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

        BookTip returnBookTip
                = new BookTip(id, author, title, summary, comment, isbn, type);
  
        stmt.close();
        rs.close();
        conn.close();

        return returnBookTip;
    }

        public Object findOneByValues(Object key) throws SQLException { 
        BookTip bookTip = (BookTip) key;
        Connection conn = db.getConnection();
        PreparedStatement stmt = conn.prepareStatement(
            "SELECT * FROM BookTip WHERE title = ? and author = ?"
        );
        stmt.setString(1, bookTip.getTitle());
        stmt.setString(2, bookTip.getAuthor());

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

        BookTip returnBookTip 
                = new BookTip(id, author, title, summary, comment, isbn, type);

        stmt.close();
        rs.close();
        conn.close();

        return returnBookTip;
    }

    @Override
    public List findAll() throws SQLException {
        List bookTips = new ArrayList<>();
        Connection conn = db.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM BookTip");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String author = rs.getString("author");
            String title = rs.getString("title");
            String summary = rs.getString("summary");
            String comment = rs.getString("comment");
            String isbn = rs.getString("isbn");
            String type = rs.getString("type");

            BookTip returnBookTip
                = new BookTip(id, author, title, summary, comment, isbn, type);

            bookTips.add(returnBookTip);

        }
        return bookTips;
    }

    @Override
    public Object saveOrUpdate(Object object) throws SQLException {
        BookTip bookTip = (BookTip) object;

        try (Connection conn = db.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO BookTip "
                    + "(author, title, summary, comment, isbn) "
                    + "VALUES (?, ?, ?, ?, ?)"
            );

            stmt.setString(1, bookTip.getAuthor());
            stmt.setString(2, bookTip.getTitle());
            stmt.setString(3, bookTip.getSummary());
            stmt.setString(4, bookTip.getComment());
            stmt.setString(5, bookTip.getIsbn());
            stmt.executeUpdate();
        }
        return findOneByValues(bookTip); 
    }

    @Override
    public void delete(Object key) throws SQLException {
        if (findOne(key) == null) {
            return;
        }
        BookTip bookTip = (BookTip) findOne(key);

        Connection conn = db.getConnection();
        PreparedStatement stmt = conn.prepareStatement(
                "DELETE FROM BookTip WHERE id = ?"
        );

        stmt.setInt(1, bookTip.getId());
        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }
}
