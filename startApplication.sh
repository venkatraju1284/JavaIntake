#!/usr/bin/env bash
# Common functions

set -e
startTime=$(date +%s)

buildAll() {
#  subStep "Building whole application"
  local buildAllCommand="mvn clean install -DskipTests=true"
  echo "${buildAllCommand}"
  ${buildAllCommand}
}

deployAll() {
#  subStep "Deploy whole application"
  local deplyCommand="docker-compose -f ./Web/docker-compose.yaml up -d"
  echo "${deplyCommand}"
  ${deplyCommand}

  local deplyAppCommand="nohup java -jar ./Web/target/Web-1.0-SNAPSHOT.jar >/dev/null 2>&1 &&"
  echo "${deplyAppCommand}"
  ${deplyAppCommand}
}

buildAll
deployAll

