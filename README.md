# Project for the Object Technologies class
Calculator turned into a webapp with login page, action logging(to the 
database) and layout created using Thymeleaf and Bootstrap.
## Technologies
* Spring-Boot
    * Spring project that makes it very easy to create and manage a Spring application
* Spring data JPA
    * Spring project that among others provides JPA repositories which have many standard methods for
    talking with the database(eliminates boilerplate code).
* H2 Database
    * Very convenient embedded in memory database. It's great for learning cause it's easy to setup.
* Thymeleaf
    * Template engine that makes it possible to use .html files instead of the .JSPs while providing 
    additional functionality.
* Bootstrap
    * CSS library that helps immensely in making nice, responsive layouts quickly. 
## A bit of history
It first started as a parent maven project with 3 sub modules: common, interface, implementation. 
Common is where main is so it's the starting point of the program. 
Interface contains interfaces of the initial program. 
Implmentation contains implementations of those interfaces.
We also had to create our own classloader that would load classes 
outside of the project which sadly brings a lot of file pathing problems.

Then I used Spring framework to turn this application into a webapp(webapp module) which took me a 
looooong time to figure out how to do. Lastly I added logging using Hibernate and H2 database.
![layout](https://github.com/krzosa/project-for-object-technologies-class/blob/master/img.PNG)

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
