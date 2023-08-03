#!/usr/bin/env bash

./mvnw clean install

cd target || exit

java -jar demo-0.0.1-SNAPSHOT.jar
