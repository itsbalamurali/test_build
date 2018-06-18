#!/bin/bash
latest_release=acquirer.tar.gz
sudo yum update -y
cd /home/ec2-user/
#unzip $latest_release
tar -zxvhf $latest_release
sudo echo "$latest_release has been installed" >> /home/ec2-user/ballesLog.txt
rm $latest_release
