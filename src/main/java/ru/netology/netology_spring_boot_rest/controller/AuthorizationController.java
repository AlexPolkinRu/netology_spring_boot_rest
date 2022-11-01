package ru.netology.netology_spring_boot_rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.netology_spring_boot_rest.repository.Authorities;
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

}