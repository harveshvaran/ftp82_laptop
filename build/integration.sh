#!/bin/bash -ex
#deploy
curl --fail -T ftpxx.war "http://manager:manager@$INTEGRATION_HOST:8080/manager/text/deploy?path=/ftpxx&update=true"
#scp -i ~/.ssh/ftp_jenkins.pem ftpxx.war centos@$INTEGRATION_HOST:/home/centos/apache-tomcat-8.5.23/webapps
#database
mysql --host ftp-integration.c1jpaaszplju.us-east-1.rds.amazonaws.com -u FTPXX -pFTPXX FTPXX < database.ddl
mysql --host ftp-integration.c1jpaaszplju.us-east-1.rds.amazonaws.com -u FTPXX -pFTPXX FTPXX < database.dml
#rest tests
rm -rf restservice
mkdir -p restservice/integration-test/src/test/java
cd restservice/integration-test/src/test/java
jar -xvf ../../../../../ftpxx-integration-tests-1.0-test-sources.jar
cd ../../../
cp ./src/test/java/META-INF/maven/com.hexa/ftpxx-integration-tests/pom.xml .
#before running tests, make sure that the war file has been deployed completely
n=0
while true
do
  response=$(curl --write-out %{http_code} --silent --output /dev/null http://$INTEGRATION_HOST:8080/ftpxx/favicon.ico)
  [ $response -eq 200 ] && break
  n=$[$n+1]
  if [ $n -ge 5 ]
  then
    echo "Web app never came up; aborting..."
    exit -1
  else
    echo "Web app still not up; sleeping and retrying..."
  fi
  sleep 30
done
/var/lib/jenkins/apache-maven-3.5.2/bin/mvn test -Dservice.host=$INTEGRATION_HOST -Dservice.webapp=ftpxx
#protractor tests
cd ../..
tar -xvzf lm-app.zip
cd lm-app
./node_modules/protractor/bin/protractor --baseUrl "http://$INTEGRATION_HOST:8080/"