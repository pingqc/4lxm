#!/bin/bash

cd ~/tmp
if [ -d 4lxm/.git ]; then
    echo "project is alreay in version control, now exec git pull"
    cd 4lxm
    git pull origin master
else
    echo "no project found, now exec git clone"
    git clone https://github.com/pingqc/4lxm.git
    cd 4lxm
fi

# using prod application
mv src/main/resources/application.prod.properties src/main/resources/application.properties

mvn package -Dmaven.test.skip=true | tee mvn.log

build_flag=`grep -r "BUILD SUCCESS" mvn.log | wc -l`
if [ $build_flag == 1 ]; then
    echo -e "\n\nmove 4lxm.war to tomcat\n\n"
    mv target/4lxm*war ~/tomcat/webapps/4lxm.war
fi

echo -e "\n\n================DONE===================\n\n"