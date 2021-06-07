# spring-boot-redisson
spring-boot-redisson


./mvnw spring-boot:run
./mvnw clean package
mvn clean package -Dmaven.test.skip=true


./mvnw spring-boot:run
./mvnw clean package
mvn clean package -Dmaven.test.skip=true

mvn compile jib:build -Djib.to.auth.username=bolingcavalry -Djib.to.auth.password=123456
mvn compile jib:build
docker login --username=xxxxx --password=xxxxx registry.hub.docker.com
mvn clean package appengine:run -Djava8=true 