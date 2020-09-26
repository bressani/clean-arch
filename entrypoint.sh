#!/bin/bash

java -server \
  ${JAVA_OPTS} \
  -XX:+ScavengeBeforeFullGC \
  -Dspring.profiles.active=${SPRING_PROFILE} \
  -jar /app/clean-arch.jar
