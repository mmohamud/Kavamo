package mytips;

import java.util.*;   // ei käytössä, checkstyle ei kuitenkaan herjaa
import mytips.model.ReadingTipManager;
import mytips.database.Database;
import java.sql.*;
import mytips.dao.ReadingTipDao;

public class Main {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args)
            throws SQLException, ClassNotFoundException {

        Database db = new Database("jdbc:sqlite:readingtips.db");
        db.init();
        ReadingTipDao readingTipDao = new ReadingTipDao(db);

        ConsoleIO io = new ConsoleIO();
        ReadingTipManager readingTipManager
                = new ReadingTipManager(readingTipDao);
        TextualUI ui = new TextualUI(readingTipManager, io);
        ui.start();
        db.close();
        System.out.println("Lopetetaan");
        System.exit(0);

    }

}
