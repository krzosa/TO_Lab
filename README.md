# Project for the Object Technologies class
Calculator turned into a webapp with login page, action logging to the database and layout created using Thymeleaf and Bootstrap.

It first started as a parent maven project with 3 sub modules: common, interface, implementation. Common is where main is so it's the starting point of the program. Interface contains interfaces of the initial program. Implmentation contains implementations of those interfaces.
We also had to create our own classloader that would load classes outside of the project which sadly brings alot of file pathing problems.

Then I used Spring framework to turn this application into a webapp > webapp module which took me a looooong time to figure out how to do. Lastly I added logging using Hibernate and H2 database.

## How to run(cmd):
1. mvn clean install
2. cd webapp
3. mvnw spring-boot:run

### or if you are on windows:

1.run
