Title: HRM System – Human Resource Management Portal for Developers

Overview

This project is a full-stack HRM (Human Resource Management) web application tailored for developers working in an AI technology company. The system is designed to support a 4-day remote work week with intelligent features like availability tracking, login monitoring, feedback on performance, and basic LLM-enhanced insights.

It uses:

Frontend: HTML, CSS, JavaScript

Backend: JSP (Java Server Pages)

Database: MySQL

Server: Apache Tomcat (No Spring Boot, Hibernate, or Servlets)

🛠 Features

User Authentication

Login system with role support (manager or developer)

Session tracking for access control

Availability Submission

Weekly 4-day (Monday–Thursday) availability submission

Automatically records the week start date and submission timestamp

Login Tracking

Users can manually or automatically log daily check-in/out

Dashboard

Displays user greeting and access to all major modules

Variance Analysis

Compares planned availability vs. actual hours logged

Calculates whether the target (36 hours/week) is met

Feedback Module

Provides performance feedback based on hours logged

Optionally integrates open-source LLM (like OpenAI) for intelligent tips

Admin Notification (Optional)

Warns admin if availability is not submitted for the week

📁 Project Structure

HRM-System/
├── loginpage1.html → Login Page
├── login_check.jsp → Processes login
├── logout.jsp → Ends session
├── submit_availability_action.jsp → Handles availability submission
│
├── css/
│ └── style.css → Styles for pages
├── js/
│ └── script.js → (Optional) JavaScript
├── db/
│ └── dbconfig.jsp → DB connection logic
├── jsp/
│ ├── dashboard.jsp → Landing page after login
│ ├── submit_availability.jsp → Weekly availability form
│ ├── view_logins.jsp → Shows past login records
│ └── feedback.jsp → Shows variance and feedback
└── README.txt → This file

🧠 How to Run the Project

Prerequisites

Java JDK 8 or higher

Apache Tomcat 9 or 10

MySQL Database

MySQL Connector JAR (put it in tomcat/lib folder)

Set up MySQL Database

Createing the schema and tables using:
CREATE DATABASE hrm_system;
USE hrm_system;

CREATE TABLE users (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100),
email VARCHAR(100),
password VARCHAR(100),
role VARCHAR(50)
);

CREATE TABLE availability (
id INT AUTO_INCREMENT PRIMARY KEY,
user_id INT,
week_start DATE,
mon_available BOOLEAN,
tue_available BOOLEAN,
wed_available BOOLEAN,
thu_available BOOLEAN,
submitted_at DATETIME
);

CREATE TABLE logins (
id INT AUTO_INCREMENT PRIMARY KEY,
user_id INT,
login_date DATE,
login_time TIME,
logout_time TIME,
hours_worked DECIMAL(5,2)
);

Add Test Users

INSERT INTO users (name, email, password, role) VALUES
('Sakshi Gumma', 'sakshi@example.com', '123456', 'developer');

Configure DB

In db/dbconfig.jsp:
String dbURL = "jdbc:mysql://localhost:3306/hrm_system";
String dbUser = "root";
String dbPass = "Sakshi@2020";

Deploy the Project

Place HRM-System folder into tomcat/webapps/

Start Tomcat (bin/startup.bat)

Open browser: http://localhost:8080/HRM-System/register.html

Login and Use

Login with email/password from DB

Submit availability

View dashboard, feedback, and logout

📊 Sample Flow

Monday: Login and submit availability for Mon–Thu

Each day: Log login/logout time

End of week: Visit Feedback to check hours variance

🧠 Optional LLM Integration

To enhance the feedback module using a Large Language Model (LLM):

Set up a Python Flask API using OpenAI or Cohere

From feedback.jsp, send HTTP POST request with:

planned hours

actual hours

role or task

Receive feedback response and display it

🔐 Security Notes

Passwords are stored as plaintext (for demo only) → You can use SHA-256

No input validation or CSRF/XSS prevention → Can be enhanced in production

🚀 Future Improvements

Add real-time notifications/email alerts for missing availability

Admin dashboard for monitoring all team members

Export weekly reports as PDF or Excel

Add real-time charts for productivity trends
