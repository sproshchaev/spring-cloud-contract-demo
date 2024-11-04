[![Java](https://img.shields.io/badge/Java-E43222??style=for-the-badge&logo=openjdk&logoColor=FFFFFF)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-FFFFFF??style=for-the-badge&logo=Spring)](https://spring.io/projects/spring-boot/)

# spring-cloud-contract-demo

### Server
```txt
1) pom.xml
  - properties: <spring-cloud.version>2023.0.3</spring-cloud.version>
  - properties: <spring.boot.version>3.3.5</spring.boot.version>
  - dependency: spring-boot-starter-web
  - dependency: spring-boot-starter-test
  - dependency: spring-cloud-starter-contract-verifier
  
  - dependencyManagement: spring-cloud-dependencies
  - build, plugins: spring-cloud-contract-maven-plugin
  - build, plugins: spring-boot-maven-plugin 

2) ServerApplication.java
3) main\..\application.properties
4) BaseClass.java
5) pom.xml: <baseClassForTests>com.prosoft.server.contract.BaseClass</baseClassForTests>
6) test\..\resources\contracts\hello.groovy  
7) запустить сервер, проверить GET http://localhost:8080/hello  
8) (server-Lifecycle) mvn install  
9) проверить stub в локальном репо: .m2\repository\com\prosoft\server\1.0-SNAPSHOT\server-1.0-SNAPSHOT-stubs.jar  
```

Аналогичный контракт для Spring Cloud Contract в формате YAML:
```YAML
description: "should return hello"
request:
  method: GET
  url: "/hello"
response:
  status: 200
  body: "Hello!"
```
В формате JSON:
```json
{
  "description": "should return hello",
  "request": {
    "method": "GET",
    "url": "/hello"
  },
  "response": {
    "status": 200,
    "body": "Hello!"
  }
}
```

### Client
```txt
1) pom.xml
  - properties: <spring.boot.version>3.3.5</spring.boot.version>
  - dependency: spring-boot-starter-web
  - dependency: spring-boot-starter-test
  - dependency: spring-cloud-starter-contract-stub-runner
  - build, plugins: spring-boot-maven-plugin
2) main\..\application.properties 
3) RestTemplateConfig.java  
4) HelloService.java  
5) ContractIntegrationTest.java  
6) Запустить интеграционный тест:
   - через ContractIntegrationTest.java
   - или (client-Lifecycle) mvn test  
```



### References 

`1.` Spring Cloud Contract https://spring.io/projects/spring-cloud-contract
`2.` Better Integration Testing With Spring Cloud Contract https://developer.okta.com/blog/2022/02/01/spring-cloud-contract  

