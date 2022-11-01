package ru.netology.netology_spring_boot_rest.service;

import org.springframework.stereotype.Service;
import ru.netology.netology_spring_boot_rest.exception.AuthorizationError;
import ru.netology.netology_spring_boot_rest.exception.InvalidCredentials;
import ru.netology.netology_spring_boot_rest.exception.UnauthorizedUser;
import ru.netology.netology_spring_boot_rest.repository.Authorities;
import ru.netology.netology_spring_boot_rest.repository.UserRepository;

import java.util.List;

/**
 * @author Aleksandr Polochkin
 * 16.10.2022
 */

@Service
public class AuthorizationService {
    private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {

        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }

        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);

        if (userAuthorities == null) {
            throw new AuthorizationError("Authorization error");
        }

        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }

        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<Authorities> list) {
        return list == null || list.isEmpty();
    }
}