#!/usr/bin/env bash

cat ../../main/resources/input/sample.txt | ../../main/ruby/max_temperature_map.rb | sort| ../../main/ruby/max_temperature_reduce.rb