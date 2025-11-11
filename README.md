
# Smart Home Stay 🏡

> A modern, full-stack homestay booking management system with real-time event processing and microservices architecture.

Smart Home Stay is a comprehensive Spring Boot and React application that provides a complete solution for managing homestay accommodations. The system handles user management, room bookings, facility selection, check-in/out processes, and billing—all with real-time event streaming through Apache Kafka.

---

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Quick Start](#quick-start)
  - [Using Docker (Recommended)](#using-docker-recommended)
  - [Local Setup](#local-setup)
- [Configuration](#configuration)
- [REST API Documentation](#rest-api-documentation)
- [Kafka Events](#kafka-events)
- [System Architecture](#system-architecture)
- [Development Guide](#development-guide)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

---

## 📝 Overview

**Smart Home Stay** is designed to streamline the management of homestay accommodations through an intuitive interface and robust backend infrastructure. It leverages modern technologies including:

- **Real-time event processing** via Apache Kafka
- **Full-stack architecture** with separated frontend and backend
- **Database persistence** using PostgreSQL
- **Containerized deployment** with Docker
- **RESTful API** for seamless integration

The application is production-ready and scalable, suitable for deployment in cloud environments.

---

## ✨ Features

### Core Functionality

1. **User Management**
   - User registration with validation
   - Profile management
   - User authentication (extensible for OAuth/JWT)

2. **Room Management**
   - Browse available rooms with detailed information
   - Real-time room availability tracking
   - Book rooms with flexible date selection
   - Room inventory management

3. **Facility Selection**
   - Select additional amenities during booking
   - Manage facility inventory and availability
   - Dynamic pricing for facility add-ons

4. **Check-In/Check-Out System**
   - Streamlined check-in process for users
   - Check-out tracking and management
   - Guest history and statistics

5. **Billing & Payment Processing**
   - Automatic bill calculation based on duration and facilities
   - Payment acceptance and processing
   - Payment history and receipts

6. **Real-Time Event Streaming**
   - Asynchronous event processing via Apache Kafka
   - Event-driven architecture for scalability
   - Real-time notifications and updates

---

## 🛠️ Tech Stack

### Backend
- **Framework**: Spring Boot 2.7.12
- **Language**: Java 17
- **Database**: PostgreSQL
- **ORM**: Spring Data JPA with Hibernate
- **Message Queue**: Apache Kafka (event-driven architecture)
- **Build Tool**: Maven 3.6.3+
- **Additional**: Lombok, Hibernate Validator, Spring Web

### Frontend
- **Framework**: React 18.2.0
- **Build Tool**: Create React App (react-scripts 5.0.1)
- **Testing**: Jest and React Testing Library
- **Language**: JavaScript (ES6+)
- **Styling**: CSS

### Infrastructure
- **Containerization**: Docker & Docker Compose
- **Service Discovery**: Eureka (optional microservices support)
- **Database**: PostgreSQL 12+

---

## 📁 Project Structure

```
smart-home-stay/
├── FE/                                    # Frontend Application (React)
│   └── smart-home-stay/
│       ├── public/                        # Static assets
│       ├── src/
│       │   ├── App.js                     # Main application component
│       │   ├── RegistrationForm.js        # User registration UI
│       │   ├── RoomList.js                # Room listing component
│       │   ├── BookingForm.js             # Booking interface
│       │   ├── CheckoutForm.js            # Checkout component
│       │   ├── PaymentForm.js             # Payment processing UI
│       │   ├── App.css                    # Global styles
│       │   └── index.js                   # React entry point
│       ├── package.json                   # Dependencies
│       └── README.md                      # Frontend documentation
│
├── service-one/                           # Backend Application (Spring Boot)
│   ├── src/main/java/com/komodo/serviceone/
│   │   ├── controller/                    # REST API endpoints
│   │   │   ├── UserController.java
│   │   │   ├── RoomController.java
│   │   │   ├── FacilityController.java
│   │   │   ├── CheckInController.java
│   │   │   ├── CheckOutController.java
│   │   │   └── PaymentController.java
│   │   ├── service/                       # Business logic layer
│   │   │   ├── UserService.java
│   │   │   ├── RoomService.java
│   │   │   ├── FacilityService.java
│   │   │   ├── CheckInService.java
│   │   │   ├── CheckOutService.java
│   │   │   └── PaymentService.java
│   │   ├── entity/                        # JPA entities (database models)
│   │   │   ├── User.java
│   │   │   ├── Room.java
│   │   │   ├── Facility.java
│   │   │   ├── CheckIn.java
│   │   │   ├── CheckOut.java
│   │   │   └── Payment.java
│   │   └── repository/                    # Data access layer
│   │       ├── UserRepository.java
│   │       ├── RoomRepository.java
│   │       ├── FacilityRepository.java
│   │       ├── CheckInRepository.java
│   │       ├── CheckOutRepository.java
│   │       └── PaymentRepository.java
│   ├── src/main/resources/
│   │   └── application.properties         # Backend configuration
│   ├── pom.xml                            # Maven dependencies
│   ├── mvnw, mvnw.cmd                     # Maven wrapper
│   ├── Dockerfile                         # Backend Docker image
│   └── api.http                           # HTTP request examples
│
├── docker-compose.yml                     # Multi-container orchestration
├── .env.example                           # Environment configuration template
├── Makefile                               # Docker automation commands
├── README.md                              # This file
└── smart-home-stay.iml                    # IntelliJ IDE configuration

```

---

## 📦 Prerequisites

### Minimum Requirements
- **Java**: 17 or higher
- **Maven**: 3.6.3 or later
- **Node.js**: 16+ (for frontend development)
- **npm**: 8+ (for frontend dependency management)

### For Docker Deployment
- **Docker**: 20.10+
- **Docker Compose**: 1.29+

### For Production
- **PostgreSQL**: 12 or later
- **Apache Kafka**: 2.8.0 or later
- **Eureka** (optional): For microservices discovery

---

## 🚀 Quick Start

### Using Docker (Recommended)

The easiest way to get started is using Docker Compose, which sets up the entire stack automatically.

```bash
# Clone the repository
git clone https://github.com/fadhlillah2/smart-home-stay.git
cd smart-home-stay

# Start the application stack
make start

# Or manually using docker-compose
docker-compose up -d

# View logs
docker-compose logs -f

# Stop the application
docker-compose down
```

The application will be available at:
- **Frontend**: http://localhost:3000
- **Backend API**: http://localhost:8080
- **PostgreSQL**: localhost:5435

### Local Setup

#### Backend Setup

```bash
# Navigate to backend directory
cd service-one

# Build the project
mvn clean install

# Configure database (update service-one/src/main/resources/application.properties)
# Ensure PostgreSQL is running and accessible

# Run the application
mvn spring-boot:run

# The API server will start on http://localhost:8080
```

#### Frontend Setup

```bash
# Navigate to frontend directory
cd FE/smart-home-stay

# Install dependencies
npm install

# Start the development server
npm start

# The frontend will open at http://localhost:3000
```

---

## ⚙️ Configuration

### Backend Configuration

Edit `service-one/src/main/resources/application.properties`:

```properties
# Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5435/users
spring.datasource.username=uroot
spring.datasource.password=qwertyui
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update

# Kafka Configuration
spring.kafka.bootstrap-servers=localhost:9092
spring.kafka.consumer.group-id=smart-home-stay-group
spring.kafka.consumer.auto-offset-reset=earliest

# Server Port
server.port=8080
```

### Environment Configuration

Copy `.env.example` to `.env` and configure:

```bash
cp .env.example .env
```

Key variables to configure:
- `DB_USERNAME`: PostgreSQL username
- `DB_PASSWORD`: PostgreSQL password
- `KAFKA_BOOTSTRAP_SERVERS`: Kafka broker addresses
- `EUREKA_SERVER_URL`: (Optional) Eureka service registry URL

---

## 🔌 REST API Documentation

### User Management

```
POST /users/register
├─ Description: Register a new user
├─ Body: { "name": "John Doe", "email": "john@example.com", "password": "..." }
└─ Returns: User object with ID

GET /users
├─ Description: Get all registered users
└─ Returns: List of all users

GET /users/{id}
├─ Description: Get a specific user by ID
└─ Returns: User object

PUT /users/{id}
├─ Description: Update user information
├─ Body: { "name": "...", "email": "..." }
└─ Returns: Updated user object

DELETE /users/{id}
├─ Description: Delete a user
└─ Returns: Success message
```

### Room Management

```
GET /rooms/available
├─ Description: Get all available rooms
├─ Query Params: checkInDate, checkOutDate (optional)
└─ Returns: List of available rooms

POST /rooms/book/{id}
├─ Description: Book a specific room
├─ Body: { "userId": "...", "checkInDate": "...", "checkOutDate": "..." }
└─ Returns: Booking confirmation

GET /rooms/{id}
├─ Description: Get detailed room information
└─ Returns: Room object with amenities
```

### Facility Management

```
GET /facilities
├─ Description: Get all available facilities
└─ Returns: List of facilities with pricing

POST /facilities
├─ Description: Add a new facility
├─ Body: { "name": "...", "description": "...", "price": ... }
└─ Returns: Facility object
```

### Check-In/Check-Out

```
POST /checkin/{userId}/{roomId}
├─ Description: Check-in a user to a room
├─ Body: { "facilities": [...] }
└─ Returns: Check-in confirmation with billing estimate

POST /checkout/{checkInId}
├─ Description: Check-out a user
└─ Returns: Final bill details
```

### Payment Processing

```
POST /payments/{checkInId}
├─ Description: Process payment for a check-in
├─ Body: { "amount": ..., "paymentMethod": "..." }
└─ Returns: Payment confirmation

GET /payments/{checkInId}
├─ Description: Get payment history for a check-in
└─ Returns: Payment details
```

---

## 📨 Kafka Events

The system publishes the following Kafka topics for real-time event processing:

### User Events
- **Topic**: `user.register`
- **Event**: Triggered when a user registers
- **Payload**: `{ userId, name, email, registeredAt }`

### Room Booking Events
- **Topic**: `room.booked`
- **Event**: Triggered when a room is successfully booked
- **Payload**: `{ bookingId, userId, roomId, checkInDate, checkOutDate }`

### Payment Events
- **Topic**: `payment.received`
- **Event**: Triggered when a payment is processed
- **Payload**: `{ paymentId, checkInId, amount, paymentMethod, processedAt }`

### Example Kafka Consumer Setup

```java
@KafkaListener(topics = "user.register", groupId = "smart-home-stay-group")
public void handleUserRegistration(String message) {
    log.info("User registered: {}", message);
    // Process registration event
}
```

---

## 🏗️ System Architecture

### High-Level Architecture

```
┌─────────────────────────────────────────────────────────────┐
│                    React Frontend                            │
│              (http://localhost:3000)                         │
└─────────────────────────────┬───────────────────────────────┘
                              │ HTTP REST API
┌─────────────────────────────▼───────────────────────────────┐
│                  Spring Boot Backend                         │
│              (http://localhost:8080)                         │
│  ┌──────────────────────────────────────────────────────┐   │
│  │         Controllers → Services → Repositories        │   │
│  └──────────────┬───────────────────────────────────────┘   │
└─────────────────┼─────────────────────────────────────────────┘
                  │
      ┌───────────┴──────────────┐
      │                          │
      ▼                          ▼
┌──────────────────┐      ┌──────────────────┐
│   PostgreSQL     │      │  Apache Kafka    │
│    Database      │      │ (Event Streaming)│
│  (Data Storage)  │      │  (Message Queue) │
└──────────────────┘      └──────────────────┘
```

### Data Flow

1. **User Request**: User interacts with React frontend
2. **API Call**: Frontend sends HTTP request to backend REST API
3. **Business Logic**: Spring Boot service processes the request
4. **Data Persistence**: Repository layer interacts with PostgreSQL
5. **Event Publishing**: Relevant Kafka events are published
6. **Real-Time Processing**: Event consumers process events asynchronously
7. **Response**: Backend returns response to frontend
8. **UI Update**: Frontend updates UI with response data

---

## 👨‍💻 Development Guide

### Backend Development

```bash
cd service-one

# Run tests
mvn test

# Run with development profile
mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=dev"

# Build production JAR
mvn clean package -DskipTests

# Check code quality
mvn verify
```

### Frontend Development

```bash
cd FE/smart-home-stay

# Run development server
npm start

# Run tests
npm test

# Build for production
npm run build

# Run linting
npm run lint
```

### Docker Development

```bash
# Build specific service
docker-compose build service-one
docker-compose build frontend

# Run in development mode
docker-compose up -d

# View service logs
docker-compose logs -f service-one

# Access container shell
docker-compose exec service-one /bin/bash
```

---

## 🐛 Troubleshooting

### Backend Issues

**Connection Refused on Port 8080**
```bash
# Check if port is already in use
lsof -i :8080

# Kill process on port 8080 (if needed)
kill -9 <PID>
```

**Database Connection Error**
- Ensure PostgreSQL is running
- Verify credentials in `application.properties`
- Check database exists and is accessible

**Kafka Connection Issues**
- Ensure Kafka broker is running on configured address
- Check Kafka connectivity: `telnet localhost 9092`
- Review Kafka logs for errors

### Frontend Issues

**Port 3000 Already in Use**
```bash
# Check process on port 3000
lsof -i :3000

# Run on different port
PORT=3001 npm start
```

**Dependency Issues**
```bash
# Clear npm cache and reinstall
rm -rf node_modules package-lock.json
npm install
```

### Docker Issues

**Port Conflicts**
- Edit `docker-compose.yml` to use different port mappings
- Ensure no other services occupy required ports

**Memory Issues**
- Increase Docker memory allocation
- Review container resource limits in `docker-compose.yml`

---

## 🤝 Contributing

We welcome contributions! Please follow these steps:

1. **Fork** the repository
2. **Create** a feature branch: `git checkout -b feature/your-feature`
3. **Commit** your changes: `git commit -m 'Add your feature'`
4. **Push** to the branch: `git push origin feature/your-feature`
5. **Open** a Pull Request with a clear description

### Contribution Guidelines
- Follow Java/JavaScript code style conventions
- Add tests for new features
- Update documentation as needed
- Ensure all tests pass before submitting

---

## 📄 License

This project is licensed under the [MIT License](LICENSE). See the LICENSE file for details.

---

## 📬 Contact & Support

- **GitHub Issues**: [Report bugs or request features](https://github.com/fadhlillah2/smart-home-stay/issues)
- **Discussions**: Join our community discussions for questions and ideas
- **Email**: Contact the maintainers for direct support

---

## 🙏 Acknowledgments

- Spring Boot community for excellent documentation
- React community for frontend best practices
- Apache Kafka for real-time streaming capabilities

---

**Last Updated**: November 2024
**Version**: 1.0.0
