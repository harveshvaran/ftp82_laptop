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
    * `git push --mirror git@github.com:HexaInnovLab/ftp01.git`
    * `git push --mirror git@github.com:HexaInnovLab/ftp02.git` etc.
    * Add each team member to the team's git repository
  * Create Scrum teams corresponding to the 10 teams
    * Add each team member to the team's Jira group
  * Jenkins jobs - 3 per team
  * Databases - 3 per team

----- To be reviewed ---------

## Setup Jira

The users are added by invite: Site Administration/User Management. Use the hexaware email address, the UI already selects the hexawareid as the username.

Create a "FTP" group and add all the users from the ftp program.

Create a project, with shared configuration w/ StationMaster. Create a scrum board, fix the swimlanes and filters, and create the epics. Give developer access to FTP group.
