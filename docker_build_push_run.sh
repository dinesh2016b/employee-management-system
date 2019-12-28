
echo "----------> Maven Clean,Build"
mvn clean compile install

echo "----------> Docker Build"
sudo docker build -t dinesh2016b/employee-management-system:0.1 .

echo "----------> Docker images"
sudo docker images

echo "----------> Docker tag"
sudo docker tag -t dinesh2016b/employee-management-system:0.1

echo "----------> Docker push"
sudo docker push dinesh2016b/employee-management-system:0.1

echo "----------> Docker run"
sudo docker run -t -d -p 8090:8090 dinesh2016b/employee-management-system:0.1
