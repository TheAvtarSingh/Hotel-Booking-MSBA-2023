# Hotel Booking Mini Project - MSBA 2023

## By Avtar Singh - 20csu241

This is a simple microservice-based application for hotel booking. The project is built using Java with Spring Boot and utilizes MySQL for data storage.

## Table of Contents
- [Introduction](#introduction)
- [Prerequisites](#prerequisites)
- [Project Files](#project-files)
- [Installation](#installation)
- [Usage](#usage)
- [Endpoints](#endpoints)
- [Contributing](#contributing)
- [License](#license)

## Introduction

This project serves as a basic template for a hotel booking application. It includes two main entities: `Hotel` and `Booking`. The application provides RESTful APIs for managing hotels and bookings.

#### Working Diagram for Application 
![MSBA Proj](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/7caaf70a-0300-4f2c-800f-3eda719d1a67.png)

#### High Level Diagram 
![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/1537cb98-3b7d-4a62-a850-c385b96678e1)


[Miro Board Link](https://miro.com/app/board/uXjVNCqSVsQ=/?share_link_id=904572644404)


-------------------------------------------------------------------------------------------------------------------------------------------------------------------

## Prerequisites

Make sure you have the following installed on your system:

- Java 8 or higher
- Maven
- Spring Boot
- MySQL or another compatible database (for data storage)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

## Project Files

##### 1. PostMan File

- **File**: [Major Project MSBA.postman_collection](Major_Project_MSBA.postman_collection.json)

This file contains the SQL script for creating the necessary tables and schema for the MySQL database used in this project.

##### 2. Postman Environments

- **File**: [MSB-AUTH-CREDENTIALS.postman_environment](MSB-AUTH-CREDENTIALS.postman_environment.json)

If you prefer using Postman for testing APIs, you can import this collection to quickly set up and test the endpoints provided by the hotel booking application.


##### 3. MYSQL Data

- **File**: [database_setup.sql](database_setup.sql)

This SQL script includes some sample data that you can use to populate the database for testing the functionality of the hotel booking application.

Feel free to explore and use these files according to your project requirements. 

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

## Installation
***Follow Proper Procedure to run Smoothly***

1. ##### Clone the repository
   
   Find the Link ( You Can Use Https/SSH)

   1.a)  
   ![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/1d28aa3b-4624-4256-8985-24b79baa5209.png)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

   1.b)  
   ![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/5551ea46-191b-4771-a17d-fbc658589c2f.png)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

   Use Command:
   ```bash
   git clone https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023.git
   ```

   
   ![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/0582c04e-0aed-4cd5-a982-0c22b2ac6a78.png)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

   1.1.a) Setup Database  
   ![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/8025fa34-0f15-4ed4-b91a-8365bf267593.png)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

2. #####  Setup Your IDE (I am Using `Spring Tool Suite`)  

   2.a) Local View  
   ![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/b99291d7-9679-42f0-9c2e-c2bfd8685d46.png)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

   2.b) Start with Specified Directory 
   ![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/045a0eaa-05eb-4fbe-a836-2d74c546cee3.png)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

   2.c) Import Maven Projects 
   ![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/d5b729aa-1ad3-4010-9db1-2b5999282748.png)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

   2.d) Choose Maven > Existing Projects  

   ![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/a05690a3-1b15-4122-8604-dfa362cbad8c.png)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

   2.e) Choose the directory of Project 

   ![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/c29db24c-8b07-4577-aca6-f177391ac250.png)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------


   2.f) Choose the root directory of Project 
   
   ![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/adc78f09-0b3e-44de-bdc2-78df19e4b232.png)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------


   2.g) Import All the Projects  
   
   ![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/6272b80a-b98b-43e3-921c-c2fdf2ba5905.png)

 -------------------------------------------------------------------------------------------------------------------------------------------------------------------


   2.h) Importing and Building will be done by IDE 
   
   ![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/f7b5e23d-48e5-4562-a496-971acb76ad85.png)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

3.  #####  Setup POSTMAN

   3.a) Import the Collection File  
   ![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/ae0feb1a-3738-4b88-82e4-393fd8550d94.png)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

   3.b) Choose File 
   ![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/758e5549-1be9-44cc-9d0f-5bfb23aa2a99.png)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

   3.c) Collection Page 
   ![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/7aecb806-e678-4684-9327-07ed0119458c.png)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

   3.d) Import Security Credentails 
   
   ![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/67adb19e-52d2-46d4-afe6-58057dbb652d.png)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

   ![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/cb8829ea-a749-42d2-b142-f68396d1a17e.png)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

   ![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/50fe1b25-8b1e-4a48-ae61-4fa9d473c904.png)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

   3.e) Choose Proper Environment 
   ![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/e7acf932-a2e0-4d29-8f66-27f3a4c05ede.png)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

4.  #####  Run the application: 
   
   ![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/a48125c0-50ed-4247-a18c-116e7e23bde4.png)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

   4.a)  Follow Order to Run Application Without Errors :
   
   ***1. Start Server*** 
   
   ![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/549c76cf-07c3-4c24-bf4a-217bac322a20.png)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

   ***2. Start Gateway***
   
   ![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/9c9100ec-6d6b-4ef2-bd63-bc6e0c5324d1.png)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

   ***1. Start Both Services*** 
   
   ![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/3b664ada-bb49-44e3-a985-969eb01fa37e.png)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

5. ##### Verify on  `https://localhost:8761` 

   ![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/0b9f386e-852c-4af9-8c0f-d44a037d4f8e)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

## Usage

The application provides RESTful APIs for managing hotels and bookings. You can use tools like `curl` or `Postman` to interact with the APIs.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

## Endpoints

## 1. Booking Service : [Booking Service](bookingservice)  

