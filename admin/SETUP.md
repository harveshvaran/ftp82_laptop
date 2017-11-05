# This readme is for the administrators of the ftp program

## Pre Nov-20th

  * Sort the teams into 2 batches of 25, then into teams of 5 each
    * CS/Non-CS folks
    * Scores equally distributed
    * Gender distribution
  * Create Git repository for the 10 teams
    * Make sure that ftp-fork-me does not have any branches
    * Go to github.com
      * delete any existing repositories: ftp01 to ftp10
      * create a repository for each team : ftp01 to ftp10
      * Add FTP-Admins as a group w/ R/W access to these repositories
    * `git clone --bare git@github.com:HexaInnovLab/ftp-fork-me.git ftpxx`
    * `cd ftpxx`
    * For each team, nn = 01 to 10
      * `git push --mirror git@github.com:HexaInnovLab/ftpnn.git`
    * For each team, nn = 01 to 10
      * from the workspace
      * `git clone git@github.com:HexaInnovLab/ftpnn.git`
      * cd ftpnn
      * For windows
        * use VS Code, find/replace in files to do the following: replacing ftpxx -> ftpnn, FTPXX -> FTPnn
        * Rename directory restservice/leavemanager/src/main/java/com/hexaware/ftpxx/ to restservice/leavemanager/src/main/java/com/hexaware/ftpnn/
      * For Mac OS
        * `find . -type f -not -path '*/\.*' -not -path "*/node_modules/*" -exec sed -i '' -e 's/ftpxx/ftpnn/g' {} \; -exec sed -i '' -e 's/FTPXX/FTPnn/g' {} \;
`
        * `mv restservice/leavemanager/src/main/java/com/hexaware/ftpxx/ restservice/leavemanager/src/main/java/com/hexaware/ftpnn/`
      * `git add restservice/leavemanager/src/main/java/com/hexaware/ftpnn/`
      * `git commit -a -m "replacing xx with the team number`
      * `git push origin HEAD`
      
    * Add the .pub key from jenkins home/.ssh directory for this team as the repository's deploy key
    * [TBD: This has to be done on day1] Add each team member to the team's git repository
  * Create Scrum teams corresponding to the 10 teams
    * Add each team member to the team's Jira group 
  * Staging and Integration ec2 instances
    * Use the instructions in JENKINS.md to spin up the instances, stop iptables, yum install and install jdk
    * Install tomcat
      * As centos, in /home/centos, wget "http://www-us.apache.org/dist/tomcat/tomcat-8/v8.5.23/bin/apache-tomcat-8.5.23.tar.gz", "tar -xvzf apache-tomcat-8.5.23"
      * Edit bin/startup.sh, add "export DB_CONNECTION=...:3306"
  * Jenkins jobs - 3 per team
    * FTPXX-10-UNIT
    * FTPXX-30-INTEGRATION
    * FTPXX-50-STAGING
    * For each team, nn = 01 to 10
      * Create a tab FTPnn
      * Create New Item, for stage = 10-UNIT, 30-INTEGRATION, and 50-STAGING
        * Free Style Project
        * Copy from FTPnn-{stage}, "Add to current view" checked
        * Change all xx to nn in the job fields  
  * Databases - 3 per team
    * Integration and Staging instances
    * `CREATE DATABASE FTPXX;` -- XX from 01 to 10
    * `CREATE USER 'FTPXX'@'%' IDENTIFIED BY 'FTPXX';`
    * `GRANT ALL ON FTPXX.* TO 'FTPXX'@'%';`

# Week #1 Day #1
  * Go to https://github.com/orgs/HexaInnovLab/people, and click "Invite Member" and add them to the FTPnn team.

----- To be reviewed ---------

## Setup Jira

The users are added by invite: Site Administration/User Management. Use the hexaware email address, the UI already selects the hexawareid as the username.

Create a "FTP" group and add all the users from the ftp program.

Create a project, with shared configuration w/ StationMaster. Create a scrum board, fix the swimlanes and filters, and create the epics. Give developer access to FTP group.
