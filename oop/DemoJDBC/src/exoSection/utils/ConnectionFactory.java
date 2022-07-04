package exoSection.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/dbslide";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}