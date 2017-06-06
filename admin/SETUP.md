# This readme is for the administrators of the ftp program

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