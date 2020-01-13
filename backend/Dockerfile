############################################################
# Dockerfile to run Java
# Based on Ubuntu Image
############################################################

# Set the base image to use to Ubuntu
# FROM ubuntu:19.04

# OpenJDK JRE
FROM openjdk:8

# Set the file maintainer (your name - the file's author)
MAINTAINER Dinesh

# copy WAR into image
COPY backend/target/ems-backend-1.0.0.war /ems.war

# run application with this command line 
CMD ["java", "-jar", "-Dspring.profiles.active=default", "/ems.war"]