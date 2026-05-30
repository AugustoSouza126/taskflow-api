# TaskFlow API

TaskFlow API is a RESTful backend application developed with Java and Spring Boot for managing tasks and productivity workflows.

## Features

* Create tasks
* List tasks
* Update tasks
* Delete tasks
* Task status management

## Technologies

* Java 21
* Spring Boot
* Spring Data JPA
* MySQL
* Maven

## Project Structure

```text
controller/
service/
repository/
model/
dto/
```

## Task Status

* TODO
* IN_PROGRESS
* DONE

## API Endpoints

| Method | Endpoint    | Description       |
| ------ | ----------- | ----------------- |
| GET    | /tasks      | Get all tasks     |
| GET    | /tasks/{id} | Get task by id    |
| POST   | /tasks      | Create a new task |
| PUT    | /tasks/{id} | Update a task     |
| DELETE | /tasks/{id} | Delete a task     |

## Future Improvements

* User authentication
* JWT authorization
* User-specific tasks
* Docker support
* Task filtering and search

## Author

Augusto Souza

Computer Science Student
