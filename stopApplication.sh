#!/usr/bin/env bash
# Common functions

set -e
startTime=$(date +%s)

undeployAll() {
#  subStep "Deploy whole application"
  local stopCommand="docker-compose down -v "
  echo "${stopCommand}"
  cd ./Web
  ${stopCommand}
}
undeployAll
