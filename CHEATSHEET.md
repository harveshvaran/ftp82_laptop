# git

## repository actions

### clone
  * ```git clone git@github.com:HexaInnovLab/ftp-xx.git```

##

# maven

## check style
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
