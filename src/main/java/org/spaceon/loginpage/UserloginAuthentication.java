package org.spaceon.loginpage;

import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.spaceon.database.FactoryProvider;
import org.spaceon.database.RegistrationDaoEntity;
import org.spaceon.registration.UserInfo;

public class UserloginAuthentication {
    private final SessionFactory sessionFactory = FactoryProvider.getSessionFactory();
    private final UserLoginInfo userLoginInfo;
    private final RegistrationDaoEntity registrationDaoEntity;

    public UserloginAuthentication(UserLoginInfo userLoginInfo, RegistrationDaoEntity registrationDaoEntity) {
        this.userLoginInfo = userLoginInfo;
        this.registrationDaoEntity = registrationDaoEntity;
    }

    public boolean userAuthenticate() {

        try {

            Session session = sessionFactory.openSession();
            Query<RegistrationDaoEntity> sessionQuery = session.createQuery("from RegistrationDaoEntity where email = :email");
            sessionQuery.setParameter("email", "email");
            RegistrationDaoEntity user = sessionQuery.uniqueResult();

            if (user != null && registrationDaoEntity.getPassword().equals(userLoginInfo.getPassword())) {
                System.out.println("You SuccessFully Logged In ");
                return true;
            }
        }
        catch (Exception error){
            System.out.println("The Email doesn't Exist");
            error.getCause();
        }

        return false;

    }
}
