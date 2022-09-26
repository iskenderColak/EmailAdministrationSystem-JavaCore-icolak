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
}

