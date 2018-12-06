/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytips.model;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mytips.ConsoleIO;
import mytips.dao.ReadingTipDao;
import mytips.database.Database;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;


/**
 *
 * @author Aino
 */
public class ReadingTipTest {
    private Database db;
    private ConsoleIO io;
    private ReadingTipDao readingTipDao;


   @Before
    public void setUp() {
        try {
            db = new Database("jdbc:sqlite:readingtipsTest.db");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadingTipTest.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
        readingTipDao = new ReadingTipDao(db);



    }

   /*@Test
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
    }*/

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
