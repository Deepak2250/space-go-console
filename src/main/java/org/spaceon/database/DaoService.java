package org.spaceon.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.spaceon.registration.Registration;
import org.spaceon.registration.validateandsavedata.Validator;

public class DaoService implements Dao{


    private SessionFactory sessionFactory;
    private Validator validator;
    private DaoEntity daoEntity;
    public DaoService(Validator validator , SessionFactory sessionFactory , DaoEntity daoEntity){

        this.validator = validator;
        this.sessionFactory = sessionFactory;
        this.daoEntity = daoEntity;
    }

    @Override
    public void save(Registration registration) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            try {

                boolean emailValidate = validator.validate(registration);

                if (daoEntity.getEmail().equals(emailValidate)) {
                    session.save(daoEntity.getId());
                    session.save(daoEntity.getFirstName());
                    session.save(daoEntity.getSecondName());
                    session.save(daoEntity.getEmail());
                    session.save(daoEntity.getPassword());
                    transaction.commit();
                    System.out.println("Data Added");
                } else {
                    System.out.println("The Data doesnot Added");
                    transaction.rollback();

                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            finally {
                session.close();
            }
}
}
