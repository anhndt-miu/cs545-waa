package dev.anhndt.lab5.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(Long id) {
        super("User not found with ID: " + id);
    }
}
