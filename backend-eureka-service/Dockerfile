############################################################
# Dockerfile to run Java
# Based on Ubuntu Image
############################################################

# Set the base image to use to Ubuntu
# FROM ubuntu:19.04

# OpenJDK JRE
FROM openjdk:8
EXPOSE 8761
#FROM tomcat:8.0.51-jre8-alpine

# Set the file maintainer (your name - the file's author)
MAINTAINER Dinesh

# copy WAR into image
COPY backend-eureka-service/target/backend-eureka-service-1.0.0.jar /backend-eureka-service.jar

# run application with this command line 
CMD ["java", "-jar", "-Dspring.profiles.active=default", "/backend-eureka-service.jar"]

#RUN rm -rf /usr/local/tomcat/webapps/*

#COPY backend-department-service/target/backend-eureka-service-1.0.0.jar /usr/local/tomcat/webapps/backend-eureka-service.jar

#CMD ["catalina.sh","run"]
