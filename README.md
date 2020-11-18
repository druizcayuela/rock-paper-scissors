[![CircleCI](https://circleci.com/gh/druizcayuela/rock-paper-scissors.svg?style=svg)](https://circleci.com/gh/druizcayuela/rock-paper-scissors)
[![codecov](https://codecov.io/gh/druizcayuela/rock-paper-scissors/branch/main/graph/badge.svg)](https://codecov.io/gh/druizcayuela/rock-paper-scissors)

# ROCK-PAPER-SCISSORS Rest Application
ROCK-PAPER-SCISSORS is a Spring Framework 5 MVC Rest Application. It's going to be the provider for the following Web App: https://github.com/druizcayuela/rock-paper-scissors-web


### Tech

It uses a number of open source projects to work properly:

* [SpringBoot](https://spring.io/projects/spring-boot) - Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".
* [Lombok](https://projectlombok.org/) - Project Lombok is a java library that automatically plugs into your editor and build tools, spicing up your java.
* [Mapstruct](https://mapstruct.org/) - MapStruct is a code generator that greatly simplifies the implementation of mappings between Java bean types based on a convention over configuration approach.
* [Swagger](https://swagger.io/) - To document our Endpoint API.
* [Maven](https://maven.apache.org/) - Apache tool for project managment.
* [Jacoco](https://mvnrepository.com/artifact/org.jacoco/jacoco-maven-plugin) - The JaCoCo Maven Plugin provides the JaCoCo runtime agent to your tests and allows basic report creation.
* [Codecov](https://codecov.io/) - To provide coverage in oir CI
* [CircleCI](https://circleci.com/) - CI system for our application.


### Testing

Testing is done with:

* [JUnit](https://junit.org/junit4/) - JUnit is a simple framework to write repeatable tests.
* [Mockito](https://site.mockito.org/) - Tasty mocking framework for unit tests in Java
* [SpringTesting](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing) - Unit test with Spring


### Build Configuration

This project was bootstrapped with [SpringBoot](https://spring.io/projects/spring-boot).


### Installation

It requires JDK 1.8 or later, Maven 3.2+ and your favourite IDE (IntelliJ IDEA in my case).

Install the dependencies and devDependencies

```sh
$ git clone https://github.com/druizcayuela/rock-paper-scissors.git
$ cd repo
$ mvn clean install
```

### Development

```sh
$ mvnw spring-boot:run
```

Open [http://localhost:8080](http://localhost:8080) to view it in the browser.

#### API Doc


http://localhost:8080/swagger-ui.html


#### Building for source

This web is also released into Heroku:

https://fast-basin-04721.herokuapp.com/
