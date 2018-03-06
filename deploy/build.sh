#!/usr/bin/env bash
cd "$(dirname "$0")"

echo "Building image front-proxy:latest ..."
cd ../front-proxy
docker build -t front-proxy -f docker/Dockerfile .
docker tag front-proxy nkavtur/front-proxy:latest
docker push nkavtur/front-proxy:latest

echo "Building image service1:latest ..."
cd ../service1
docker build -t service1 -f docker/Dockerfile .
docker tag service1:latest nkavtur/service1:latest
docker push nkavtur/service1:latest

echo "Building image service2:latest ..."
cd ../service2
docker build -t service2 -f docker/Dockerfile .
docker tag service2 nkavtur/service2:latest
docker push nkavtur/service2:latest
