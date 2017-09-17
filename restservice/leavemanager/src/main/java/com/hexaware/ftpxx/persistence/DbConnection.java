package com.hexaware.ftpxx.persistence;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.logging.PrintStreamLog;;

/**
 */
public class DbConnection {
    /**
     * Connecting to MYSQL DB.
     * @return database Connection.
     */
    public final DBI getConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //FIXME: Make this parametrized, with default
            DBI dbi = new DBI("jdbc:mysql://staging-rds.csgmpwijurve.us-east-1.rds.amazonaws.com:3306/FTP01_DEV",
                "FTP01_DEV", "FTP01_DEV");
            dbi.setSQLLog(new PrintStreamLog());
            return dbi;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
