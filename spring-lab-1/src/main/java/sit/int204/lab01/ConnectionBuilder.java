package sit.int204.lab01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBuilder {
    private static String DB_URL = "jdbc:mysql://localhost:3306/classicmodels?useSSL=false";
    private static String DB_USER = "root";
    private static String DB_PASSWORD = "MySQL_63130500042";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
