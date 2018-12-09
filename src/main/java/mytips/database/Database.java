package mytips.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private String databaseAddress;

    public Database(String databaseAddress) throws ClassNotFoundException {
        this.databaseAddress = databaseAddress;
        //System.out.println("Database syntyy nyt täällä");
    }

    public Connection getConnection() throws SQLException {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        if (dbUrl != null && dbUrl.length() > 0) {
            return DriverManager.getConnection(dbUrl);
        }

        if (databaseAddress != null) {
            return DriverManager.getConnection(databaseAddress);
        }

        return DriverManager.getConnection("jdbc:sqlite:readingtips.db");
    }
}
