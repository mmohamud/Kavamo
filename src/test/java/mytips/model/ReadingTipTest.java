/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytips.model;

import java.sql.SQLException;
import java.sql.Statement;
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
            Statement statement = c.createStatement();
            String dropReadingTip = "DROP TABLE IF EXISTS ReadingTip;";
            statement.execute(dropReadingTip);
            String sql = "CREATE TABLE IF NOT EXISTS ReadingTip ("
                    + "id integer PRIMARY KEY,"
                    + "author varchar(40),"
                    + "title varchar(40),"
                    + "summary varchar(200),"
                    + "comment varchar(100),"
                    + "isbn varchar(20),"
                    + "url varchar(100),"
                    + "type varchar(20),"
                    + "readStatus boolean"
                    + ");";

            statement.execute(sql);
            statement.close();
            c.close();
        } catch (SQLException e) {
            System.out.println("Tietokannan alustus epäonnistui, SQL-virhe");
            System.out.println(e);
        } catch (Exception e) {
            System.out.println("Tietokannan alustus epäonnistui");
            System.out.println(e);
        }
        readingTipDao = new ReadingTipDao(db);
    }

    @Test
    public void webTipinTalletus() throws SQLException {
        ReadingTip webTip
                = new ReadingTip("Author", "Title", "Summary",
                        "Comment", "web", false);
        webTip.setUrl("url-osoite");

        ReadingTip luotu
                = (ReadingTip) readingTipDao.saveOrUpdate(webTip);
        assertEquals(webTip.getAuthor(), luotu.getAuthor());
    }

    @Test
    public void bookTipinTalletus() throws SQLException {

        ReadingTip bookTip
                = new ReadingTip("Author", "Title", "Summary",
                        "Comment", "book", false);
        ReadingTip luotu
                = (ReadingTip) readingTipDao.saveOrUpdate(bookTip);

        assertEquals(bookTip.getAuthor(), luotu.getAuthor());
    }

    @Test
    public void bookTipinSetISBN() throws SQLException {
        // jos tuota isbn-setteriä ei tarvita, myös testin voi poistaa
        ReadingTip bookTip
                = new ReadingTip("Author", "Title", "Summary",
                        "Comment", "book", false);
        bookTip.setIsbn("isbntest");
        ReadingTip luotu
                = (ReadingTip) readingTipDao.saveOrUpdate(bookTip);
        assertEquals(luotu.getIsbn(), "isbntest");
    }

    @Test
    public void webTipSetUrl() throws SQLException {
        ReadingTip webTip
                = new ReadingTip("Author X", "Title", "Summary",
                        "Comment", "web", false);
        String url = "www.saitti.com";
        webTip.setUrl(url);
        ReadingTip luotu
                = (ReadingTip) readingTipDao.saveOrUpdate(webTip);
        assertEquals(luotu.getUrl(), url);
    }

    @Test
    public void markAsRead() throws SQLException {
        ReadingTip webTip
                = new ReadingTip("Author Y", "Title Z", "Summary",
                        "Comment", "web", false);
        webTip.setUrl("url-osoite");
        ReadingTip luotu = (ReadingTip) readingTipDao.saveOrUpdate(webTip);
        
        luotu.setReadStatus(true);
        ReadingTip modified = (ReadingTip) readingTipDao.saveOrUpdate(luotu);
        assertEquals(modified.getReadStatus(), true);
    }
}
