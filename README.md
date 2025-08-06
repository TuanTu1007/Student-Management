# Student Management System

## Overview

This project is a web-based Student Management System developed as a Java programming course project. The system facilitates the management of student information, grades, classes, and subjects for educational institutions. It uses Java technologies (Servlet, JSP), MySQL for data storage, and integrates a chatbot using Google’s Dialogflow Essentials for enhanced user interaction.

## Features

- **User Roles**:
  - **Admin**: Manage accounts, classes, subjects, and system regulations (e.g., age and grade constraints).
  - **Teacher**: View and manage grades, access student and class information.
  - **Office**: Handle administrative tasks like student enrollment and class assignments.
  - **Student**: View personal information and academic results.
- **Core Functionalities**:
  - Manage student profiles (add, edit, delete, search).
  - Manage classes and subjects (add, edit, delete).
  - Grade management (input, view, export grade reports).
  - Generate semester and annual academic reports.
  - Chatbot integration for user queries using Dialogflow.
- **Database**: MySQL database with tables for students, classes, subjects, grades, and academic years.
- **Constraints**: Ensures data integrity (e.g., unique class/subject names, non-deletable active classes/subjects).
- **Responsive UI**: Clear and user-friendly interface for easy navigation.

## Prerequisites

To run or develop this project, ensure you have:

- **Java Development Kit (JDK)**: Version 17 or higher.
- **Apache Tomcat**: Version 9 or higher for deploying the web application.
- **MySQL**: Version 5.7 or higher for the database.
- **Dialogflow Account**: For chatbot integration (requires API credentials).
- A modern web browser (e.g., Chrome, Firefox).
- A text editor or IDE (Eclipse).

# Key Screens:
- Login: Authenticate users based on their role.
- Account Management: Admins can create, edit, or delete user accounts.
- Student Information: View, add, edit, or search student profiles.
- Class Management: Add, edit, or delete classes; assign students to classes.
- Subject Management: Manage subjects and their coefficients.
- Grade Management: Input, view, or export grades; generate reports.
- Chatbot: Interact with the Dialogflow-powered chatbot for assistance.
- Reports: Generate semester summaries or filter students by academic performance (e.g., “Khá” for good performers).

# Project Structure
```
Student-Management/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── servlet/       # Servlets for handling client requests
│   │   │   └── dao/
│   │   │   └── web/       
│   │   ├── webapp/
│   │   │   ├── WEB-INF/
│   │   │   │   └── web.xml    # Web application configuration
│   │   │   ├── jsp/           # JSP files for UI
│   │   │   ├── css/           # Stylesheets
│   │   │   └── js/            # JavaScript for client-side logic
├── database/
│   └── schema.sql             # MySQL schema (if included)
├── pom.xml                    # Maven dependencies (if applicable)
└── README.md                  # Project documentation
```

# Contributing
Contributions are welcome! To contribute:
1. Fork the repository.
2. Create a new branch (git checkout -b feature/your-feature).
3. Make changes and commit (git commit -m "Add your feature").
4. Push to the branch (git push origin feature/your-feature).
5. Open a pull request.
