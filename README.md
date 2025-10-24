# 🏆 Full Stack Assignment Submission

[![Framework](https://img.shields.io/badge/Framework-SpringBoot-green)](https://spring.io/projects/spring-boot)
[![Database](https://img.shields.io/badge/Database-MongoDB_Atlas-brightgreen)](https://www.mongodb.com/atlas)
[![Deployment](https://img.shields.io/badge/Deployment-Render-blue)](https://render.com)
[![Status](https://img.shields.io/badge/Status-Completed-brightgreen)]()

## 📖 Table of Contents
- [Overview](#-overview)
- [Video Demo](#-video-demo)
- [Repository Structure](#-repository-structure)
- [Live Deployment](#-live-deployment)
- [Part 1 – DSA Problem](#-part-1--dsa-problem)
  - [Problem Statement](#problem-statement)
  - [Approach](#approach)
  - [Example](#example)
  - [How to Run](#how-to-run)
- [Part 3 – Backend Task (Spring Boot)](#-part-3--backend-task-spring-boot)
  - [Description](#description)
  - [APIs](#apis)
  - [Tech Stack](#tech-stack)
  - [Project Structure](#project-structure)
  - [Database Configuration](#database-configuration)
  - [How to Run Locally](#how-to-run-locally)
  - [Docker Deployment](#docker-deployment)
  - [Postman Requests](#postman-requests)
- [Notes](#notes)

## 📌 Overview
This repository contains my completed assignment submission:  

- ✅ **Part 1 – DSA Problem**  
- ✅ **Part 3 – Backend Task (Spring Boot with MongoDB Atlas)**  
- ✅ **Dockerized Deployment on Render**

All code is tested and functional for the provided examples.

## 🎥 Video Demo
[![YouTube Demo](https://img.shields.io/badge/YouTube-Video_Demo-red)](https://youtu.be/your-video-link-here)

*Click the badge above to watch the complete walkthrough and demo of the application*

## 📁 Repository Structure

```
YourDOST-Assignment/
├── dsa/
│   └── SecondLargestNumber.java
│
└── Simple To-Do CRUD - YourDost/
    ├── src/
    │   └── main/
    │       ├── java/
    │       │   └── com/
    │       │       └── YourDost/
    │       │           ├── controller/
    │       │           ├── model/
    │       │           ├── repository/
    │       │           └── SimpleToDoCrudApiApplication.java
    │       └── resources/
    │           └── application.properties
    ├── target/
    ├── .gitignore
    ├── mvnw
    ├── mvnw.cmd
    ├── Dockerfile
    ├── pom.xml
    └── README.md
```

## 🚀 Live Deployment



## 🧠 Part 1 – DSA Problem

### Problem Statement
Return the **second largest unique number** from an array of integers.  
If it does not exist, return `-1`.

### Approach
1. Store all unique numbers in a **set**.  
2. Convert the set into a **list** and sort in **descending order**.  
3. Return the **second element** if it exists; otherwise, return `-1`.  

**Time Complexity:** `O(n log n)` (due to sorting)  
**Space Complexity:** `O(n)`

### Example
```java
Input: [3, 5, 2, 5, 6, 6, 1]
Output: 5

Input: [7, 7, 7]
Output: -1
```

### How to Run
```bash
cd dsa
javac Problem.java
java Problem
```

## ⚙️ Part 3 – Backend Task (Spring Boot)

### Description
A simple REST API for managing To-Do items with full CRUD functionality.  
Data is stored in **MongoDB Atlas** (cloud database) and deployed on **Render**.

**API Base URL:** `https://yourdost-assigement-todolist.onrender.com`

The application is deployed on **Render** using Docker and can be accessed at the above URL.

### APIs
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/todos` | Get all todos |
| POST | `/api/todos` | Create a new todo |
| PUT | `/api/todos/{id}` | Update a todo |
| DELETE | `/api/todos/{id}` | Delete a todo |

### Tech Stack
- Java 17
- Spring Boot 3.x
- Lombok
- MongoDB Atlas
- Maven
- Spring Data MongoDB
- Docker

### Project Structure
```
src/main/java/com/YourDost/
├── controller/          # REST controllers
├── model/              # Entity classes
├── repository/         # MongoDB repositories
└── SimpleToDoCrudApiApplication.java  # Main application class
```

### Database Configuration
The application uses **MongoDB Atlas** with environment-based configuration:

**application.properties:**
```properties
spring.data.mongodb.uri=${MONGODB_URI}
server.port=${PORT:8080}
```

### How to Run Locally
```bash
cd "Simple To-Do CRUD - YourDost"
mvn clean install
mvn spring-boot:run
```

Access API at: http://localhost:8080/api/todos

### Docker Deployment

**Dockerfile:**
```dockerfile
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

**Build and Run with Docker:**
```bash
# Build stage
FROM maven:3.9.7 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Run stage
FROM openjdk:17-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]

```

**Deploy on Render:**
1. Connect your GitHub repository to Render
2. Set environment variables in Render dashboard:
   - `MONGODB_URI`: Your MongoDB Atlas connection string
3. Render automatically detects Dockerfile and deploys

## 📮 Postman Requests

### Base URL: `https://yourdost-assigement-todolist.onrender.com/todo`

### 1. Get All Todos
**Request:**
```
GET https://your-todo-app.onrender.com/api/todos
```

**Response:**
```json
[
    {
        "id": "67a4b5c6d7e8f90123456789",
        "title": "Finish assignment",
        "description": "Complete the YourDOST assignment",
        "completed": false,
    }
]
```

### 2. Create New Todo
**Request:**
```
POST https://yourdost-assigement-todolist.onrender.com/todos
Content-Type: application/json
```

**Body:**
```json
{
    "title": "Learn Spring Boot",
    "description": "Study Spring Boot fundamentals",
    "completed": false
}
```

**Response:**
```json
{
    "id": "67a4b5c6d7e8f90123456790",
    "title": "Learn Spring Boot",
    "description": "Study Spring Boot fundamentals",
    "completed": false,
}
```

### 3. Get Todo by ID
**Request:**
```
GET https://yourdost-assigement-todolist.onrender.com/todos/{id}
```

**Response:**
```json
{
    "id": "67a4b5c6d7e8f90123456789",
    "title": "Finish assignment",
    "description": "Complete the YourDOST assignment",
    "completed": false,
}
```

### 4. Update Todo
**Request:**
```
PUT https://yourdost-assigement-todolist.onrender.com/todos/{id}
Content-Type: application/json
```

**Body:**
```json
{
    "title": "Finish assignment - UPDATED",
    "description": "Complete the YourDOST assignment with bonus features",
    "completed": true
}
```

**Response:**
```json
{
    "id": "67a4b5c6d7e8f90123456789",
    "title": "Finish assignment - UPDATED",
    "description": "Complete the YourDOST assignment with bonus features",
    "completed": true,
}
```

### 5. Delete Todo
**Request:**
```
DELETE https://yourdost-assigement-todolist.onrender.com/todos/{id}
```

**Response:**
```json
{
    "message": "Todo deleted successfully",
}
```
