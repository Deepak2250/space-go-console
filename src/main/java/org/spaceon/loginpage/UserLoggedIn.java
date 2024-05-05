package org.spaceon.loginpage;

import org.spaceon.database.RegistrationDaoEntity;
import org.spaceon.registration.Registration;
import org.spaceon.registration.UserInfo;

public class UserLoggedIn {

    private final UserLoginInfo userLoginInfo = new UserLoginInfo();

    private final UserInfo userInfo = new UserInfo();
   private final Registration registration = new Registration(userInfo.getFirstName() , userInfo.getSecondName() , userInfo.getEmail() , userInfo.getPassword() , userInfo);
    private final RegistrationDaoEntity registrationDaoEntity = new RegistrationDaoEntity(registration);
    private final UserloginAuthentication userloginAuthentication = new UserloginAuthentication(userLoginInfo , registrationDaoEntity);

    public void userLogging(){
     userLoginInfo.userInfo();
     userloginAuthentication.userAuthenticate();
    }
}
