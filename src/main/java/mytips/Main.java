package mytips;

import java.util.*;   // ei käytössä, checkstyle ei kuitenkaan herjaa
//import mytips.model.ReadingTip;
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
        Connection conn = db.getConnection();
        String sql = "CREATE TABLE IF NOT EXISTS ReadingTip ("
            + "id integer PRIMARY KEY,"
            + "author varchar(40),"
            + "title varchar(40),"
            + "summary varchar(200),"
            + "comment varchar(100),"
            + "isbn varchar(20),"
            + "url varchar(100),"
            + "type varchar(20)"
            + ");";
        Statement statement = conn.createStatement();
        statement.execute(sql);
        statement.close();
        try {
            sql = "ALTER TABLE ReadingTip ADD COLUMN readStatus";
            statement = conn.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
        }
        
        statement.close();
        conn.close();
        ReadingTipDao readingTipDao = new ReadingTipDao(db);

        ConsoleIO io = new ConsoleIO();
        ReadingTipManager readingTipManager = 
                new ReadingTipManager(readingTipDao);
        TextualUI ui = new TextualUI(readingTipManager, io);
        ui.start();

        System.out.println("Lopetetaan");
        System.exit(0);

    }

}