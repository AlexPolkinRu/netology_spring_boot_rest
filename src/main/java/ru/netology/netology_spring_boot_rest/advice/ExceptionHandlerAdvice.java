package ru.netology.netology_spring_boot_rest.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.netology_spring_boot_rest.exception.AuthorizationError;
import ru.netology.netology_spring_boot_rest.exception.InvalidCredentials;
import ru.netology.netology_spring_boot_rest.exception.UnauthorizedUser;

/**
 * @author Aleksandr Polochkin
 * 01.11.2022
 */

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(InvalidCredentials.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String resolveValidationException(InvalidCredentials exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(UnauthorizedUser.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    String resolveValidationException(UnauthorizedUser exception) {
        System.out.println(exception.getMessage());
        return exception.getMessage();
    }

    @ExceptionHandler(AuthorizationError.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    String resolveValidationException(AuthorizationError exception) {
        return exception.getMessage();
    }
}
