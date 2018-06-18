#!/bin/bash
cd /home/ec2-user
echo "Validating start_server" >> /home/ec2-user/ballesLog.txt
isAppRunning = "pgrep java"
if [ $isAppRunning = null]; then
  echo "Servers are NOT running" >> /home/ec2-user/ballesLog.txt
else
  echo "Servers are running" >> /home/ec2-user/ballesLog.txt
fi
