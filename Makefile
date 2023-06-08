APP_IMAGE_LIST ?= auth-service gateway-service kafka-producer kafka-consumer lesson-service cache-redis-db zookeeper broker

start : down remove up

down :
	docker compose down

remove :
	docker image rm -f ${APP_IMAGE_LIST}

up:
	docker compose up -d

build:
	docker compose build

restart: down up

env:
	cp .env.example .env
	nano .env