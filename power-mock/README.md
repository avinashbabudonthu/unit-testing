# Async Controller

* Problem Statement
```
Consume 3 API asynchronously. Wrap 3 API calls response and return final response. 3 API calls run in parallel
```

## Create project using maven
```
mvn archetype:generate -DgroupId=power.mock -DartifactId=power-mock -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Add gradle
```
gradle init --type pom
```

## Versions
* Maven **3.5.2**
* Gradle **5.0**

## Steps
* Add spring boot dependencies. Refer [pom.xml](pom.xml) or [build.gradle](build.gradle)
* Create **async.controller.config.AppConfig** class. Declare annotation **org.springframework.scheduling.annotation.EnableAsync**
* Create **async.controller.service.AsyncService** class. Declare methods calling API with annotation **org.springframework.scheduling.annotation.Async**
* All async methods in service class return **java.util.concurrent.CompletableFuture**
* Create **async.controller.controller.AsyncController**. Call API consuming method in service class

## API
* Refer [files/async-controller.postman_collection.json](files/async-controller.postman_collection.json)

## Run this project
* Import project into IDE as Maven or Gradle project
* Execute App class in each package

## Run using maven
```
mvn clean compile spring-boot:run
```

## Run using gradle
```
gradlew clean compileJava bootRun
```

## Create package using maven
```
mvn clean compile package
```

## Create package using gradle
```
gradlew clean compileJava build
```

## Execute jar of Maven
```
java -jar target\async-controller.jar
```

## Execute jar of Gradle
```
java -jar build\libs\async-controller.jar
```
