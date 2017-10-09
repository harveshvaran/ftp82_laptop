# Classroom material

## Structure of the program
  * Team
  * Product E2E
  * Agile/DevOps
  * Full stack
  * Cloud (little bit)

## Goals of the program
  * "Learning to learn"
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

## Source code control systems

## Git
  * workspace, staging, local, remote


## IDE

# Workshop material

  * Command Line/Cygwin
  * Command Line/Gitbash
  * Git (setup/checkout/clone/pull/push)
    * `git --version`
    * `git config --global -l`
    * `git config --global user.name "<your name>"`
    * `git config --global user.email <your email>`
    * `git config --global -l`
    * Open https://github.com/HexaInnovLab/ftp[nn]
      * look at source code organization
    * TBD: setup ssh keys
    * create projects folder
    * `git clone git@github.com:HexaInnovLab/ftp[nn].git`
    * `git status`
  * VS Code
    * Open projects/ftp[nn]
    * Edit a file README-<username>.md
    * `git status`
    * `git add README-<username>.md`
    * `git commit -m "<message>"`
    * `git status`
    * `git log`
    * `git log --oneline`
    * `git push origin HEAD`
    * Open https://github.com/HexaInnovLab/ftp[nn]
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
