
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

#### Working Diagram for Application 
![MSBA Proj](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/7caaf70a-0300-4f2c-800f-3eda719d1a67)

#### High Level Diagram 

![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/31988f7c-cce8-4542-9ea2-e75efd70ea8c)

[Miro Board Link](https://miro.com/app/board/uXjVNCqSVsQ=/?share_link_id=904572644404)

## Prerequisites

Make sure you have the following installed on your system:

- Java 8 or higher
- Maven
- Spring Boot
- MySQL or another compatible database (for data storage)


## Project Files

##### 1. PostMan File

- **File**: [Major Project MSBA.postman_collection](/Major_Project_MSBA.postman_collection)

This file contains the SQL script for creating the necessary tables and schema for the MySQL database used in this project.

##### 2. Postman Environments

- **File**: [MSB-AUTH-CREDENTIALS.postman_environment](/MSB-AUTH-CREDENTIALS.postman_environment)

If you prefer using Postman for testing APIs, you can import this collection to quickly set up and test the endpoints provided by the hotel booking application.

##### 3. MYSQL Data

- **File**: [database_setup.sql](/database_setup.sql)

This SQL script includes some sample data that you can use to populate the database for testing the functionality of the hotel booking application.

Feel free to explore and use these files according to your project requirements. 

## Installation
***Follow Proper Procedure to run Smoothly***

1. Clone the repository:
   

Find the Link ( You Can Use Https/SSH)
1.a) 
![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/1d28aa3b-4624-4256-8985-24b79baa5209)
1.b) 
![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/5551ea46-191b-4771-a17d-fbc658589c2f)

Use Command : 
 ```bash
   git clone https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023.git
   ```
1.c) 
![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/0582c04e-0aed-4cd5-a982-0c22b2ac6a78)

### 1.1.a) Setup Database 
![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/8025fa34-0f15-4ed4-b91a-8365bf267593)


2. Setup Your IDE (I am Using `Spring Tool Suite`) :
2.a) 
   Local View :
   ![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/b99291d7-9679-42f0-9c2e-c2bfd8685d46)
2.b)
Start with Specified Directory :
![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/045a0eaa-05eb-4fbe-a836-2d74c546cee3)

2.c) Import Maven Projects :
![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/d5b729aa-1ad3-4010-9db1-2b5999282748)

2.d) Choose Maven > Existing Projects
![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/a05690a3-1b15-4122-8604-dfa362cbad8c)

2.e) Choose the directory of Project :
![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/c29db24c-8b07-4577-aca6-f177391ac250)

2.f) Choose the root directory of Project :
![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/adc78f09-0b3e-44de-bdc2-78df19e4b232)

2.g) Import All the Projects :
![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/6272b80a-b98b-43e3-921c-c2fdf2ba5905)

2.h) Importing and Building will be done by IDE :
![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/f7b5e23d-48e5-4562-a496-971acb76ad85)

3. Setup POSTMAN:

3.a) Import the Collection File
![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/ae0feb1a-3738-4b88-82e4-393fd8550d94)
3.b) Choose File
![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/758e5549-1be9-44cc-9d0f-5bfb23aa2a99)
3.c) Collection Page
![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/7aecb806-e678-4684-9327-07ed0119458c)
3.d) Import Security Credentails
![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/67adb19e-52d2-46d4-afe6-58057dbb652d)
![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/cb8829ea-a749-42d2-b142-f68396d1a17e)
![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/50fe1b25-8b1e-4a48-ae61-4fa9d473c904)
3.e) Choose Proper Environment
![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/e7acf932-a2e0-4d29-8f66-27f3a4c05ede)

4. Run the application:
   ![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/a48125c0-50ed-4247-a18c-116e7e23bde4)

4.a) Follow Order to Run Application Without Errors :
***1. Start Server***
   ![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/549c76cf-07c3-4c24-bf4a-217bac322a20)

***2. Start Gateway***
![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/9c9100ec-6d6b-4ef2-bd63-bc6e0c5324d1)

***1. Start Both Services***
![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/3b664ada-bb49-44e3-a985-969eb01fa37e)



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
