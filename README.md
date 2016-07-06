
## Install Hadoop

STEP 1: First Install HomeBrew, download it from http://brew.sh
$ ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"

STEP 2: Install Hadoop
$ brew install hadoop
Hadoop will be installed at path /usr/local/Cellar/hadoop

STEP 3: SET JAVA_HOME

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
    
    
    