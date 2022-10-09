package com.icolak.emailapp;

import java.util.*;

public class EmailApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // User info
        System.out.print("Enter first name: ");
        String firstName = scanner.next();
        System.out.print("Enter last name: ");
        String lastName = scanner.next();

        // creating object for Email class
        Email em1 = new Email(firstName, lastName);
        int choice = -1;
        do {
            System.out.println("\n******\nEnter your choice\n1.Show Info\n2.Change Password\n" +
                    "3.Change Mailbox Capacity\n4.Set Alternate Mail\n5.Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    em1.getInfo();
                    break;
                case 2:
                    em1.set_password();
                    break;
                case 3:
                    em1.set_mailCap();
                    break;
                case 4:
                    em1.alternate_email();
                    break;
                case 5:
                    System.out.println("Thank you for using application!");
                    break;
                default:
                    System.out.println("Invalid choice!!\nEnter proper choice again");
            }
        } while (choice!=5);

    }
}
