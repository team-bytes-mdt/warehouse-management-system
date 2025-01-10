# Warehouse Management System

## Project Description
The Warehouse Management System (WMS) is a Spring Boot application designed to streamline warehouse operations. It provides functionalities for inventory management, order processing, and user management. The system supports both RESTful APIs and GraphQL endpoints to enhance flexibility in data retrieval and manipulation.

## Features
- **Inventory Management:** Create, update, view, and delete inventory items.
- **Order Management:** Process orders and track their statuses.
- **User Management:** Manage roles and user accounts.
- **GraphQL Support:** Query and mutate data using GraphQL APIs.
- **Web Interface:** Interactive templates for managing inventories, items, orders, and users.

## Project Structure
```plaintext
├── Domain Model.pdf               # Project's domain model diagram
├── HELP.md                        # Spring Boot help file
├── mvnw, mvnw.cmd                 # Maven wrapper scripts
├── pom.xml                        # Maven project configuration
├── src
│   ├── main
│   │   ├── java
│   │   │   └── de.fhdo.warehouseMgmtSys
│   │   │       ├── WarehouseMgmtSysApplication.java   # Main application class
│   │   │       ├── controllers                        # REST controllers
│   │   │       ├── converters                         # DTO converters
│   │   │       ├── domain                             # Domain entities
│   │   │       ├── dto                                # Data Transfer Objects
│   │   │       ├── graphqlapi                         # GraphQL controllers
│   │   │       ├── repositories                       # Repository interfaces
│   │   │       └── service                            # Business logic
│   │   └── resources
│   │       ├── application.properties                 # Configuration file
│   │       ├── data.sql                               # Initial data script
│   │       ├── graphql                                # GraphQL schema
│   │       ├── schema.sql                             # Database schema
│   │       ├── static                                 # Static resources
│   │       └── templates                              # HTML templates
│   └── test
│       └── java
│           └── de.fhdo.warehouseMgmtSys
│               └── WarehouseMgmtSysApplicationTests.java # Unit tests
├── target                          # Compiled output
└── warehouseMgmtSys.iml           # IntelliJ IDEA project file
```

## Installation

### Prerequisites
- Java 17 or later
- Maven 3.8+

### Steps
1. Clone the repository:
   ```bash
   git clone <repository_url>
   ```
2. Navigate to the project directory:
   ```bash
   cd warehouseMgmtSys
   ```
3. Configure the database in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:h2:mem:warehousedb
   spring.datasource.username=sa
   spring.datasource.password=<your_db_password>
   ```
4. Build the project:
   ```bash
   ./mvnw clean install
   ```
5. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

## Usage

### Web Interface
Access the web interface at [http://localhost:8080](http://localhost:8080).

### H2 Database Console
Access the web interface at [http://localhost:8080/h2-console](http://localhost:8080/h2-console).

### REST Endpoints
- Inventory: `/api/inventory`
- Item: `/api/item`
- Order: `/api/order`
- User: `/api/user`

### GraphQL
GraphQL API is available at [http://localhost:8080/graphiql?path=/graphql](http://localhost:8080/graphiql?path=/graphql).

## Testing
Run unit tests using:
```bash
./mvnw test
```

## Contributing
Contributions are welcome! Please follow these steps:
1. Fork the repository.
2. Create a new branch for your feature or bugfix.
3. Submit a pull request.

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.

## Contact
For any inquiries, please contact the project maintainer at [allen.mwandunga001@stud.fh-dortmund.de].
