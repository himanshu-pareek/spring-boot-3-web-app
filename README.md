# Building Web Applications in Java with Spring Boot 3

## Roadmap

1. Module 1 - Introduction
2. Module 2 - Creating a Project
3. Module 3 - Creating REST APIs
4. Module 4 - Connecting to Database
5. Module 5 - REST Client
6. Module 6 - Testing

---

## Module 1 - Introduction

- Who am I?
- Outcomes
- Prerequisites
- What / Why is Spring?
- Resources

### Who am I?

Himanshu Pareek\
Software Engineer @[Indihood](https://www.indihood.com/)\
[LinkedIn](https://linkedin.com/in/himanshu-pareek)\
[Github](https://github.com/himanshu-pareek)\
[Youtube](https://youtube.com/@java-rush)

### Outcomes
- Learn Spring
	- What is Spring?
	- What can it do?
	- What is Spring Boot?
	- How to build a web application using Spring Boot?
	- How to use Spring Data to interact with database?
	- How to test Spring Boot application?
- What are we going to build?
	- A system to manage orders.

### Prerequisites

- Java Fundamentals (Beginner - Intermediate)
- JDK 17
	- Check using `java --version`
- Java Build Tools (maven / grale) - Installation not needed
- IDE / Text Editor
	- [IntelliJ IDEA](https://www.jetbrains.com/idea/download) (Community / Ultimate)
	- [Spring Tools](https://spring.io/tools) for
		- Visual Studio Code
		- Eclipse
- API Testing Tool
	- [Postman](https://www.postman.com/)
	- [HTTP Client](https://www.jetbrains.com/help/idea/http-client-in-product-code-editor.html) (IntelliJ IDEA Ultimate)
	- [cURL](https://curl.se/)
- [Docker](https://www.docker.com/)
	- To install database (Can be installed on host machine as well)

### What / Why is Spring?

- [Spring | What](https://spring.io/)
- [Spring | Why](https://spring.io/why-spring)

### Resources

- [JavaRush youtube channel](https://www.youtube.com/@java-rush)
- [Spring Academy](https://spring.academy/)
- [Spring | Learn](https://spring.io/learn)

---

## Module 2 - Creating a Project

- How to create Spring Boot project?
- How to run application?
- How to organize code?
- How to create **Model**?
- How to log?

### How to create Spring Boot project?

[Spring Initializr](https://start.spring.io/)

- Build tool - Anything is fine
- Language - Java
- Spring Boot version - 
- Group - Reverse domain of you company's website
	- `example.com` --> `com.example`
- Artifact - Project name
- Packaging
	- Jar (Server included)
	- War (Needs separate server)
- Java Version - `17`
- Dependencies
	- Libraries, the project depends on
	- Don't need to define everything in advance
	- Can add later
	- Spring Web

### How to run application?

- Using **Run button** in IDE
	- From toolbar
	- From class
	- From main method
- Using **mvn**
	- `./mvnw spring-boot:run`
- Using **gradle**
	- `./gradlew bootRun`

### How to organize Code?

Layers

- Model (POJO)
- Repository (Database)
- Service (Business Logic)
- Controller (Handle requests)

Features

- User related
- Order related

#### Organize Code using Layers ⚠️

`main-package`\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
|\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
|--------- `model`\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|--------- `User.java`\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|--------- `Order.java`\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
|\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
|--------- `repository`\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|--------- `UserRepository.java`\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|--------- `OrderRepository.java`\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
|\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
|--------- `service`\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|--------- `UserService.java`\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|--------- `OrderService.java`\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
|\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
|--------- `controller`\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|--------- `UserController.java`\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|--------- `OrderController.java`

#### Organize code using features ✅

`main-package`\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
|--------- `user`\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|--------- `User.java`\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|--------- `UserRepository.java`\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|--------- `UserService.java`\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|--------- `UserController.java`\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
|--------- `order`\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|--------- `Order.java`\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|--------- `OrderRepository.java`\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|--------- `OrderService.java`\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|--------- `OrderController.java`

### How to create a **Model** class

- Plain Old Java Object (POJO)
- `main-package` > `order` > `Order.java`

### How to log?

- Preconfigured for us 🥳

---

## Module 3 - Creating REST APIs

Spring MVC (Model - View - Controller)

1. Spring MVC
2. Dependency Injection
3. Annotations
4. Request Methods
5. Error Handling
6. Data Validation
7. Configuration

### Spring MVC

#### Model - View - Controller

**Model** - Data (Java object / database record)\
**View** - What the user sees (`HTML` / `JSON`)\
**Controller** - Handles request (`Controller` / `RestController`)

### Dependency Injection

- Spring manages dependencies
- Inversion of Control (IoC)
- Spring IoC Container / Application Context
- [ApplicationContext](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ApplicationContext.html)
- [Spring Core Playlist @java-rush](https://youtube.com/playlist?list=PLbk-lC-jmHehc5n-tDePYVsswcokpHTYP&si=KdGDphK6FelFzxot)

### Annotations

- `@Component`
- `@Repository` - Database specific
- `@Service` - Business logic
- `@Controller` - Request Handling
- `@RestController` - `@Controller` for REST APIs

### Request Methods

**CRUD** - Create - Read - Update - Delete 

- `GET` - Query something, no modifications
- `POST` - Insert something
- `PUT` - Replaces something
- `PATCH` - Modifies something
- `DELETE` - Delete something

### Error Handling

Custom Exception - `MyException`

- `@Controller` -> `@ControllerAdvice`
- `@RestController` -> `@RestControllerAdvice`

### Data Validation

- Write by yourself
- `sprint-boot-starter-validation`
- Mix both

### Configuration

- `application.properties`
- `application.yml`

---

## Module 4 - Connecting to database

- H2 database (in memory db)
- Initialize Schema
- Options
- Load data
- Postgres Database

### H2 Database

- In memory embedded database
- Enable h2-console at `/h2-console`
	`spring.h2.console.enabled=true`
- Configure database properties

### Initialize Schema

- `resources/schema.sql`

### Options

- `Connections`, `Statement`, `PreparedStatement`, ... 🤯
- `JdbcTemplate`
- `JdbcClient` 🥳

### JdbcClient

```java
jdbcClient.sql("SQL here")
	.params()
	.update();
```

### Load data

- Put code in `CommandLineRunner` bean
- `data.sql`
- Read `JSON` file

### Postgres Database

- In **container** using **docker**
  
	- [Read here](https://www.docker.com/blog/how-to-use-the-postgres-docker-official-image/)
	- `docker-compose.yaml`
    - `docker-compose up -d`
- On host machine
	
	- [Download Postgres](https://www.postgresql.org/)
    - Install it
- `spring.sql.init.mode=always`
