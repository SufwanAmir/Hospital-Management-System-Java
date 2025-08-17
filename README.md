🏥 Hospital Management System

A Java-based console application for managing patients, doctors, appointments, billing, and user accounts.
This project simulates the core functionalities of a hospital’s information system in a simple, interactive menu-driven format.

📌 Features
👨‍⚕️ Patient Management

Add new patients with validation (age, gender, contact number).

Update patient details.

Remove patient records.

Search patient by ID.

View all patient records.

👩‍⚕️ Doctor Management

Add new doctors with specialization and contact details.

Update doctor details.

Remove doctors from the system.

Search doctor by ID.

View all doctors.

📅 Appointment Scheduling

Schedule appointments between patients and doctors.

Validates date and time format (YYYY-MM-DD HH:MM).

Stores appointment details.

💰 Billing

Generate invoices for patients.

Display patient details with billing amount.

Payment instructions included.

🔐 Account Management

Login system for patients and doctors.

Create new accounts (username & password).

Change account passwords securely.

Prevents duplicate accounts.

🛠️ Technologies Used

Java (Core Java, OOP concepts, Exception Handling)

Console-based Menu System

Arrays for Data Storage

🚀 Getting Started
1. Clone the Repository
   git clone https://github.com/your-username/Hospital-Management-System.git

2. Open in IDE

Open the project folder in IntelliJ IDEA, Eclipse, or VS Code.

3. Run the Application

Compile and run the Main.java file:

javac Main.java
java Main

📖 Usage Guide

After starting the program, you’ll see a main menu:

----- HOSPITAL MANAGEMENT SYSTEM ------
Enter 1 for Patient Management
Enter 2 for Doctor Management
Enter 3 for Billing
Enter 4 for Appointment Scheduling
Enter 5 to Manage Accounts
Enter 0 to Exit
---------------------------------------


Choose an option by entering the corresponding number.

🔑 Demo Login Credentials

Use the following credentials to log in:

Username: sufwan
Password: sufwan063
or you can create your own account.



Each section (patients, doctors, billing, etc.) has its own sub-menu.

Example: In Patient Management, you can add, update, or search patients.

📌 Example Flow

Add a patient (system generates a Patient ID, e.g., P1).

Add a doctor (system generates a Doctor ID, e.g., D1).

Schedule an appointment between P1 and D1.

Generate a bill for P1.

🧩 Future Improvements

Replace arrays with ArrayLists or database integration (MySQL/PostgreSQL).

Implement persistent storage (files or DB) to save records permanently.

Add a GUI (JavaFX/Swing) for a user-friendly experience.

Introduce role-based authentication (Admin, Doctor, Patient).

Extend billing with insurance support & payment records.

👨‍💻 Author

Sufwan Amir

📧 sufwanamir99@gmail.com

🌐 https://www.linkedin.com/in/sufwan-amir-2a0a54363/