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

    private ArrayList<ReadingTip> readingTips;
    private Dao bookTipDao;
    private Dao webTipDao;

    public ReadingTipManager(Dao bookTipDao,
            Dao webTipDao) {

        this.bookTipDao = bookTipDao;
        this.webTipDao = webTipDao;
        readingTips = new ArrayList<>();
    }

    public ArrayList<ReadingTip> getReadingTips() {
        try {
            ArrayList<ReadingTip> bookTips = 
                    (ArrayList<ReadingTip>)bookTipDao.findAll();
            ArrayList<ReadingTip> webTips = 
                    (ArrayList<ReadingTip>)webTipDao.findAll();
            for (ReadingTip readingTip : bookTips) {
                readingTips.add(readingTip);
            }
            for (ReadingTip webTip : webTips) {
                readingTips.add(webTip);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReadingTipManager.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        Collections.sort(readingTips, (o1, o2) -> o1.getTitle()
                .compareTo(o2.getTitle()));
        return readingTips;
    }

    public BookTip addBookTip(BookTip readingTip) throws SQLException {
        BookTip newBook = (BookTip) bookTipDao.saveOrUpdate(readingTip);

        return newBook;
    }

    public WebTip addWebTip(WebTip webTip) throws SQLException {
        WebTip newTip = (WebTip) webTipDao.saveOrUpdate(webTip);

        return newTip;
    }

    public ReadingTip getReadingTip(int id) {
        ReadingTip foundBook = null;
        ReadingTip foundWeb = null;
        try {
            foundBook = (ReadingTip) bookTipDao.findOne(id);
            foundWeb = (ReadingTip) bookTipDao.findOne(id);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        if (foundBook != null) return foundBook;
        if (foundWeb != null) return foundWeb;
        return null;
    }

}
