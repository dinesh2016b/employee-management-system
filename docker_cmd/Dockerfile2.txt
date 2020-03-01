# OpenJDK JRE
FROM openjdk:8
# copy WAR into image
COPY backend/target/ems-backend-1.0.0.war /ems.war 
# run application with this command line 
CMD ["java", "-jar", "-Dspring.profiles.active=default", "/ems.war"]