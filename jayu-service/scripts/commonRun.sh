#!/bin/bash

echo "happy Server Run"

JAVA_OPTS="-XX:MaxMetaspaceSize=512m -XX:+UseG1GC -Xss512k -Xms512m -Xmx512m -Dfile.encoding=UTF-8"
PORT=8888
PROJECT=../bin/common-0.0.1-SNAPSHOT.jar
PROFILE=local

runPid=$(pgrep -f $PROJECT)
if [ -z $runPid ]; then
  echo "No servers are running"
fi

runPortCount=$(ps -ef | grep $PROJECT | grep -v grep | grep $PORT | wc -l)
if [ $runPortCount -gt 0 ]; then
  kill -TERM $runPid
  echo "kill $runPid"
fi
echo "Server $PORT Starting..."
java -jar -Duser.timezone=Asia/Seoul -Dserver.port=$PORT -Dspring.profiles.active=$PROFILE $JAVA_OPTS $PROJECT

