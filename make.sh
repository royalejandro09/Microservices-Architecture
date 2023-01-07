cd eureka-service/
mvn clean && mvn package -DskipTests
docker build . -t eureka-service
cd ..

cd config-service/
mvn clean && mvn package -DskipTests
docker build . -t config-service
cd ..

cd api-gateway/
mvn clean && mvn package -DskipTests
docker build . -t api-gateway
cd ..

cd catalog-service/
mvn clean && mvn package -DskipTests
docker build . -t catalog-service
cd ..

cd movie-service/
mvn clean && mvn package -DskipTests
docker build . -t movie-service
cd ..

cd serie-service/
mvn clean && mvn package -DskipTests
docker build . -t serie-service
cd ..

docker-compose up