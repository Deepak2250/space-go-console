package org.spaceon.registration.validateandsavedata;

import org.spaceon.registration.Registration;
import org.spaceon.registration.RegistrationService;

public interface Validator {

    boolean validate(Registration registration);
}
