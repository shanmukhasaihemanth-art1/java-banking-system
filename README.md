# Java Banking System

A console-based banking application built using Java demonstrating Object-Oriented Programming (OOP) concepts and transaction management.

## Features
- Create bank account
- Deposit money
- Withdraw money
- Check account balance
- View transaction history
- Data persistence using file handling

## Project Structure

src/bank
│
├── app
│   └── Main.java
│
├── model
│   ├── Account.java
│   └── Transaction.java
│
├── repository
│   └── AccountRepository.java
│
├── service
│   └── BankService.java
│
└── util
    └── FileUtil.java

## Technologies Used

- Java
- Object-Oriented Programming
- File Handling
- Command Line Interface

## How to Run

1. Compile the project
javac src/bank/**/*.java

2. Run the program
java -cp src bank.app.Main
