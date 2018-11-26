
package mytips.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
// import java.util.ArrayList;
import java.util.List;
import mytips.database.*;
import mytips.model.BookTip;

public class BookTipDao implements Dao {

    Database db;

    public BookTipDao(Database db) {
        this.db = db;
    }

// Mallista AiheDao korvattu "Aihe" sanalla "BookTip" ja "nimi" sanalla "author"
    
    @Override
    public Object findOne(Object key) throws SQLException { // Katsotaan, löytyykö booktip nimen ja id:n yhdistelmällä tai ID:llä
        BookTip etsittavaBookTip = (BookTip) key;
        Connection conn = db.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM BookTip WHERE (LOWER(author) = LOWER(?) AND book_id = ?) OR id = ?");
        stmt.setString(1, etsittavaBookTip.getAuthor());
//        stmt.setInt(2, etsittavaAihe.getKurssiId());
        stmt.setInt(2, etsittavaBookTip.getId());
                
        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }

        String author = rs.getString("author");
        int id = rs.getInt("id");
// "Palauttaa" tietokannasta oikeasti vain id:n ja authorin
        BookTip lisattavaBookTip = new BookTip(id, author, "title","isbn","Summary","Comment");
        
//        lisattavaAihe.setKysymykset(new KysymysDao(db).findAllByAiheId(id));  // Alkuperäisessä oli tämä

        stmt.close();
        rs.close();
        conn.close();

        return lisattavaBookTip;
    }

    
    @Override
    public List findAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object saveOrUpdate(Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
