# Instructions on how to setup jenkins on an aws instance
  * Spin up an ec2 instance (TBD: elaborate these steps)
  * install some pre-requisites
    * yum install cloud-init curl dracut-modules-growroot epel-release glibc.i686 lsof nc parted python screen tcpdump telnet unzip wget zip
  * Install oracle jdk
    * install java as per https://www.digitalocean.com/community/tutorials/how-to-install-java-on-centos-and-fedora
    * `wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" "http://download.oracle.com/otn-pub/java/jdk/8u131-b11/d54c1d3a095b4ff2b6607d096fa80163/jre-8u131-linux-x64.rpm"`
    * `yum localinstall jre-8u131-linux-x64.rpm`
  
