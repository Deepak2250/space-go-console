package org.spaceon.registration.validateandsavedata.implementedclass;

import org.spaceon.registration.Registration;
import org.spaceon.registration.validateandsavedata.Validator;

public class EmailChecker implements Validator {
    @Override
    public boolean validate(Registration registration) {
        String email = registration.getEmail();
        if (email.isEmpty() && !email.contains("@") && !email.contains(".com")){
            return false;
        }
        else {
            email.toLowerCase();
            return true;
        }
    }
}
