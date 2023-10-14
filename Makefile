
docker-build:
	docker build -t eshurupov/em23-2gis-routes-adapter:1.0 -t eshurupov/em23-2gis-routes-adapter:latest .

docker-login:
	docker login

docker-push:
	docker push --all-tags eshurupov/em23-2gis-routes-adapter

docker-build-push: docker-build docker-push

build:
	./mvnw clean package -DskipTests

docker-fast-build: build
	docker build -f DockerfileFast -t eshurupov/em23-2gis-routes-adapter:1.0 -t eshurupov/em23-2gis-routes-adapter:latest .

docker-fast-build-push: docker-fast-build docker-push