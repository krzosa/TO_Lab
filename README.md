# Project for the Object Technologies class
Calculator turned into a webapp with login page, action logging(to the 
database) and layout created using Thymeleaf and Bootstrap.
## Technologies
* [Spring-Boot](https://spring.io/projects/spring-boot)
* [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html)
* [Spring data JPA](https://spring.io/projects/spring-data-jpa)
* [H2 Database](https://en.wikipedia.org/wiki/H2_(DBMS))
* [Bootstrap](https://getbootstrap.com/)
* [Thymeleaf](https://www.thymeleaf.org/)

## A bit of history
It first started as a parent maven project with 3 sub modules: common, interface, implementation. 
Common is where main is so it's the starting point of the program. 
Interface contains interfaces of the initial program. 
Implmentation contains implementations of those interfaces.
We also had to create our own classloader that would load classes 
outside of the project which sadly brings a lot of file pathing problems.

Then I used Spring framework to turn this application into a webapp(webapp module) which took me a 
looooong time to figure out how to do. Lastly I added logging using Hibernate and H2 database.

## Image
![layout](https://github.com/krzosa/project-for-object-technologies-class/blob/master/IMG.PNG)

## How to run(cmd):
1. mvn clean install
2. cd webapp
3. mvnw spring-boot:run
4. type into your browser: localhost:8080 
5. password and login are: login pass

### or if you are on windows:

1. run
1. type into your browser: localhost:8080 
1. password and login are: login pass
