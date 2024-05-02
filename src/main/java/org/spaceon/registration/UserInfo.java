package org.spaceon.registration;

import java.util.Scanner;

public class UserInfo {

    private String firstName;
    private String secondName;
    private String email;
    private String password;


    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    /// RegisterUser Method For Registration

    public void registerUser(Scanner scanner){

        System.out.println("Enter the First Name");
        firstName = scanner.next();

        System.out.println("Enter The Second Name");
        secondName = scanner.next();

        System.out.println("Enter The Email");
        email = scanner.next();

        System.out.println("Enter The password");
        password = scanner.next();


    }
}
