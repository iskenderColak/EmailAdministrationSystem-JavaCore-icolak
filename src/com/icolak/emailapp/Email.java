package com.icolak.emailapp;

import java.util.*;
import java.io.*;

public class Email {
    public Scanner s = new Scanner(System.in); // Scanner class global
    //Setting variables as private to not give directly
    private String firstName;
    private String lastName;
    private String department;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String alter_email;

    // Constructor to receive first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("New Employee: " + this.firstName + " " + this.lastName);
        //Calling methods
        this.department = this.setDepartment(); // Department
        this.password = this.generate_password(8); // Password
        this.email = this.generate_email(); // Email generation
    }

    // Generate mail method
    private String generate_email() {
        return this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" +
                this.department.toLowerCase() + ".company.com";
    }

    // Asking for department
    private String setDepartment() {
        System.out.println("Department codes: \n1 for Sales \n2 for Development \n3 for Accounting \n0 for none");
        boolean flag = false;
        do {
            System.out.println("Enter Department code");
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    return "Sales";
                case 2:
                    return "Development";
                case 3:
                    return "Accounting";
                case 0:
                    return "None";
                default:
                    System.out.println("Invalid choice please choose it again");
            }
        } while (!flag);
        return null;
    }

    // Generate Random password method
    private String generate_password(int length) {
        Random random = new Random();
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXVZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%&?";
        String values = Capital_chars + Small_chars + numbers + symbols;
        String password = "";
        for (int i = 0; i < length; i++) {
            password = password + values.charAt(random.nextInt(values.length()));
        }
        return password;
    }

    // Change password method
    public void set_password() {
        boolean flag = false;
        do {
            System.out.println("DO you want to change your password!(Y/N)");
            char choice = s.next().charAt(0);
            if (choice == 'Y' || choice == 'y') {
                flag = true;
                System.out.println("Enter current password: ");
                String temp = s.next();
                if (temp.equals(this.password)) {
                    System.out.println("Enter new password: ");
                    this.password = s.next();
                    System.out.println("Password changed successfully");
                } else {
                    System.out.println("Incorrect password");
                }
            } else if (choice == 'N' || choice == 'n') {
                flag = true;
                System.out.println("Password changed option cancelled! ");
            } else {
                System.out.println("Enter Valid Choice");
            }
        } while (!flag);
    }

    // set mailbox capacity method
    public void set_mailCap() {
        System.out.println("Current capacity = " + this.mailCapacity + "mb");
        System.out.println("Enter new mailbox capacity: ");
        this.mailCapacity = s.nextInt();
        System.out.println("Mailbox capacity is successfully changed");
    }

    // set alternate email
    public void alternate_email() {
        System.out.println("Enter new alternate mail: ");
        this.alter_email = s.next();
        System.out.println("Alternate email is set");
    }

    // Display user information method
    public void getInfo() {
        System.out.println("New: " + this.firstName + " " + this.lastName);
        System.out.println("Department: " + this.department);
        System.out.println("Email: " + this.email);
        System.out.println("Password: " + this.password);
        System.out.println("Mailbox capacity: " + this.mailCapacity + "mb");
        System.out.println("Alternate mail: " + this.alter_email);
    }

    // Store in file
    public void storeFile() {
        try {
            FileWriter in = new FileWriter("/Users/iskendercolak/Desktop/info.txt");
            in.write("First name: "+ this.firstName);
            in.append("\nLast name: " + this.lastName);
            in.append("\nEmail: " + this.email);
            in.append("\nPassword: " + this.password);
            in.append("\nCapacity: " + this.mailCapacity);
            in.append("\nAlternate email: " + this.alter_email);
            in.close();
            System.out.println("Data Stored..");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void readFile() {
        try {
            FileReader f1 = new FileReader("/Users/iskendercolak/Desktop/info.txt");
            int i;
            while ((i = f1.read())!=-1) {
                System.out.print((char)i);
            }
            f1.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }




}

