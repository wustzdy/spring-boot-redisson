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

mvn jib:dockerBuild -DsendCredentialsOverHttp=true

docker镜像到docker hub
https://blog.csdn.net/huangdeijia/article/details/78675739


https://blog.csdn.net/boling_cavalry/article/details/94355659

mvn compile jib:build
docker load < jib-image.tar


打镜像
mvn clean compile jib:build
mvn jib:dockerBuild -DsendCredentialsOverHttp=true

或者
mvn clean compile jib:dockerBuild -U



page request:
{
"name": "zdy",
"pageRequire": {
"page": 2,
"pageSize": 10,
"orders": {
"items": [
"createdTime"
],
"ascs": [
true
]
}
}
}