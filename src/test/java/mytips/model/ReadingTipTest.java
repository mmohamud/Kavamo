/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytips.model;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import mytips.ConsoleIO;
import mytips.dao.ReadingTipDao;
import mytips.database.Database;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.BeforeClass;
import java.sql.Connection;

/**
 *
 * @author Aino
 */
public class ReadingTipTest {
    private static Database db;
    private ConsoleIO io;
    private static ReadingTipDao readingTipDao;


   @BeforeClass
    public static void setUp() {
        try {
            db = new Database("jdbc:sqlite:?cache=shared");
            Connection c = db.getConnection();
            String sql = "CREATE TABLE IF NOT EXISTS ReadingTip ("
                + "id integer PRIMARY KEY,"
                + "author varchar(40),"
                + "title varchar(40),"
                + "summary varchar(200),"
                + "comment varchar(100),"
                + "isbn varchar(20),"
                + "url varchar(100),"
                + "type varchar(20)"
                + ");";
            Statement statement = c.createStatement();
            statement.execute(sql);
            String sql2 = "DELETE FROM ReadingTip";
            statement.execute(sql2);
            statement.close();
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadingTipTest.class.getName()).log(Level.SEVERE, 
                    null, ex);
        } catch (SQLException e) {
            System.out.println("Tietokannan alustus epäonnistui");
            System.out.println(e.getMessage());
        }
        readingTipDao = new ReadingTipDao(db);
    }

   @Test
    public void webTipinTalletus() throws SQLException {
        ReadingTip webTip = 
                new ReadingTip("Author", "Title", "Summary", 
                        "Comment", "web");
        webTip.setUrl("url-osoite");
        
        ReadingTip luotu = 
            (ReadingTip) readingTipDao.saveOrUpdate(webTip);
        assertEquals(webTip.getAuthor(), luotu.getAuthor());
    }   

    @Test
    public void bookTipinTalletus() throws SQLException {

        ReadingTip bookTip = 
                new ReadingTip("Author", "Title", "Summary", 
                        "Comment", "book");
        ReadingTip luotu = 
                (ReadingTip) readingTipDao.saveOrUpdate(bookTip);
    
        assertEquals(bookTip.getAuthor(), luotu.getAuthor());
    }

    @Test
    public void bookTipinSetISBN() throws SQLException {
        // jos tuota isbn-setteriä ei tarvita, myös testin voi poistaa
        ReadingTip bookTip = 
                new ReadingTip("Author", "Title", "Summary", 
                        "Comment", "book");
        bookTip.setIsbn("isbntest");
        ReadingTip luotu = 
                (ReadingTip) readingTipDao.saveOrUpdate(bookTip);  
        assertEquals(bookTip.getIsbn(), "isbntest");
    }  
    
    @Test
    public void webTipSetUrl() throws SQLException {
        ReadingTip webTip = 
                new ReadingTip("Author", "Title", "Summary", 
                        "Comment", "web");
        webTip.setUrl("url-osoite");
        ReadingTip luotu = 
                (ReadingTip) readingTipDao.saveOrUpdate(webTip);
        assertEquals(webTip.getUrl(), "url-osoite");
    }
}
