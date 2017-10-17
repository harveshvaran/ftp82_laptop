# Week #2: Course Materials


# Week #2: Workshop Day #1 - Create the development database, table and populate it
  * Create JIRAs for all the work to be done in Week #2 
    * Create a JIRA for changing the database design
    * Others?
  * Start the sprint
    
  * Database Design
  * Assign the jira to one of the team members  
  * Pull it to "In Progress"
  * `git checkout -b FTPXX-<TicketNumber>-DDL`
  * Edit Database.ddl for two tables: EMPLOYEE and LEAVE_HISTORY
    * Use the "STANDARDS_AND_GUIDELINES.md" file for the naming conventions to be followed.
  * Edit Database.dml to insert data into the EMPLOYEE table; The LEAVE_HISTORY table can be blank to start with.
  * Run the ddls and dmls against your local mysql server
  * Push the changes to remote branch
    * `git add database/database.ddl`
    * `git add database/database.dml`
    * `git commit -m "ddl/dml changed for the leave application"`
    * `git push origin HEAD`
  * Now, the other team members can pull from branch and run the ddl/dml against their local databases
  * `git pull`
  * You should see that the branch just created is now available locally as well
  * `git checkout FTPXX-<TicketNumber>-DDL`
  * You should be able to see the updated ddl and dml via VS Code
  * Run the ddl and dml against your local mysql server
  * Re-run the Cli, the Curl and the Browser UI to see the changed data in all three interfaces
  * When ready, create a Pull Request
    * Go to "https://github.com/HexaInnovLab/ftpxx"
    * You may see a yellow box with your branch name, and with a button for creating a pull request.
      * If you don't see it, drop down the "Branch" dropdown, select your branch. Then click the "New Pull Request" button next to it.
      * Review your changes in the next screen. Lookout for typos, trailing whitespace etc. and fix them.
         * Go back to VS code, edit the files and commit/push the files to the branch again
       * Once happy, click the "Create pull request" button after correcting the description, comment etc.
     * Ask your facilitator to review the pull request.
  
