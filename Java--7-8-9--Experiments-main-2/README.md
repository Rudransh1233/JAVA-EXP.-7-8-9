# Java--7-8-9--Experiments
This repository contains a collection of Java programs developed as part of college academic coursework.

# Java_EXP_8

**Project:** Web Applications Using Servlets and JSP for User Input Handling and Database Integration

## Contents
- `src/` - Java servlet source files (package: `com.example.servlets`)
- `WebContent/` - HTML and JSP files
- `WebContent/WEB-INF/web.xml` - servlet mappings
- `testdb.sql` - SQL script to create `testdb`, `Employee`, and `Attendance` tables
- `lib/` - place `mysql-connector-j.jar` here (not included due to environment restrictions)

## Notes about the JDBC driver
I could not include the actual `mysql-connector-j.jar` file inside `lib/` because this environment does not allow downloading external files. Please download the appropriate MySQL Connector/J driver (for example `mysql-connector-java-8.0.xx.jar`) from the official MySQL website and place it into the `lib/` folder before building/deploying.

## How to run locally (Eclipse + Tomcat)
1. Import project into Eclipse as **Existing Projects into Workspace** or create a **Dynamic Web Project** named `PBLJ_EXP_8` and copy files.
2. Ensure Apache Tomcat 9/10 is configured in Eclipse.
3. Put the MySQL JDBC driver JAR into `WEB-INF/lib/` or project's `lib/` folder and add to build path.
4. Create the MySQL database:
   - Run `testdb.sql` in your MySQL client to create `testdb` and sample data.
5. Update DB credentials if needed:
   - Default connection in servlets uses `jdbc:mysql://localhost:3306/testdb`, user `root`, password `password`.
   - Change as necessary in the servlet source before building.
6. Build and run on Tomcat.
7. Access pages:
   - `http://localhost:8080/PBLJ_EXP_8/login.html`
   - `http://localhost:8080/PBLJ_EXP_8/employee.html`
   - `http://localhost:8080/PBLJ_EXP_8/attendance.jsp`

## Files to check before pushing to GitHub
- Remove any local credentials or change them to environment variables for production.
- Add `.gitignore` if you don't want to commit files like compiled classes or local DB credentials.

## Troubleshooting
- If you see `ClassNotFoundException: com.mysql.cj.jdbc.Driver`, make sure the connector JAR is in the project's classpath and copied to `WEB-INF/lib`.
- If database connection fails, verify MySQL is running and credentials/URL are correct.

---
# Java Applications Using Spring and Hibernate

### Dependency Injection, CRUD Operations, and Transaction Management

---

## 📘 Overview

This project demonstrates the integration of **Spring Framework** and **Hibernate ORM** in three parts:

1. **Dependency Injection (DI)** using Java-based configuration.
2. **Hibernate CRUD operations** for a `Student` entity.
3. **Transaction Management** in a simple banking system using Spring + Hibernate.

Each section builds on fundamental enterprise Java concepts like Inversion of Control, ORM mapping, and declarative transaction handling.

---

## 🧩 Part A: Dependency Injection in Spring (Java-Based Configuration)

### 🎯 Objective

To create a simple Spring application demonstrating **Dependency Injection (DI)** using **Java-based configuration** instead of XML.

### 🧠 Concept

Spring’s **DI mechanism** manages object creation and dependency wiring automatically using annotations like `@Configuration`, `@Bean`, and `@Autowired`.

### 🏗️ Implementation Steps

1. **Create Classes**

   * `Course` – Represents a course with basic details.
   * `Student` – Depends on `Course` and displays course info.

2. **Configure Beans**

   * Create a `SpringConfig` class annotated with `@Configuration`.
   * Define beans using `@Bean` methods for both `Student` and `Course`.

3. **Run the Application**

   * Initialize the context using `AnnotationConfigApplicationContext(SpringConfig.class)`.
   * Retrieve the `Student` bean and call its method to confirm DI success.

### 🧩 Example Structure

```
com.nimbus.springdi
 ├── Course.java
 ├── Student.java
 ├── SpringConfig.java
 └── MainApp.java
```

---

## 🧮 Part B: Hibernate Application for Student CRUD Operations

### 🎯 Objective

