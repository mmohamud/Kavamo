package mytips.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private String databaseAddress;

    public Database(String databaseAddress) throws ClassNotFoundException {
        this.databaseAddress = databaseAddress;
    }

    public Connection getConnection() throws SQLException {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        if (dbUrl != null && dbUrl.length() > 0) {
            return DriverManager.getConnection(dbUrl);
        }

        // if (databaseAddress != null) {
        //     return DriverManager.getConnection(databaseAddress);
        // }

        return DriverManager.getConnection(databaseAddress);
        //return DriverManager.getConnection("jdbc:sqlite:readingtips.db");
    }
    
    public void init() throws SQLException {
        Connection conn = this.getConnection();
        Statement statement = conn.createStatement();
        statement.execute(createTables());
        statement.close();
        conn.close();
    }

    private String createTables() {
	return "CREATE TABLE IF NOT EXISTS ReadingTip ("
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
        }
}

