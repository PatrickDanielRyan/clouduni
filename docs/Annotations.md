# Glossary
List of annotations used in this project.

* **@ActiveProfiles("test")** Tells Spring which environment-specific configuration to load when running an application (most commonly used in Tests).

* **@AutoConfigureMockMvc** Used in a Spring Boot test to automatically set up and configure a MockMvc instance (used to fake sending HTTP requests).

* **@Autowired** In Spring Boot, it is the "switch" that triggers Dependency Injection.  Without it, you would need to use `new`.

* **@Entity** A "mapping" label in JPA. It tells the Hibernate engine that a specific Java class should be treated as a database table.

* **@ExceptionHandler** In Spring Boot, it marks a specific method to handle exceptions (errors) that occur during the execution of your REST controllers.

* **@GeneratedValue** In JPA and Hibernate, it tells the database to automatically create a unique value for a field—usually the Primary Key (`@Id`).

* **@GetMapping** In Spring Boot, it is a specialized shortcut that maps an HTTP GET request to a specific method in your REST controller.

* **@Id** In JPA (Jakarta Persistence API), it identifies a specific field in your Java class as the Primary Key for a database table.

* **@JoinColumn** In Spring Data JPA (and Hibernate), it is used to define the physical mapping of a foreign key column in your database.

* **@JoinTable** In a Relational Database, it is used to define a separate "link" table that connects two different entities. It is primarily used to manage Many-to-Many relationships

* **@ManyToMany** In a Relational Database, it defines a relationship where multiple records in one table are associated with multiple records in another.

* **@NotBlank** In Spring Boot and Jakarta Validation, it is the strictest way to ensure a text field (String) actually contains "real" data.

* **@Override** In Java, it is a "safety check" you place on a method to tell the compiler: *"I am intentionally replacing a method that already exists in my parent class or interface."*

* **@Pattern** In Spring Boot and Jakarta Validation, it is used to validate a string against a specific Regular Expression

* **@PathVariable** In a Spring Boot REST controller, it is used to extract a dynamic value directly from the URL path and pass it as a parameter into your Java method.

* **@PostMapping** In Spring Boot, it is a specialized shortcut that maps an HTTP POST request to a specific method in your REST controller.

* **@RequestBody** In a Spring Boot REST controller, it is used to map the body of an incoming HTTP request (usually a JSON string) into a Java object.

* **@RestController** In Spring Boot, it is a specialized version of a standard Spring component that marks a class as a handler for RESTful web requests.

* **@RestControllerAdvice** In Spring Boot, it is used to create a Global Error Handler for your entire application.

* **@Service** In Spring Boot, it is used to mark a class as a Service Layer component. It tells Spring that this class contains the business logic of your application.

* **@SpringBootApplication** In Spring Boot, it is the "Master Switch." It is placed on your main class (the one with the main method) to tell Spring to start up and configure your entire application.

* **@SprintBootTest** In a Spring Boot application, the @SpringBootTest annotation is the "heavy-duty" tool for Integration Testing.
It tells Spring to start up the entire Application Context—just as if you were running the real app.

* **@Table** In JPA and Hibernate, it is used to customize the mapping between your Java class and the actual table in your relational database.
While `@Entity` tells JPA that a class is a table, `@Table` tells JPA how that table should look.

* **@Test** In Java and Spring Boot, it marks a method as a unit test. It tells the testing framework (usually JUnit 5) that this specific method contains code that should be executed to verify if a piece of your application works correctly.

* **@Valid** In Spring Boot and Jakarta Validation, it is the "trigger" that tells Spring to actually check the validation rules you've set on a Java object.
