package src.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String JDBC_URL = "";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";

    // Opens and returns connection to the db
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    // Closes db connection
    public static void closeConnection(Connection connection) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Connection closed");
        }
    }

    // Tests db connection
    public static void testConnection() throws SQLException {
        try (Connection connection = getConnection()) {
            System.out.println("Successful test, connected to the database!");
            closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Prints db info
    public static void getDatabaseInfo() throws SQLException {
        try (Connection connection = getConnection()) {
            DatabaseMetaData dbMetaData = connection.getMetaData();
            String productName = dbMetaData.getDatabaseProductName();   // Database name
            String productVersion = dbMetaData.getDatabaseProductVersion(); // Database version

            System.out.println("Database: " + productName);
            System.out.println("Version: " + productVersion);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
