develop a RESTful CRUD API for managing a railway management system using Spring Boot. The API should include endpoints for creating, reading, updating, and deleting resources related to trains, stations, and tickets. Additionally, the API should implement basic authentication to ensure that only authorized users can access the endpoints. 

Requirements: 
1. Resource Entities: Define data models/entities for the following resources: 
•	Train: Include attributes such as train number, departure time, arrival time, origin station, destination station, seat capacity, and ticket price. 
•	Station: Include attributes such as station code, station name, location, and contact information. 
•	Ticket: Include attributes such as ticket ID, passenger name, seat number, train ID, and departure date. 
2.	Repositories: Implement repository interfaces to interact with the database using JPA (Java Persistence API). Define separate repositories for trains, stations, and tickets. 
3.	Controllers: Create RESTful endpoints for CRUD operations on trains, stations, and tickets. Use appropriate HTTP methods and URI paths. For example: 
•	Train endpoints: /api/trains (GET - get all trains), /api/trains/{id} (GET - get train by id), /api/trains (POST - create a new train), etc. 
•	Station endpoints: /api/stations (GET - get all stations), /api/stations/{id} (GET - get station by id), /api/stations (POST - create a new station), etc. 
•	Ticket endpoints: /api/tickets (GET - get all tickets), /api/tickets/{id} (GET - get ticket by id), /api/tickets (POST - create a new ticket), etc. 
4.	Service Layer: Implement service methods to handle business logic and interact with the repositories. For example, service methods for creating a train, updating a station, booking a ticket, etc. 
5.	Authentication: Implement basic authentication using Spring Security. Ensure that endpoints are secured, and only authenticated users can access them. You can use username and password-based authentication or token based authentication.
    • this project use JWT token based authentication
6.	Documentation: Provide clear and concise documentation for the API, including endpoint descriptions, request/response formats, and authentication requirements. Use tools like Swagger or Spring Rest Docs to generate API documentation.

swagger UI path : http://localhost:8080/swagger-ui/index.html#/

spring datasource driver : Postgres

spring JPA : hibernate
