package org.spaceon.database;

import org.spaceon.registration.Registration;


import javax.persistence.*;


@Entity
@Table(name = "userRegistration")
public class DaoEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    private final String firstName;
    private final String secondName;

    @Column(unique = true)
    private final String email;
    @Column(unique = true)
    private final String password;


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
