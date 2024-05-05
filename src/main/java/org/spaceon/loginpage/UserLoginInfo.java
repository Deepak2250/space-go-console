package org.spaceon.loginpage;

import java.util.Scanner;

public class UserLoginInfo {

    private final Scanner scanner = new Scanner(System.in);
    private String email;
    private String password;


    public void userInfo(){
        try {

            System.out.println("Enter Your Email : ");
            this.email = scanner.next();
            System.out.println("Enter Your Password : ");
            this.password = scanner.next();
        }
        catch (ClassCastException e){
            e.notify();
            System.out.println("Enter the Correct Value");
            scanner.close();
        }
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
