# FROM openjdk:17-jdk-slim
# WORKDIR /app
# COPY target/*.jar app.jar
# RUN mkdir -p /app/logs 
# ENV SPRING_PROFILES_ACTIVE=prod
# HEALTHCHECK --interval=30s --timeout=10s --start-period=10s --retries=3 \
#     CMD curl -f http://localhost:8080/actuator/health || exit 1
# EXPOSE 8080
# ENTRYPOINT [ "java", "-jar", "target/dockerbasics-0.0.1.jar" ]
# ENTRYPOINT ["./mvnw", "spring-boot:run"]
# ENTRYPOINT [ "java", "-jar", "app.jar"]


## multistage option below

FROM maven:3.8.3-openjdk-17-slim AS builder
VOLUME /app/logs
VOLUME /app/data
WORKDIR /usr/src/app
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app

RUN ls -la /usr/src/app/src
RUN mvn clean install -DskipTests

FROM openjdk:17-jdk-slim
COPY --from=builder /usr/src/app/target/dockerbasics-0.0.1.jar /usr/app/myapp.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "/usr/app/myapp.jar"]