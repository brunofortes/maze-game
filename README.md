# Maze Game

Is a sample project using Spring MVC, JPA, JUnit/Mockito, with Thymeleaf, Bootstrap, jQuery at front-end and PostgreSQL database. Is a simple maze game showing some concepts like: TDD, Spring framework, JPA, database connection with PostgreSQL, Bootstrap framework and Ajax call.

## Prerequisites

* JDK 8
* Maven 3
* PostgreSQL 9

## Installing

* Clone this repository
* Create a PostgreSQL database using ```database``` folder scripts
* ```database``` folder also contains scripts to create some sample mazes, generated with [Maze generation - Rosetta Code](https://rosettacode.org/wiki/Maze_generation#Java)
* Alter file ```persistence-pgsql.properties``` with created database properties
* Deploy the application to JBoss WildFly
* Test by accessing: http://localhost:8080/maze-0.0.1/

## Built With

* [Maven](https://maven.apache.org/)
* [Spring MVC Quickstart Maven Archetype](https://github.com/brunofortes/spring-mvc-quickstart-archetype)
* [Spring MVC](http://spring.io/)
* [Bootstrap](/https://getbootstrap.com/)
* [Maze generation - Rosetta Code](https://rosettacode.org/wiki/Maze_generation#Java)

## License

This project is licensed under the MIT License.
