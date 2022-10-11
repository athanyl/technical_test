# springboot-technical-test-app

Application created for a technical test with Spring Boot.
This application exposes two services: One to register users and another to access a user from his id.  

## Requirements

For building and running the application we recommend :

- Git
- Java 17
- Maven 3

## Running the application locally

The easiest way to launch the application on your machine is to use the Spring Boot Maven plugin like so:

```shell
git clone https://github.com/athanyl/technical_test
cd technical_test/
./mvnw clean install
./mvnw spring-boot:run
```

## Test with Postman

There is a json file on the repository with the Postman collection needed for testing. You can run all the queries independently and see the result.



Thanks for reading and have a great day!