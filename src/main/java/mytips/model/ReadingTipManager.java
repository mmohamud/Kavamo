
package mytips.model;

import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import mytips.dao.Dao;
//import mytips.dao.BookTipDao;
// import mytips.dao.WebTipDao;
// import mytips.database.Database;

public class ReadingTipManager {

    private ArrayList<ReadingTip> readingTips;
    private Dao readingTipDao;

    public ReadingTipManager(Dao readingTipDao) {

        this.readingTipDao = readingTipDao;
        readingTips = new ArrayList<>();
    }

    public ArrayList<ReadingTip> getReadingTips() {
        try {
            ArrayList<ReadingTip> tips = 
                    (ArrayList<ReadingTip>) readingTipDao.findAll();

            for (ReadingTip readingTip : tips) {
                readingTips.add(readingTip);
            }
            
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


    public ReadingTip getReadingTip(int id) {
        ReadingTip foundTip = null;
        try {
            foundTip = (ReadingTip) readingTipDao.findOne(id);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        if (foundTip != null) {
            return foundTip;
        }
        return null;
    }

}
