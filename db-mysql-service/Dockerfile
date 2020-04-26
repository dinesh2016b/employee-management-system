# Derived from official mysql image (our base image)
FROM mysql:8

# Add a database
ENV MYSQL_DATABASE employees
ENV MYSQL_USER root
ENV MYSQL_PASSWORD Dinesh@123
ENV MYSQL_ROOT_PASSWORD Dinesh@123

# Add the content of the sql-scripts/ directory to your image
# All scripts in docker-entrypoint-initdb.d/ are automatically
# executed during container startup

COPY db-mysql-service/sql-scripts/ /docker-entrypoint-initdb.d/

CMD ["mysql", "-u root", "-pDinesh@123", " < /docker-entrypoint-initdb.d/employees.sql"]
