package org.spaceon.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.spaceon.registration.Registration;
import org.spaceon.registration.RegistrationService;
import org.spaceon.registration.validateandsavedata.Validator;

import javax.persistence.*;


@Entity
@Table(name = "userRegistration")
public class DaoEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    private String firstName;
    private String secondName;
    private String email;
    private String password;

    @Lob
    protected SessionFactory sessionFactory;
    @Lob
    private RegistrationService registrationService;
    @Lob
    Validator validator;

    public DaoEntity(Registration registration) {
        this.firstName = registration.getFirstName();
        this.secondName = registration.getLastName();
        this.email = registration.getEmail();
        this.password = registration.getPassword();
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
