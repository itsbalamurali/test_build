#!/bin/bash
instanceId=$(curl http://169.254.169.254/latest/meta-data/instance-id)
cd /home/ec2-user
sudo echo "Backing up" >> /home/ec2-user/ballesLog.txt
cd /home/ec2-user/
latest_backup=acquirer_latest.tar.gz
tar -zcvhf $latest_backup acquirer/
#date_current=`date -u +%Y-%m-%d`
#echo "Today's date is $date_current" >> /home/ec2-user/ballesLog.txt
sudo echo "Backing up $latest_backup to S3" >> /home/ec2-user/ballesLog.txt
aws s3 cp $latest_backup s3://ipsidy-latest-backups/acquirer/$instanceId/
sudo echo "Backed up" >> /home/ec2-user/ballesLog.txt
# deleting old logs
#rm /home/ec2-user/acquirer/gateway/logs/*
#rm /home/ec2-user/acquirer/paygate/logs/*
