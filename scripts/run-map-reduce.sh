#!/usr/bin/env bash
#set classpath where jar has been created
export HADOOP_CLASSPATH=../target/hadoopLearning-1.0-SNAPSHOT.jar
hadoop MaximumTemperature ../src/main/resources/input/sample.txt ../target/output