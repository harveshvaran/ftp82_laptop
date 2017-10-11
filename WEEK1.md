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

# Workshop material
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
    * TBD: setup ssh keys
    * create projects folder
    * `git clone git@github.com:HexaInnovLab/ftpxx.git`
    * `git status`
  * VS Code
    * Open projects/ftpxx
    * Edit a file README-<username>.md
    * `git status`
    * `git add README-<username>.md`
    * `git commit -m "<message>"`
    * `git status`
    * `git log`
    * `git log --oneline`
    * `git push origin HEAD`
    * Open https://github.com/HexaInnovLab/ftpxx
      * See the changes in 'master'
    * Edit README-<username>.md again
    * Redo the above
    * `git rm README-<username>.md`   
    * Redo the above

# Reading material

## Must-Read
  * https://en.wikipedia.org/wiki/Multitier_architecture#Three-tier_architecture

## Nice-To-Read
  * https://git-scm.com/docs

## Go-Deep
  * https://git-scm.com/book/en/v2
