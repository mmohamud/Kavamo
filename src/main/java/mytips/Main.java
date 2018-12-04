package mytips;

import java.util.*;   // ei käytössä, checkstyle ei kuitenkaan herjaa
//import mytips.model.ReadingTip;
import mytips.model.ReadingTipManager;
import mytips.database.Database;
import java.sql.*;
import mytips.dao.BookTipDao;
import mytips.dao.WebTipDao;

public class Main {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args)
            throws SQLException, ClassNotFoundException {

        Database db = new Database("jdbc:sqlite:readingtips.db");
        BookTipDao bookTipDao = new BookTipDao(db);
        WebTipDao webTipDao = new WebTipDao(db);
        
        ConsoleIO io = new ConsoleIO();
        ReadingTipManager readingTipManager = 
                new ReadingTipManager(bookTipDao, webTipDao);
        TextualUI ui = new TextualUI(readingTipManager, io);
        ui.start();
        
        System.out.println("Lopetetaan");
        System.exit(0);

    }

}