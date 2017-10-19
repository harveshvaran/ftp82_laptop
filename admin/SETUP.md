# This readme is for the administrators of the ftp program

## Pre Nov-20th

  * Sort the teams into 2 batches of 25, then into teams of 5 each
    * CS/Non-CS folks
    * Scores equally distributed
    * Gender distribution
  * ONCE only: Setup deploy keys for the 10 teams
    * ssh to jenkins instance; sudo -u jenkins -s
    * `cd .ssh`
    * For each team, nn = 01 to 10
      * `ssh-keygen -t rsa -f jenkins_for_ftp..`
    * Create 10 credentials in jenkins with names such as 'jenkins_for_ftpnn',
      * Kind: "SSH Username with private key"
      * Username:" "jenkins_for_ftpnn"
      * Private key: "From a file on jenkins master"; "/var/lib/jenkins/.ssh/jenkins_for_ftpnn"
  * Create Git repository for the 10 teams
    * Make sure that ftp-fork-me does not have any branches
    * Go to github.com
      * delete any existing repositories: ftp01 to ftp10
      * create a repository for each team : ftp01 to ftp10
      * Add FTP-Admins as a group w/ R/W access to these repositories
    * `git clone --bare git@github.com:HexaInnovLab/ftp-fork-me.git ftpxx`
    * `cd ftpxx`
    * For each team, nn = 01 to 10
      * `find . -type f -not -path '*/\.*' -exec sed -i '' -e 's/ftpxx/ftp01/g' {} \;'`
      * `git push --mirror git@github.com:HexaInnovLab/ftpnn.git`
    * Add the .pub key from jenkins home/.ssh directory for this team as the repository's deploy key
    * Add each team member to the team's git repository
  * Create Scrum teams corresponding to the 10 teams
    * Add each team member to the team's Jira group    
  * Jenkins jobs - 3 per team
    * FTPXX-10-UNIT
    * FTPXX-30-INTEGRATION
    * FTPXX-50-STAGING
    * For each team, nn = 01 to 10
      * Create a tab FTP<nn>
      * Create New Item, for stage = 10-UNIT, 30-INTEGRATION, and 50-STAGING
        * Free Style Project
        * Copy from FTP<nn>-<stage>, "Add to current view" checked
        * Change all xx to <nn> in the job fields  
  * Databases - 3 per team
    * DEV, Integration and Staging instances
    * `CREATE DATABASE FTPXX;` -- XX from 01 to 10

----- To be reviewed ---------

## Setup Jira

The users are added by invite: Site Administration/User Management. Use the hexaware email address, the UI already selects the hexawareid as the username.

Create a "FTP" group and add all the users from the ftp program.

Create a project, with shared configuration w/ StationMaster. Create a scrum board, fix the swimlanes and filters, and create the epics. Give developer access to FTP group.
