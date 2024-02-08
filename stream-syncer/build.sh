#!/bin/bash
rm -rf build/libs
gradle bootJar
mv build/libs/* build/libs/application.jar
