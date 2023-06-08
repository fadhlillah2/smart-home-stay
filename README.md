
# Smart Home Stay

Smart Home Stay is a SpringBoot application that manages a homestay booking system with Apache Kafka integration.

## Features

1. **User Registration**: New users can register.
2. **Room Booking**: Users can view available rooms and book them.
3. **Facility Selection**: Users can select additional facilities during room booking.
4. **Check-In/Out**: Users can check-in and check-out.
5. **Billing and Payment**: Employees can calculate bills and accept payments.

Kafka events are produced when a user registers, a room is booked, and a payment is made.

## Prerequisites

- Java 11
- Spring Boot
- Spring Data JPA
- Apache Kafka

## System Architecture
The system architecture for the Smart Home Stay solution could be roughly represented as follows:

1. **User Interface**: This is where users interact with the system. They can register, check in and out, explore rooms, choose additional facilities, and so forth. This could be a web interface or a mobile app.

2. **Application Server**: This is where the main logic of the system resides. The server receives requests from the user interface, interacts with the database and Kafka, and sends responses back to the user interface.

   - **Controllers**: Handle incoming HTTP requests and delegate processing to the appropriate service.
   - **Services**: Implement the main business logic of the application.
   - **Repository**: Interface with the database to store and retrieve data.

3. **Database**: This is where all the data of the system is stored. It holds tables for users, rooms, facilities, check-ins and check-outs, payments, etc.

4. **Apache Kafka**: A distributed streaming platform used for building real-time data pipelines and streaming apps. Events such as user registrations, room bookings, and payments are published to Kafka topics, and can be processed in real-time or stored for later processing.

The flow of data could be like this:

- Users send requests from the User Interface to the Application Server.
- The Application Server processes these requests, interacting with the Database to fetch or store data, and with Kafka to publish events.
- The Kafka system can process these events in real-time, or they can be consumed later for processing.

Here's a basic ASCII diagram to illustrate the architecture:

```
+---------------+        +-------------------+
| User Interface| <----> |Application Server|
+---------------+        +-------------------+
                                 |   |
                                 |   |
                           +-----+   +-----+
                           |                 |
               +--------+  |  +------------+ |
               |Database|  |  | Apache Kafka|
               +--------+  |  +------------+ |
                           |                 |
                           +-----------------+
```

Remember, this is a high-level view of the system architecture and could be refined or expanded based on specific project requirements.


## Prerequisites

- Java 11 or later
- Maven 3.6.3 or later
- Apache Kafka 2.8.0 or later

## How to Run

1. Clone the repository: `git clone https://github.com/fadhlillah2/smart-homestay.git`
2. Navigate to the project directory: `cd smart-homestay`
3. Build the project: `mvn clean install`
4. Run the application: `mvn spring-boot:run`

## REST APIs

- POST `/users/register`: Register a new user
- GET `/rooms/available`: Get available rooms
- POST `/rooms/book/{id}`: Book a room with given ID
- GET `/facilities`: Get available facilities
- POST `/checkin/{userId}/{roomId}`: Check-in user to room
- POST `/checkout/{checkInId}`: Check-out user
- POST `/payments/{checkInId}`: Make a payment for a check-in


## Kafka Topics

- `user.register`: User registration events
- `room.booked`: Room booking events
- `payment.received`: Payment received events

## Contributing

We welcome contributions! Please feel free to open an issue or create a pull request if you have something to contribute to the project.

## License

This project is licensed under the [MIT License](LICENSE).

## Contact Information

If you have any questions or run into any issues, please open an issue on this GitHub repository.

---