To develop a Hibernate-based application that performs **Create, Read, Update, and Delete (CRUD)** operations on a `Student` entity stored in a **MySQL** database.

### 🧠 Concept

Hibernate provides Object-Relational Mapping (ORM) — automatically mapping Java classes to database tables using annotations like `@Entity`, `@Id`, and `@Column`.

### 🏗️ Implementation Steps

1. **Create `Student` Entity**

   * Annotate with `@Entity`, `@Id`, and `@Column`.

2. **Configure Hibernate**

   * Use `hibernate.cfg.xml` or Java-based configuration to set database connection details and mapping class.

3. **CRUD Operations**

   * `createStudent()` – Save new student record.
   * `readStudents()` – Retrieve student list.
   * `updateStudent()` – Modify student info.
   * `deleteStudent()` – Remove student by ID.

4. **Use `SessionFactory` and `Session`**

   * Manage transactions and persistence.

### ⚙️ Example Structure

```
com.hibernatecrud
 ├── Student.java
 ├── HibernateUtil.java
 ├── StudentDAO.java
 ├── MainApp.java
 └── resources/hibernate.cfg.xml
```

---

## 💰 Part C: Transaction Management Using Spring and Hibernate

### 🎯 Objective

To create a simple **Banking System** that allows money transfer between accounts while ensuring **transaction consistency** using Spring’s `@Transactional` support.

### 🧠 Concept

Spring provides **declarative transaction management** through annotations. Transactions ensure **atomicity** and **rollback** if any operation fails.

### 🏗️ Implementation Steps

1. **Create Entities**

   * `Account` – Represents a bank account.
   * `Transaction` – Represents transfer details.

2. **DAO Layer**

   * Handles database operations using Hibernate.

3. **Service Layer**

   * Annotate methods with `@Transactional`.
   * Implement logic to:

     * Deduct from sender account.
     * Add to receiver account.
     * Rollback if any step fails.

4. **Configuration**

   * Use Spring configuration classes for bean setup.
   * Integrate Hibernate for persistence.

### 🧩 Example Structure

```
com.nimbus.bank
 ├── entity
 │   ├── Account.java
 │   └── Transaction.java
 ├── dao
 │   └── AccountDAO.java
 ├── service
 │   └── BankingService.java
 ├── config
 │   └── AppConfig.java
 └── MainApp.java
```

---

## 🗄️ Database Setup (MySQL)

**Example Database:** `nimbus_db`

```sql
CREATE DATABASE nimbus_db;
USE nimbus_db;
```

**Example Table (for Part B):**

```sql
CREATE TABLE student (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100),
  course VARCHAR(100),
  marks DOUBLE
);
```

**Example Table (for Part C):**

```sql
CREATE TABLE account (
  account_id INT PRIMARY KEY AUTO_INCREMENT,
  holder_name VARCHAR(100),
  balance DOUBLE
);
```

## Output
```
Student object created via Dependency Injection!
Enrolled in course: Spring Framework Mastery
```
```
Hibernate: insert into students ...
Student saved successfully!
All Students:
Student{id=1, name='Arya Stark', course='Hibernate ORM', email='arya@winterfell.com'}
```
```
Before Transfer:
Account 1 balance: 10000
Account 2 balance: 5000

Transfer successful!

After Transfer:
Account 1 balance: 9000
Account 2 balance: 6000
```

---

## 🧰 Technologies Used

* **Java 17+**
* **Spring Framework 6+**
* **Hibernate 6+**
* **MySQL 8+**
* **Maven / Gradle**
* **IntelliJ IDEA / Eclipse IDE**

---

## 🧪 How to Run

1. Clone the repository.
2. Configure the MySQL database and update connection details in Hibernate configuration.
3. Build the project using Maven/Gradle.
4. Run each module’s `MainApp` to test.

---

## 🏁 Learning Outcomes

* Understand Spring **Dependency Injection** using Java configuration.
* Perform **CRUD operations** using Hibernate ORM.
* Implement **transactional operations** integrating Spring and Hibernate.
* Gain practical exposure to enterprise-grade application architecture.

---

**Author:** *Arjun Dubey*
**License:** MIT
**Version:** 1.0.0
