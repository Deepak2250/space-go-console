package org.spaceon.database;


// Singleton Design Pattern

import org.hibernate.cfg.Configuration;

public class FactoryProvider {
    private static org.hibernate.SessionFactory sessionFactory;
    public static org.hibernate.SessionFactory getSessionFactory(){

        if (sessionFactory==null){
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }

        return sessionFactory;
    }
}
