############################################################
# Dockerfile to run Java
# Based on Ubuntu Image
############################################################

# Set the base image to use to Ubuntu
# FROM ubuntu:19.04

# OpenJDK JRE
#FROM openjdk:8
#FROM adoptopenjdk/openjdk8:alpine-slim
FROM openjdk:11-jre-slim

#FROM tomcat:8.0.51-jre8-alpine

# Set the file maintainer (your name - the file's author)
MAINTAINER Dinesh

# copy WAR into image
COPY target/db-h2-service-1.0.0.jar /db-h2-service.jar

# run application with this command line 
CMD ["java", "-jar", "-Dspring.profiles.active=default", "/db-h2-service.jar"]

#RUN rm -rf /usr/local/tomcat/webapps/*

#COPY db-h2-service/target/db-h2-service-1.0.0.jar /usr/local/tomcat/webapps/db-h2-service.jar

#CMD ["catalina.sh","run"]
