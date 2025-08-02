# Railse Backend Assignment

This is the solution to the backend assignment for Railse. The application is a basic workforce management system built using Java and Spring Boot.

## 🛠️ Technologies Used

- Java 17  
- Spring Boot  
- Spring Data JPA  
- H2 Database (for development and testing)  
- Maven  
- Git

## 📂 Project Structure

workforcemgmt/
├── src/
│ ├── main/
│ │ ├── java/com/railse/workforcemgmt/
│ │ │ ├── controller/
│ │ │ ├── dto/
│ │ │ ├── entity/
│ │ │ ├── repository/
│ │ │ ├── service/
│ │ │ └── WorkforcemgmtApplication.java
│ └── test/
│ └── java/com/railse/workforcemgmt/
│ └── WorkforcemgmtApplicationTests.java
├── application.properties
├── pom.xml
└── README.md


---

## 🧪 Prerequisites

- Java 17 or higher  
- Maven  
- Git  

---

## 🧑‍💻 Running the App

### Step 1: Clone the Repository
Technologies Used & How It’s Built
This workforce management backend system is built using Java 17 and the Spring Boot framework, leveraging Spring Data JPA for seamless ORM-based interaction with the database. For development and testing purposes, we use the in-memory H2 database, which allows for quick setup without the need for external configuration.

The backend architecture follows a layered structure:

Controller layer handles HTTP requests and routes them appropriately.

DTOs (Data Transfer Objects) are used for clean and structured request/response communication.

Entity layer defines the JPA entities mapped to database tables.

Repository layer abstracts database operations using Spring Data JPA.

Service layer contains the business logic of the application.

The project uses Maven for dependency management and build automation. All source code is maintained under version control using Git.
```bash


git clone https://github.com/BolaLokesh/railse-backend-assignment.git
cd railse-backend-assignment
mvn spring-boot:run


| Method | Endpoint        | Description           |
| ------ | --------------- | --------------------- |
| GET    | /employees      | Get all employees     |
| POST   | /employees      | Create a new employee |
| PUT    | /employees/{id} | Update an employee    |
| DELETE | /employees/{id} | Delete an employee    |

mvn test
Edit
