package ru.netology.netology_spring_boot_rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.netology.netology_spring_boot_rest.Authorities;
import ru.netology.netology_spring_boot_rest.exception.InvalidCredentials;
import ru.netology.netology_spring_boot_rest.exception.UnauthorizedUser;
import ru.netology.netology_spring_boot_rest.service.AuthorizationService;

import java.util.List;

/**
 * @author Aleksandr Polochkin
 * 16.10.2022
 */

@RestController
public class AuthorizationController {
    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(
            @RequestParam("user") String user,
            @RequestParam("password") String password
    ) {
        return service.getAuthorities(user, password);
    }

    @ExceptionHandler(InvalidCredentials.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String resolseValidationException(InvalidCredentials exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(UnauthorizedUser.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    String resolseValidationException(UnauthorizedUser exception) {
        System.out.println(exception.getMessage());
        return exception.getMessage();
    }
}