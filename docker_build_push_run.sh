
echo "----------> Maven Clean,Build"
#mvn clean install

echo "----------> Docker Build"
sudo docker build -t dinesh2016b/employee-management-system:0.2 .

echo "----------> Docker images"
sudo docker images

echo "----------> Docker tag"
#sudo docker tag -t 6fc88282612a dinesh2016b/employee-management-system:0.2

echo "----------> Docker push"
#sudo docker push dinesh2016b/employee-management-system:0.2

echo "----------> Docker run"
sudo docker run -t -p 8090:8090 dinesh2016b/employee-management-system:0.2
