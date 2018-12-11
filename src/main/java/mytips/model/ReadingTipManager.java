
package mytips.model;

import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import mytips.dao.Dao;

public class ReadingTipManager {

    private ArrayList<ReadingTip> readingTips;
    private Dao readingTipDao;

    public ReadingTipManager(Dao readingTipDao) {

        this.readingTipDao = readingTipDao;
    }

    public ArrayList<ReadingTip> getReadingTips() {
        try {
            readingTips = (ArrayList<ReadingTip>) readingTipDao.findAll();
        } catch (SQLException ex) {
            Logger.getLogger(ReadingTipManager.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        Collections.sort(readingTips, (o1, o2) -> o1.getTitle()
                .compareTo(o2.getTitle()));
        return readingTips;
    }

    public ReadingTip addReadingTip(ReadingTip readingTip) throws SQLException {
        ReadingTip newTip = (ReadingTip) readingTipDao.saveOrUpdate(readingTip);
        return newTip;
    }
    
    public ReadingTip updateReadingTip(ReadingTip readingTip) throws SQLException {
        ReadingTip newTip = (ReadingTip) readingTip;
        readingTip.setReadStatus(true);
        readingTipDao.saveOrUpdate(readingTip);
        return newTip;
    }


    public ReadingTip getReadingTip(int id) {
        ReadingTip foundTip = null;
        try {
            foundTip = (ReadingTip) readingTipDao.findOneById(id);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        if (foundTip != null) {
            return foundTip;
        }
        return null;
    }
    public ArrayList<ReadingTip> getReadingTipBySearch(String key) {
        ArrayList foundTips = new ArrayList();
        try {
            foundTips = (ArrayList) readingTipDao.findBySearch(key);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        if (foundTips != null) {
            return foundTips;
        }
        return null;
    }
    public ArrayList<ReadingTip> getReadingTipBySelection(int key) {
        ArrayList foundTips = new ArrayList();
        try {
            foundTips = (ArrayList) readingTipDao.findBySelection(key);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        if (foundTips != null) {
            return foundTips;
        }
        return null;
    }

}
