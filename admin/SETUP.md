# This readme is for the administrators of the ftp program

## Pre Nov-20th

  * Sort the teams into 2 batches of 25, then into teams of 5 each
    * CS/Non-CS folks
    * Scores equally distributed
    * Gender distribution
  * Create Git repository for the 10 teams
    * Go to github.com and create a repository for each team : ftp01 to ftp10
    * `git clone --bare git@github.com:HexaInnovLab/ftp-fork-me.git ftpxx`
    * `cd ftpxx`
    * `git push --mirror git@github.com:HexaInnovLab/ftp01.git`
    * `git push --mirror git@github.com:HexaInnovLab/ftp02.git` etc.
    * Add each team member to the team's git repository
  * Create Scrum teams corresponding to the 10 teams
    * Add each team member to the team's Jira group
    

## Github
  * Create a github account for each trainee
  * Copy ftp-fork-me as ftp[nn] for each team
  * Allow only members of team nn to work on repository ftp[nn]

----- To be reviewed ---------
## Set up an AWS account

Login to the hexaware-cto aws account with root credentials, go to organizations, and "create an account". Use "krishnakumar@hexaware-ftp<teamno>@gmail.com" as the email address. Login with <aws-account-id>.signin.aws.amazon.com, and click "login with root credentials", and click "forgot password". Login to the gmail account and click on the link to set the password for the account.
Save the password in passpack.

Create a "FTP" group with EC3/S3/RDS full access.

### Create IAM users for each team member

Create IAM users with hexaware id as id, add them to the "FTP" group. Send the credentials file via email.

### Set the budget limit for the AWS Account

Some usage needed before you can set the budget.

## Setup Github



## Setup Jira

The users are added by invite: Site Administration/User Management. Use the hexaware email address, the UI already selects the hexawareid as the username.

Create a "FTP" group and add all the users from the ftp program.

Create a project, with shared configuration w/ StationMaster. Create a scrum board, fix the swimlanes and filters, and create the epics. Give developer access to FTP group.
