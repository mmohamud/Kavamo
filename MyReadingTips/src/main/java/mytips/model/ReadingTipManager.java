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
import mytips.IO;
import mytips.dao.BookTipDao;
import mytips.dao.Dao;
import mytips.dao.WebTipDao;
import mytips.database.Database;

/**
 *
 * @author vseppane
 */
public class ReadingTipManager implements TipManager {

    private ArrayList<ReadingTip> readingTips;
    private IO io;
    private Database db;

    public ReadingTipManager(IO io, Database db) {
        //Haetaanko lukuvinkit tässä kohtaa tietokannasta?

        this.db = db;
        readingTips = new ArrayList<>();
        this.io = io;
    }

    @Override
    public ArrayList<ReadingTip> getReadingTips() {
        return readingTips;
    }

    @Override
    public void printReadingTips() {
        for (ReadingTip tip : readingTips) {
            io.print(tip.toString() + "\n");
        }
    }

    @Override
    public void addBookTip(BookTip readingTip) {
        BookTipDao readingTipDao = new BookTipDao(db);
        try {
            readingTipDao.saveOrUpdate(readingTip);
            io.print("Kirja tallennettu!");
        } catch (SQLException ex) {
            System.out.println("ex: " + ex);
            io.print("Lukuvinkin talletus ei onnistunut");
        }
        this.readingTips.add(readingTip);
    }

    @Override
    public void addWebTip(WebTip readingTip) {
        WebTipDao readingTipDao = new WebTipDao(db);
        try {
            readingTipDao.saveOrUpdate(readingTip);
        } catch (SQLException ex) {
            io.print("Lukuvinkin talletus ei onnistunut");
        }
        this.readingTips.add(readingTip);
    }
}
