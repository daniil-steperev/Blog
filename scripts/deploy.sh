#!/usr/bin/env bash

mvn clean package

echo 'Copy files...'

scp -i ~/.ssh/sweater-london.pem \
    targer/sweater-1.0-SNAPSHOT.jar \
    ec2-user@35.178.115.187:/home/ec2-user/

echo 'Restart server...'

ssh -i ~/.ssh/sweater-london.pem ec2-user@ec2-35-178-115-187.eu-west-2.compute.amazonaws.com << EOF

pgrep java | hargs kill -9
nohup java -jar sweater-1.0.SNAPSHOT.jar > log.txt &

EOF

echo 'Bye'
