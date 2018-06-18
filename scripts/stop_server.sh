#!/bin/bash
cd /home/ec2-user
echo "Running servers are stopping" > /home/ec2-user/ballesLog.txt
chown ec2-user:ec2-user ballesLog.txt
isAppRunning = "pgrep java"
if [ -n  $isAppRunning ]; then
  cd /home/ec2-user/acquirer/tools/
  service ipsidy-startup-acq stop
  service ipsidy-startup-pay stop
  echo "Servers have stopped" >> /home/ec2-user/ballesLog.txt
fi
