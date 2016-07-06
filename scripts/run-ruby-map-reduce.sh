#!/usr/bin/env bash
#The hadoop command doesn’t support a Streaming option;
# instead, you specify the Streaming JAR file along with the jar option.
# Options to the Streaming program specify the input and output paths and the map and reduce scripts.
hadoop jar $HADOOP_HOME/libexec/share/hadoop/tools/lib/hadoop-streaming-*.jar \
-input ../src/main/resources/input/sample.txt \
-output ../target/output_ruby \
-mapper ../src/main/ruby/max_temperature_map.rb \
-combiner ../src/main/ruby/max_temperature_reduce.rb \
-reducer ../src/main/ruby/max_temperature_reduce.rb

