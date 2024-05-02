package org.spaceon.database;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.spaceon.registration.Registration;
import org.spaceon.registration.validateandsavedata.Validator;

import javax.persistence.PersistenceException;

public class DaoService implements Dao{


    private final Validator validator;
    private final DaoEntity daoEntity;
    public DaoService(Validator validator , DaoEntity daoEntity){

        this.validator = validator;
        this.daoEntity = daoEntity;
    }

    @Override
    public void save(Registration registration) {
            Session session = FactoryProvider.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            try {

                boolean emailValidate = validator.validate(registration);

                if (emailValidate) {
                    session.save(daoEntity);
                    transaction.commit();
                }
            }
            catch (PersistenceException e){
                e.getStackTrace();
                System.out.println("The Email named : " +daoEntity.getEmail() +" is Already Been Used");
                transaction.rollback();
            }
            catch (Exception e){
                e.getStackTrace();
                transaction.rollback();
            }
            finally {
                session.close();
            }
}
}
