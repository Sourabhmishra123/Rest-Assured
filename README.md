# Rest-Assured API Testing 🌐🔍

A **test automation framework** for validating REST APIs using **Rest-Assured + Java + TestNG**.  
This project demonstrates how to structure automated API tests that are scalable, maintainable, and easy to extend.

---

## 🎯 Project Goal

The purpose of this framework is to:

- Automate validation of REST APIs (CRUD operations: GET, POST, PUT, DELETE)  
- Validate response codes, headers, and JSON schema  
- Enable data-driven testing for multiple input sets  
- Provide readable, reusable test classes and utility methods  
- Generate HTML reports with detailed execution results  

---

## ✅ Features

- End-to-end API testing with Rest-Assured  
- JSON schema validation  
- Parameterized & data-driven tests  
- Centralized configuration management (Base URL, Auth tokens, etc.)  
- Extensible design (add new API endpoints easily)  
- Integrated reporting with TestNG  

---

## 🛠️ Tech Stack & Dependencies

- **Language:** Java  
- **Libraries / Frameworks:** Rest-Assured, TestNG, JSON, Hamcrest matchers  
- **Build Tool:** Maven  
- **Reports:** TestNG HTML Reports  

---

## 📂 Project Structure & File Details
- ├── src/
- └── test/
- ├── java/
- │ ├── tests/ # Test classes for APIs (e.g. UserAPITests.java)
- │ ├── clients/ # API client classes encapsulating endpoint calls
- │ ├── utils/ # Utilities (ConfigReader, RequestBuilder, ResponseValidator)
- │ └── listeners/ # TestNG listeners for logging & reporting
- └── resources/
- ├── data/ # Test data files (JSON, CSV, properties)
- └── schemas/ # JSON schema files for response validation
-── pom.xml # Maven dependencies & build configuration
-── README.md # Project documentation


### 📄 Folder / File Roles (Examples)

- **tests/**  
  - Contains TestNG classes with `@Test` methods for different APIs  
  - Example: `UserAPITests.java` (validates GET, POST, DELETE endpoints for User API)  

- **clients/**  
  - Encapsulates the actual API calls  
  - Example: `UserClient.java` with methods like `createUser()`, `getUserById()`, `deleteUser()`  

- **utils/**  
  - `ConfigReader.java` → reads properties (base URL, tokens, environment configs)  
  - `RequestBuilder.java` → builds standardized API requests (headers, auth)  
  - `ResponseValidator.java` → common methods to validate status codes, response time, JSON schema  

- **listeners/**  
  - Optional TestNG listeners for logging, retry mechanism, or reporting  

- **resources/data/**  
  - External payload files for POST/PUT APIs (JSON or CSV)  

- **resources/schemas/**  
  - JSON schema definitions for validating response body structure  

---


## ▶️ How to Run Tests

1. Clone the repository  
   ```bash
   git clone https://github.com/Sourabhmishra123/SDET-CucumberTesting.git

2.Import into your IDE (IntelliJ / Eclipse)

3.Run with Maven

```bash
mvn clean test
```
4. (Optional) Run a specific test class or method from IDE with TestNG runner
