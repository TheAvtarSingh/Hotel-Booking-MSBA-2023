
# Hotel Booking Mini Project - MSBA 2023

## By Avtar Singh - 20csu241

This is a simple microservice-based application for hotel booking. The project is built using Java with Spring Boot and utilizes MySQL for data storage.

## Table of Contents
- [Introduction](#introduction)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Project Files](#project-files)
- [Endpoints](#endpoints)
- [Contributing](#contributing)
- [License](#license)

## Introduction

This project serves as a basic template for a hotel booking application. It includes two main entities: `Hotel` and `Booking`. The application provides RESTful APIs for managing hotels and bookings.

## Prerequisites

Make sure you have the following installed on your system:

- Java 8 or higher
- Maven
- Spring Boot
- MySQL or another compatible database (for data storage)

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/hotel-booking-mini-project.git
   ```

2. Configure your database settings in `src/main/resources/application.properties`.

3. Build the project using Maven:

   ```bash
   cd hotel-booking-mini-project
   mvn clean install
   ```

4. Run the application:

   ```bash
   java -jar target/hotel-booking-mini-project.jar
   ```
## Project Files

##### 1. Database Schema

- **File**: [database-schema.sql](/path/to/database-schema.sql)

This file contains the SQL script for creating the necessary tables and schema for the MySQL database used in this project.

##### 2. Postman Collection

- **File**: [hotel-booking-api.postman_collection.json](/path/to/hotel-booking-api.postman_collection.json)

If you prefer using Postman for testing APIs, you can import this collection to quickly set up and test the endpoints provided by the hotel booking application.

##### 3. Sample Data

- **File**: [sample-data.sql](/path/to/sample-data.sql)

This SQL script includes some sample data that you can use to populate the database for testing the functionality of the hotel booking application.

Feel free to explore and use these files according to your project requirements. If you have any questions or need assistance, refer to the [Contributing](#contributing) section or open an issue.

## Usage

The application provides RESTful APIs for managing hotels and bookings. You can use tools like `curl` or Postman to interact with the APIs.

## Endpoints

### Hotels

- **GET /hotels**: Get a list of all hotels.
- **GET /hotels/{id}**: Get details of a specific hotel by ID.
- **POST /hotels**: Create a new hotel.
- **PUT /hotels/{id}**: Update details of a specific hotel by ID.
- **DELETE /hotels/{id}**: Delete a specific hotel by ID.

### Bookings

- **GET /bookings**: Get a list of all bookings.
- **GET /bookings/{id}**: Get details of a specific booking by ID.
- **POST /bookings**: Create a new booking.
- **PUT /bookings/{id}**: Update details of a specific booking by ID.
- **DELETE /bookings/{id}**: Delete a specific booking by ID.

## Contributing

Feel free to contribute to the project by opening issues or submitting pull requests. Your contributions are welcome!

## License

This project is licensed under the [MIT License](LICENSE).
```
Make sure to replace placeholders like `{id}`, `yourusername`, and others with the actual values and details specific to your project. Additionally, update the `LICENSE` file according to your preferences.
```
