#!/bin/bash
cd /home/ec2-user
echo "Servers are starting" >> /home/ec2-user/ballesLog.txt
cd /home/ec2-user/acquirer/tools/
service ipsidy-startup-acq start
service ipsidy-startup-pay start
