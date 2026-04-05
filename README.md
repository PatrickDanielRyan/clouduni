# clouduni
Backend Service For Cloud Software Engineering University

## Executive Summary
### API
* Add lecturer
  * Endpoint: `/lecturers`
  * JSON Input: `{"name": "John", "surname": "Doe"}`
* Get lecturer by Lecturer Id
  * Endpoint: `/lecturers/{lecturerId}`
  * JSON Output: `{"id":1,"name":"John","surname":"Doe","students":[]}`
* Add student and assign them to an existing lecturer
  * Endpoint: `/students/add/{lecturerId}`
  * JSON Input: `{"name":"Alice","surname":"Smith"}`
* Get student by Student Id
  * Endpoint:  `/students/{studentId}`
  * JSON Output: `{"id":1,"name":"Alice","surname":"Smith","lecturers":[{"id":1,"name":"John","surname":"Doe"}]}`

### Starting and Stopping the Application
In the root project directory run

```docker compose up --build```

This starts a container running the application and another container running the database.  The application is accessable via port `8080`.

The application can be stopped by running

```docker compose down```

## Teseting
### Manual Testing
Start the application using ```docker compose up --build```.  The cURL commands below should be entered in another
shell on your machine.

#### Create lecturer
```curl -X POST http://localhost:8080/lecturers -H "Content-Type: application/json" -d '{"name":"John","surname":"Doe"}'```

Expected response:

```
{
  "id": 1,
  "name": "John",
  "surname": "Doe",
  "students": []
}
```
#### Get lecturer by Id
```curl http://localhost:8080/lecturers/1```

Expected response:

```
{
  "id":1,
  "name":"John",
   "surname":"Doe"
  "students":[]
}
```

#### Add student and assign them to an existing lecturer
```curl -X POST http://localhost:8080/students/add/1 -H "Content-Type: application/json" -d '{"name":"Alice" "surname":"Smith"}'```

Expectged response:

```
{
  "id": 1,
  "name": "Alice",
  "surname": "Smith",
  "lecturers": [
    {
      "id": 1,
      "name": "John",
      "surname": "Doe"
    }
  ]
}
```

#### Get student by Id
```curl http://localhost:8080/students/1```

Expected response:

```
{
  "id":1,
  "name":"Alice",
  "surname":"Smith",
  "lecturers":[{"id":1,
                "name":"John",
                "surname":"Doe"
                }
              ]
}
```

### Automated Integration Tests
The automated tests us an in-memory H2 database.  To run them, executing the following from the root project directory

```
mvn test
```