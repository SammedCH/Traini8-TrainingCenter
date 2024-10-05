# Traini8 - Training Center Registry

## Overview

This is a Spring Boot application for managing a registry of government-funded training centers. It provides APIs to create and retrieve training centers, with data persisted in a MySQL database.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Setup Instructions](#setup-instructions)
- [Database Configuration](#database-configuration)
- [API Endpoints](#api-endpoints)
  - [Create Training Center](#create-training-center)
  - [Retrieve Training Centers](#retrieve-training-centers)
- [Testing the API with Postman](#testing-the-api-with-postman)
- [Error Handling](#error-handling)

## Features

- Create a new training center with validations.
- Retrieve a list of all training centers, with optional filtering by city or center code.
- Proper error handling and validation messaging.

## Technologies Used

- **Java**: Programming language.
- **Spring Boot**: Framework for building the REST API.
- **JPA/Hibernate**: ORM for database interaction.
- **MySQL**: Database for persisting training center information.
- **Postman**: Tool for testing APIs.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- **Java JDK 17 or later**: [Download and Install](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).
- **Maven**: Build tool for Java projects. [Installation Guide](https://maven.apache.org/install.html).
- **MySQL Server**: Database server to host the training center data. [Download MySQL](https://dev.mysql.com/downloads/mysql/).
- **Postman**: API testing tool. [Download Postman](https://www.postman.com/downloads/).

## Setup Instructions

Follow these steps to set up and run the Traini8 application:

1. **Clone the Repository**:
   Open your terminal and run:
   ```bash
   git clone <repository-url>
   cd <repository-directory>

## Database Configuration
-spring.datasource.url=jdbc:mysql://localhost:3306/traini8_db
-spring.datasource.username=traini8_user
-spring.datasource.password=your_password

## API Endpoints
  - [Create Training Center]
     //Create Training Centers: Post "/api/training-centers"
     Request Body:
    {
      "centerName": "Center Name",
      "centerCode": "ABCD12345678",
      "address": {
      "detailedAddress": "123 Main St",
      "city": "SomeCity",
      "state": "SomeState",
      "pincode": "123456"
        },
      "studentCapacity": 100,
      "coursesOffered": ["Course 1", "Course 2"],
      "contactEmail": "contact@example.com",
      "contactPhone": "1234567890"
    }

  - [Retrieve Training Centers]
     //Get all training centers: GET /api/training-centers

         [
          {
            "id": 1,
            "centerName": "Center Name",
            "centerCode": "ABCD12345678",
            "address": {
            "detailedAddress": "123 Main St",
            "city": "SomeCity",
            "state": "SomeState",
            "pincode": "123456"
              },
            "studentCapacity": 100,
            "coursesOffered": ["Course 1", "Course 2"],
            "createdOn": 1633536000000,
            "contactEmail": "contact@example.com",
            "contactPhone": "1234567890"
          }
        ]

    //Filter by city: GET /api/training-centers?city=SomeCity
    //Filter by center code: GET /api/training-centers?centerCode=ABCD12345678

## Build the Application: Ensure you have Maven installed, then run:
  mvn clean install
## Run the Application: After building, run the application using:
  mvn spring-boot:run

## Testing the API with Postman
  - Open Postman.
  - Set the request type to POST and enter the endpoint http://localhost:8080/api/training-centers.
  - In the Body tab, select raw and choose JSON from the dropdown. Paste the JSON data for creating a training center.
  - Click Send to create the training center. You should receive a response with the created training center data.
  - To retrieve training centers, set the request type to GET and enter the endpoint http://localhost:8080/api/training-centers. Click Send to see the list of training centers.

## Error Handling
  - If validation fails, the API returns a 400 Bad Request status with details about the errors:
    {
      "status": 400,
      "message": "Validation failed",
      "errors": [
      {
      "field": "centerName",
      "message": "must not be empty"
      },
       {
      "field": "contactEmail",
      "message": "must be a valid email"
      }
    }
    
