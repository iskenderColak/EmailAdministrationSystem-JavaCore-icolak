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
    private String alter_mail;

    // Constructor to receive first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("New Employee: " + this.firstName + " " + this.lastName);
    }

    // Generate mail method
    private String generate_email() {
        return this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" +
                this.department.toLowerCase() + ".company.com";
    }

    // Asking for department
    private String setDepartment() {
        System.out.println("Department codes \n1 for Sales \n2 for Development \n3 for Accounting \n0 for none");
        boolean flag = false;
        do{
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

}

