package org.spaceon.main;

import org.spaceon.registration.Registration;
import org.spaceon.registration.validateandsavedata.Repositary;
import org.spaceon.registration.validateandsavedata.Validator;
import org.spaceon.registration.validateandsavedata.implementedclass.DataBase;
import org.spaceon.registration.validateandsavedata.implementedclass.EmailChecker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the First name");
        String registerFirstName = scanner.next();
        System.out.println("Enter the last name");
        String registerSecondName = scanner.next();
        System.out.println("Enter the email ");
        String registeremail = scanner.next();
        System.out.println("Enter the password");
        String registerpassword = scanner.next();

        Validator validator = new EmailChecker();
        Repositary repositary = new DataBase();
        Registration registration = new Registration(registerFirstName , registerSecondName , registeremail , registerpassword , validator , repositary);
        registration.register();
    }
}
