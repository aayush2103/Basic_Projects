package com.pluralsight.org.bridge;

import java.sql.*;

public class BridgeEverydayDemo {

    public static void main(String[] args) {
        try {
            //DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
            String dbUrl = "jdbc:derby:memory:codejava/webdb;create=true";
            Connection conn = DriverManager.getConnection(dbUrl);
            Statement sta = conn.createStatement();
            sta.executeUpdate("CREATE TABLE ADDRESS (ID INT, StreetName VARCHAR()20, CITY VARCHAR(20))");
            System.out.println("Table created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
