# OpenJDK JRE
FROM openjdk:8

# Set the file maintainer (your name - the file's author)
MAINTAINER Dinesh

# copy WAR into image
COPY backend-zuul-api-gateway-server/target/backend-zuul-api-gateway-server-1.0.0.jar backend-zuul-api-gateway-server.jar

# run application with this command line 
CMD ["java", "-jar", "-Dspring.profiles.active=docker", "backend-zuul-api-gateway-server.jar"]