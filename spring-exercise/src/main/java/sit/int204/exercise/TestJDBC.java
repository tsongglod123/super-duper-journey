package sit.int204.exercise;

import sit.int204.exercise.beans.ConnectionBuilder;

import java.sql.Connection;
import java.sql.SQLException;

public class TestJDBC {
    public static void main(String[] args) throws SQLException {
        ConnectionBuilder cb = new ConnectionBuilder();
        cb.setUrl("jdbc:mysql://localhost:3306/classicmodels?useSSL=false");
        cb.setUser("root");
        cb.setPassword("MySQL_63130500042");

        Connection con = cb.getConnection();
        System.out.println(cb);
    }
}