#### 1.1. Logic Class (To Calculate Price and Room Numbers) - [Class](bookingservice/src/main/java/com/bookingservice/logic/BusinessLogicMethodClass.java)
#### 1.2. Model Classes - [BookingInfoEntity](bookingservice/src/main/java/com/bookingservice/entity/BookingInfoEntity.java)
#### 1.3. Controller -

### **Endpoint 1: POST /booking** 
  
#### • URI: /booking
#### • HTTP METHOD: POST
#### • RequestBody: fromDate, toDate,aadharNumber,numOfRooms
#### • Response Status: Created
#### • Response: ResponseEntity<BookingInfoEntity>

#### ***Working*** 

![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/7e1fbb0a-7969-498e-8d3d-728f1cdc2347)

#### ***Database*** 

![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/26a5e512-413a-496f-8f7e-e1843e8dc4cf)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

#### ***Exception 1*** - If Any Of One Field is Missing 

![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/5c3474df-f2db-4815-805b-8da3d0ab2ca3)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

#### ***Exception 2*** - If Data within Same Date and AAdhar Number is Present 

![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/e2582e28-2a91-42a5-ab3e-8a4c0a581679)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

### **Endpoint 2: POST booking/{bookingId}/transaction**  
#### • URI: /booking/{bookingId}/transaction
#### • HTTP METHOD: POST
#### • PathVariable : int
#### • RequestBody : paymentMode, bookingId, upiId,cardNumber
#### • Response: ResponseEntity<BookingInfoEntity>

#### ***Working***  

![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/99144215-1378-4bb5-bca4-ecc59887515a)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

#### ***Database***  

![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/2227b006-fd18-4dd9-a4ac-756e94bde5f9)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/7e68d737-9254-4aa1-a1ba-7b90f98966a6)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

#### ***Exception 1*** - If the user gives any other input apart from “UPI” or “CARD”   

![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/59085d9e-dda2-4065-820e-e78fd00eec7a)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

#### ***Exception 2*** -  If no transactions exist for the Booking Id passed to this endpoint  

![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/3f3e3286-085f-4602-b9e0-b4eceb27a860)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

#### ***Exception 3*** -  If no Payment form is given  

![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/24fa71d5-549f-442a-baf1-485e99c44d7d)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

#### ***Exception 4*** -  If no Payment details is given for payment form 

![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/ccea3c29-6574-46b5-be37-a73fe36460c6)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/d00d5cab-2b3a-402e-83b8-d00116e422fd)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

#### ***Exception 5*** -  If Booking Id is different in Path Variable and Request Body 

![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/f6a3d7b2-e68b-4715-b109-45782250a3fa)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

### **Endpoint 3: GET hotel/getBookingByTransId/{transactionId}** 
#### • URI: hotel/getBookingByTransId/{transactionId}
#### • HTTP METHOD: GET
#### • PathVariable : int
#### • Response: ResponseEntity<BookingInfoEntity>

#### ***Working*** 

![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/5e8e486f-f3e5-452f-af46-e56c296bbb34)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

#### 1.3 Configure this service to run on port number 8081. 

![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/52377cbe-3ed1-4f85-8459-6847620d690f)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

#### 1.4 Configure the hotel booking service as Eureka Client 

[Main File](bookingservice/src/main/java/com/bookingservice/BookingserviceApplication.java)

![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/038855e8-9f2c-4c0b-a6f7-e65e9c99215b)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------


## 2. Payment Service : [Payment Service](paymentservice) 

#### 2.1. Model Classes - [TransactionDetailsEntity](paymentservice/src/main/java/com/paymentservice/entity/TransactionDetailsEntity.java)
#### 2.2. Controller -

***Note: This endpoint will be called by the ‘endpoint 2’ of the Booking service***

### **Endpoint 1: POST /transaction** 
  
#### • URI: /transaction
#### • HTTP METHOD: POST
#### • RequestBody: paymentMode, bookingId, upiId, cardNumber
#### • Response Status: Created
#### • Response: ResponseEntity<transactionId>

#### ***Working*** 

![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/7b0f274a-0f31-4da1-a181-a99d8645bac9)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

#### ***Database*** 

![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/e758d1c1-113b-4080-9dbc-5cc48f2baa60)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

#### ***Exception 1*** - If the user gives any other input apart from “UPI” or “CARD” 

![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/d9303ce7-e7b3-4c05-ac32-7841a1a26384)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

#### ***Exception 2*** -  If no Payment form is given 

![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/e660d085-8c0c-4f1f-8f08-3ca1a50397ea)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

#### ***Exception 3*** -   If no Payment details is given for payment form 

![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/032b56ea-4669-4066-9d06-543509b83c5f)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

### **Endpoint 2: GET /transaction/{transactionId}**  

#### • URI: /transaction/{transactionId}
#### • HTTP METHOD: GET
#### • Path Variable: int
#### • Response Status: OK
#### • Response: ResponseEntity<TransactionDetailsEntity>

#### ***Working*** 

![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/8f97768e-7ab1-4460-995b-3af58b095864)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

#### ***Exception 1*** - If transaction Not Exists 

![image](https://github.com/TheAvtarSingh/Hotel-Booking-MSBA-2023/assets/88712571/cb23d491-16c6-4c53-b9ec-6bf10f48f62a)


-------------------------------------------------------------------------------------------------------------------------------------------------------------------

Feel free to contribute to the project by opening issues or submitting pull requests. Your contributions are welcome!


-------------------------------------------------------------------------------------------------------------------------------------------------------------------

 
## License

This project is Coyrighted to  [@TheAvtarSingh](https://github.com/TheAvtarSingh/).


-------------------------------------------------------------------------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------------------------------------------------------------

