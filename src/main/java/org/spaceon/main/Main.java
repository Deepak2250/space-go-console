package org.spaceon.main;

import org.spaceon.apijson.ProjectIdResponseJson;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    static String registerFirstName;
    static String registerSecondName;
    static String registeremail;
    static String registerpassword;
    private static void getRegistrationData(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the First name");
        registerFirstName = scanner.next();

        System.out.println("Enter the last name");
        registerSecondName = scanner.next();

        System.out.println("Enter the email ");
        registeremail = scanner.next();

        System.out.println("Enter the password");
        registerpassword = scanner.next();
    }
    public static void main(String[] args) throws IOException {


//        getRegistrationData();
//        Validator validator = new EmailChecker();
//        Repositary repositary = new DataBase();
//        Registration registration = new Registration(registerFirstName , registerSecondName , registeremail , registerpassword , validator , repositary);
//        registration.register();

        ProjectIdResponseJson projectIdResponse = new ProjectIdResponseJson();
        projectIdResponse.jsonResponse();

    }
}
