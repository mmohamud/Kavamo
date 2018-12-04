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
import mytips.dao.BookTipDao;
import mytips.dao.WebTipDao;
import mytips.database.Database;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;


/**
 *
 * @author Aino
 */
public class BookTipTest {
    private Database db;
    private ConsoleIO io;
    private BookTipDao bookTipDao;
    private WebTipDao webTipDao;

   @Before
    public void setUp() {
        try {
            db = new Database("jdbc:sqlite:readingtipsTest.db");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookTipTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        bookTipDao = new BookTipDao(db);
        webTipDao = new WebTipDao(db);

        
    }
    
   @Test
    public void webTipinTalletus() throws SQLException {
        WebTip webTip = 
                new WebTip(1, "test1", "test1", "test1", "test1", "test1", "testi1");
        WebTip luotu = 
                (WebTip) webTipDao.saveOrUpdate(webTip);
    
        assertEquals(webTip.getAuthor(), luotu.getAuthor());
    }   

    @Test
    public void bookTipinTalletus() throws SQLException {

        BookTip bookTip = 
                new BookTip(1, "test1", "test1", "test1", "test1", "test1", "testi1");
        BookTip luotu = 
                (BookTip) bookTipDao.saveOrUpdate(bookTip);
    
        assertEquals(bookTip.getAuthor(), luotu.getAuthor());
    }   
}
