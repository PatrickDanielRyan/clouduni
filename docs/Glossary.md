# Glossary
Definition of terms relevant to this project.

* **Annotation** Metadata added to code to give extra instructions to the compiler or runtime framework.
Start with `@`, for example `@Entity`.

* **CRUD** The four basic operations you can perform on data in a database
  * **Create** maps to `POST` in HTML and `INSERT` in SQL
  * **Read** maps to `GET` in HTML and `SELECT` in SQL
  * **Update** maps to `PUT/PATCH` in HTML and `UPDATE` in SQL
  * **Delete** maps to `DELETE` in HTML and `DELETE` in SQL

* **Data Transfer Object** (DTO) used to transfer objects between layers.  Allows API to be independent of database structure and other internal fields.

* **Dependency Injection** A design pattern in which an object does not create the other objects it needs.
Instead, the objects it needs are injected (passed) into it.

* **Entity** A Java class that represents a table in the database.  Mapped to SQL by Hibernate.

* **H2** An open-source relational database that can store data in-memory.  It's often used with Spring Boot
because it's fast and requires no installation or external setup.

* **Hibernate** Converts between Java objects (Entities) and SQL commands according to the JPA.

* **Hikari** The connection pool used by Spring Boot to manage database connections

* **HTTP** (Hypertext Transfer Protocol) a request-response protocol used by clients to communicate with
servers on the web.
  * Methods
    * **POST** Create new resource
    * **PUT** Replace existing resource
    * **PATCH** Modify existing resource
    * **GET** Get resource
    * **DELETE** Remove resource
  * Status Codes
    * **200** Ok
    * **404** Not found
    * **500** Internal server error

* **Jackson** A Java library that converts between JSON and Java classes.

* **Jakarta** Set of specifications that defines standards for Java applications.

* **JavaBean** A standard Java class that follows a specific set of coding rules.  These include private fields,
getters and setters, and a no-argument constructor.

* **JPA** (Jakarta Persistence API) Java standard for managing relational data in applications.
It uses annotations to map Java classes to database tables.

* **ResponseEntity** A class in the Spring Framework that represents the entire HTTP response.
It consists of a Status Code (`200 OK` or `404 Not Found` for example), Headers, and a Body (the data you're sending back, usually JSON).  Without it, Spring usually defaults to a status code of `200 OK`.

* **REST** (Representational State Transfer) software architectural style that defines how computer systems
on the internet communicate.  In REST, everything is a resource and the server sends back a representation
of its current state when a resource is requested.  The server is stateless since it does not store
information about the client between requests.

* **Servlet** A Java class that runs on a web server to handle HTTP requests and generate responses.
A servlet lives in a servlet container (Tomcat, for example, in Spring Boot).

* **Spring** Java framework for application development.

* **Spring Boot** Extension to Spring to simply rapid development.  Makes development of REST APIs and microservices fast and easy.
