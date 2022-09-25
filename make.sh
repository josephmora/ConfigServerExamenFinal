cd service-registry/
mvn clean && mvn package -DskipTests
docker build . -t service-registry
cd ..

cd config-service/
mvn clean && mvn package -DskipTests
docker build . -t config-service
cd ..

cd gateway-service/
mvn clean && mvn package -DskipTests
docker build . -t gateway-service

cd ..

cd movie-service/
mvn clean && mvn package -DskipTests
docker build . -t movie-service

cd .. 

