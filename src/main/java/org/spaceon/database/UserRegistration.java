package org.spaceon.database;

import org.spaceon.registration.Registration;
import org.spaceon.registration.RegistrationService;
import org.spaceon.registration.UserInfo;
import org.spaceon.registration.validateandsavedata.Validator;
import org.spaceon.registration.validateandsavedata.implementedclass.EmailRepositry;

import java.util.Scanner;

public class UserRegistration {

   private final Validator validator = new EmailRepositry();
   private  UserInfo userInfo = new UserInfo();
   private Scanner scanner = new Scanner(System.in);
    private RegistrationService registrationService = new RegistrationService(validator);
   private DaoEntity daoEntity;
   private DaoService daoService;


    public void userRegister(){
        userInfo.registerUser(scanner);
        Registration registration = new Registration(userInfo.getFirstName(), userInfo.getSecondName(), userInfo.getEmail(), userInfo.getPassword(), userInfo);
        intializeDao(registration);
        registration.register(registrationService);
        daoService.save(registration);

        displayWelcomeMessage(registration.getEmail());
    }

    private void intializeDao(Registration registration){
      daoEntity = new DaoEntity(registration);
      daoService = new DaoService(validator ,daoEntity );
    }

    private void displayWelcomeMessage(String email) {
        System.out.println("The Your Data With this :" + email + " has been Added");
        System.out.println("Welcome To Space-Go <Click 1 for Using Commands and 0 For Logout");
    }
}
