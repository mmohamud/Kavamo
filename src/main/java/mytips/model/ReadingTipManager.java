/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytips.model;

import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import mytips.IO;
//import mytips.dao.BookTipDao;
import mytips.dao.Dao;
//import mytips.dao.Dao;
// import mytips.dao.WebTipDao;
// import mytips.database.Database;

/**
 *
 * @author vseppane
 */
public class ReadingTipManager {

    private List readingTips;
    private Dao bookTipDao;
    private Dao webTipDao;

    public ReadingTipManager(Dao bookTipDao,
            Dao webTipDao) {

        this.bookTipDao = bookTipDao;
        this.webTipDao = webTipDao;
        readingTips = new ArrayList<>();
    }

    public List getReadingTips() {
        try {
            List bookTips = bookTipDao.findAll();
            List webTips = webTipDao.findAll();
            for (Object readingTip : bookTips) {
                readingTips.add(readingTip);
            }
            for (Object webTip : webTips) {
                readingTips.add(webTip);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReadingTipManager.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return readingTips;
    }

    public BookTip addBookTip(BookTip readingTip) throws SQLException {
        BookTip newBook = (BookTip) bookTipDao.saveOrUpdate(readingTip);

        return newBook;
    }

    public WebTip addWebTip(WebTip webTip) throws SQLException {
        WebTip newTip = (WebTip)webTipDao.saveOrUpdate(webTip);
        
        return newTip;
    }

}
