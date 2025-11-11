# 🎥 Movie Booking Demo (Java + JUnit 5)

## Overview

This is a simple demo project for learning and practicing **JUnit 5** testing in Java. The application simulates a **movie ticket booking process**, allowing you to test core business logic.

## Requirements

* **Java JDK 17** or higher
* **Maven 3.6** or higher

## Features

The demo simulates the following steps of a movie booking system:

1. Select a movie
2. Choose a showtime
3. Pick seats
4. Book tickets and validate the booking logic

## Running Tests

To run all tests, use Maven:

```bash
mvn test
```

The project includes **JUnit 5 tests** that cover the main business rules, including:

* Validating seat selection
* Ensuring showtime availability
* Booking workflow correctness

## Project Structure

```
src/main/java       # Application source code
src/test/java       # JUnit 5 test cases
pom.xml             # Maven configuration
```

## Learning Goals

* Understand how to write **unit tests** with JUnit 5
* Learn to **simulate a business workflow** in Java
* Practice **testing business logic** and edge cases

## License

This project is for **educational purposes only**.
