package org.spaceon.registration;

import org.spaceon.registration.validateandsavedata.Repositary;
import org.spaceon.registration.validateandsavedata.Validator;

public class Registration {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private final Validator validator;
    private final Repositary repositary;

    public Registration(String firstName, String lastName, String email, String password, Validator validator, Repositary repositary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.validator = validator;
        this.repositary = repositary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void register() {
        if (validator.validate(this)) {
            repositary.save(this);
            System.out.println("The Your Data With this :" + email + " has been Added");
        }
        else {
            System.out.println("The " + email + " email is Wrong !!");
        }
    }

}
