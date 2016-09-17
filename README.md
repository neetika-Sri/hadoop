
## Install Hadoop

STEP 1: First Install HomeBrew, download it from http://brew.sh  
$ ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"  

STEP 2: Install Hadoop
   
$ brew install hadoop  
Hadoop will be installed at path /usr/local/Cellar/hadoop  

STEP 3: SET JAVA_HOME and change it in hadoop_env.sh located at /usr/local/Cellar/hadoop/x.y.z/libexec/etc/hadoop

STEP 4: SET HADOOP_HOME and add in PATH in .bashrc or .bash_profile  
    % export HADOOP_HOME=/usr/local/Cellar/hadoop/x.y.z  
    % export PATH=$PATH:$HADOOP_HOME/bin:$HADOOP_HOME/sbin  
    
    

    
## Building

To build the code, you will first need to have installed Maven and Java. Then type  

```bash
% mvn package -DskipTests
```

## Running  

open scripts/<script-name>sh and set jar path and target folder . If your maven output folder is target folder, No need to change the script

```bash
cd scripts
<script>.sh
```

part-r-000000 file will be created in target/output folder  

1949	111  
1950	22  

## Scripts 

 Run relevant classes script to see output

| ClassName| ScriptName|
| ---------| ----------|
| MaximumTemperature| run-map-reducer.sh|
| MaximumTemperatureWithCombiner| run-map-reduce.sh|
| Ruby map-reduce| run-ruby-map-reduce.sh|
    
    
    
## HDFS - Hadoop Distributed File System
 
###  Configuration for PseudoDistributed Mode
 
 * set HADOOP_CONF_DIR in .bashrc or .bash_profile
 
 export HADOOP_CONF_DIR=*path to the project*/conf
 
 * configure ssh
 
 **On Linux**
 
 ```bash
 
    sudo apt-get install ssh 
    
 ```
 
 **On Mac** -
 
 make sure Remote Login (under System Preferences→Sharing) is enabled for the current user (or all users)
  
Then, to enable password-less login, generate a new SSH key with an empty passphrase:

```bash
 
% ssh-keygen -t rsa -P '' -f ~/.ssh/id_rsa
% cat ~/.ssh/id_rsa.pub >> ~/.ssh/authorized_keys  

 ```
 
 **Run SSH**
 
 ```bash
  
 % ssh localhost
 exit
 
 
  ```
  
  
**copy xmls in conf folder to $HADOOP_HOME/libexec/etc/conf**

**Formatting the HDFS filesystem - while running HDFS Node First Time** 

 ```bash
  
 % hdfs namenode -format
 
  ```
  
### Start HDFS Daemon  
 
  ```bash
   
  % start-dfs.sh 
  % start-yarn.sh 
  
  
   ```