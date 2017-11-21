# git

## repository actions

### clone
  * ```git clone git@github.com:HexaInnovLab/ftpxx.git```

### reset

## checkout/branch

## stash

## file actions

  * Checkout a previous version
    * `git checkout <commit> <filename>`
  * Undo changes in staging
    * `git reset HEAD <filename>`
  * Discard changes in workspace
    * `git checkout -- <filename>`

## development cycle

### Clean up before starting

   * `git status` -- you should be on 'master' branch; and it should not show any files changed/staged etc
>       On branch master
>       Your branch is up-to-date with 'origin/master'.
>       nothing to commit, working tree clean
   * `git branch` -- it should not show any local branches
   * `git pull` -- get the latest master
     
### Create a branch

   * `git checkout -b [BranchName]`
      * See STANDARDS_AND_GUIDELINES.md for branch naming guidelines

### EDIT: Edit files as needed

### Periodically, add the file to staging area

   * `git status`
   * `git add -i` and 2/4 options to add changed/new files to staging area
   * `git status`
   * go to EDIT, if there are more changes

### Commit it to the branch
   
   * `git commit -m [message]`
   * `git status`

### Push it to origin

   * `git status` -- and check if you are on branch and not on 'master'
   * `git push origin HEAD`

### Create a pull request and get it merged

   * Go to "https://github.com/HexaInnovLab/ftpxx"
   * You may see a yellow box with your branch name, and with a button for creating a pull request.
       * If you don't see it, drop down the "Branch" dropdown, select your branch. Then click the "New Pull Request" button next to it.
   * Review your changes in the next screen. Lookout for typos, trailing whitespace etc. and fix them.
   * if there are any changes, go back to EDIT
   * Once happy, click the "Create pull request" button after correcting the description, comment etc.
   * Ask a reviewer to review the pull request.
   * The reviewer will and review your changes
       * If there are any comments needing changes to the files, go back to EDIT
   * The reviewer will merge the pull request and delete the branch

### Clean up
   
   * `git checkout master`
   * `git fetch -p`
   * `git pull`
   * `git branch -a` -- list all branches; the local branch will be there
   * `git branch -d [BranchName]`
   * `git branch -a` -- list all branches; the local branch will not be there

# maven

## check style
  * ```mvn -Dcheckstyle.consoleOutput=true checkstyle:check```
  * ```mvn checkstyle:checkstyle```
  * ```open target/site/checkstyle.html```

## Package
  * ```mvn package```

# tomcat

## Start/monitor logs

  * ```cd /path/to/apache-tomcat-9.0.0.M22```
  * ```rm -rf logs/*```
  * ```./bin/startup.sh```
  * ```tail -f logs/*```

## Deploy

  * Copy the war file to the webapps folder
    * ```cp target/<some>.war /path/to/apache-tomcat-9.0.0.M22/webapps/ftpxx.war```

# angular

  * To serve from the working directory
    * ng serve --open
  * Build
    * ng build
  * Unit Test
    * ng test
    * npm test
  * Lint/Style check
    * ng lint --type-check
  * Generate new component
    * ng g component components/{name}
  * Generate new service
    * ng g service services/{name}


# Angular/Augury

  * ng is the angular instance
  * ng.probe($0).componentInstance where $0 is the selected component in the Elements tab
