# Classroom material

## Structure of the program
  * Team
  * Product E2E
  * Agile/DevOps
  * Full stack
  * Cloud (little bit)

## Goals of the program
  * "Learning to learn"
    * Git, Jira, Jenkins, MySQL, SQL, JDBI, Java, Junit, Jmockit, Jersey, Maven, REST, Json, RestAssured, Javascript, HTML, CSS, Angular 4, Karma/Jasmine, Selenium
  * Productivity hacks
    * google
    * command line (+ simple IDE)
    * cheat sheets
    * bookmarks
    * check lists
    * REPL
    * tutorials
    * ...
  * Communication, teamwork, ...

## Multi-tier systems
  * Presentation, Business Logic, Persistence
    * Web, Mobile, Cli, Thick Client, ...
      * Web
        * Hybrid MVC vs Browser-side MVC
      * Mobile
        * Native vs Cross-Platform
    * Containers, REST API, EJB, ...
    * File system, RDBMS, NoSQL, BigData, DW, ...

 ## Software Development
   * Tools : source code control, ticket, IDE, build, test, execute
   * Iteration:
     * Assign to yourself
     * Checkout
     * branch
     * change
     * test
     * deploy/test
     * checkin
     * review
     * pipeline
     * close
     * delete branch   

## Unix command line basics
  * pwd
  * ls
  * 
## Source code control systems

## Git
  * workspace, staging, local, remote

## Editors, Build systems vs IDE

## Databases: concepts

## Databases: SQL/DML

# Workshop material - Day #1 - Git/VS Code
  * Setting up git
    * Open "https://github.com/HexaInnovLab" in your browser
    * Click the signup on the top-right
    * In the following instructions, <hexawareid> is the part preceding @hexaware.com in your email address
    * your username is <hexawareid>-Hexaware, e.g., krishnakumar-Hexaware
    * Use hexaware email address as the email address
    * Select your own password
    * Tell the facilitator the username just created
    * You will get mail to verify your mail address; click the link to complete the verification
    * The facilitator will add you to the hexaware github organization
    * You will get a mail inviting you to the HexaInnovLab organization. Please join the organization.
    * Follow the instructions as in https://help.github.com/articles/connecting-to-github-with-ssh/
      * Skip "Checking for existing SSH keys" as this is a fresh installation
      * Run the ssh-keygen command and save the private key in C:\users\<employeeid>\.ssh\id_rsa. *Do not* use a passphrase in step #4 - just press enter twice.
      * Skip "Adding your SSH key to the ssh-agent" section as we do not use ssh-agent
      * Follow the instructions as in "https://help.github.com/articles/adding-a-new-ssh-key-to-your-github-account/" and "https://help.github.com/articles/testing-your-ssh-connection/" and test the setup

  * Command Line/Cygwin
  * Command Line/Gitbash --  Open Gitbash
    
    * `pwd` -- Check and verify that the current working directory is C:\users\<employeeid>
    * `mkdir workspace` -- We will create a sub-directory called workspace and put all the project materials there
    * `cd workspace` -- change current working to workspace
        
  * Git (setup/checkout/clone/pull/push)
    * `git --version`
    * `git config --global -l`
    * `git config --global user.name "<your name>"`
    * `git config --global user.email <your email>`
    * `git config --global -l`
    * Open https://github.com/HexaInnovLab/ftpxx
      * look at source code organization
    * create workspace folder
    * `git clone git@github.com:HexaInnovLab/ftpxx.git`
    * `cd ftpxx`
    * `git status`
  * VS Code
    * Open c:\users\<emplpoyeeid>\workspace\ftpxx
    * Browse the directories to understand the repository structure

# Workshop material - Day #2 - MySQL Workbench

  * Open MySQL Workbench
  * Ask the facilitator for the root password for the locally installed mysql server
  * Setup a connection to localhost:3306, and use the password. You may have to change the password at this time.
  * Open the connection
  * `CREATE DATABASE FTPXX;` and click the lightning button
  * Open database/database.ddl in VS code
  * Copy the contents to Workbench
  * Execute the ddl 
  * Click the table icon against the EMPLOYEE table in the right-hand side schemas section 
  * Open database/database.dml in VS code
  * Copy the contents to Workbench
  * Execute the dml 
  * Click the table icon against the EMPLOYEE table in the right-hand side schemas section. You should see the data just inserted.
  * Play around with
    * SELECT with predicates
    * UPDATE statements with predicates
    * DELETE statements with predicates
    
  * Next, we will build and run the java code
  * `mvn exec:java -Dexec.mainClass=com.hexaware.ftpxx.util.CliMain`
      

# Reading material

## Must-Read
  * https://en.wikipedia.org/wiki/Multitier_architecture#Three-tier_architecture

## Nice-To-Read
  * https://git-scm.com/docs

## Go-Deep
  * https://git-scm.com/book/en/v2
