# OpenJDK JRE
#FROM openjdk:8
FROM adoptopenjdk/openjdk11:alpine-jre

# Set the file maintainer (your name - the file's author)
MAINTAINER Dinesh

# copy WAR into image
COPY /backend-department-service/target/backend-department-service-1.0.0.jar backend-department-service.jar

# run application with this command line 
CMD ["java", "-jar", "-Dspring.profiles.active=cloud", "backend-department-service.jar"]