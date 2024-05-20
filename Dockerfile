# usar una imagen base de alpine con openjdk 17
# se elige alpine por ser una imagen ligera y con menos vulnerabilidades
FROM openjdk:17-jdk-slim

#establecer el directorion de trabajo
WORKDIR /app

#copiar el jar generado en la carpeta target a la imagen
#preferir a ADD por ser mas seguro
# COPY target/*.jar app.jar

ENV SPRING_PROFILES_ACTIVE=prod

HEALTHCHECK --interval=30s --timeout=10s --start-period=10s --retries=3 \
    CMD curl -f http://localhost:8080/actuator/health || exit 1

#exponer el puerto 8080
EXPOSE 8080

#ejecutar la aplicacion
#preferir ENTRYPOINT por ser mas seguro
# ENTRYPOINT [ "java", "-jar", "target/dockerbasics-0.0.1.jar" ]
ENTRYPOINT ["./mvnw", "spring-boot:run"]
