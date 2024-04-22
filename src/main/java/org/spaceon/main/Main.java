package org.spaceon.main;

import org.spaceon.logout.Logout;
import org.spaceon.logout.LogoutHandler;
import org.spaceon.registration.Registration;
import org.spaceon.registration.validateandsavedata.Repositary;
import org.spaceon.registration.validateandsavedata.Validator;
import org.spaceon.registration.validateandsavedata.implementedclass.DataBase;
import org.spaceon.registration.validateandsavedata.implementedclass.EmailChecker;

import java.util.ArrayList;
import java.util.List;
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
    public static void main(String[] args) {


        getRegistrationData();
        Validator validator = new EmailChecker();
        Repositary repositary = new DataBase();
        Registration registration = new Registration(registerFirstName , registerSecondName , registeremail , registerpassword , validator , repositary);
        registration.register();

    }
}
