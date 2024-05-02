package org.spaceon.registration;

public class Registration {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private UserInfo userInfo;

    public Registration(String firstName, String lastName, String email, String password , UserInfo userInfo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userInfo = userInfo;
    }

    // Getters and setters omitted for brevity

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

    // Register using the RegistrationService
    public void register(RegistrationService registrationService) {
        registrationService.register(this);
    }
}
