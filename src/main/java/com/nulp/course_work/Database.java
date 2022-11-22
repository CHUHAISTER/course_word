package com.nulp.course_work;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.sql.DriverManager;

public class Database {
    public static final Logger LOGI = (Logger) LogManager.getLogger(Database.class);
    public static final String url = "jdbc:sqlserver://flowersshops.database.windows.net:1433;" +
            "database=shopsforflowers_database;user=dead_hero15@flowersshops;password=sword_1n_chest!;encrypt=true;" +
            "trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    public static java.sql.Connection connection = null; // connection to database
    /**
     * a method that checks whether there is a connection to the database. I
     * f there is no connection, we establish it
     * @return The connection to database
     */
    public static java.sql.Connection getConnection() {

        if(connection == null){
            try {
                //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connection  = DriverManager.getConnection(url);
                LOGI.info("Success connection to database.");
            }
            catch (Exception e) {
                e.printStackTrace();
                LOGI.error("Fail connection."+ e.getMessage());
            }
        }
        return  connection;
    }
}
