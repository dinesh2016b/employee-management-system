############################################################
# Dockerfile to run Java
# Based on Ubuntu Image
############################################################

# Set the base image to use to Ubuntu
# FROM ubuntu:19.04

# OpenJDK JRE
FROM openjdk:8
EXPOSE 8092
#FROM tomcat:8.0.51-jre8-alpine

# Set the file maintainer (your name - the file's author)
MAINTAINER Dinesh

# copy WAR into image
COPY backend-employee-service/target/backend-employee-service-1.0.0.jar /backend-employee-service.jar

# run application with this command line 
CMD ["java", "-jar", "-Dspring.profiles.active=default", "/backend-employee-service.jar"]

#RUN rm -rf /usr/local/tomcat/webapps/*

#COPY backend-employee-service/target/backend-employee-service-1.0.0.jar /usr/local/tomcat/webapps/backend-employee-service.jar

#CMD ["catalina.sh","run"]
