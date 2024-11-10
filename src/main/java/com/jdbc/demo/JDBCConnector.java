package com.jdbc.demo;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCConnector {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/online_pet_adoption";
    private static final String USER = "root";
    private static final String PASSWORD = "Devang@MySQL";

    public static Connection getConnection() throws SQLException{
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            //DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pet_adoption_platform?user=root&password=Devang@MySQL");
            System.out.println("Connection Established between Java and Database successfully");
            return connection;
        } catch (SQLException e) {
            System.out.println("Error while connecting to Database " + e.getMessage());
            throw e;
        }
    }
}
