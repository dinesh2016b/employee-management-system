# OpenJDK JRE
#FROM openjdk:8
#FROM adoptopenjdk/openjdk11:alpine-jre
FROM openjdk:11-jre-slim

# Set the file maintainer (your name - the file's author)
MAINTAINER Dinesh

# copy WAR into image
COPY backend-config-server/target/backend-config-server-1.0.0.jar backend-config-server.jar

# run application with this command line 
CMD ["java", "-jar", "-Dspring.profiles.active=cloud", "backend-config-server.jar"]