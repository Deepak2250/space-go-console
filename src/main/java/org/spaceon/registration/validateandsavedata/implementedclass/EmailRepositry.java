package org.spaceon.registration.validateandsavedata.implementedclass;

import org.spaceon.registration.Registration;
import org.spaceon.registration.RegistrationService;
import org.spaceon.registration.validateandsavedata.Validator;

public class EmailRepositry implements Validator {
    @Override
    public boolean validate(Registration registration) {
        String email = registration.getEmail();
        if (email==null || email.isEmpty() || !email.contains("@") || !email.contains(".com")){
            return false;
        }
        else {
            return true;
        }
    }
}
