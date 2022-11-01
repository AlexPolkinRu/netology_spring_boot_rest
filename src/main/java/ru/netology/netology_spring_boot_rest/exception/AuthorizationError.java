package ru.netology.netology_spring_boot_rest.exception;

/**
 * @author Aleksandr Polochkin
 * 16.10.2022
 */

public class AuthorizationError extends RuntimeException {
    public AuthorizationError(String msg) {
        super(msg);
    }
}
