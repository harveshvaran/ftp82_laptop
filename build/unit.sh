#!/bin/bash -ex
set -ex
cd restservice/leavemanager/
/var/lib/jenkins/apache-maven-3.5.2/bin/mvn package -Dbuild.number=${BUILD_NUMBER}
cd ../integration-test
/var/lib/jenkins/apache-maven-3.5.2/bin/mvn package -DskipTests
cd ../../webui/lm-app
# Here we run the jasmine test
npm install
ng lint --type-check
ng test --watch false
ng build
cp ../../restservice/leavemanager/target/ftpxx-0.0.1-${BUILD_NUMBER}.war ./ftpxx.war
cd ..
tar -cvzf lm-app.zip lm-app/*
cd lm-app/dist
jar -uvf ../ftpxx.war *
cd ../../../build
cp ../webui/lm-app/ftpxx.war .
cp ../webui/lm-app.zip .
cp ../restservice/integration-test/target/ftpxx-integration-tests-1.0-test-sources.jar .
cp ../database/database.* .
tar -cvzf ftpxx-${BUILD_NUMBER}.tar.gz ftpxx.war ftpxx-integration-tests-1.0-test-sources.jar lm-app.zip database.*
echo TAR_FILE=ftpxx-${BUILD_NUMBER}.tar.gz > build.properties
/usr/local/bin/aws s3 cp ftpxx-${BUILD_NUMBER}.tar.gz s3://com.hexaware.builds.ftp/