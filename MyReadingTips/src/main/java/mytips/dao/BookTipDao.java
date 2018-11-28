package mytips.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
// import java.util.ArrayList;
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
        PreparedStatement stmt 
                = conn.prepareStatement("SELECT * FROM BookTip WHERE"
                + "(LOWER(title) = LOWER(?) AND id = ?) OR id = ?");
        stmt.setString(1, bookTip.getTitle());
//        stmt.setInt(2, etsittavaAihe.getKurssiId());
        stmt.setInt(2, bookTip.getId());

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
// "Palauttaa" tietokannasta oikeasti vain id:n ja authorin

        BookTip returnBookTip 
                = new BookTip(id, author, title, summary, comment, isbn);


// Alkuperäisessä oli tämä
// lisattavaAihe.setKysymykset(new KysymysDao(db).findAllByAiheId(id));  
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
            BookTip returnBookTip 
                    = new BookTip(id, author, title, summary, comment, isbn);
            bookTips.add(returnBookTip);

        }
        return bookTips;
    }

    @Override
    public Object saveOrUpdate(Object object) throws SQLException {
        BookTip bookTip = (BookTip) object;
        
        BookTip compareTo = (BookTip) findOne(bookTip);
        if (compareTo != null) {
            return bookTip;
        }
        
        try (Connection conn = db.getConnection()) {
            PreparedStatement stmt 
                    = conn.prepareStatement("INSERT INTO BookTip" 
                    + "(id, author, title, summary, comment, isbn)");
            stmt.setInt(1, bookTip.getId());
            stmt.setString(2, bookTip.getAuthor());
            stmt.setString(3, bookTip.getTitle());
            stmt.setString(4, bookTip.getSummary());
            stmt.setString(5, bookTip.getComment());
            stmt.setString(6, bookTip.getIsbn());
            stmt.executeUpdate();
        }
        return findOne(bookTip);
    }

    @Override
    public void delete(Object key) throws SQLException {
        if (findOne(key) == null) {
            return;
        }
        BookTip bookTip = (BookTip) findOne(key);
        
        Connection conn = db.getConnection();
        PreparedStatement stmt  
                = conn.prepareStatement("DELETE FROM BookTip WHERE id = ?");
        
        stmt.setInt(1, bookTip.getId());
        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }
}
