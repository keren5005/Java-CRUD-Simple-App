# Java CRUD Simple App

A simple Java Spring Boot application demonstrating **CRUD operations** (Create, Read, Update, Delete) using **JPA, Hibernate**, and a DAO pattern.

## 🚀 Features
- Add new employees to the database.
- Read employee details by ID.
- Retrieve all employees.
- Update employee information.
- Delete a single employee or all employees.

## 🛠️ Technologies Used
- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **H2 / MySQL** (configurable)
- **Maven**

## ⚙️ Setup & Run

```bash
# 1️⃣ Clone the repository:
git clone https://github.com/keren5005/Java-CRUD-Simple-App.git
cd Java-CRUD-Simple-App

# 2️⃣ Build and run the app:
./mvnw spring-boot:run

# 3️⃣ Access the application:
The app runs on http://localhost:8080
````

## 📂 Project Structure

```text
src/
├── main/
│   ├── java/
│   │   ├── com.example.crudapp/        # Main application
│   │   ├── DAO/                        # Data Access Objects and Interface
│   │   └── entity/                     # JPA Entity classes
│   └── resources/
│       └── application.properties      # Database configuration
└── test/                               # Unit tests
```

## 📌 Example Code Snippets

```java
// ✅ Create Employee
Employee emp = new Employee("John", "Doe", "john.doe@example.com");
employeeDAO.save(emp);

// ✅ Find Employee by ID
Employee emp = employeeDAO.findById(1);

// ✅ Update Employee
emp.setFirstName("Johnny");
employeeDAO.update(emp);

// ✅ Delete Employee
employeeDAO.delete(1);
```

