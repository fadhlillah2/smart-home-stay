
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
