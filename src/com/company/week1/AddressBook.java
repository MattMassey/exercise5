package com.company.week1;
import java.util.*;

//Matthew Massey, 2/12/2019
//Program generates an address book, which user may add to or search for an email using a name
//CSCI 1660, Exercise 5

public class AddressBook {
    static Scanner input = new Scanner(System.in);
    private static HashMap<String, String> book = new HashMap<>();

    public static void main(String[] args) {

        System.out.println("(1) Add a person to the address book.\n(2) Search for a person's email" +
                " from the address book.\n(0) Exit.");
        int choice = Integer.parseInt(input.nextLine());
        while (choice != 0) {
            switch (choice) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    System.out.println("Name of person?");
                    System.out.println(searchPerson(input.nextLine()));
                    break;
                default:
                    System.out.println("That wasn't a valid choice.");
                    break;
            }
            System.out.println("(1) Add a person to the address book.\n(2) Search for a person's email" +
                    " from the address book.\n(0) Exit.");
            choice = Integer.parseInt(input.nextLine());
        }
    }

    public static void addPerson() {
        ContactInfo person = new ContactInfo();
        System.out.println("Name of person: ");
        person.setName(input.nextLine());
        System.out.println("Email: ");
        person.setEmail(input.nextLine());
        book.put(person.getName(), person.getEmail());
    }

    public static String searchPerson(String personName) {
        String email = "";
        if (book.containsKey(personName)) {
            email = book.get(personName);
        } else {
            System.out.println("That name doesn't appear to exist.");
        }
        return email;
    }
}