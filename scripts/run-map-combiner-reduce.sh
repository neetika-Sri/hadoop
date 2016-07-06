#!/usr/bin/env bash
#set classpath where jar has been created
export HADOOP_CLASSPATH=../target/hadoopLearning-1.0-SNAPSHOT.jar
hadoop MaximumTemperatureWithCombiner ../src/main/resources/input/sample.txt ../target/output