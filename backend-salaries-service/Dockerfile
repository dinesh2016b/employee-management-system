# OpenJDK JRE
FROM openjdk:8

# Set the file maintainer (your name - the file's author)
MAINTAINER Dinesh

# copy WAR into image
COPY backend-salaries-service/target/backend-salaries-service-1.0.0.jar backend-salaries-service.jar

# run application with this command line 
CMD ["java", "-jar", "-Dspring.profiles.active=cloud", "backend-salaries-service.jar"]