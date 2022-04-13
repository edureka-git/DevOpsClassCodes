#!/bin/bash
if [ $# -eq 0 ]
  then
    echo "No hostname supplied"
    exit
fi
env=$1
echo $env
hostname=ip-172-31-45-105.ap-south-1.compute.internal
apt-get update -y
apt-get upgrade -y
wget http://apt.puppetlabs.com/puppetlabs-release-trusty.deb
dpkg -i puppetlabs-release-trusty.deb
apt-get update -y
apt-get -y install puppetmaster
sed -i "s/$hostname/$env/g" /etc/hostname
sed -i "s/no/yes/g"  /etc/default/puppetmaster
echo "172.31.32.117  ip-172-31-32-117.ap-south-1.compute.internal    puppet" >>  /etc/hosts
echo "172.31.45.105  ip-172-31-45-105.ap-south-1.compute.internal    puppet" >>  /etc/hosts
reboot
