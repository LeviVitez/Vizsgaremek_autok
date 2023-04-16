package com.example.vizsgaremek_autok;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public Connection databaseLink;

    public static String DB_DRIVER = "mysql";
    public static String DB_HOST = "localhost";
    public static String DB_PORT = "3306";
    public static String DB_DBNAME = "vizsgaremek";
    public static String DB_USER = "root";
    public static String DB_PASS = "";

    public DatabaseConnection() throws SQLException {
        String url = String.format("jdbc:%s://%s:%s/%s", DB_DRIVER, DB_HOST, DB_PORT, DB_DBNAME);
        databaseLink = DriverManager.getConnection(url, DB_USER, DB_PASS);
    }

    public Connection getConnection(){
        String databaseName="vizsgaremek";
        String databaseUser="de";
        String databasePassword="";
        String url="jdbc:mysql://localhost/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink=DriverManager.getConnection(url,databaseUser,databasePassword);
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

        return databaseLink;
    }
}
