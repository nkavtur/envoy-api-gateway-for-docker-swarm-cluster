#!/usr/bin/env bash
cd "$(dirname "$0")"

echo "Building image front-proxy:latest ..."
cd ../front-proxy
docker build -t front-proxy:latest -f docker/Dockerfile .


echo "Building image service1:latest ..."
cd ../service1
docker build -t service1:latest -f docker/Dockerfile .


echo "Building image service2:latest ..."
cd ../service2
docker build -t service2:latest -f docker/Dockerfile .