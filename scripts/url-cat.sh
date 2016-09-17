#!/usr/bin/env bash
#set classpath where jar has been created
#export HADOOP_CLASSPATH=../target/hadoopLearning-1.0-SNAPSHOT.jar
export HADOOP_CLASSPATH=/Users/neetikasrivastava/project/hadoop/target/hadoopLearning-1.0-SNAPSHOT.jar
hadoop URLCat "hdfs://localhost/user/neetikasrivastava/Text.txt";
hadoop FileSystemCat "hdfs://localhost:9000//MYDir/ABC.txt"