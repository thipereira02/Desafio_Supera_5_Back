# Desafio 5 - Supera

This project aims to build a service layer for a commonly performed operation in banks - generating bank statements. The Extractbank provides functionalities to retrieve and process bank statements, allowing users to view detailed transaction information within a specified date range.

## Technologies
The following tools and frameworks were used in the construction of this project:<br>

  ![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)&nbsp;
  ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)&nbsp;
  ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)&nbsp;
  
## Features
The system has implemented the following endpoints:

- GET /transfers/{accountId}: Retrieves a list of transfers for the specified account ID.
- GET /transfers/{accountId}/by-date: Retrieves a list of transfers for the specified account ID within a date range.
- GET /transfers/{accountId}/by-operator: Retrieves a list of transfers for the specified account ID performed by a specific operator.
- GET /transfers/{accountId}/by-date-and-operator: Retrieves a list of transfers for the specified account ID within a date range and performed by a specific operator.

## How to run

1. Make sure you have Java 17 (or higher) and Apache Maven installed on your machine.
2. Clone the repository to your local machine.
 ``
git clone https://github.com/thipereira02/Desafio_Supera_5_Back
``
3. Navigate to the cloned project directory.
4. Open the project in your preferred IDE.
5. Wait for the project dependencies to be resolved.
6. If you want to run the application via the command line, start by executing the following command:
    ``
    ./mvnw clean package
    ``

7. After that, run the command:.
    ``
    java -jar <...pathToYourJar>
    ``
8. The application will start and will be available at http://localhost:8080.