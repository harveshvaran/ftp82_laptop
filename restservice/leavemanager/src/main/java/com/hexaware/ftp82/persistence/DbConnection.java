package com.hexaware.ftp82.persistence;

import org.skife.jdbi.v2.DBI;
//import org.skife.jdbi.v2.logging.PrintStreamLog;;

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
      String dbc = System.getenv("DB_CONNECTION");
      if (dbc == null || dbc.equals("")) {
        dbc = "localhost:3307";
      }
<<<<<<< HEAD
      DBI dbi = new DBI("jdbc:mysql://" + dbc + "/ftp82", "root", "Password123");
=======
      DBI dbi = new DBI("jdbc:mysql://" + dbc + "/ftp82", "ftp82", "ftp82");
>>>>>>> b348f222ca9c6de4e256da621a9d25320e1aa423
      //dbi.setSQLLog(new PrintStreamLog());
      return dbi;
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
