# Week #1: Course Materials

This week, you should learn the following topics. Online courses, tutorials and other learning material links are provided

  * Conceptual Topics
    * multi-tier architecture - database, application logic, REST interfaces, UI
    * source code control systems
    * agile project management
    * Database Management Systems
      * https://lagunita.stanford.edu/courses/DB/2014/SelfPaced/about
  * Concrete Techs
    * Git
      * https://in.udacity.com/course/version-control-with-git--ud123
    * Jira
      * https://www.atlassian.com/agile/how-to-do-scrum-with-jira-software
    * MySQL, MySQL Workbench

# Week #1: Workshop #1 - Create the development database, table and populate it
  * Pre-Reqs
    * Git Repository setup
    * RDS Database setup for DEV, INTEG, STAGING and PROD environments;
    * MySQL Workbench installed on the desktop

  * Git Clone
    * ```git clone git@github.com:git@github.com:HexaInnovLab/ftpxx.git```
  * Open MySQL Workbench, and connect to the development mysql instance
    * TBD
  * Run database/database.ddl to create the employee table
  * Click 'File'/'New Query Tab' menu. Run 'SELECT * from EMPLOYEE' in the tab opened. No rows will be returned.
  * Run database/database.dml to populate the employee table
  * Run 'SELECT * from EMPLOYEE' in the query tab. 5 rows will be returned.

# Week #1: Workshop #2 - Build/Run the skeleton rest service
  * Pre-Reqs
    * Apache Tomcat installed on the desktop
  * Open DbConnection.java and change the connection string, username, password
  * ```mvn checkstyle:checkstyle```
  * ```mvn package```
  * ```cp target/ftpxx-0.0.1-SNAPSHOT.war /path/to/apache-tomcat-9.0.0.M22/webapps/ftpxx.war```
  * ```curl http://localhost:8080/ftpxx/api/employees```

