## DOCKER

<br/>

1. Building a docker image
    1. Write a Dockerfile
    2. Build a docker image  
2. Running containers
    1. Running and stopping containers
    2. Exposing ports and 
    3. Mouting volumens for data persistence
    4. Env variables and configuration
3. Containers management
    1. Running containers
    2. Inspect containers
    3. Delete containers and images
4. Docker compose
    1. docker-compose.yml
    2. Running apps with DC
5. Optimization and best practices
    1. Reduce the container size
    2. Dockerfile layers
    3. Security
6. CI/CD 
    1. Integrate Docker in CI/CD pipelines
    2. Integrate Docker with Github Actions
7. Networking in Docker
    1. Communication among containers
8. Docker Swarm and Kubernetes
    1. Osquestating with Docker Swarm
    2. Kubernetes for advanced orchestration
9. Docker on production
    1. Deployment strategies
    2. Logging and monitoring containers
<br /><br /><br />
 ___ 


#### 1. Building a docker image

* Having a ***Dockerfile*** is mandatory

```bash
./mvnw clean package
```
```bash
docker build -t demo-springboot-docker .
```

#### 2. Running containers 
#### 2.1 Running and stopping containers

```bash
docker run -p 8080:8080 demo-springboot-docker
```

* Stop and delete docker container

```
docker ps -a
docker stop <container id>
docker rm <container id>
```

* Stop and delete docker images

```shell
docker images
docker rmi <image_id>
```

### Running the docker container in sync with code changes
---
<br />
* We are going to mount the volumen where source code will be left. 
* We will need to add the devtools dependency

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-devtools</artifactId>
	<optional>true</optional>
</dependency>
```        

* We will need to ask spring boot to consider reloading the app 

```properties
spring.devtools.restart.enabled=true
spring.devtools.livereload.enabled=true
```

0. The Dockerfile should avoid using COPY and instead of using java -jar we will use sprint boot command:

``` Dockerfile
FROM ...
WORKDIR ...
EXPOSE ...
ENTRYPOINT ["./mvnw", "spring-boot:run"]
```

1. Initial build is mandatory, it will happen just once

```shell
docker build -t demo-springboot-docker .
```


2. Run the docker container with the mounted volumen

```shell
docker run -p 8080:8080 -v $(pwd):/app demo-springboot-docker
```
