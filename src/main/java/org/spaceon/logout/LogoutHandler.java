package org.spaceon.logout;

public interface LogoutHandler {
    void logout();
    void logoutEnding() throws InterruptedException;
}
