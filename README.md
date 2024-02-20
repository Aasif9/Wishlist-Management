## Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/your_username/WishlistManagement.git
   ```

2. Navigate to the project directory:

   ```bash
   cd WishlistManagement
   ```

3. Build the project using Maven:

   ```bash
   mvn clean install
   ```

4. Run the application:

   ```bash
   mvn spring-boot:run
   ```


## Database Setup

To set up the database for the WishlistManagement application, follow these steps:

1. Open the `application.properties` file in the project's `src/main/resources` directory.

2. Configure the datasource properties according to your MySQL database setup:
   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/Employee_Wishlist?autoReconnect=true&useSSL=false&createDatabaseIfNotExist=true
   spring.datasource.username=your_database_username
   spring.datasource.password=your_database_password
   spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
   spring.jpa.hibernate.ddl-auto=update
   ```

   Replace `your_database_username` and `your_database_password` with your MySQL database credentials.

3. Optionally, configure Hibernate properties for SQL logging:
   ```
   spring.jpa.properties.hibernate.show_sql=true
   spring.jpa.properties.hibernate.use_sql_comments=true
   spring.jpa.properties.hibernate.format_sql=true
   ```

   These properties enable SQL logging in the console for debugging purposes.

## Default Spring Security Credentials

By default, Spring Security is enabled in the WishlistManagement application.

Ensure to replace the default credentials with your own before deploying the application to production.

## Usage

- Access the application through your web browser at `http://localhost:8080`.
- Use the provided API endpoints to interact with wishlists programmatically.

## Contributing

Contributions are welcome! Please feel free to submit pull requests or open issues for any improvements or features you'd like to see.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
