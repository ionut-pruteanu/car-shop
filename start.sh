#!/usr/bin/env sh

set -e

./mvnw clean install

docker-compose build
docker-compose up

echo "The application is available on: http://localhost:8080"
