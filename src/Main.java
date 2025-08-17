import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static final int MAX_PATIENTS = 100;
    static final int MAX_DOCTORS = 50;
    static int patientCount = 0;
    static int doctorCount = 0;
    static String[][] patients = new String[MAX_PATIENTS][5];
    static String[][] doctors = new String[MAX_DOCTORS][4];
    static String[][] appointments = new String[MAX_PATIENTS][MAX_DOCTORS];
    static Scanner input = new Scanner(System.in);

    static String[][] accounts = new String[20][2];


    public static void main(String[] args) {
        accounts[0][0]  = "sufwan";
        accounts[1][0] = "huzaima";
        accounts[2][0] = "zaryan";
        accounts[0][1] = "sufwan063";
        accounts[1][1] = "huzaima017";
        accounts[2][1] = "zaryan039";
        try {
            int choice = -1;

            while (choice != 0) {
                System.out.println("-----HOSPITAL MANAGEMENT SYSTEM------");
                System.out.println("Enter 1 for Patient Management");
                System.out.println("Enter 2 for Doctor Management");
                System.out.println("Enter 3 for Billing");
                System.out.println("Enter 4 for Appointment Scheduling");
                System.out.println("Enter 5 to manage acounts");
                System.out.println("Enter 0 to exit \n ----------------------------------");

                System.out.print("Enter your choice: ");
                choice = input.nextInt();
                input.nextLine();

                if (choice == 1) {
                    patientManagement();
                } else if (choice == 2) {
                    System.out.println("Enter username to login: ");
                    String newp_username = input.nextLine();
                    System.out.println("Enter password: ");
                    String newp_password = input.nextLine();
                    boolean found = false;
                    for (int i = 0; i < accounts.length; i++) {
                        for (int j = 0; j < accounts[i].length; j++) {
                            if (newp_username.equals(accounts[i][0]) && newp_password.equals(accounts[i][1])) {
                                System.out.println("Login Successful");
                                found = true;
                                break;
                            }
                        }
                        if (found) {
                            break;
                        }
                    }

                    if (found) {
                        doctorManagement();
                    }
                } else if (choice == 3) {
                    billing();
                } else if (choice == 4) {
                    appointmentScheduling();
                } else if (choice == 5){
                    System.out.println("Press 1 to add account");
                    System.out.println("Press 2 to change password");
                    int accChoice = -1;
                    System.out.println("Enter your choice (1/2): ");
                    accChoice = input.nextInt();
                    if(accChoice == 1)
                        addAccount();
                    else if(accChoice == 2)
                        changePassword();
                    else
                        System.out.println("Invalid choice");
                }
                else if (choice == 0) {
                    System.out.println("Good-bye");
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid choice.");
            input.nextLine();
        }
    }


    public static void patientManagement() {
        int choice = -1;

        System.out.println("Enter username to login: ");
        String newp_username = input.nextLine();
        System.out.println("Enter password: ");
        String newp_password = input.nextLine();
        boolean found = false;
        for (int i = 0; i < accounts.length; i++) {
            for (int j = 0; j < accounts[i].length; j++) {
                if (newp_username.equals(accounts[i][0]) && newp_password.equals(accounts[i][1])) {
                    found = true;
                    System.out.println("Login Successful");
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        if (found) {
            while (choice != 0) {

                System.out.println("--------PATIENT MANAGEMENT--------");
                System.out.println("Enter 1 to Add a new patient to the system");
                System.out.println("Enter 2 to Update patient information");
                System.out.println("Enter 3 to Remove a patient from the system.");
                System.out.println("Enter 4 to Search for patients");
                System.out.println("Enter 5 to All View patient details");
                System.out.println("Enter 0 to log out  \n ---------------------------------");

                System.out.print("Enter your choice: ");
                choice = input.nextInt();
                input.nextLine();

                if (choice == 1) {
                    addPatient();
                } else if (choice == 2) {
                    updatePatientInfo();
                } else if (choice == 3) {
                    removePatient();
                } else if (choice == 4) {
                    searchPatient();
                } else if (choice == 5) {
                    displayPatients();
                } else if (choice == 6) {
                    addAccount();
                } else if (choice == 0) {
                    System.out.println("Logged out");
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid username or password");
        }
    }


    public static void doctorManagement() {
        int choice = -1;

        while (choice != 0) {
            System.out.println("---------DOCTOR MANAGEMENT-----------");
            System.out.println("Enter 1 to Add a new doctor to the system");
            System.out.println("Enter 2 to Update doctor information");
            System.out.println("Enter 3 to Remove a doctor from the system.");
            System.out.println("Enter 4 to Search for doctors");
            System.out.println("Enter 5 to View All doctor details");
            System.out.println("Enter 0 to log out \n -----------------------");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                addDoctor();
            } else if (choice == 2) {
                updateDoctorInfo();
            } else if (choice == 3) {
                removeDoctor();
            } else if (choice == 4) {
                searchDoctor();
            } else if (choice == 5) {
                viewAllDoctors();
            } else if (choice == 0) {
                System.out.println("Logged out");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    public static void billing() {
        System.out.println("------BILLING-------");
        System.out.println("Enter Patient ID: ");
        String patientID = input.nextLine();
        int patientIndex = -1;

        for (int i = 0; i < patientCount; i++) {
            if (patients[i][0].equals(patientID)) {
                patientIndex = i;
                break;
            }
        }

        if (patientIndex == -1) {
            System.out.println("Patient with ID " + patientID + " not found.");
            return;
        }

        System.out.println("Enter amount due: ");
        double amountDue = input.nextDouble();
        input.nextLine();

        System.out.println("---------PATIENT'S INVOICE----------");
        System.out.println("Patient's Name: " + patients[patientIndex][1]);
        System.out.println("Patient's age: " + patients[patientIndex][2]);
        System.out.println("Patient's Contact: " + patients[patientIndex][4]);
        System.out.println("Amount Due: Rs. " + amountDue);
        System.out.println("Payment Instructions: Payable to Zuberi Hospital");
    }


    public static void appointmentScheduling() {
        try {
            System.out.println("-------APPOINTMENT SCHEDULING-------");
            System.out.println("Enter Patient ID: ");
            String patientID = input.next();
            int patientIndex = -1;

            for (int i = 0; i < patientCount; i++) {
                if (patients[i][0].equals(patientID)) {
                    patientIndex = i;
                    break;
                }
            }

            if (patientIndex == -1) {
                System.out.println("Patient with ID " + patientID + " not found.");
                return;
            }

            System.out.println("Available Doctors:");
            for (int i = 0; i < doctorCount; i++) {
                System.out.println((i + 1) + ". " + doctors[i][1]);
            }

            System.out.print("Select a doctor (Enter doctor number): ");
            int doctorChoice = input.nextInt();
            input.nextLine(); // Consume newline character

            if (doctorChoice < 1 || doctorChoice > doctorCount) {
                System.out.println("Invalid doctor choice.");
                return;
            }

            int doctorIndex = doctorChoice - 1;

            String appointmentDateTime;
            boolean isValidFormat = false;

            do {
                System.out.println("Enter Appointment Date and Time (e.g., YYYY-MM-DD HH:MM): ");
                appointmentDateTime = input.nextLine();
                isValidFormat = validateDateTimeFormat(appointmentDateTime);
                if (!isValidFormat) {
                    System.out.println("Invalid date and time format. Please try again.");
                }
            } while (!isValidFormat);

            appointments[patientIndex][doctorIndex] = appointmentDateTime;
            System.out.println("Appointment scheduled successfully with " + doctors[doctorIndex][1] +
                    " on " + appointmentDateTime);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input format. Please try again.");
            input.nextLine();
        }
    }

    private static boolean validateDateTimeFormat(String dateTime) {
        String[] parts = dateTime.split(" ");
        if (parts.length != 2) {
            return false;
        }
        String[] dateParts = parts[0].split("-");
        String[] timeParts = parts[1].split(":");
        if (dateParts.length != 3 || timeParts.length != 2) {
            return false;
        }
        try {
            int year = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int day = Integer.parseInt(dateParts[2]);
            int hour = Integer.parseInt(timeParts[0]);
            int minute = Integer.parseInt(timeParts[1]);
            if (year < 1000 || year > 9999 || month < 1 || month > 12 || day < 1 || day > 31 || hour < 0 || hour > 23 || minute < 0 || minute > 59) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }





    public static void addPatient() {
        boolean isValidContact = false;
        String gender = "none";
        if (patientCount < MAX_PATIENTS) {
            try {
                System.out.println("Name: ");
                String name = input.nextLine();
                System.out.println("Age:");
                String age = input.nextLine();
                int ageValue = Integer.parseInt(age);
                if (ageValue <= 0 || ageValue > 110) {
                    throw new IllegalArgumentException("Age must be a positive number and less than 110.");
                }
                while (!gender.equals("Male") && !gender.equals("Female")) {
                    System.out.println("Gender(Male/Female): ");
                    gender = input.nextLine();
                    if (!gender.equals("Male") && !gender.equals("Female")) {
                        System.out.println("Invalid input. Please re-enter from the options below:");
                    }
                }

                String contact = "";
                while (!isValidContact) {
                    System.out.println("Contact: +92");
                    String temp_contact = input.nextLine();
                    if (temp_contact.length() == 10) {
                        isValidContact = true;
                        contact = "+92" + temp_contact;
                    } else {
                        System.out.println("Not a valid contact number. Re-enter number: ");
                    }
                }

                String patientID = "P" + (patientCount + 1);
                patients[patientCount][0] = patientID;
                patients[patientCount][1] = name;
                patients[patientCount][2] = age;
                patients[patientCount][3] = gender;
                patients[patientCount][4] = contact;
                patientCount++;
                System.out.println("Patient Record Successfully Added");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input format for age. Please enter a valid integer.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Max patient limit exceeded! Delete a record to add new.");
        }
    }


    public static void updatePatientInfo() {
        boolean patientFound = false;
        System.out.print("Enter Patient ID: ");
        String patientID = input.nextLine();
        input.nextLine();

        for (int i = 0; i < patientCount; i++) {
            if (patients[i][0].equals(patientID)) {
                patientFound = true;
                System.out.println("Enter new information for Patient ID " + patientID + ":");

                System.out.print("Name: ");
                String name = input.nextLine();

                System.out.print("Age: ");
                String age = input.nextLine();

                System.out.print("Gender: ");
                String gender = input.nextLine();

                System.out.print("Contact: ");
                String contact = input.nextLine();

                patients[i][1] = name;
                patients[i][2] = age;
                patients[i][3] = gender;
                patients[i][4] = contact;

                System.out.println("Patient information updated successfully.");
                break;
            }
        }

        if (!patientFound) {
            System.out.println("Patient with ID " + patientID + " not found.");
        }
    }


    public static void removePatient() {
        System.out.print("Enter Patient ID to remove: ");
        String patientID = input.nextLine().trim();

        boolean patientFound = false;
        for (int i = 0; i < patientCount; i++) {
            if (patients[i][0].equals(patientID)) {
                patientFound = true;

                for (int j = i; j < patientCount - 1; j++) {
                    patients[j] = patients[j + 1];
                }
                patientCount--;
                System.out.println("Patient with ID " + patientID + " removed successfully.");
                break;
            }
        }

        if (!patientFound) {
            System.out.println("Patient with ID " + patientID + " not found.");
        }

    }

    public static void addDoctor() {
        if (doctorCount < MAX_DOCTORS) {
            try {
                System.out.println("Name: ");
                String name = input.nextLine();
                System.out.println("Specialization: ");
                String specialization = input.nextLine();

                String contact = "";
                boolean isValidContact = false;
                while (!isValidContact) {
                    System.out.println("Contact: +92");
                    String temp_contact = input.nextLine();
                    if (temp_contact.length() == 10) {
                        isValidContact = true;
                        contact = "+92" + temp_contact;
                    } else {
                        System.out.println("Not a valid contact number. Re-enter number: ");
                    }
                }

                String doctorID = "D" + (doctorCount + 1);
                doctors[doctorCount][0] = doctorID;
                doctors[doctorCount][1] = name;
                doctors[doctorCount][2] = specialization;
                doctors[doctorCount][3] = contact;
                doctorCount++;
                System.out.println("Doctor Record Successfully Added");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Max doctor limit exceeded! Delete a record to add new.");
        }
    }



    public static void updateDoctorInfo() {
        System.out.println("Enter Doctor ID to update: ");
        String doctorID = input.nextLine();
        boolean doctorFound = false;

        for (int i = 0; i < doctorCount; i++) {
            if (doctors[i][0].equals(doctorID)) {
                doctorFound = true;
                System.out.println("Enter new name: ");
                input.nextLine(); // Consume newline character
                doctors[i][1] = input.nextLine();
                System.out.println("Enter new specialization: ");
                doctors[i][2] = input.nextLine();
                System.out.println("Enter new contact: ");
                doctors[i][3] = input.nextLine();
                System.out.println("Doctor information updated successfully.");
                break;
            }
        }

        if (!doctorFound) {
            System.out.println("Doctor with ID " + doctorID + " not found.");
        }
    }


    public static void removeDoctor() {
        System.out.println("Enter Doctor ID to remove: ");
        String doctorID = input.nextLine();
        boolean doctorFound = false;

        for (int i = 0; i < doctorCount; i++) {
            if (doctors[i][0].equals(doctorID)) {
                doctorFound = true;

                for (int j = i; j < doctorCount - 1; j++) {
                    doctors[j] = doctors[j + 1];
                }

                doctorCount--;
                System.out.println("Doctor with ID " + doctorID + " removed successfully.");
                break;
            }
        }

        if (!doctorFound) {
            System.out.println("Doctor with ID " + doctorID + " not found.");
        }
    }

    public static void searchDoctor() {
        boolean doctorFound = false;
        System.out.println("Enter Doctor ID: ");
        String doctorID = input.nextLine();

        for (int i = 0; i < doctorCount; i++) {
            if (doctors[i][0].equals(doctorID)) {
                doctorFound = true;
                System.out.println("ID: " + doctors[i][0]);
                System.out.println("Name: " + doctors[i][1]);
                System.out.println("Specialization: " + doctors[i][2]);
                System.out.println("Contact: " + doctors[i][3]);
                break;
            }
        }

        if (!doctorFound) {
            System.out.println("Doctor with ID " + doctorID + " not found.");
        }
    }

    public static void viewAllDoctors() {
        if (doctorCount == 0) {
            System.out.println("No doctors in the system.");
        } else {
            System.out.println("List of Doctors:");
            for (int i = 0; i < doctorCount; i++) {
                System.out.println("Doctor ID: " + doctors[i][0]);
                System.out.println("Name: " + doctors[i][1]);
                System.out.println("Specialization: " + doctors[i][2]);
                System.out.println("Contact: " + doctors[i][3]);
                System.out.println();
            }
        }
    }

    public static void changePassword() {
        boolean accountFound = false;
        System.out.println("Enter username: ");
        String username = input.next();
        System.out.println("Enter old password: ");
        String oldPassword = input.next();

        for (int i = 0; i < accounts.length; i++) {
            if (!accountFound && username.equals(accounts[i][0]) && oldPassword.equals(accounts[i][1])) {
                accountFound = true;
                System.out.println("Enter new password: ");
                String newPassword = input.next();
                accounts[i][1] = newPassword; // Update password
                System.out.println("Password changed successfully for " + username);
                break;
            }
        }
        if (!accountFound)
            System.out.println("Incorrect username or password");
    }




    public static void searchPatient() {
        boolean patientFound = false;
        System.out.println("Enter Patient ID: ");
        String patientID = input.nextLine();
        for (int i = 0; i < patientCount; i++) {
            if (patients[i][0].equals(patientID)) {
                patientFound = true;
                System.out.println("ID: " + patients[i][0]);
                System.out.println("Name: " + patients[i][1]);
                System.out.println("Age: " + patients[i][2]);
                System.out.println("Gender: " + patients[i][3]);
                System.out.println("Contact: " + patients[i][4]);
            }
        }
        if (!patientFound)
            System.out.println("Record not found for id: " + patientID);
    }

    public static void displayPatients() {
        if (patientCount == 0) {
            System.out.println("No record in system");
        } else {
            System.out.println("List of Patients");
            System.out.println();
            for (int i = 0; i < patientCount; i++) {
                System.out.println("ID: " + patients[i][0]);
                System.out.println("Name: " + patients[i][1]);
                System.out.println("Age: " + patients[i][2]);
                System.out.println("Gender: " + patients[i][3]);
                System.out.println("Contact: " + patients[i][4]);
                System.out.println();
            }
        }
    }
    public static void addAccount(){
        int emptyIndex = 3;
        boolean accountExists = false;
        System.out.println("Enter new username: ");
        String newUsername = input.next();


        System.out.println("Enter new password: ");
        String newPassword = input.next();

        for(int i = 0; i < accounts.length; i++){
            for(int j = 0; j < accounts[i].length; j++){
                if(newUsername.equals(accounts[i][0]) && newPassword.equals(accounts[i][1])) {
                    System.out.println("Account already exists");
                    accountExists = true;
                    break;
                }
            }
            if(accountExists) {
                break;
            }
        }
        if(!accountExists && emptyIndex < accounts.length){
            accounts[emptyIndex][0] = newUsername;
            accounts[emptyIndex][1] = newPassword;
            emptyIndex++;
            System.out.println("Account successfully created");
        }
    }
}