#!/bin/bash

docker-compose -f mongodb-replicaset.yml down
docker-compose -f all-dependencies.yml down
