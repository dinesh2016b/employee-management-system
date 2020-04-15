############################################################
# Dockerfile to run Java
# Based on Ubuntu Image
############################################################

# Set the base image to use to Ubuntu
# FROM ubuntu:19.04

# OpenJDK JRE
FROM openjdk:8
EXPOSE 8091
#FROM tomcat:8.0.51-jre8-alpine

# Set the file maintainer (your name - the file's author)
MAINTAINER Dinesh

# copy WAR into image
COPY backend-department-service/target/backend-department-service-1.0.0.jar /backend-department-service.jar

# run application with this command line 
CMD ["java", "-jar", "-Dspring.profiles.active=docker", "/backend-department-service.jar"]

#RUN rm -rf /usr/local/tomcat/webapps/*

#COPY backend-department-service/target/backend-department-service-1.0.0.jar /usr/local/tomcat/webapps/backend-department-service.jar

#CMD ["catalina.sh","run"]
