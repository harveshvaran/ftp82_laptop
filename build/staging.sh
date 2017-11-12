#!/bin/bash -ex
/usr/local/bin/aws s3 cp s3://com.hexaware.builds.ftp/$TAR_FILE $TAR_FILE
tar -xvzf $TAR_FILE
#deploy
scp -i ~/.ssh/ftp_jenkins.pem ftpxx.war centos@$STAGING_HOST:/home/centos/apache-tomcat-8.5.23/webapps
#database
mysql --host ftp-staging.c1jpaaszplju.us-east-1.rds.amazonaws.com -u FTPXX -pFTPXX FTPXX < database.ddl
mysql --host ftp-staging.c1jpaaszplju.us-east-1.rds.amazonaws.com -u FTPXX -pFTPXX FTPXX < database.dml
#rest tests
rm -rf restservice
mkdir -p restservice/integration-test/src/test/java
cd restservice/integration-test/src/test/java
jar -xvf ../../../../../ftpxx-integration-tests-1.0-test-sources.jar
cd ../../../
cp ./src/test/java/META-INF/maven/com.hexa/ftpxx-integration-tests/pom.xml .
/var/lib/jenkins/apache-maven-3.5.2/bin/mvn test -Dservice.host=$STAGING_HOST -Dservice.webapp=ftpxx
#protractor tests
cd ../..
tar -xvzf lm-app.zip
cd lm-app
./node_modules/protractor/bin/protractor --baseUrl "http://$STAGING_HOST:8080/"