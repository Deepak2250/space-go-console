package org.spaceon.logout;

import java.util.Scanner;

public class Logout implements LogoutHandler {
    Scanner scanner = new Scanner(System.in);
    int decision = scanner.nextInt();
    char[] dots = {'.' , '.' , '.' , '.'};

    @Override
    public void logout() {
        if (decision != 0){
            System.out.println("Enter a Valid Argument");
            return;
        }
        else {
            try {
                logoutEnding();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            System.exit(1);


        }
    }

    @Override
    public void logoutEnding() throws InterruptedException {
     StringBuilder endingStatement = new StringBuilder();
     endingStatement.append("You Are Logging Out");

     System.out.println(endingStatement);

     for (int i = 0 ; i<=dots.length-1 ; i++){
         System.out.print(dots[i]);
         Thread thread = new Thread();
         thread.sleep(500);
     }
    }
}
