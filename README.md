# Pet Clinic in Java, Kotlin and Scala

This project is a **very basic** implementation of pet clinic web application in **Java**, **Kotlin** and **Scala**. Created mainly for *learning* and *comparison* purposes; and perhaps to facilitate the process in the future :)

It exposes two database entities, `Pet` and `Customer` with a *many-to-one* relationship, available through two *repositories* and two *controllers*.

If you're unfamiliar with Spring, to run this, you need to launch these two commands in any of the language-specific subfolders:
* `mvn clean install` (or `mvnw clean install` if you don't have mvn installed - I don't guarantee it'll work, though)
* `java -jar target/pet-clinic-0.0.1-SNAPSHOT.jar`

Access resources at following URIs (I realize it's not perfectly RESTful :) ):
* `localhost:8080/customers` **GET**, **POST**
* `localhost:8080/customers/{id}` **GET**
* `localhost:8080/customers/formatted` **GET**
* `localhost:8080/pets` **GET**, **POST**

The project also includes a static index.html page with basic **Vue.js** attached, for completion sake.
